package com.javarush.breslavetc.exception;

/**
 * This exception is thrown when an error occurs during encryption or decryption.
 */
public class EncryptionException extends RuntimeException {

    public EncryptionException(String message) {
        super(message);
    }

    public EncryptionException(String message, Throwable cause) {
        super(message, cause);
    }
}