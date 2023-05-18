public class Function {
    private MyFunction AnonymFactoriel;

    public Function() {
        anonymfactoriel();
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

    public MyFunction lambdaSquare = x -> (int)Math.pow(x, 2);

    public MyFunction lambdaFactoriel = x -> {
        int result = 1;
        for (int i = 1; i <= x; i++ ) {
            result *= i;
        }
        return result;
    };

    public static MyFunction StaticFactoriel = x -> {
        int result = 1;
        for (int i = 1; i <= x; i++ ) {
            result *= i;
        }
        return result;
    };

    public void anonymfactoriel() {
        this.AnonymFactoriel = new MyFunction() {
            public int apply(int x) {
                int result = 1;
                for (int i = 1; i <= x; i++ ) {
                    result *= i;
                }
                return result;
            }
        };
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
}
