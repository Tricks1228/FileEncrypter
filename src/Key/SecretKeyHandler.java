package Key;
// Creates and handles the Secret Key

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecretKeyHandler {
    private SecretKey secretKey;
    private int keySize;
    private String algorithim;

    public SecretKeyHandler(String algorithim, int keySize) {
        this.algorithim = algorithim;
        this.keySize = keySize;
    }

    /**
     * Initializes the secret key with secretKeySize size and AES algorithim
     * @throws NoSuchAlgorithmException
     */
    public void init() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithim);
        generator.init(keySize);
        secretKey = generator.generateKey();
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public int getKeySize() {
        return keySize;
    }
}
