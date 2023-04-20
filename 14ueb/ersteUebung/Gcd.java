public class Gcd {
    /**
     * This method calculates the greatest common divisor of two long integers using the Euclidean algorithm.
     *
     * @param a The first long integer
     * @param b The second long integer
     * @return The GCD of the two long integers
     * @throws GcdException if either of the input values is not a valid long integer
     */
    public static long gcd(long a, long b) throws GcdException {
        GcdException.checkIfValidNumber(a);
        GcdException.checkIfValidNumber(b);

        if (a == 0) {
            return a;
        } 

        if (b == 0) {
            return b;
        }

        return gcdBerechner(a, b);
    }

    /**
     * This method is a helper function that uses recursion to calculate the GCD of two long integers.
     *
     * @param a The first long integer
     * @param b The second long integer
     * @return The GCD of the two long integers
     */
    private static long gcdBerechner(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcdBerechner(b, a % b);
    }
}
