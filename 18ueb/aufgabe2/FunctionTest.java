import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FunctionTest {

    private final Function function = new Function();

    @BeforeEach
    public void setUp() {
        function.anonymFunction();
    }

    @Test
    public void testLambdaSquare_shouldReturn_25() {
        int result = function.getlambdaSquare().apply(5);
        Assertions.assertEquals(25, result);
    }

    @Test
    public void testAnonymSquare_shouldReturn_25() {
        int result = function.getAnonymSquare().apply(5);
        Assertions.assertEquals(25, result);
    }

    @Test
    public void testLambdaFactorial_WithNumber_5_shouldReturn_120() {
        int result = function.getlambdaFactoriel().apply(5);
        Assertions.assertEquals(120, result);
    }

    @Test
    public void testLambdaFactorial_withNegativeNumber_shouldThrowException() {
        Assertions.assertThrows(MyIllegalArgumentException.class, () -> {
            function.getlambdaFactoriel().apply(-5);
        });
    }

    @Test
    public void testStaticNestedFactorial_WithNumber_5_shouldReturn_120() {
        int result = function.useStaticNestedFactoriel(5);
        Assertions.assertEquals(120, result);
    }

    @Test
    public void testStaticNestedFactorial_withNegativeNumber_shouldThrowException() {
        Assertions.assertThrows(MyIllegalArgumentException.class, () -> {
            function.useStaticNestedFactoriel(-5);
        });
    }

    @Test
    public void testAnonymFactorial_WithNumber_5_shouldReturn_120() {
        function.anonymFunction();
        MyFunction anonymFactoriel = function.getAnonymFactoriel();
        int result = anonymFactoriel.apply(5);
        Assertions.assertEquals(120, result);
    }

    @Test
    public void testAnonymFactorial_withNegativeNumber_shouldThrowException() {
        function.anonymFunction();
        MyFunction anonymFactoriel = function.getAnonymFactoriel();
        Assertions.assertThrows(MyIllegalArgumentException.class, () -> {
            anonymFactoriel.apply(-5);
        });
    }

    @Test
    public void testLambdaQuadratic_WithNumber_4_shouldReturn_8() {
        int result = function.getlambdaQuadratic().apply(2);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testLambdaQuadratic_withNegativeNumber_shouldThrowException() {
        Assertions.assertThrows(MyIllegalArgumentException.class, () -> {
            function.getlambdaQuadratic().apply(-5);
        });
    }

    @Test
    public void testAnonymQuadratic_WithNumber_4_shouldReturn_8() {
        function.anonymFunction();
        MyFunction anonymQuadratic = function.getAnonymQuadratic();
        int result = anonymQuadratic.apply(2);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testAnonymQuadratic_withNegativeNumber_shouldThrowException() {
        function.anonymFunction();
        MyFunction anonymQuadratic = function.getAnonymQuadratic();
        Assertions.assertThrows(MyIllegalArgumentException.class, () -> {
            anonymQuadratic.apply(-5);
        });
    }

    @Test
    public void testLambdaFibonacci_WithNumver_6_shouldReturn_8() {
        int result = function.getlambdaFibonacci().apply(6);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testLambdaFibonacci_withNegativeNumber_shouldThrowException() {
        Assertions.assertThrows(MyIllegalArgumentException.class, () -> {
            function.getlambdaFibonacci().apply(-5);
        });
    }

    @Test
    public void testAnonymFibonacci_WithNumver_6_shouldReturn_8() {
        function.anonymFunction();
        MyFunction anonymFibonacci = function.getAnonymFibonacci();
        int result = anonymFibonacci.apply(6);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testAnonymFibonacci_withNegativeNumber_shouldThrowException() {
        function.anonymFunction();
        MyFunction anonymFibonacci = function.getAnonymFibonacci();
        Assertions.assertThrows(MyIllegalArgumentException.class, () -> {
            anonymFibonacci.apply(-5);
        });
    }

    @Test
    public void testLambdaEvenSquareWithOddNumber_shouldReturn_DefaultValue() {
        int result = function.getlambdaEvenSquare().apply(5);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testLambdaEvenSquareWithEvenNumber_4_shouldReturn_16() {
        int result = function.getlambdaEvenSquare().apply(4);
        Assertions.assertEquals(16, result);
    }

    @Test
    public void testLambdaEvenSquare_withZeroInput_shouldReturnZero() {
        int result = function.getlambdaEvenSquare().apply(0);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testLambdaOddFactorialWithOddResult_shouldReturn_1() {
        int result = function.getlambdaOddFactoriel().apply(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testLambdaOddFactorialWithEvenResult_shouldReturn_DefaultValue() {
        int result = function.getlambdaOddFactoriel().apply(5);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testApplyAndPrint_withValidInput_shouldPrintResults() {
        int i = 1;
        int j = 5;
        StringBuilder output = new StringBuilder();

        function.applyAndPrint(i, j, x -> {
            output.append(x).append(": ").append(x * 2).append("\n");
            return x * 2;
        });

        String expectedOutput = "1: 2\n2: 4\n3: 6\n4: 8\n5: 10\n";
        Assertions.assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testApplyAndPrint_withValidInputThatShouldBeSwapped_shouldNotThrowException() {
        int i = 1;
        int j = 5;
        StringBuilder output = new StringBuilder();

        function.applyAndPrint(i, j, x -> {
            output.append(x).append(": ").append(x * 2).append("\n");
            return x * 2;
        });

        String expectedOutput = "1: 2\n2: 4\n3: 6\n4: 8\n5: 10\n";
        Assertions.assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testApplyAndPrint_withOneInvalidInput_shouldThrowException() {
        int i = -1;
        int j = 1;
        StringBuilder output = new StringBuilder();

        Assertions.assertThrows(MyIllegalArgumentException.class, () -> {
            function.applyAndPrint(i, j, x -> {
                output.append(x).append(": ").append(x * 2).append("\n");
                return x * 2;
            });
        });
    }

    @Test
    public void testApplyAndPrint_withEqualInput_shouldPrintResult() {
        int i = 5;
        int j = 5;
        StringBuilder output = new StringBuilder();

        function.applyAndPrint(i, j, x -> {
            output.append(x).append(": ").append(x * 2).append("\n");
            return x * 2;
        });

        String expectedOutput = "5: 10\n";
        Assertions.assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testApplyAndPrint_withSwappedInput_shouldPrintResults() {
        int i = 5;
        int j = 2;
        StringBuilder output = new StringBuilder();

        function.applyAndPrint(i, j, x -> {
            output.append(x).append(": ").append(x * 2).append("\n");
            return x * 2;
        });

        String expectedOutput = "2: 4\n3: 6\n4: 8\n5: 10\n";
        Assertions.assertEquals(expectedOutput, output.toString());
    }
}

