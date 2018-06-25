package main.tracker;

import main.constant.StringConstant;
import main.output.FileParserConsoleOutput;

import java.io.IOException;
import java.nio.file.*;

public class FileTracker implements Runnable {

    private Path pathDir;
    private String fileName;

    public FileTracker(String pathDir, String fileName){
        if (pathDir != null && fileName != null){
            this.pathDir = Paths.get(pathDir);
            this.fileName = fileName;
        }
    }

    @Override
    public void run() {
        if (pathDir == null || fileName == null){
            return;
        }
        boolean flag = FileParserConsoleOutput.outputHostInfo(Paths.get(pathDir+"/"+fileName));
        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
            final WatchKey watchKey = pathDir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
            while (flag) {
                final WatchKey wk = watchService.take();
                Thread.sleep( 5 ); // to avoid double updating event
                for (WatchEvent<?> event : wk.pollEvents()) {
                    final Path changed = (Path) event.context();
                    if (changed.endsWith(fileName)) {
                        // after file modify update whole information about hosts
                        flag = FileParserConsoleOutput.outputHostInfo(Paths.get(pathDir+"/"+fileName));
                    }
                }
                boolean valid = wk.reset();
                if (!valid) {
                    flag = false;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        // here only after some exceptions that're incompatible with future work
        System.out.println(StringConstant.FINISH);
        System.exit(0);
    }
}
