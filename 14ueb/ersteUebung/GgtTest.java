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
    public void testGgt() {
        long result = Ggt.ggt(10, 25);
        assertEquals(5, result);
    }
    
    @Test
    public void testGgtWithZero() {
        long result = Ggt.ggt(25, 0);
        assertEquals(25, result);
        
        long result2 = Ggt.ggt(0, 25);
        assertEquals(25, result2);
    }
    
    @Test
    public void testGgtWithNegativeNumbers()  {
        assertThrows(GgtException.class, () -> Ggt.ggt(-10, 25));
        
        assertThrows(GgtException.class, () -> Ggt.ggt(10, -25));

        assertThrows(GgtException.class, () -> Ggt.ggt(-10, -10));
    }
    
    @Test
    public void testGgtWithSameNumbers()  {
        long result = Ggt.ggt(10, 10);
        assertEquals(10, result);
    }
    
    @Test
    public void testGgtWithOneNumber()  {
        long result1 = Ggt.ggt(10, 1);
        assertEquals(1, result1);
        
        long result2 = Ggt.ggt(1, 10);
        assertEquals(1, result2);
    }
    
    @Test
    public void testGgtWithLargeNumbers()  {
        long result = Ggt.ggt(1000000000, 500000000);
        assertEquals(500000000, result);
    }
}

