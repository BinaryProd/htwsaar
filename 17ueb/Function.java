import java.util.function.IntPredicate;

public class Function {
    private MyFunction anonymFactoriel;
    private IntPredicate odd;

    public Function() {
        anonymFunction();
    }

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

    public MyFunction lambdaSquare = x -> (int)x*x;

    public MyFunction lambdaFactoriel = x -> {
        int result = 1;
        for (int i = 1; i <= x; i++ ) {
            result *= i;
        }
        return result;
    };

    private static class StaticNestedFactoriel implements MyFunction {
        @Override
        public int apply(int x) {
            int result = 1;
            for (int i = 1; i <= x; i++ ) {
                result *= i;
            }
            return result;
        };
    }

    public int useStaticNestedFactoriel(int x) {
        StaticNestedFactoriel staticNestedFactoriel = new StaticNestedFactoriel();
        return staticNestedFactoriel.apply(x);
    }

    public void anonymFunction() {
        this.anonymFactoriel = new MyFunction() {
            public int apply(int x) {
                int result = 1;
                for (int i = 1; i <= x; i++ ) {
                    result *= i;
                }
                return result;
            }
        };

        this.odd = new IntPredicate() {
            public boolean test(int x) {
                return x % 2 == 1;
            }
        };
    }

    public MyFunction getAnonymFactoriel() {
        return anonymFactoriel;
    }

    public MyFunction lambdaQuadratic = x -> (int)Math.pow(x, x+1);

    public MyFunction lambdaFibonacci = x -> { 
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

    public IntPredicate even = x -> x % 2 == 0;

    public MyFunction lambdaEvenSquare = x -> even.test(x) ? lambdaSquare.apply(x) : null;

    public MyFunction lambdaOddFactoriel = x -> (odd.test(lambdaFactoriel.apply(x))) ? lambdaFactoriel.apply(x) : 0;

}
