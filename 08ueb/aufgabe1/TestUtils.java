public class TestUtils {
    private static final int MIN_NUMBER = 1000;
    private static final int MAX_NUMBER = 9999;

    /**
     * This function checks if a given number is within the range of MIN_NUMBER and MAX_NUMBER (inclusive).
     * If the number is outside of this range, an IllegalArgumentException is thrown.
     * @param patientenNr The number to check
     * @throws IllegalArgumentException If the number is outside of the range MIN_NUMBER and MAX_NUMBER
    */
     public static void checkPatientenNr(int patientenNr) {
        if (patientenNr < MIN_NUMBER || patientenNr > MAX_NUMBER) {
            throw new IllegalArgumentException("Die Artikelnummer muss zwischen " + MIN_NUMBER + " und " + MAX_NUMBER + " liegen.");
        }
    }

    /**
     * This function checks if a given number is equal to or above 1.
     * If the number is below 1, an IllegalArgumentException is thrown.
     * @param patientenNr The number to check
     * @throws IllegalArgumentException If the number is below 1
    */
    public static void checkAboveOne(int patientenNr) {
        if (patientenNr < 1) {
            throw new IllegalArgumentException("Die Anzahl muss mindestens 1 sein.");
        }
    }

    /**
     * This function checks if a given string is null or empty.
     * If the string is null or empty, an IllegalArgumentException is thrown.
     * @param string The string to check
     * @throws IllegalArgumentException If the string is null or empty
    */
    public static void checkNotEmpty(String text) {
        if (text == null || text.strip().isEmpty()) {
            throw new IllegalArgumentException("Der Text darf nicht leer sein.");
        }
    }
}

