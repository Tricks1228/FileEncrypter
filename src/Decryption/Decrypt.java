package Decryption;

import java.io.File;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import FileIO.DecryptedFileWriter;
import FileIO.TextReader;


public class Decrypt {
    private File file;
    private Cipher cipher;
    private byte[] decryptedData;

    public Decrypt(File file, String transformation, SecretKey key) throws Exception {
        System.out.println("> DECRYPTION CONSTRUCTOR...");
        this.file = file; // Store file for class use
        cipher = DecryptionUtils.createCipher(transformation); // Create the cipher
        System.out.println("> DECRYPTION CIPHER CREATED...");

        IvParameterSpec iv = new IvParameterSpec(new byte[16]);
        cipher.init(Cipher.DECRYPT_MODE, key, iv); // Initialize the Cipher
        System.out.println("> DECRYPTION CIPHER INITIALIZED...");
    }

    public byte[] applyDecryption() throws Exception {
        TextReader text = new TextReader(file); // Create reader for encrypted file
        byte[] data = text.getTextBytes(); // Get raw byte data of the file
        DecryptionUtils.decode(data); // Undo base64 decoding
        decryptedData = cipher.doFinal(data); // Decrypt
        return decryptedData; // Return decrypted data
    }

    public File getDecryptedFile() throws Exception {
        System.out.println("> GETTING DECRYPTED FILE...");
        return DecryptedFileWriter.createDecryptedFile(decryptedData);
    }
}
