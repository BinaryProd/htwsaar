/**
 * <h1> FunctionTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FunctionTest {

    private Function function;

    @BeforeEach
    void setUp() {
        function = new Function();
    }

    @Test
    public void testLambdaSquare() {
        int result = function.getlambdaSquare().apply(5);
        Assertions.assertEquals(25, result);
    }

    @Test
    public void testLambdaFactoriel() {
        int result = function.getlambdaFactoriel().apply(5);
        Assertions.assertEquals(120, result);
    }

    @Test
    public void testStaticNestedFactoriel() {
        int result = function.useStaticNestedFactoriel(5);
        Assertions.assertEquals(120, result);
    }

    @Test
    public void testAnonymFactoriel() {
        function.anonymFunction();
        MyFunction anonymFactoriel = function.getAnonymFactoriel();
        int result1 = anonymFactoriel.apply(5);
        int result2 = anonymFactoriel.apply(6);
        Assertions.assertEquals(120, result1);
        Assertions.assertEquals(720, result2);
    }

    @Test
    public void testLambdaQuadratic() {
        int result = function.getlambdaQuadratic().apply(2);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testLambdaFibonacci() {
        int result = function.getlambdaFibonacci().apply(6);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testLambdaEvenSquare() {
        int result1 = function.getlambdaEvenSquare().apply(4);
        int result2 = function.getlambdaEvenSquare().apply(5);
        Assertions.assertEquals(16, result1);
        Assertions.assertEquals(-1, result2);
    }

    @Test
    public void testLambdaOddFactoriel() {
        int result1 = function.getlambdaOddFactoriel().apply(5);
        int result2 = function.getlambdaOddFactoriel().apply(1);
        Assertions.assertEquals(0, result1);
        Assertions.assertEquals(1, result2);
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
    public void testApplyAndPrint_withValidInputThatShouldBeSwaped_shouldNotThrowException() {
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

        Assertions.assertThrows(FunctionException.class, () -> {
            function.applyAndPrint(i, j, x -> {
                output.append(x).append(": ").append(x * 2).append("\n");
                return x * 2;
            });
        });
    }


    @Test
    public void testApplyAndPrint_withTwoInvalidInput_shouldThrowException() {
        int i = -1;
        int j = -1;
        StringBuilder output = new StringBuilder();

        Assertions.assertThrows(FunctionException.class, () -> {
            function.applyAndPrint(i, j, x -> {
                output.append(x).append(": ").append(x * 2).append("\n");
                return x * 2;
            });
        });
    }
}
