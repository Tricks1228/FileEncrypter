package Decryption;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import FileIO.Base64Handler;

public class DecryptionUtils {
    private DecryptionUtils() {} // Prevent instances of this class

    public static Cipher createCipher(String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance(transformation);
    }

    public static byte[] decode(byte[] data) {
        return Base64Handler.getDecodedData(data);
    }
    
}
