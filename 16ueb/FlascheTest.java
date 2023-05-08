/**
 * <h1> FlascheTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.0
 * @since 2023-04-11
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class FlascheTest {

    private Wasser wasser;
    private Wasser wasser2;
    private Softdrink softdrink;
    private Flasche<Wasser> flasche;
    private Flasche<Wasser> flasche1;
    private Flasche<Softdrink> flasche2;

    @BeforeEach
    public void setUp() {
        this.wasser = new Wasser();
        this.wasser2 = new Wasser();
        this.softdrink = new Softdrink();
        this.flasche = new Flasche<>();
        this.flasche1 = new Flasche<>();
        this.flasche2 = new Flasche<>();
    }

    @Test
    public void testFuellen() {
        assertFalse(flasche.istGefuellt());
        flasche.fuellen(wasser);
        assertTrue(flasche.istGefuellt());
        assertEquals(wasser, flasche.getInhalt());
        
        try {
            flasche.fuellen(wasser2);
            fail("Expected FlascheException was not thrown");
        } catch (FlascheException e) {
            assertEquals("Flasche ist bereits gefuellt", e.getMessage());
        }
    }

    @Test
    public void testLeeren() throws FlascheException {
        flasche.fuellen(wasser);

        assertTrue(flasche.istGefuellt());
        flasche.leeren();
        assertFalse(flasche.istGefuellt());
        assertNull(flasche.getInhalt());

        try {
            flasche.leeren();
            fail("Expected FlascheException was not thrown");
        } catch (FlascheException e) {
            assertEquals("Flasche ist bereits leer", e.getMessage());
        }
    }

    @Test
    public void testEquals() {
        flasche.fuellen(wasser);
        flasche1.fuellen(wasser2);
        flasche2.fuellen(softdrink);

        assertTrue(flasche.equals(flasche1));
        assertFalse(flasche1.equals(flasche2));
        assertFalse(flasche1.equals("Bier"));
    }

    @Test
    public void testHashCode() {
        flasche.fuellen(wasser);
        flasche1.fuellen(wasser2);
        flasche2.fuellen(softdrink);

        assertEquals(flasche.hashCode(), flasche1.hashCode());
        assertNotEquals(flasche.hashCode(), flasche2.hashCode());
    }
}

