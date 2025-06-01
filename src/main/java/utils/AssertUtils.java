package utils;

public class AssertUtils {
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        if (actual == null && expected == null) {
            return;
        }
        if (actual == null || !actual.equals(expected)) {
            throw new AssertionError(message + "\nExpected: " + expected + "\nActual: " + actual);
        }
    }
}