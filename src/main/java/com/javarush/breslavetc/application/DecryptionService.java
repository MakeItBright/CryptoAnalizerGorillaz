package com.javarush.breslavetc.application;

import com.javarush.breslavetc.domain.model.EncryptedData;
import com.javarush.breslavetc.domain.model.PlainText;
import com.javarush.breslavetc.domain.service.EncryptionAlgorithm;
import com.javarush.breslavetc.exception.EncryptionException;
import com.javarush.breslavetc.infrastructure.file.FileHandler;

/**
 * Service class for decrypting encrypted data from a file and saving the plain text to a new file.
 */
public class DecryptionService {

    private final EncryptionAlgorithm encryptionAlgorithm;
    private final FileHandler fileHandler;

    public DecryptionService(EncryptionAlgorithm encryptionAlgorithm, FileHandler fileHandler) {
        this.encryptionAlgorithm = encryptionAlgorithm;
        this.fileHandler = fileHandler;
    }

    /**
     * Decrypts the text from the specified file using the given key and saves the plain text to a new file.
     *
     * @param filePath The path to the file containing the encrypted data to be decrypted.
     * @param key The key to use for decryption.
     */
    public void decryptFile(String filePath, String key) {
        try {
            // Load the encrypted data from the file
            EncryptedData encryptedData = fileHandler.loadEncryptedData(filePath);

            // Decrypt the encrypted content
            String decryptedContent = encryptionAlgorithm.decrypt(encryptedData.getContent(), key);

            // Create a PlainText object with the decrypted content
            PlainText plainText = new PlainText(decryptedContent);

            // Save the plain text to a new file
            String decryptedFilePath = filePath.replace(".enc", ".dec");
            System.out.printf(decryptedFilePath);
            fileHandler.savePlainText(decryptedFilePath, plainText);
        } catch (Exception e) {
            throw new EncryptionException("Failed to decrypt file: " + filePath, e);
        }
    }

}
