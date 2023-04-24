/**
  * <h1> GgtIterativ </h1>
  * 
  * This class provides a method for calculating the greatest common divisor (GGT) of two long integers using the
  * Euclidean algorithm iteratively.
  * 
  * @author Victor Plage and David Glaser
  * @version 1.0
  * @since 2023-04-11
  */
public class GgtIterativ implements Ggt {

    /**
     * This method calculates the greatest common divisor of two long integers using the Euclidean algorithm iteratively.
     * 
     * @param a The first long integer
     * @param b The second long integer
     * @return The GGT of the two long integers
     * @throws GgtException if either of the input values is not a valid long integer
     */
    @Override
    public long ggt(long a, long b) throws GgtException {
        GgtException.checkIfBothNumbersAreZero(a, b);

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 1) {
            return b;
        }
        if (b == 0 || a == 1) {
            return a;
        }
        if (a == b || a == -b) {
            return a;
        }

        while (b != 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
