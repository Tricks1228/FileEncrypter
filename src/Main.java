import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.SecretKey;

import Decryption.Decrypt;
import Encryption.Encrypt;
import Key.SecretKeyHandler;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static File file;
    private static String transformation = "AES/ECB/PKCS5Padding";
    private static SecretKey key;

    public static void main(String[] args) throws Exception {
        
        boolean runProgram = true;
        int selection = 0;
        key = createSecretKey(transformation);
        Files.deleteIfExists(Paths.get("../encrypted.txt"));
        System.out.println("> DELETED EXISTING ENCRYPTED.TXT");
        Files.deleteIfExists(Paths.get("../decrypted.txt"));
        System.out.println("> DELETING EXISTING DECRYPTED.TXT");

        while (runProgram) {
            System.out.println("=============");
            System.out.println("What would you like to do?");
            System.out.println("1. Select a File");
            System.out.println("2. Encrypt a File");
            System.out.println("3. Decrypt a File");
            System.out.println("4. Get the current selected file");
            System.out.println("5. Quit");
            System.out.println("=============" + "\n");
            selection = sc.nextInt();

            switch (selection) {
                case 1: // Select
                    selectFile();
                    System.out.println("=============" + "\n");
                    break;

                case 2: // Encrypt
                    encrypt();
                    System.out.println("=============" + "\n");
                    break;

                case 3: // Decrypt
                    decrypt();
                    System.out.println("=============" + "\n");
                    break;

                case 4: // Get slected file
                    System.out.println("File found at: " + file.getAbsolutePath());
                    System.out.println("=============" + "\n");
                    break;

                case 5: // Quit
                    sc.close();
                    runProgram = false;
                    break;
        
                default:
                    System.out.println("An error occured: Invalid input");
                    break;
            }

        }
    }

    private static void selectFile() {
        System.out.println("Enter the file path: ");
        String path = sc.next();
        file = new File(path);
    }

    private static File encrypt() throws Exception {
        Encrypt encrypt = new Encrypt(file, transformation, key);
        encrypt.applyEncryption();
        file = encrypt.getEncryptedFile();
        return file;
    }

    private static File decrypt() throws Exception {
        Decrypt decrypt = new Decrypt(file, transformation, key);
        decrypt.applyDecryption();
        file = decrypt.getDecryptedFile();
        return file;

    }

    /**
     * Generates and initializes the secret Key using the ciphers algorithim and key size of 128
     * @return the Secret key
     * @throws NoSuchAlgorithmException
     */
    public static SecretKey createSecretKey(String transformation) throws NoSuchAlgorithmException {
        System.out.println("> CREATING SECRET KEY");
        SecretKeyHandler key = new SecretKeyHandler(transformation.substring(0, 3), 128); 
        key.init();
        System.out.println("> SECRET KEY INITIALIZED...");
        return key.getSecretKey();
    }
}
