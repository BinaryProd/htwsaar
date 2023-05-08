/**
 * <h1> SoftdrinkTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SoftdrinkTest {

    private Softdrink softdrinkStandardKonstruktor;
    private Softdrink softdrinkOhneNameKonstruktor;
    private Softdrink softdrinkGanzerKonstruktor;
    private Softdrink softdrinkGanzerKonstruktorSame;
    private Softdrink softdrinkGanzerKonstruktorDifferent;

    @BeforeEach
    public void setup() {
        softdrinkStandardKonstruktor = new Softdrink();
        softdrinkOhneNameKonstruktor = new Softdrink("Coca-Cola Company", 106.4f);
        softdrinkGanzerKonstruktor = new Softdrink("Fanta Orange", "Coca-Cola Company", 130.9f);
        softdrinkGanzerKonstruktorSame = new Softdrink("Fanta Orange", "Coca-Cola Company", 130.9f);
        softdrinkGanzerKonstruktorDifferent = new Softdrink("Orangina", "Schweppes International Limited", 42.3f);
    }

    @Test
    public void testStandardKonstruktor() {
        assertEquals("Name", softdrinkStandardKonstruktor.getName());
        assertEquals("Hersteller", softdrinkStandardKonstruktor.getHersteller());
        assertEquals(0.0f, softdrinkStandardKonstruktor.getZuckergehalt(), 0.001f);
    }

    @Test
    public void testKonstructorOhneName() {
        assertEquals("Coca-Cola Company", softdrinkOhneNameKonstruktor.getHersteller());
        assertEquals(106.4f, softdrinkOhneNameKonstruktor.getZuckergehalt(), 0.001f);
    }

    @Test
    public void testGanzerKonstruktor() {
        assertEquals("Fanta Orange", softdrinkGanzerKonstruktor.getName());
        assertEquals("Coca-Cola Company", softdrinkGanzerKonstruktor.getHersteller());
        assertEquals(130.9f, softdrinkGanzerKonstruktor.getZuckergehalt(), 0.001f);
    }

    @Test
    public void testEquals() {
        assertTrue(softdrinkGanzerKonstruktor.equals(softdrinkGanzerKonstruktor));
        assertTrue(softdrinkGanzerKonstruktor.equals(softdrinkGanzerKonstruktorSame));
        assertFalse(softdrinkGanzerKonstruktor.equals(softdrinkGanzerKonstruktorDifferent));
    }

    @Test
    public void testHashCode() {
        assertEquals(softdrinkGanzerKonstruktor.hashCode(), softdrinkGanzerKonstruktorSame.hashCode());
        assertNotEquals(softdrinkGanzerKonstruktor.hashCode(), softdrinkGanzerKonstruktorDifferent.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Getraenk: Fanta Orange, Hersteller: Coca-Cola Company, Zuckergehalt: 130.9, Softdrink", softdrinkGanzerKonstruktor.toString());
    }

}

