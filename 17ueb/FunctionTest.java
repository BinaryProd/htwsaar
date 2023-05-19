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
        int result = function.lambdaSquare.apply(5);
        Assertions.assertEquals(25, result);
    }

    @Test
    public void testLambdaFactoriel() {
        int result = function.lambdaFactoriel.apply(5);
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
        int result = function.lambdaQuadratic.apply(2);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testLambdaFibonacci() {
        int result = function.lambdaFibonacci.apply(6);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testLambdaEvenSquare() {
        int result1 = function.lambdaEvenSquare.apply(4);
        int result2 = function.lambdaEvenSquare.apply(5);
        Assertions.assertEquals(16, result1);
        Assertions.assertEquals(5, result2);
    }

    @Test
    public void testLambdaOddFactoriel() {
        int result1 = function.lambdaOddFactoriel.apply(5);
        int result2 = function.lambdaOddFactoriel.apply(1);
        Assertions.assertEquals(0, result1);
        Assertions.assertEquals(1, result2);
    }
}

