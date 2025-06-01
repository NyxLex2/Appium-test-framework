package utils;

import java.util.Random;

public class RandomStringUtils {
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    private static final Random random = new Random();

    public static String generateRandomEmail() {
        String username = generateRandomString(ALPHA + NUMERIC, 8);
        String domain = generateRandomString(ALPHA, 6);
        String tld = generateRandomString(ALPHA, 3);
        return username + "@" + domain + "." + tld;
    }

    public static String generateRandomPassword(int length) {
        return generateRandomString(ALPHA + NUMERIC + SPECIAL, length);
    }

    public static String generateRandomInvalidEmail() {
        String[] invalidPatterns = {
                generateRandomString(ALPHA + NUMERIC, 8),
                "@" + generateRandomString(ALPHA, 6) + ".com",
                generateRandomString(ALPHA, 8) + "@",
                generateRandomString(ALPHA, 8) + "@" + generateRandomString(ALPHA, 6), // No TLD
                generateRandomString(ALPHA, 8) + "@@domain.com",
                generateRandomString(ALPHA, 8) + "@domain..com",
                generateRandomString(ALPHA, 8) + "@domain.com."
        };
        return invalidPatterns[random.nextInt(invalidPatterns.length)];
    }

    public static String randomNumeric(int length) {
        return generateRandomString(NUMERIC, length);
    }

    private static String generateRandomString(String chars, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}