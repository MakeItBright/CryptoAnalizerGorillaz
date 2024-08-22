package com.javarush.breslavetc.exception;

/**
 * This exception is thrown when an error occurs during file processing.
 */
public class FileProcessingException extends RuntimeException {

    public FileProcessingException(String message) {
        super(message);
    }

    public FileProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}