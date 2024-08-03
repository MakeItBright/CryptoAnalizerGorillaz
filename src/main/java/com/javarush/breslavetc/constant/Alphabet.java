package com.javarush.breslavetc.constant;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private Alphabet() {
    }

    public static final String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String symbols = "\n☮.,”’:-!?";
    public static final char[] CHARS = (alphabet.toLowerCase() + symbols).toCharArray();
    public final static Map<Character, Integer> index = new HashMap<>();

    static {
        for (int i = 0; i < CHARS.length; i++) {
            index.put(CHARS[i], i);
        }
    }
}
