package main.output;

import main.exception.InvalidPathException;
import main.parser.ParserFileRules;
import main.reader.ReaderFromFile;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import main.constant.*;

public class FileParserConsoleOutput {

    public static boolean outputHostInfo(Path path){
        try {
            ParserFileRules parser = new ParserFileRules();
            List<String> lines = ReaderFromFile.readFromFile(path);
            parser.analyzeAllLines(lines);
            System.out.println(StringConstant.STOP_COMMAND);
            String hosts = parser.getCurrentDescendingOrderCountHost();
            System.out.println(hosts);
            outputForTest(hosts);
            System.out.println(StringConstant.WAIT_UPDATE);
            return true;
        } catch (InvalidPathException | IOException e) {
            return false;
        }
    }

    //for tracker tests to monitor last result after log file modify
    private static void outputForTest(String answer){
        try (FileWriter fileWriter = new FileWriter(StringConstant.FILE_TEST_PATH)) {
            fileWriter.write(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
