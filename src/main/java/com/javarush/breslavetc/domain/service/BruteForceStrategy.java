package com.javarush.breslavetc.domain.service;

/**
 * Interface for implementing brute force strategy to crack encryption.
 */
public interface BruteForceStrategy {
    String crack(String encryptedText);
}
