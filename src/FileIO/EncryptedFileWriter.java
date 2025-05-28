package FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptedFileWriter {

    private EncryptedFileWriter() {} // Prevent class from being instantiated

    /**
     * Creates a new text file and writes the encrypted data to the file
     * @param data Encrypted bytes
     * @return txt file containing encrypted data
     * @throws IOException
     */
    public static File createEncryptedFile(byte[] data) throws IOException {
        File encryptedText = new File("encrypted.txt"); // Create the new text file
        System.out.println("> ENCRYPTED.TXT CREATED...");

        FileWriter writer = new FileWriter(encryptedText); // Create the writer and write to the encrypted text file
        System.out.println("> WRITING TO ENCRYPTED FILE...");

        writer.write(Base64Handler.getEncodedString(data)); // Write the encoded string to the file
        System.out.println("> DATA WRITTEN TO ENCRYPTED FILE...");

        writer.close(); // Close the writer
        System.out.print("\n" + "Encrypted file found at: " + encryptedText.getAbsolutePath() + "\n");
        return encryptedText; // Return the encrypted file
    }
}
