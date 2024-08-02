package com.javarush.breslavetc.infrastructure.crypto;

import com.javarush.breslavetc.domain.service.EncryptionAlgorithm;

/**
 *
 */
public class AESAlgorithm implements EncryptionAlgorithm {
    private static final String ALGORITHM = "AES";

    @Override
    public String encrypt(String plainText, String key) {
        return "";
    }
}
