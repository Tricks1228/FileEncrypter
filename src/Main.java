import java.io.File;
import java.util.Scanner;

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
                    break;

                case 2: // Encrypt
                    encrypt();
                    break;

                case 3: // Decrypt
                    decrypt();
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

    }

    private static void decrypt() {

    }
}
