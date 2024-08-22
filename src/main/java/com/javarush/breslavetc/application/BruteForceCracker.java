package com.javarush.breslavetc.application;

import com.javarush.breslavetc.domain.model.EncryptedData;
import com.javarush.breslavetc.domain.model.PlainText;
import com.javarush.breslavetc.domain.service.BruteForceStrategy;
import com.javarush.breslavetc.exception.EncryptionException;
import com.javarush.breslavetc.infrastructure.file.FileHandler;

/**
 * Service class for attempting to decrypt encrypted data using brute force method.
 */
public class BruteForceCracker {

    private final BruteForceStrategy bruteForceStrategy;
    private final FileHandler fileHandler;

    public BruteForceCracker(BruteForceStrategy bruteForceStrategy, FileHandler fileHandler) {
        this.bruteForceStrategy = bruteForceStrategy;
        this.fileHandler = fileHandler;
    }

    /**
     * Attempts to decrypt the text from the specified file using brute force and saves the decrypted text to a new file.
     *
     * @param filePath The path to the file containing the encrypted data to be cracked.
     */
    public void crackFile(String filePath) {

        try {
        // Load the encrypted data from the file
        EncryptedData encryptedData = fileHandler.loadEncryptedData(filePath);

        // Attempt to decrypt the encrypted content using brute force
        String crackedContent = bruteForceStrategy.crack(encryptedData.getContent());

        // Create a PlainText object with the cracked content
        PlainText plainText = new PlainText(crackedContent);

        // Save the plain text to a new file
        String crackedFilePath = filePath.replace(".enc", ".cracked");
        System.out.printf(crackedFilePath);
        fileHandler.savePlainText(crackedFilePath, plainText);
        } catch (Exception e) {
            throw new EncryptionException("Failed to crack file using brute force: " + filePath, e);
        }
    }
}
