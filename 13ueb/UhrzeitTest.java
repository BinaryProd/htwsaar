/**
 * <h1> UhrzeitTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UhrzeitTest {

    private Uhrzeit uhrzeit;

    @BeforeEach
    public void setUp() {
        uhrzeit = new Uhrzeit(10, 30);
    }

    @Test
    public void testGetStunde() {
        assertEquals(10, uhrzeit.getStunde());
    }

    @Test
    public void testGetMinute() {
        assertEquals(30, uhrzeit.getMinute());
    }

    @Test
    public void testToString() {
        assertEquals("10:30 Uhr", uhrzeit.toString());
    }

    @Test
    public void testCompareTo() {
        Uhrzeit otherUhrzeit = new Uhrzeit(12, 15);

        assertTrue(uhrzeit.compareTo(otherUhrzeit) < 0); 
        assertTrue(otherUhrzeit.compareTo(uhrzeit) > 0);
        assertEquals(0, uhrzeit.compareTo(new Uhrzeit(10, 30)));
    }

    @Test
    public void testIstNachBeginException(){
        Uhrzeit beginn = new Uhrzeit(12, 15);
        Exception exception = assertThrows(UhrzeitException.class, () -> uhrzeit.istNachBegin(beginn));
        assertEquals("Die beginn Stunde soll kleiner als die end Stunde sein", exception.getMessage());
    }

    @Test
    public void testEquals() {
        assertTrue(uhrzeit.equals(new Uhrzeit(10, 30)));
        assertFalse(uhrzeit.equals(new Uhrzeit(10, 31)));
        assertFalse(uhrzeit.equals(new Uhrzeit(11, 30)));
        assertFalse(uhrzeit.equals(new Uhrzeit(11, 31)));
    }
}

