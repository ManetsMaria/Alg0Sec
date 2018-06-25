package main.tracker;

import main.constant.StringConstant;

import java.util.Scanner;

public class ParserFileService {

    // use main thread to monitor client stop wish and one more thread for monitor file updating
    public static void start(){
        FileTracker fileTracker = new FileTracker(StringConstant.FILE_PATH, StringConstant.FILE_NAME);
        Thread thread = new Thread(fileTracker);
        thread.start();
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (scanner.hasNext() && StringConstant.STOP_SYMBOL.equals(scanner.next())){
                System.out.println(StringConstant.FINISH);
                System.exit(0);
            }
        }
    }
}
