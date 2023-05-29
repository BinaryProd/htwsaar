public class StaticFactorial {
    public static int factorial(int x) {
        Check.checkPositiveNumberOrZero(x);
        int factorialResult = 1;
        for (int i = 1; i <= x; i++ ) {
            factorialResult *= i;
        }
        return factorialResult;
    }
}
