import java.util.Scanner;

public class Tester{
    public static void main(String[] args) {
        new Tester().run();
    }

    public void run() {
        int num1, num2;

        try (Scanner scanner = EingabeUtils.scanOpen()) {
            System.out.println("You will now be asked to enter two numbers, note that these numbers will be used for each method.");
            System.out.println("Enter the first number: ");
            num1= EingabeUtils.scanInt(scanner);

            System.out.println("Enter the second number: ");
            num2 = EingabeUtils.scanInt(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
            return; // Exit the method if input is invalid
        }

        // Test the Methodes of the class Function with applyAndPrint
        Function function = new Function();
        Factoriel factoriel = new Factoriel();

        System.out.println("Test the Methodes of the class Function with applyAndPrint");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaSquare");
        function.applyAndPrint(num1, num2, function.getlambdaSquare());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaFactoriel");
        function.applyAndPrint(num1, num2, function.getlambdaFactoriel());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaFibonacci");
        function.applyAndPrint(num1, num2, function.getlambdaFibonacci());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaQuadratic");
        function.applyAndPrint(num1, num2, function.getlambdaQuadratic());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaEvenSquare");
        function.applyAndPrint(num1, num2, function.getlambdaEvenSquare());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Methode lambdaOddFactoriel");
        function.applyAndPrint(num1, num2, function.getlambdaOddFactoriel());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Object Method Reference\n");
        System.out.println("Test the Methode applyAndPrint with the Class Factoriel with a method reference");
        function.applyAndPrint(num1, num2, factoriel::apply);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Class Factoriel with a lambda reference");
        function.applyAndPrint(num1, num2, x -> factoriel.apply(x));
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Class Factoriel with a anonymous class");
        function.applyAndPrint(num1, num2, new MyFunction() {
            @Override
            public int apply(int x) {
                return factoriel.apply(x);
            }
        });
        System.out.println("------------------------------------------------------------------");
        System.out.println("Static Method Reference\n");
        System.out.println("Test the Methode applyAndPrint with the Static Nested Class with method reference");
        function.applyAndPrint(num1, num2, function::useStaticNestedFactoriel);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Static Nested Class with a lambda reference");
        function.applyAndPrint(num1, num2, x -> function.useStaticNestedFactoriel(x));
        System.out.println("------------------------------------------------------------------");
        System.out.println("Test the Methode applyAndPrint with the Static Nested Class with a anonymous class");
        function.applyAndPrint(num1, num2, new MyFunction() {
            @Override
            public int apply(int x) {
                return function.useStaticNestedFactoriel(x);
            }
        });
    }
}
