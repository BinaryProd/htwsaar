public class StaticFibonacci {
    public static int fibonacci(int n) {
        Check.checkPositiveNumber(n);

        if (n == 0) {
            return 0;
        }

        int previousFibonacci = 1;
        int currentFibonacci = 0;
        int number = 0;

        if (n == 1) {
            return previousFibonacci;
        }

        for (int i = 2; i <= n; i++) {
            number = previousFibonacci + currentFibonacci;
            currentFibonacci = previousFibonacci;
            previousFibonacci = number;
        }

        return number;
    }
}
