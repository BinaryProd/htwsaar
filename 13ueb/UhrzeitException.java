/**
 * <h1> UhrzeitException </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
class UhrzeitException extends RuntimeException {
    private static final int MAX_STUNDE = 23;
    private static final int MAX_MINUTE = 59;

    private static final String FEHLER_STUNDE = "Stunde muss zwischen 0 und 23 liegen";
    private static final String FEHLER_MINUTE = "Minute muss zwischen 0 und 59 liegen";

    public UhrzeitException() {
        super();
    }

    public UhrzeitException(String message) {
        super(message);
    }

    /**
     * Check if a hour is valid else throw an error
     *
     * @param hour
     * @throws UhrzeitException
     */

    public static void checkIfValidHour(int hour) throws UhrzeitException {
        if (hour < 0 || hour > MAX_STUNDE) {
            throw new UhrzeitException(FEHLER_STUNDE);
        }
    }

    /**
     * Check if a minute is valid else throw an error
     *
     * @param minute
     * @throws UhrzeitException
     */

    public static void checkIfValidMinute(int minute) throws UhrzeitException {
        if (minute < 0 || minute > MAX_MINUTE) {
            throw new UhrzeitException(FEHLER_MINUTE);
        }
    }
}

