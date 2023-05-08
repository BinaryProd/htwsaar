import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WasserTest {

    private Wasser wasserStandardKonstruktor;
    private Wasser wasserOhneNameKonstruktor;
    private Wasser wasserGanzerKonstruktor;
    private Wasser wasserGanzerKonstruktorSame;
    private Wasser wasserGanzerKonstruktorDifferent;

    @BeforeEach
    public void setup() {
        wasserStandardKonstruktor = new Wasser();
        wasserOhneNameKonstruktor = new Wasser("Adelholzener AlpenQuelle GmbH", "Adelholzener AlpenQuelle");
        wasserGanzerKonstruktor = new Wasser("Gerolsteiner", "Gerolsteiner Brunnen GmbH & Co. KG", "Gerolsteiner Quelle");
        wasserGanzerKonstruktorSame = new Wasser("Gerolsteiner", "Gerolsteiner Brunnen GmbH & Co. KG", "Gerolsteiner Quelle");
        wasserGanzerKonstruktorDifferent = new Wasser("Vilsa", "Vilsa-Brunnen Otto Rodekohr GmbH & Co. KG", "Vilsa Quelle");
    }

    @Test
    public void testStandardKonstruktor() {
        assertEquals("Name", wasserStandardKonstruktor.getName());
        assertEquals("Hersteller", wasserStandardKonstruktor.getHersteller());
        assertEquals("Quelle", wasserStandardKonstruktor.getQuelle());
    }

    @Test
    public void testKonstructorOhneName() {
        assertEquals("Adelholzener AlpenQuelle GmbH", wasserOhneNameKonstruktor.getHersteller());
        assertEquals("Adelholzener AlpenQuelle", wasserOhneNameKonstruktor.getQuelle());
    }

    @Test
    public void testGanzerKonstruktor() {
        assertEquals("Gerolsteiner", wasserGanzerKonstruktor.getName());
        assertEquals("Gerolsteiner Brunnen GmbH & Co. KG", wasserGanzerKonstruktor.getHersteller());
        assertEquals("Gerolsteiner Quelle", wasserGanzerKonstruktor.getQuelle());
    }

    @Test
    public void testEquals() {
        assertTrue(wasserGanzerKonstruktor.equals(wasserGanzerKonstruktor));
        assertTrue(wasserGanzerKonstruktor.equals(wasserGanzerKonstruktorSame));
        assertFalse(wasserGanzerKonstruktor.equals(wasserGanzerKonstruktorDifferent));
    }

    @Test
    public void testHashCode() {
        assertEquals(wasserGanzerKonstruktor.hashCode(), wasserGanzerKonstruktorSame.hashCode());
        assertNotEquals(wasserGanzerKonstruktor.hashCode(), wasserGanzerKonstruktorDifferent.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Getraenk: Gerolsteiner, Hersteller: Gerolsteiner Brunnen GmbH & Co. KG, Quelle: Gerolsteiner Quelle, Wasser", wasserGanzerKonstruktor.toString());
    }

}

