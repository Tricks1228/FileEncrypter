import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.NoSuchPaddingException;

import Encryption.Encrypt;
import Encryption.EncryptionUtils;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static File file;

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

    private static void encrypt() {
        System.out.println("Enter the desired Encyption Transformation");
        String transformation = sc.next();

        Encrypt encrypt = new Encrypt(file, transformation);
        encrypt.applyEncryption();
    }

    private static void decrypt() {

    }
}
