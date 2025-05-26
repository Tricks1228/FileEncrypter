package FileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PlainTextReader {
    private File file;

    public PlainTextReader(File file) {
        this.file = file;
    }   

    public Path getFilePath() {
        System.out.println("[GETTING FILE PATH...]");
        return Paths.get(file.getAbsolutePath());
    }

    public byte[] getTextBytes() throws IOException {
        System.out.println("[GETTING FILE BYTES...]");
        return Files.readAllBytes(getFilePath());
    }
}
