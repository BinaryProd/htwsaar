public class TopLevelClass {
    public static void main(String[] args) {
        new TopLevelClass().run();
    }

    public void run() {
        // Test the Methodes of the class Function with applyAndPrint
        Function function = new Function();
        Factoriel factoriel = new Factoriel();

        System.out.println("Test the Methodes of the class Function with applyAndPrint");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaSquare");
        function.applyAndPrint(1, 10, function.getlambdaSquare());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaFactoriel");
        function.applyAndPrint(1, 10, function.getlambdaFactoriel());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaFibonacci");
        function.applyAndPrint(1, 10, function.getlambdaFibonacci());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaQuadratic");
        function.applyAndPrint(1, 10, function.getlambdaQuadratic());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaEvenSquare");
        function.applyAndPrint(1, 10, function.getlambdaEvenSquare());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaOddFactoriel");
        function.applyAndPrint(1, 10, function.getlambdaOddFactoriel());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Class Factoriel with method reference");
        function.applyAndPrint(1, 10, factoriel::apply);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Class Factoriel with a lambda reference");
        function.applyAndPrint(1, 10, x -> factoriel.apply(x));
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Class Factoriel with a anonymous class");
        function.applyAndPrint(1, 10, new MyFunction() {
            @Override
            public int apply(int x) {
                return factoriel.apply(x);
            }
        });
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Static Nested Class with method reference");
        function.applyAndPrint(1, 10, function::useStaticNestedFactoriel);
    }
}
