package com.javarush.breslavetc.infrastructure.file;

import com.javarush.breslavetc.domain.model.EncryptedData;
import com.javarush.breslavetc.domain.model.PlainText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {

    public PlainText loadPlainText(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return new PlainText(content);
        } catch (IOException e) {
            throw new RuntimeException("Error loading file", e);
        }
    }

    public void saveEncryptedData(String filePath, EncryptedData encryptedData) {
        try {
            Files.write(Paths.get(filePath), encryptedData.getContent().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error saving file", e);
        }
    }
}
