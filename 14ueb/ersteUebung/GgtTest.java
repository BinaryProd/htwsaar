/**
 * <h1> GgtTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class GgtTest {

    private GgtIterativ ggtIterativ;
    private GgtRekursiv ggtRekursiv;

    @BeforeEach
    public void setup() {
        ggtIterativ = new GgtIterativ();
        ggtRekursiv = new GgtRekursiv();
    }

    @Test
    public void testGgtIterativ() {
        long result = ggtIterativ.ggt(10, 25);
        assertEquals(5, result);
    }

    @Test
    public void testGgtRekursiv() {
        long result = ggtRekursiv.ggt(10, 25);
        assertEquals(5, result);
    }
    
    @Test
    public void testGgtIterativWithNumberNegativ() {
        long result = ggtIterativ.ggt(-25, 100);
        assertEquals(25, result);
        
        long result2 = ggtIterativ.ggt(-100, 5);
        assertEquals(5, result2);
    }

    @Test
    public void testGgtRekursivWithNumberNegativ() {
        long result = ggtRekursiv.ggt(-25, 100);
        assertEquals(25, result);
        
        long result2 = ggtRekursiv.ggt(-100, 5);
        assertEquals(5, result2);
    }
    
    @Test
    public void testGgtIterativWithZero()  {
        assertEquals(25, ggtIterativ.ggt(0, 25));
        assertEquals(25, ggtIterativ.ggt(-25, 0));

    }

    @Test
    public void testGgtRekursivRekursivWithZero()  {
        assertEquals(25, ggtRekursiv.ggt(0, 25));
        assertEquals(25, ggtRekursiv.ggt(-25, 0));
        
    }
    
    @Test
    public void testGgtIterativWithSameNumbers()  {
        long result = ggtIterativ.ggt(10, 10);
        assertEquals(10, result);
    }
    
    @Test
    public void testGgtRekursivWithSameNumbers()  {
        long result = ggtRekursiv.ggt(10, 10);
        assertEquals(10, result);
    }

    @Test
    public void testGgtIterativWithOneNumber()  {
        long result1 = ggtIterativ.ggt(10, 1);
        assertEquals(1, result1);
        
        long result2 = ggtIterativ.ggt(1, 10);
        assertEquals(1, result2);
    }
    
    @Test
    public void testGgtRekursivWithOneNumber()  {
        long result1 = ggtRekursiv.ggt(10, 1);
        assertEquals(1, result1);
        
        long result2 = ggtRekursiv.ggt(1, 10);
        assertEquals(1, result2);
    }

    @Test
    public void testGgtIterativWithLargeNumbers()  {
        long result = ggtIterativ.ggt(1000000000, 500000000);
        assertEquals(500000000, result);
    }

    @Test
    public void testGgtRekursivWithLargeNumbers()  {
        long result = ggtRekursiv.ggt(1000000000, 500000000);
        assertEquals(500000000, result);
    }

    @Test
    public void testGgtIterativSameNumbers()  {
        long result = ggtIterativ.ggt(5, 5);
        assertEquals(5, result);

        long result2 = ggtIterativ.ggt(-5, 5);
        assertEquals(5, result2);

        long result3 = ggtIterativ.ggt(5, -5);
        assertEquals(5, result3);

        long result4 = ggtIterativ.ggt(-5, -5);
        assertEquals(5, result4);
    }

    @Test
    public void testGgtRekursivSameNumbers()  {
        long result = ggtRekursiv.ggt(5, 5);
        assertEquals(5, result);

        long result2 = ggtRekursiv.ggt(-5, 5);
        assertEquals(5, result2);

        long result3 = ggtRekursiv.ggt(5, -5);
        assertEquals(5, result3);

        long result4 = ggtRekursiv.ggt(-5, -5);
        assertEquals(5, result4);
    }

    @Test
    public void testGgtIterativWithOne()  {
        long result = ggtIterativ.ggt(5, 1);
        assertEquals(1, result);

        long result2 = ggtIterativ.ggt(-1, 5);
        assertEquals(1, result2);

        long result3 = ggtIterativ.ggt(1, -5);
        assertEquals(1, result3);

        long result4 = ggtIterativ.ggt(-1, -5);
        assertEquals(1, result4);
    }

    @Test
    public void testGgtRekursivWithOne()  {
        long result = ggtRekursiv.ggt(5, 1);
        assertEquals(1, result);

        long result2 = ggtRekursiv.ggt(-1, 5);
        assertEquals(1, result2);

        long result3 = ggtRekursiv.ggt(1, -5);
        assertEquals(1, result3);

        long result4 = ggtRekursiv.ggt(-1, -5);
        assertEquals(1, result4);
    }
}
