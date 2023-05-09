/**
 * <h1> RotweinTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RotweinTest {

    private Rotwein rotweinStandardKonstruktor;
    private Rotwein rotweinOhneNameKonstruktor;
    private Rotwein rotweinGanzerKonstruktor;
    private Rotwein rotweinGanzerKonstruktorSame;
    private Rotwein rotweinGanzerKonstruktorDifferent;

    @BeforeEach
    public void setup() {
        rotweinStandardKonstruktor = new Rotwein();
        rotweinOhneNameKonstruktor = new Rotwein(14.0f, "Pio Casare");
        rotweinGanzerKonstruktor = new Rotwein("Chateauneuf-du-Pape", 14.5f, "Domaine du Vieux Telegraphe");
        rotweinGanzerKonstruktorSame = new Rotwein("Chateauneuf-du-Pape", 14.5f, "Domaine du Vieux Telegraphe");
        rotweinGanzerKonstruktorDifferent = new Rotwein("Cabernet Sauvignon", 13.5f, "Chateau Margaux");
    }

    @Test
    public void testStandardKonstruktor() {
        assertEquals("Name", rotweinStandardKonstruktor.getName());
        assertEquals(0.0f, rotweinStandardKonstruktor.getAlkoholgehalt());
        assertEquals("Weingut", rotweinStandardKonstruktor.getWeingut());
    }

    @Test
    public void testKonstructorOhneName() {
        assertEquals(14.0f, rotweinOhneNameKonstruktor.getAlkoholgehalt());
        assertEquals("Pio Casare", rotweinOhneNameKonstruktor.getWeingut());
    }

    @Test
    public void testGanzerKonstruktor() {
        assertEquals("Chateauneuf-du-Pape", rotweinGanzerKonstruktor.getName());
        assertEquals(14.5f, rotweinGanzerKonstruktor.getAlkoholgehalt());
        assertEquals("Domaine du Vieux Telegraphe", rotweinGanzerKonstruktor.getWeingut());
    }

    @Test
    public void testEquals() {
        assertTrue(rotweinGanzerKonstruktor.equals(rotweinGanzerKonstruktor));
        assertTrue(rotweinGanzerKonstruktor.equals(rotweinGanzerKonstruktorSame));
        assertFalse(rotweinGanzerKonstruktor.equals(rotweinGanzerKonstruktorDifferent));
    }

    @Test
    public void testHashCode() {
        assertEquals(rotweinGanzerKonstruktor.hashCode(), rotweinGanzerKonstruktorSame.hashCode());
        assertNotEquals(rotweinGanzerKonstruktor.hashCode(), rotweinGanzerKonstruktorDifferent.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Getraenk: Chateauneuf-du-Pape, Alkoholgehalt: 14.5%, Weingut: Domaine du Vieux Telegraphe, Rotwein", rotweinGanzerKonstruktor.toString());
    }

}

