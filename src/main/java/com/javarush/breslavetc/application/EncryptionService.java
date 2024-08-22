package com.javarush.breslavetc.application;

import com.javarush.breslavetc.domain.model.EncryptedData;
import com.javarush.breslavetc.domain.model.PlainText;
import com.javarush.breslavetc.domain.service.EncryptionAlgorithm;
import com.javarush.breslavetc.exception.EncryptionException;
import com.javarush.breslavetc.infrastructure.file.FileHandler;

/**
 * Service class for encrypting text and saving the encrypted data to a file.
 */

public class EncryptionService {

    private final EncryptionAlgorithm encryptionAlgorithm;
    private final FileHandler fileHandler;

    public EncryptionService(EncryptionAlgorithm encryptionAlgorithm, FileHandler fileHandler) {
        this.encryptionAlgorithm = encryptionAlgorithm;
        this.fileHandler = fileHandler;
    }

    /**
     * Encrypts the text from the specified file using the given key and saves the encrypted data to a new file.
     *
     * @param filePath The path to the file containing the plain text to be encrypted.
     * @param key The key to use for encryption.
     */
    public void encryptFile(String filePath, String key) {
        try {
            // Load the plain text from the file
            PlainText plainText = fileHandler.loadPlainText(filePath);

            // Encrypt the plain text
            String encryptedContent = encryptionAlgorithm.encrypt(plainText.getContent(), key);

            // Create an EncryptedData object with the encrypted content
            EncryptedData encryptedData = new EncryptedData(encryptedContent);

            // Save the encrypted data to a new file
            String encryptedFilePath = filePath + ".enc";
            System.out.printf(encryptedFilePath);
            fileHandler.saveEncryptedData(encryptedFilePath, encryptedData);
        } catch (Exception e) {
            throw new EncryptionException("Failed to encrypt file: " + filePath, e);
        }
    }
}
