package FileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextReader {
    private File file;

    public TextReader(File file) {
        this.file = file;
    }   

    public Path getFilePath() {
        System.out.println("> GETTING FILE PATH...");
        return Paths.get(file.getAbsolutePath());
    }

    public static byte[] getTextBytes(File file) throws IOException {
        System.out.println("> GETTING FILE BYTES...");
        return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    }
}
