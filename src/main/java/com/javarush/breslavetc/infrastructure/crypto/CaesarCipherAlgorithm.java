package com.javarush.breslavetc.infrastructure.crypto;

import com.javarush.breslavetc.domain.service.EncryptionAlgorithm;
import com.javarush.khmelov.constant.Alphabet;

/**
 * Implementation of Caesar Cipher for Russian text with additional symbols.
 * <p>
 * This class implements the Caesar Cipher algorithm specifically for Russian text,
 * including handling a custom Russian alphabet and additional symbols.
 * </p>
 */

public class CaesarCipherAlgorithm  implements EncryptionAlgorithm {

    // Russian alphabet and additional symbols
    private static final String RUS_ALPHABET = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String SYMBOLS = "\n☮.,”’:-!? ";

    // Combined alphabet containing Russian letters and additional symbols
    private static final String ALPHABET = RUS_ALPHABET + SYMBOLS;
    private static final int ALPHABET_SIZE = ALPHABET.length();

    @Override
    public String encrypt(String plainText, String key) {
        int shift = Integer.parseInt(key);
        shift = shift % ALPHABET_SIZE; // Ensure shift is within the bounds of the alphabet size

        StringBuilder encrypted = new StringBuilder();
        for (char i : plainText.toCharArray()) {
            int index = ALPHABET.indexOf(i);
            if (index != -1) {
                // Shift character and wrap around the alphabet if necessary
                int newIndex = (index + shift) % ALPHABET_SIZE;
                if (newIndex < 0) newIndex += ALPHABET_SIZE; // Handle negative shift
                encrypted.append(ALPHABET.charAt(newIndex));
            } else {
                // If character is not in the alphabet, just append it as is (e.g., unknown characters)
                encrypted.append(i);
            }
        }
        return encrypted.toString();
    }
}


