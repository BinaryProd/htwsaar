import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MittelwertTest {

    /**
     * Tests the constructor and getter methods of the Mittelwert class.
     */
    @Test
    public void Test_Constructor_And_Getter_Ohne_Fehler() {
        Mittelwert m = new Mittelwert(1, 2, 3);
        assertEquals(1, m.getMittelwert(), 0.0001);
        assertEquals(2, m.getNaehesterWert(), 0.0001);
        assertEquals(3, m.getEntferntesterWert(), 0.0001);
    }

    /**
     * Tests the toString method.
     */
    @Test
    public void Test_ToString_Ohne_Fehler() {
        Mittelwert m = new Mittelwert(1, 2, 3);
        assertEquals("Mittelwert: 1.0, Naehstewert: 2.0, Weitestenwert: 3.0", m.toString());
    }
}

