package main.reader;

import main.constant.StringConstant;
import main.exception.InvalidPathException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderFromFile {

    public static List<String> readFromFile(Path path) throws IOException, InvalidPathException {
        if (path == null || !Files.exists(path)){
            throw new InvalidPathException(StringConstant.UNABLE_PATH);
        }
        return Files.readAllLines(path);
    }
}
