package Encryption;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import Key.SecretKeyHandler;

// Handles the applying of the encryption to the inputted file
public class Encrypt {
    private File file;
    private Cipher cipher;
    private SecretKey key;

    public Encrypt(File file, String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        this.file = file;        
        cipher = EncryptionUtils.createCipher(transformation);
        this.key = getSecretKey();
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    public void applyEncryption() throws FileNotFoundException {

    }

    public SecretKey getSecretKey() throws NoSuchAlgorithmException {
        SecretKeyHandler key = new SecretKeyHandler(cipher.getAlgorithm(), 128);
        key.init();
        return key.getSecretKey();
    }
}
