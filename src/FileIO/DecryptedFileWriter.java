package FileIO;

import java.io.File;
import java.io.FileWriter;

public class DecryptedFileWriter {

    public static File createDecryptedFile(byte[] data) throws Exception {
        System.out.println(">CREATING DECRYPTED FILE...");
        File decryptedText = new File("decrypted.txt"); // Create the new text file
        FileWriter writer = new FileWriter(decryptedText); // Create the writer
        String plaintext = new String(data); // Create the plaintext using the decoded and decrypted data (done in Decrypt class)
        System.out.println(">WRITING TO DECRYPTED FILE...");
        writer.write(plaintext); // Write to the new file
        writer.close(); // Close the writer
        System.out.print("----" + "\n" + "Decrypted file found at: " + decryptedText.getAbsolutePath() + "\n" + "----");
        return decryptedText;
    }
    
}
