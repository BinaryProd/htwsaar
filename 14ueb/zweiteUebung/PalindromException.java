/**
 * <h1>PalindromException</h1>
 * 
 * @author Victor Plage, David Glaser
 * @version 1.1.1
 * @since 19.04.2023
 */

class PalindromException extends RuntimeException {
    // Konstanten
    public static final String FEHLER_PALINDROM = "Es muss ein String uebergeben werden der weder leer, null oder aus Leerzeichen besteht !";

    /**
     * Default Constructor
     */
    public PalindromException() {
        super();
    }

    /**
     * Constructor with a message parameter.
     * 
     * @param message the error message to be displayed.
     */
    public PalindromException(String message) {
        super(message);
    }

    /**
     * Checks if the passed string is null, empty or consists of only whitespace.
     * 
     * @param str the string to be checked.
     * @throws PalindromException if the string is null, empty or consists of only
     *                            whitespace.
     */
    public static void stringTest(String str) {
        if (str == null || str.isBlank()) {
            throw new PalindromException(FEHLER_PALINDROM);
        }
    }

}
