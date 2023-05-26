/**
 * <h1> Function </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.function.IntPredicate;

public class Function {
    private MyFunction anonymFactoriel;
    private IntPredicate odd;

    /**
     * Konstruktor
     */
    public Function() {
        anonymFunction();
    }

    /**
     * Function that applies a function to all numbers between i and j and prints the result
     * @param i int
     * @param j int
     * @param myfunction MyFunction
     * @throws FunctionException if i or j are not natural numbers
     */
    public void applyAndPrint(int i, int j, MyFunction myfunction) throws FunctionException {
        if ( i < 1 || j < 1 ) {
            throw new FunctionException("j und i sollen natuerliche Zahlen sein"); 
        }

        if ( i > j ) {
            int swap = i;
            i = j;
            j = swap;
        }

        for ( int c = i; c <= j; c++) {
            int result = myfunction.apply(c);
            System.out.println(c + ": " + result);
        }
    }

    /**
     * Lambda function that calculates the square of a number
     * @param x int
     * @return int
     */
    private MyFunction lambdaSquare = x -> (int)x*x;

    /**
     * Getter for lambdaSquare
     * @return MyFunction
     */
    public MyFunction getlambdaSquare() {
        return lambdaSquare;
    }

    /**
     * Lambda function that calculates the factorial of a number
     * @param x int
     * @return int
     */
    private MyFunction lambdaFactoriel = x -> {
        int result = 1;
        for (int i = 1; i <= x; i++ ) {
            result *= i;
        }
        return result;
    };

    /**
     * Getter for lambdaFactoriel
     * @return MyFunction
     */
    public MyFunction getlambdaFactoriel() {
        return lambdaFactoriel;
    }

    /**
     * Inner class that calculates the square of a number
     */
    private static class StaticNestedFactoriel implements MyFunction {
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
        };
    }

    /**
     * Function that call the inner class StaticNestedFactoriel
     * @param x int
     * @return int
     */
    public int useStaticNestedFactoriel(int x) {
        StaticNestedFactoriel staticNestedFactoriel = new StaticNestedFactoriel();
        return staticNestedFactoriel.apply(x);
    }

    /**
     * Anonymous function that calculates the factorial of a number
     */
    public void anonymFunction() {
        /**
         * Anonymous class that calculates the factorial of a number
         * @param x int
         * @return int
         */
        this.anonymFactoriel = new MyFunction() {
            public int apply(int x) {
                int result = 1;
                for (int i = 1; i <= x; i++ ) {
                    result *= i;
                }
                return result;
            }
        };

        /**
         * Anonymous class that checks if a number is odd
         * @param x int
         * @return boolean
         */
        this.odd = new IntPredicate() {
            public boolean test(int x) {
                return x % 2 == 1;
            }
        };
    }

    /**
     * Getter for the anonymous function for the factorial
     * @return MyFunction
     */
    public MyFunction getAnonymFactoriel() {
        return anonymFactoriel;
    }

    /**
     * lambda function that calculates the quadratic of a number
     * @param x int
     * @return int
     */
    private MyFunction lambdaQuadratic = x -> (int)Math.pow(x, x+1);
        
    /**
     * Getter for lambdaQuadratic
     * @return MyFunction
     */
    public MyFunction getlambdaQuadratic() {
        return lambdaQuadratic;
    }

    /**
     * lambda function that calculates the fibonacci of a number
     * @param x int
     * @return int
     */
    private MyFunction lambdaFibonacci = x -> { 
        if (x == 0) {
            return 0;
        }

        int fib1 = 1;
        int fib2 = 0;
        int number = 0;

        if (x == 1) {
            return fib1;
        }

        for (int i = 2; i <= x; i++) {
            number = fib1 + fib2;
            fib2 = fib1;
            fib1 = number;
        }

        return number;
    };

    /**
     * Getter for lambdaFibonacci
     * @return MyFunction
     */
    public MyFunction getlambdaFibonacci() {
        return lambdaFibonacci;
    }

    /**
     * lambda function that check is even
     * @param x int
     * @return boolean
     */
    public IntPredicate even = x -> x % 2 == 0;

    /**
     * lambda function that caculates the square of a number if it is even
     * @param x int
     * @return int
     */
    private MyFunction lambdaEvenSquare = x -> even.test(x) ? lambdaSquare.apply(x) : -1;

    /**
     * Getter for lambdaEvenSquare
     * @return MyFunction
     */
    public MyFunction getlambdaEvenSquare() {
        return lambdaEvenSquare;
    }

    /**
     * lambda function that caculates the factorial of a number if it is odd
     * @param x int
     * @return int
     */
    private MyFunction lambdaOddFactoriel = x -> (odd.test(lambdaFactoriel.apply(x))) ? lambdaFactoriel.apply(x) : 0;
    

    /**
     * Getter for lambdaOddFactoriel
     * @return MyFunction
     */
    public MyFunction getlambdaOddFactoriel() {
        return lambdaOddFactoriel;
    }
}
