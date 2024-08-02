package com.javarush.breslavetc.domain.model;

/**
 * Represents encrypted data that can be decrypted.
 */

public class EncryptedData {
    private String content;

    /**
     * Constructor to initialize EncryptedData with the given content.
     *
     * @param content The encrypted text content.
     */
    public EncryptedData(String content) {
        this.content = content;
    }

    /**
     * Gets the content of the EncryptedData.
     *
     * @return The encrypted text content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the EncryptedData.
     *
     * @param content The new encrypted text content.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Converts the EncryptedData to a string representation.
     *
     * @return The string representation of the EncryptedData.
     */
    @Override
    public String toString() {
        return content;
    }

    /**
     * Checks if the EncryptedData content is empty.
     *
     * @return True if the content is null or empty; otherwise, false.
     */
    public boolean isEmpty() {
        return content == null || content.trim().isEmpty();
    }
}
