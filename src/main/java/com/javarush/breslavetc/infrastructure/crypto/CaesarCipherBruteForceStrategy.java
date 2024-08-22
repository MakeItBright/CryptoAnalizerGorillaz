package com.javarush.breslavetc.infrastructure.crypto;

import com.javarush.breslavetc.domain.service.BruteForceStrategy;
import com.javarush.breslavetc.constant.Alphabet;

/**
 * Implementation of brute force attack on Caesar Cipher.
 * This class tries to decrypt the text by trying all possible shifts and returning the most likely plaintext.
 */
public class CaesarCipherBruteForceStrategy implements BruteForceStrategy {

    private static final int ALPHABET_SIZE = Alphabet.CHARS.length;

    @Override
    public String crack(String encryptedText) {
        System.out.printf(encryptedText);
        String bestGuess = "";
        int maxWordCount = 0;

        // Try all possible shifts (keys)
        for (int shift = 0; shift < ALPHABET_SIZE; shift++) {
            String decryptedText = decrypt(encryptedText, Integer.toString(shift));
            int wordCount = countRecognizableWords(decryptedText);

            // Update the best guess if this one has more recognizable words
            if (wordCount > maxWordCount) {
                bestGuess = decryptedText;
                maxWordCount = wordCount;
            }
        }

        return bestGuess;
    }

    /**
     * Decrypts the text using a specific key (shift).
     *
     * @param encryptedText The encrypted text to decrypt.
     * @param key The key to use for decryption.
     * @return The decrypted text.
     */
    private String decrypt(String encryptedText, String key) {
        CaesarCipherAlgorithm caesarCipher = new CaesarCipherAlgorithm();
        return caesarCipher.decrypt(encryptedText, key);
    }

    /**
     * A simple method to count recognizable words in the text.
     *
     * @param text The text to analyze.
     * @return The number of recognizable words in the text.
     */
    private int countRecognizableWords(String text) {
        // Split the text by spaces and punctuation to identify potential words
        String[] words = text.split("\\W+");
        int count = 0;

        for (String word : words) {
            if (isRecognizableWord(word)) {
                count++;
            }
        }

        return count;
    }

    /**
     * A placeholder method to determine if a word is recognizable.
     *
     * @param word The word to check.
     * @return True if the word is recognizable, false otherwise.
     */
    private boolean isRecognizableWord(String word) {
        // Simplified check: consider any non-empty word as recognizable
        return word.length() > 2; //TODO rewrite , use a dictionary of common words.
    }
}
