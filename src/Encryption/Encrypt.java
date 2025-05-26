package Encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

// Handles the applying of the encryption to the inputted file
public class Encrypt {
    private File file;
    private Cipher cipher;

    public Encrypt(File file, String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.file = file;

        cipher = Cipher.getInstance(transformation);

    }

    public void applyEncryption() throws FileNotFoundException {

    }

}
