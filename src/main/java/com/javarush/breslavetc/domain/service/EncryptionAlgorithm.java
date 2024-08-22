package com.javarush.breslavetc.domain.service;
/**
 * Interface for encryption algorithms.
 * <p>
 * This interface defines the contract for any encryption algorithm implementations.
 * Each implementation must provide a way to encrypt a given plaintext using a specified key.
 * </p>
 */
public interface EncryptionAlgorithm {

    /**
     * Encrypts the given plaintext using the specified key.
     *
     * @param plainText The plaintext to be encrypted.
     * @param key The encryption key used to encrypt the plaintext.
     * @return The encrypted text.
     */
    String encrypt(String plainText, String key);
    String decrypt(String encryptedText, String key);

}
