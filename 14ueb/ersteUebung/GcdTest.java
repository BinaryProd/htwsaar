import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GcdTest {

    @Test
    public void testGcd() {
        long result = Gcd.gcd(10, 25);
        assertEquals(5, result);
    }
    
    @Test
    public void testGcdWithZero() {
        long result = Gcd.gcd(25, 0);
        assertEquals(0, result);
        
        long result2 = Gcd.gcd(0, 25);
        assertEquals(0, result2);
    }
    
    @Test
    public void testGcdWithNegativeNumbers()  {
        assertThrows(GcdException.class, () -> Gcd.gcd(-10, 25));
        
        assertThrows(GcdException.class, () -> Gcd.gcd(10, -25));

        assertThrows(GcdException.class, () -> Gcd.gcd(-10, -10));
    }
    
    @Test
    public void testGcdWithSameNumbers()  {
        long result = Gcd.gcd(10, 10);
        assertEquals(10, result);
    }
    
    @Test
    public void testGcdWithOneNumber()  {
        long result1 = Gcd.gcd(10, 1);
        assertEquals(1, result1);
        
        long result2 = Gcd.gcd(1, 10);
        assertEquals(1, result2);
    }
    
    @Test
    public void testGcdWithLargeNumbers()  {
        long result = Gcd.gcd(1000000000, 500000000);
        assertEquals(500000000, result);
    }
}

