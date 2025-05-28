package FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DecryptedFileWriter {

    private DecryptedFileWriter() {} // Prevent class from being instantiated

    /**
     * Creates a new text file and writes the decrypted data to the file
     * @param data Decrypted bytes
     * @return txt file containing decrypted data
     * @throws IOException
     */
    public static File createDecryptedFile(byte[] data) throws Exception {
        File decryptedText = new File("decrypted.txt"); // Create the new text file
        System.out.println("> DECRYPTED.TXT CREATED...");

        FileWriter writer = new FileWriter(decryptedText); // Create the writer
        System.out.println("> WRITING TO DECRYPTED FILE...");

        writer.write(new String(data, StandardCharsets.UTF_8)); // Write to the new file
        System.out.println("> WRITING TO DECRYPTED FILE...");

        writer.close(); // Close the writer
        System.out.print("----" + "\n" + "Decrypted file found at: " + decryptedText.getAbsolutePath() + "\n" + "----" + "\n");
        return decryptedText;
    }
    
}
