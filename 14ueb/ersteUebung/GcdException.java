class GcdException extends RuntimeException {

    private static final String FEHLER_NUMMER = "Die Zahl muss groesser als 0 sein";

    public GcdException() {
        super();
    }

    public GcdException(String message) {
        super(message);
    }

    /**
     * Check if long is positiv of null
     *
     * @param long
     * @throws GcdException
     */
    public static void checkIfValidNumber(long number) throws GcdException {
        if (number < 0) {
            throw new GcdException(FEHLER_NUMMER);
        }
    }
}
