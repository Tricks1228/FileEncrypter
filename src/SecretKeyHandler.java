// Creates and handles the Secret Key

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecretKeyHandler {
    private SecretKey secretKey;

    /**
     * Initializes the secret key with secretKeySize size and AES algorithim
     * @throws NoSuchAlgorithmException
     */
    public void init() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(Constants.EDK.secretKeySize);
        secretKey = generator.generateKey();
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }
}
