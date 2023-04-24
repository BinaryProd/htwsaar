/**
 * <h1> GgtRekursiv </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class GgtRekursiv {
    /**
     * This method calculates the greatest common divisor of two long integers using the Euclidean algorithm.
     *
     * @param a The first long integer
     * @param b The second long integer
     * @return The GGT of the two long integers
     * @throws GgtException if either of the input values is not a valid long integer
     */
    public static long ggt(long a, long b) throws GgtException {
        GgtException.checkIfBothNumbersAreZero(a, b);

        if (a == 0 || b == 1) {
            return b;
        } 
        if (b == 0 || a == 1) {
            return a;
        }
        if ( a == b || a == -b) {
            return Math.abs(a);
        }

        return ggtBerechner(Math.abs(a), Math.abs(b));
    }

    /**
     * This method is a helper function that uses recursion to calculate the GGT of two long integers.
     *
     * @param a The first long integer
     * @param b The second long integer
     * @return The GGT of the two long integers
     */
    private static long ggtBerechner(long a, long b) {
        if (b == 0) {
            return a;
        }
        return ggtBerechner(b, a % b);
    }
}
