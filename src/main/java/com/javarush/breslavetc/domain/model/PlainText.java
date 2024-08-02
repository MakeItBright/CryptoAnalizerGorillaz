package com.javarush.breslavetc.domain.model;

/**
 * Represents plain text that can be encrypted or decrypted.
 */

public class PlainText {
    private String content;

    /**
     * Constructor to initialize PlainText with the given content.
     *
     * @param content The text content.
     */
    public PlainText(String content) {
        this.content = content;
    }

    /**
     * Gets the content of the PlainText.
     *
     * @return The text content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the PlainText.
     *
     * @param content The new text content.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Converts the PlainText to a string representation.
     *
     * @return The string representation of the PlainText.
     */
    @Override
    public String toString() {
        return content;
    }

    /**
     * Checks if the PlainText content is empty.
     *
     * @return True if the content is null or empty; otherwise, false.
     */
    public boolean isEmpty() {
        return content == null || content.trim().isEmpty();
    }
}
