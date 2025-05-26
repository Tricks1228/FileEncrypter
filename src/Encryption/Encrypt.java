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

import FileIO.PlainTextReader;
import Key.SecretKeyHandler;

// Handles the applying of the encryption to the inputted file
public class Encrypt {
    private File file;
    private Cipher cipher;
    private SecretKey key;

    /**
     * Stores the file for class use. Also creates and initializes the cipher using the algorithim
     * @param file File to be encrypted
     * @param transformation Encryption transformation to be used
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public Encrypt(File file, String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        this.file = file; // Store file for class use
        cipher = EncryptionUtils.createCipher(transformation); // Create the cipher
        this.key = getSecretKey(); // Create the secret key
        cipher.init(Cipher.ENCRYPT_MODE, key); // Initialize the Cipher
    }

    /**
     *  Applies the encryption transformation to the class file
     * @return Encrypted byte array
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] applyEncryption() throws IOException, IllegalBlockSizeException, BadPaddingException {
        PlainTextReader text = new PlainTextReader(file); // Create the text reader
        byte[] plainText = text.getTextBytes(); // Get the byte data of the file
        return cipher.doFinal(plainText); // Apply and return the encrypted bytes
    }

    /**
     * Generates and initializes the secret Key using the ciphers algorithim and key size of 128
     * @return the Secret key
     * @throws NoSuchAlgorithmException
     */
    public SecretKey getSecretKey() throws NoSuchAlgorithmException {
        SecretKeyHandler key = new SecretKeyHandler(cipher.getAlgorithm(), 128); 
        key.init();
        return key.getSecretKey();
    }
}
