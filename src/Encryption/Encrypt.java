package Encryption;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import FileIO.EncryptedFileWriter;
import FileIO.TextReader;

// Handles the applying of the encryption to the inputted file
public class Encrypt {
    private Cipher cipher;
    private byte[] encryptedFileData;

    /**
     * Stores the file for class use. Also creates and initializes the cipher using the algorithim
     * @param file File to be encrypted
     * @param transformation Encryption transformation to be used
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public Encrypt(File file, String transformation, SecretKey key) throws Exception {
        this.encryptedFileData = TextReader.getTextBytes(file);
        System.out.println("> BYTE DATA EXTRACTED");

        cipher = EncryptionUtils.createCipher(transformation); // Create the cipher
        System.out.println("> CIPHER CREATED...");

        cipher.init(Cipher.ENCRYPT_MODE, key); // Initialize the Cipher
        System.out.println("> CIPHER INITIALIZED...");
    }

    /**
     *  Applies the encryption transformation to the class file
     * @return Encrypted byte array
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] applyEncryption() throws Exception {
        encryptedFileData = cipher.doFinal(encryptedFileData); // Apply and return the encrypted bytes
        System.out.println("> ENCRYPTION APPLIED");

        return encryptedFileData;
    }

    public File getEncryptedFile() throws Exception {
        System.out.println("> GETTING ENCRYPTED FILE...");
        
        return EncryptedFileWriter.createEncryptedFile(encryptedFileData); // Create the file using the encrypted data
    }
}
