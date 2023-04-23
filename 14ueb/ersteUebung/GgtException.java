/**
 * <h1> GgtException </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
class GgtException extends RuntimeException {

    private static final String FEHLER_NUMMER = "Die Zahl muss groesser als 0 sein";

    public GgtException() {
        super();
    }

    public GgtException(String message) {
        super(message);
    }

    /**
     * Check if long is positiv or null
     *
     * @param long
     * @throws GgtException
     */
    public static void checkIfValidNumber(long number) throws GgtException {
        if (number < 0) {
            throw new GgtException(FEHLER_NUMMER);
        }
    }
}
