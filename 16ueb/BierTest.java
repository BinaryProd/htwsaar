/**
 * <h1> BierTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BierTest {

    private Bier bierStandardKonstruktor;
    private Bier bierOhneNameKonstruktor;
    private Bier bierGanzerKonstruktor;
    private Bier bierGanzerKonstruktorSame;
    private Bier bierGanzerKonstruktorDifferent;

    @BeforeEach
    public void setup() {
        bierStandardKonstruktor = new Bier();
        bierOhneNameKonstruktor = new Bier(12, "Krombacher");
        bierGanzerKonstruktor = new Bier("Krombacher Pils", 12f, "Krombacher");
        bierGanzerKonstruktorSame = new Bier("Krombacher Pils", 12f, "Krombacher");
        bierGanzerKonstruktorDifferent = new Bier("Kronenbourg Pils", 50f, "Kronenbourg");
    }

    @Test
    public void testStandardKonstruktor() {
        assertEquals("Name", bierStandardKonstruktor.getName());
        assertEquals("Brauerei", bierStandardKonstruktor.getBrauerei());
        assertEquals(0f, bierStandardKonstruktor.getAlkoholgehalt(), 0.001f);
    }

    @Test
    public void testKonstructorOhneName() {
        assertEquals("Krombacher", bierOhneNameKonstruktor.getBrauerei());
        assertEquals(12f, bierOhneNameKonstruktor.getAlkoholgehalt(), 0.001f);
    }

    @Test
    public void testGanzerKonstruktor() {
        assertEquals("Krombacher Pils", bierGanzerKonstruktor.getName());
        assertEquals("Krombacher", bierGanzerKonstruktor.getBrauerei());
        assertEquals(12, bierGanzerKonstruktor.getAlkoholgehalt(), 0.001f);
    }

    @Test
    public void testEquals() {
        assertTrue(bierGanzerKonstruktor.equals(bierGanzerKonstruktor));
        assertTrue(bierGanzerKonstruktor.equals(bierGanzerKonstruktorSame));
        assertFalse(bierGanzerKonstruktor.equals(bierGanzerKonstruktorDifferent));
    }

    @Test
    public void testHashCode() {
        assertEquals(bierGanzerKonstruktor.hashCode(), bierGanzerKonstruktorSame.hashCode());
        assertNotEquals(bierGanzerKonstruktor.hashCode(), bierGanzerKonstruktorDifferent.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Getraenk: Krombacher Pils, Alkoholgehalt: 12.0, Brauerei: Krombacher", bierGanzerKonstruktor.toString());
    }

}

