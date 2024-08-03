package com.javarush.breslavetc.infrastructure.crypto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CaesarCipherAlgorithmTest {

    @Test
    public void testEncrypt() {
        CaesarCipherAlgorithm caesarCipher = new CaesarCipherAlgorithm();
        String plainText = "Чу, я слышу пушек гром!";
        String key = "3";

        String encryptedText = caesarCipher.encrypt(plainText, key);

        // Ожидаемый результат шифрования
        String expected = "Ъц: . фоюыц тцызн ёуспб";

        assertEquals(expected, encryptedText);
    }

    @Test
    public void testDecrypt() {
        CaesarCipherAlgorithm caesarCipher = new CaesarCipherAlgorithm();
        String encryptedText = "Ъц: . фоюыц тцызн ёуспб";
        String key = "3";

        String decryptedText = caesarCipher.encrypt(encryptedText, Integer.toString(-Integer.parseInt(key)));

        // Ожидаемый результат расшифровки
        String expected = "Чу, я слышу пушек гром!";

        assertEquals(expected, decryptedText);
    }
}