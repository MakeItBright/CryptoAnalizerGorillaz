package com.javarush.breslavetc.entrypoint;

import com.javarush.breslavetc.application.BruteForceCracker;
import com.javarush.breslavetc.application.DecryptionService;
import com.javarush.breslavetc.application.EncryptionService;
import com.javarush.breslavetc.domain.service.EncryptionAlgorithm;
import com.javarush.breslavetc.infrastructure.crypto.CaesarCipherAlgorithm;
import com.javarush.breslavetc.infrastructure.crypto.CaesarCipherBruteForceStrategy;
import com.javarush.breslavetc.infrastructure.file.FileHandler;

import com.javarush.breslavetc.exception.FileProcessingException;
import com.javarush.breslavetc.exception.EncryptionException;

import java.util.Scanner;


public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        EncryptionAlgorithm algorithm = new CaesarCipherAlgorithm();
        FileHandler fileHandler = new FileHandler();

        EncryptionService encryptionService = new EncryptionService(algorithm, fileHandler);
        DecryptionService decryptionService = new DecryptionService(algorithm, fileHandler);

        CaesarCipherBruteForceStrategy bruteForceStrategy = new CaesarCipherBruteForceStrategy();
        BruteForceCracker bruteForceCracker = new BruteForceCracker(bruteForceStrategy, fileHandler);


        while (true) {
            System.out.println("--------------------");
            System.out.println("Please select mode:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Brute force");
            System.out.println("4. Analyze");
            System.out.println("5. Exit");
            System.out.println("--------------------");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    handleEncryption(scanner, encryptionService);
                    break;
                case 2:
                    handleDecryption(scanner, decryptionService);
                    break;

                case 3:
                    handleBruteForce(scanner, bruteForceCracker);
                    break;

                case 4:
                    System.out.println("Analyze mode is not implemented yet.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void handleEncryption(Scanner scanner, EncryptionService encryptionService) {
        while (true) {
            System.out.println("Enter the file path to encrypt:");
            String encryptFilePath = scanner.nextLine();
            System.out.println("Enter the encryption key:");
            String encryptionKey = scanner.nextLine();

            try {
                encryptionService.encryptFile(encryptFilePath, encryptionKey);
                System.out.println("File encrypted successfully.");
                return;
            } catch (FileProcessingException | EncryptionException e) {
                System.out.println("Error: " + e.getMessage());
                if (askForExit(scanner)) {
                    return;
                }
            }
        }
    }

    private static void handleDecryption(Scanner scanner, DecryptionService decryptionService) {
        while (true) {
            System.out.println("Enter the file path to decrypt:");
            String decryptFilePath = scanner.nextLine();
            System.out.println("Enter the decryption key:");
            String decryptionKey = scanner.nextLine();

            try {
                decryptionService.decryptFile(decryptFilePath, decryptionKey);
                System.out.println("File decrypted successfully.");
                return;
            } catch (FileProcessingException | EncryptionException e) {
                System.out.println("Error: " + e.getMessage());
                if (askForExit(scanner)) {
                    return;
                }
            }
        }
    }

    private static void handleBruteForce(Scanner scanner, BruteForceCracker bruteForceCracker) {
        while (true) {
            System.out.println("Enter the file path to brute force:");
            String bruteForceFilePath = scanner.nextLine();

            try {
                bruteForceCracker.crackFile(bruteForceFilePath);
                System.out.println("Brute force attack completed.");
                return;
            } catch (FileProcessingException | EncryptionException e) {
                System.out.println("Error: " + e.getMessage());
                if (askForExit(scanner)) {
                    return;
                }
            }
        }
    }



    private static boolean askForExit(Scanner scanner) {
        while (true) {
            System.out.println("Would you like to retry? (y/n)");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'y' to retry or 'n' to return to the main menu.");
            }
        }
    }

}
