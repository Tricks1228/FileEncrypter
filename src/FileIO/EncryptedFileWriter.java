package FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class EncryptedFileWriter {
    private byte[] data;

    public EncryptedFileWriter(byte[] data) {
        this.data = data;
    }

    public String getEncodedString() {
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * Creates a new text file and writes the encrypted data to the file
     * @param data Encrypted bytes
     * @return txt file containing encrypted data
     * @throws IOException
     */
    public File createEncryptedFile(byte[] data) throws IOException {
        File encryptedText = new File("encrypted.txt"); // Create the new text file
        FileWriter writer = new FileWriter(encryptedText); // Create the writer and write to the encrypted text file
        writer.write(getEncodedString()); // Write the encoded string to the file
        writer.close(); // Close the writer
        return encryptedText; // Return the encrypted file
 
    }
}
