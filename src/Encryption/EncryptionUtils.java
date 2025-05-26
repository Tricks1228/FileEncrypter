package Encryption;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

// Contains helper methods to simplify Encrypt.java
public class EncryptionUtils {
    private EncryptionUtils() {} // Prevent instances of this class

    public static Cipher createCipher(String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance(transformation);
    }

}
