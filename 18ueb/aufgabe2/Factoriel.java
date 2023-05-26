/**
 * <h1> Factoriel </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class Factoriel implements MyFunction {

    /**
     * Calculates the factorial of a number
     * @param x int
     * @return int
     */
    @Override
    public int apply(int x) {
        int result = 1;
        for (int i = 1; i <= x; i++ ) {
            result *= i;
        }
        return result;
    }
}
