package Decryption;

import java.io.File;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import FileIO.Base64Handler;
import FileIO.DecryptedFileWriter;
import FileIO.TextReader;


public class Decrypt {
    private Cipher cipher;
    private byte[] decryptedData;

    public Decrypt(File file, String transformation, SecretKey key) throws Exception {
        this.decryptedData = TextReader.getTextBytes(file);
        System.out.println("> BYTE DATA EXTRACTED");

        cipher = DecryptionUtils.createCipher(transformation); // Create the cipher
        System.out.println("> DECRYPTION CIPHER CREATED...");

        cipher.init(Cipher.DECRYPT_MODE, key); // Initialize the Cipher
        System.out.println("> DECRYPTION CIPHER INITIALIZED...");
    }

    public byte[] applyDecryption() throws Exception {
        byte[] data = Base64Handler.getDecodedData(Base64Handler.cleanBase64(decryptedData)); // Decode Base64
        System.out.println("> BASE64 DECODED...");

        decryptedData = cipher.doFinal(data); // Decrypt
        System.out.println("> DECRYPTION APPLIED...");
        return decryptedData; // Return decrypted data
    }

    public File getDecryptedFile() throws Exception {
        System.out.println("> GETTING DECRYPTED FILE...");

        return DecryptedFileWriter.createDecryptedFile(decryptedData);
    }
}
