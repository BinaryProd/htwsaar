/**
 * <h1> Function </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.function.IntPredicate;

public class Function {
    private MyFunction anonymSquare;
    private MyFunction anonymFactoriel;
    private MyFunction anonymQuadratic;
    private MyFunction anonymFibonacci;
    private IntPredicate odd;

    /**
     * Konstruktor
     */
    public Function() {
        anonymFunction();
    }

    /**
     * Function that applies a function to all numbers between i and j and prints the functionOutput
     * @param i int
     * @param j int
     * @param myfunction MyFunction
     * @throws MyIllegalArgumentException if i or j are not natural numbers
     */
    public void applyAndPrint(int i, int j, MyFunction myfunction) throws MyIllegalArgumentException {

        if ( i > j ) {
            int swap = i;
            i = j;
            j = swap;
        }

        for ( int c = i; c <= j; c++) {
            int functionOutput = myfunction.apply(c);
            System.out.println(c + ": " + functionOutput);
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
     * Getter for anonymSquare
     * @return MyFunction
     */
    public MyFunction getAnonymSquare() {
        return anonymSquare;
    }
    

    /**
     * Lambda function that calculates the factorial of a number
     * @param x int
     * @return int
     */
    private MyFunction lambdaFactoriel = x -> {
        return StaticFactorial.factorial(x);
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
            return StaticFactorial.factorial(x);
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
                return StaticFactorial.factorial(x);
            }
        };

        /**
         * Anonymous class that calculates the square of a number
         * @param x int
         * @return int
         */
        this.anonymSquare = new MyFunction() {
            public int apply(int x) {
                return x*x;
            }
        };

        /**
         * Anonymous class that calculates the quadratic of a number
         * @param x int
         * @return int
         */
        this.anonymQuadratic = new MyFunction() {
            public int apply(int x) {
                Check.checkPositiveNumber(x);
                return (int)Math.pow(x, x+1);
            }
        };
        
        /**
         * Anonymous class that calculates the fibonacci of a number
         * @param x int
         * @return int
         */
        this.anonymFibonacci = new MyFunction() {
            public int apply(int x) {
                return StaticFibonacci.fibonacci(x);
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
    private MyFunction lambdaQuadratic = x -> {
        Check.checkPositiveNumber(x);
        return (int)Math.pow(x, x+1);
    };

    /**
     * Getter for lambdaQuadratic
     * @return MyFunction
     */
    public MyFunction getlambdaQuadratic() {
        return lambdaQuadratic;
    }

    /**
     * Getter for anonymQuadratic
     * @return MyFunction
     */
    public MyFunction getAnonymQuadratic() {
        return anonymQuadratic;
    }

    /**
     * lambda function that calculates the fibonacci of a number
     * @param x int
     * @return int
     */
    private MyFunction lambdaFibonacci = x -> StaticFibonacci.fibonacci(x);

    /**
     * Getter for lambdaFibonacci
     * @return MyFunction
     */
    public MyFunction getlambdaFibonacci() {
        return lambdaFibonacci;
    }

    /**
     * Getter for the anonymous function for the fibonacci
     * @return MyFunction
     */
    public MyFunction getAnonymFibonacci() {
        return anonymFibonacci;
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
