package FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class EncryptedFileWriter {

    private EncryptedFileWriter(byte[] data) {} // Prevent class from being instantiated

    public static String getEncodedString(byte[] data) {
        System.out.println("[GETTING ENCODED STRING...]");
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * Creates a new text file and writes the encrypted data to the file
     * @param data Encrypted bytes
     * @return txt file containing encrypted data
     * @throws IOException
     */
    public static File createEncryptedFile(byte[] data) throws IOException {
        System.out.println("[CREATING ENCRYPTED FILE...]");
        File encryptedText = new File("encrypted.txt"); // Create the new text file
        FileWriter writer = new FileWriter(encryptedText); // Create the writer and write to the encrypted text file
        System.out.println("[WRITING TO ENCRYPTED FILE...]");
        writer.write(getEncodedString(data)); // Write the encoded string to the file
        writer.close(); // Close the writer
        System.out.print("----" + "\n" + "Encrypted file found at: " + encryptedText.getAbsolutePath() + "\n" + "----");
        return encryptedText; // Return the encrypted file
 
    }
}
