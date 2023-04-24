/**
 * <h1> GgtTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GgtTest {

    @Test
    public void testGgtIterativ() {
        long result = GgtIterativ.ggt(10, 25);
        assertEquals(5, result);
    }

    @Test
    public void testGgtRekursiv() {
        long result = GgtRekursiv.ggt(10, 25);
        assertEquals(5, result);
    }
    
    @Test
    public void testGgtIterativWithNumberNegativ() {
        long result = GgtIterativ.ggt(-25, 100);
        assertEquals(25, result);
        
        long result2 = GgtIterativ.ggt(-100, 5);
        assertEquals(5, result2);
    }

    @Test
    public void testGgtRekursivWithNumberNegativ() {
        long result = GgtRekursiv.ggt(-25, 100);
        assertEquals(25, result);
        
        long result2 = GgtRekursiv.ggt(-100, 5);
        assertEquals(5, result2);
    }
    
    @Test
    public void testGgtIterativWithZero()  {
        assertEquals(25, GgtIterativ.ggt(0, 25));
        assertEquals(25, GgtIterativ.ggt(-25, 0));

    }

    @Test
    public void testGgtRekursivRekursivWithZero()  {
        assertEquals(25, GgtRekursiv.ggt(0, 25));
        assertEquals(25, GgtRekursiv.ggt(-25, 0));
        
    }
    
    @Test
    public void testGgtIterativWithSameNumbers()  {
        long result = GgtIterativ.ggt(10, 10);
        assertEquals(10, result);
    }
    
    @Test
    public void testGgtRekursivWithSameNumbers()  {
        long result = GgtRekursiv.ggt(10, 10);
        assertEquals(10, result);
    }

    @Test
    public void testGgtIterativWithOneNumber()  {
        long result1 = GgtIterativ.ggt(10, 1);
        assertEquals(1, result1);
        
        long result2 = GgtIterativ.ggt(1, 10);
        assertEquals(1, result2);
    }
    
    @Test
    public void testGgtRekursivWithOneNumber()  {
        long result1 = GgtRekursiv.ggt(10, 1);
        assertEquals(1, result1);
        
        long result2 = GgtRekursiv.ggt(1, 10);
        assertEquals(1, result2);
    }

    @Test
    public void testGgtIterativWithLargeNumbers()  {
        long result = GgtIterativ.ggt(1000000000, 500000000);
        assertEquals(500000000, result);
    }

    @Test
    public void testGgtRekursivWithLargeNumbers()  {
        long result = GgtRekursiv.ggt(1000000000, 500000000);
        assertEquals(500000000, result);
    }

    @Test
    public void testGgtIterativSameNumbers()  {
        long result = GgtIterativ.ggt(5, 5);
        assertEquals(5, result);

        long result2 = GgtIterativ.ggt(-5, 5);
        assertEquals(5, result2);

        long result3 = GgtIterativ.ggt(5, -5);
        assertEquals(5, result3);

        long result4 = GgtIterativ.ggt(-5, -5);
        assertEquals(5, result4);
    }

    @Test
    public void testGgtRekursivSameNumbers()  {
        long result = GgtRekursiv.ggt(5, 5);
        assertEquals(5, result);

        long result2 = GgtRekursiv.ggt(-5, 5);
        assertEquals(5, result2);

        long result3 = GgtRekursiv.ggt(5, -5);
        assertEquals(5, result3);

        long result4 = GgtRekursiv.ggt(-5, -5);
        assertEquals(5, result4);
    }

    @Test
    public void testGgtIterativWithOne()  {
        long result = GgtIterativ.ggt(5, 1);
        assertEquals(1, result);

        long result2 = GgtIterativ.ggt(-1, 5);
        assertEquals(1, result2);

        long result3 = GgtIterativ.ggt(1, -5);
        assertEquals(1, result3);

        long result4 = GgtIterativ.ggt(-1, -5);
        assertEquals(1, result4);
    }

    @Test
    public void testGgtRekursivWithOne()  {
        long result = GgtRekursiv.ggt(5, 1);
        assertEquals(1, result);

        long result2 = GgtRekursiv.ggt(-1, 5);
        assertEquals(1, result2);

        long result3 = GgtRekursiv.ggt(1, -5);
        assertEquals(1, result3);

        long result4 = GgtRekursiv.ggt(-1, -5);
        assertEquals(1, result4);
    }
}
