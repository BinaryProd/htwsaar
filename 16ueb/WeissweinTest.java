/**
 * <h1> WeissweinTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeissweinTest {

    private Weisswein weissweinStandardKonstruktor;
    private Weisswein weissweinOhneNameKonstruktor;
    private Weisswein weissweinGanzerKonstruktor;
    private Weisswein weissweinGanzerKonstruktorSame;
    private Weisswein weissweinGanzerKonstruktorDifferent;

    @BeforeEach
    public void setup() {
        weissweinStandardKonstruktor = new Weisswein();
        weissweinOhneNameKonstruktor = new Weisswein(13.5f, "Domaine de la Vougeraie");
        weissweinGanzerKonstruktor = new Weisswein("Riesling Kabinett", 11.5f, "Schloss Johannisberg");
        weissweinGanzerKonstruktorSame = new Weisswein("Riesling Kabinett", 11.5f, "Schloss Johannisberg");
        weissweinGanzerKonstruktorDifferent = new Weisswein("Gruener Veltiliner", 12.5f, "Weingut Bruendlmaier");
    }

    @Test
    public void testStandardKonstruktor() {
        assertEquals("Name", weissweinStandardKonstruktor.getName());
        assertEquals(0.0f, weissweinStandardKonstruktor.getAlkoholgehalt());
        assertEquals("Weingut", weissweinStandardKonstruktor.getWeingut());
    }

    @Test
    public void testKonstructorOhneName() {
        assertEquals(13.5f, weissweinOhneNameKonstruktor.getAlkoholgehalt());
        assertEquals("Domaine de la Vougeraie", weissweinOhneNameKonstruktor.getWeingut());
    }

    @Test
    public void testGanzerKonstruktor() {
        assertEquals("Riesling Kabinett", weissweinGanzerKonstruktor.getName());
        assertEquals(11.5f, weissweinGanzerKonstruktor.getAlkoholgehalt());
        assertEquals("Schloss Johannisberg", weissweinGanzerKonstruktor.getWeingut());
    }

    @Test
    public void testEquals() {
        assertTrue(weissweinGanzerKonstruktor.equals(weissweinGanzerKonstruktor));
        assertTrue(weissweinGanzerKonstruktor.equals(weissweinGanzerKonstruktorSame));
        assertFalse(weissweinGanzerKonstruktor.equals(weissweinGanzerKonstruktorDifferent));
    }

    @Test
    public void testHashCode() {
        assertEquals(weissweinGanzerKonstruktor.hashCode(), weissweinGanzerKonstruktorSame.hashCode());
        assertNotEquals(weissweinGanzerKonstruktor.hashCode(), weissweinGanzerKonstruktorDifferent.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Getraenk: Riesling Kabinett, Alkoholgehalt: 11.5%, Weingut: Schloss Johannisberg, Weisswein", weissweinGanzerKonstruktor.toString());
    }

}

