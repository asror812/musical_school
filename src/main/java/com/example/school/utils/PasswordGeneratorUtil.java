package com.example.school.utils;

import java.security.SecureRandom;

public class PasswordGeneratorUtil {

    private static final char[] LETTERS_AND_DIGITS = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static final SecureRandom RANDOM = new SecureRandom();

    private PasswordGeneratorUtil() {
    }

    public static String generate() {

        StringBuilder password = new StringBuilder();

        for (int j = 0; j < 10; j++) {
            password.append(LETTERS_AND_DIGITS[RANDOM.nextInt(LETTERS_AND_DIGITS.length)]);
        }

        return password.toString();
    }
}
