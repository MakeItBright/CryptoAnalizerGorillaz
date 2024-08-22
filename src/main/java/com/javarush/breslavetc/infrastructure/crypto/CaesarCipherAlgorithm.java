package com.javarush.breslavetc.infrastructure.crypto;

import com.javarush.breslavetc.domain.service.EncryptionAlgorithm;
import com.javarush.breslavetc.constant.Alphabet;

/**
 * Implementation of Caesar Cipher for Russian text with additional symbols.
 * <p>
 * This class implements the Caesar Cipher algorithm specifically for Russian text,
 * including handling a custom Russian alphabet and additional symbols.
 * </p>
 */

public class CaesarCipherAlgorithm  implements EncryptionAlgorithm {

    private static final int ALPHABET_SIZE = Alphabet.CHARS.length;

    public String encrypt(String plainText, String key) {
        int shift = Integer.parseInt(key);
        shift = shift % ALPHABET_SIZE; // Ensure shift is within the bounds of the alphabet size

        StringBuilder encrypted = new StringBuilder();
        for (char character : plainText.toCharArray()) {
            if (Alphabet.index.containsKey(Character.toLowerCase(character))) {
                int index = Alphabet.index.get(Character.toLowerCase(character));
                int newIndex = (index + shift + ALPHABET_SIZE) % ALPHABET_SIZE;
                char newChar = Alphabet.CHARS[newIndex];
                // Preserve the case of the character
                if (Character.isUpperCase(character)) {
                    newChar = Character.toUpperCase(newChar);
                }
                encrypted.append(newChar);
            } else {
                // If character is not in the alphabet, just append it as is (e.g., unknown characters)
                encrypted.append(character);
            }
        }

        return encrypted.toString();
    }

    @Override
    public String decrypt(String encryptedText, String key) {
//        TODO перписать на  .encrypt(encryptedText, Integer.toString(-Integer.parseInt(key)));
        int shift = Integer.parseInt(key);
        shift = shift % ALPHABET_SIZE; // Ensure shift is within the bounds of the alphabet size

        StringBuilder decrypted = new StringBuilder();
        for (char character : encryptedText.toCharArray()) {
            if (Alphabet.index.containsKey(Character.toLowerCase(character))) {
                int index = Alphabet.index.get(Character.toLowerCase(character));
                int newIndex = (index - shift + ALPHABET_SIZE) % ALPHABET_SIZE;
                char newChar = Alphabet.CHARS[newIndex];
                if (Character.isUpperCase(character)) {
                    newChar = Character.toUpperCase(newChar);
                }
                decrypted.append(newChar);
            } else {
                // If character is not in the alphabet, just append it as is (e.g., unknown characters)
                decrypted.append(character);
            }
        }

        return decrypted.toString();
    }

}




