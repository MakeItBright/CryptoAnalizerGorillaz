package com.javarush.breslavetc.entrypoint;

import com.javarush.breslavetc.application.EncryptionService;
import com.javarush.breslavetc.domain.service.EncryptionAlgorithm;
import com.javarush.breslavetc.infrastructure.crypto.CaesarCipherAlgorithm;
import com.javarush.breslavetc.infrastructure.file.FileHandler;


public class ConsoleRunner {
    public static void main(String[] args) {
//        if (args.length < 2) {
//            System.out.println("Usage: java ConsoleRunner <command> <file_path> [<key>]");
//            System.out.println("Commands:");
//            System.out.println("  encrypt <file_path> <key>");
//            System.out.println("  decrypt <file_path> <key>");
//            System.out.println("  crack <file_path>");
//            return;
//        }

       // Создаем экземпляры необходимых компонентов
        EncryptionAlgorithm algorithm = new CaesarCipherAlgorithm();
        FileHandler fileHandler = new FileHandler();

        // Создаем сервис шифрования
        EncryptionService encryptionService = new EncryptionService(algorithm, fileHandler);

        // Шифруем файл
        String filePath = "/Users/yuribreslavets/Development/Java/CryptoAnalizerGorillaz/text/plaintext.txt";
        String key = "300"; // Пример ключа для шифра Цезаря
        encryptionService.encryptFile(filePath, key);

        System.out.println("File encrypted successfully!");


    }
}
