/**
 * <h1> GgtException </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
class GgtException extends RuntimeException {

    private static final String FEHLER_NUMMER = "Die Zahl darf nicht 0 sein";
    private static final String FEHLER_NULL = "Beide Zahlen duerfen nicht 0 sein";

    public GgtException() {
        super();
    }

    public GgtException(String message) {
        super(message);
    }

    /**
     * Check if both numbers are 0
     *
     * @param number1
     * @param number2
     * @throws GgtException
     */
    public static void checkIfBothNumbersAreZero(long number1, long number2) throws GgtException {
        if (number1 == 0 && number2 == 0) {
            throw new GgtException(FEHLER_NULL);
        }
    }
}
