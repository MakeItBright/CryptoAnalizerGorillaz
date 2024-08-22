package com.javarush.breslavetc.infrastructure.file;

import com.javarush.breslavetc.domain.model.EncryptedData;
import com.javarush.breslavetc.domain.model.PlainText;
import com.javarush.breslavetc.exception.FileProcessingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {

    public void savePlainText(String filePath, PlainText plainText) {
        try {
            Files.write(Paths.get(filePath), plainText.getContent().getBytes());
        } catch (IOException e) {
            throw new FileProcessingException("Error saving plain text file: " + filePath, e);
        }
    }

    public PlainText loadPlainText(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return new PlainText(content);
        } catch (IOException e) {
            throw new FileProcessingException("Error loading plain text file: " + filePath, e);
        }


    }

    public void saveEncryptedData(String filePath, EncryptedData encryptedData) {
        try {
            Files.write(Paths.get(filePath), encryptedData.getContent().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error saving file", e);
        }
    }

    public EncryptedData loadEncryptedData(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return new EncryptedData(content);
        } catch (IOException e) {
            throw new FileProcessingException("Error saving encrypted file: " + filePath, e);
        }
    }
}
