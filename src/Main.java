import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.SecretKey;

import Decryption.Decrypt;
import Encryption.Encrypt;
import Key.SecretKeyHandler;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static File file;
    private static SecretKey key;

    public static void main(String[] args) throws Exception {
        
        boolean runProgram = true;
        int selection = 0;

        while (runProgram) {
            System.out.println("=============");
            System.out.println("What would you like to do?");
            System.out.println("1. Select a File");
            System.out.println("2. Encrypt a File");
            System.out.println("3. Decrypt a File");
            System.out.println("4. Quit");
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

                case 4: // Quit
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

    private static void encrypt() throws Exception {
        System.out.println("Enter the desired Encyption Transformation: ");
        String transformation = sc.next();
        key = createSecretKey(transformation);
        Encrypt encrypt = new Encrypt(file, transformation, key);
        encrypt.applyEncryption();
        encrypt.getEncryptedFile();
    }

    private static void decrypt() throws Exception {
        System.out.println("Enter the desired Encyption Transformation: ");
        String transformation = sc.next();
        Decrypt decrypt = new Decrypt(file, transformation, key);
        decrypt.applyDecryption();
        decrypt.getDecryptedFile();

    }

    /**
     * Generates and initializes the secret Key using the ciphers algorithim and key size of 128
     * @return the Secret key
     * @throws NoSuchAlgorithmException
     */
    public static SecretKey createSecretKey(String transformation) throws NoSuchAlgorithmException {
        SecretKeyHandler key = new SecretKeyHandler(transformation.substring(0, 3), 128); 
        key.init();
        System.out.println("[SECRET KEY INITIALIZED...]");
        return key.getSecretKey();
    }
}
