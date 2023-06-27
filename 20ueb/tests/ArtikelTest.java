import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

public class ArtikelTest {

    /**
     * Test of get methods, of class Artikel.
     */
    @Test
    public void test_Get_Methods() {
        Artikel artikel = new Artikel(1111, "Testartikel", 10, 10.0);
        assertEquals(1111, artikel.getArtikelNr());
        assertEquals("Testartikel", artikel.getArt());
        assertEquals(10, artikel.getBestand());
        assertEquals(10.0, artikel.getPreis());
    }

    /**
     * Test if the ArtikelNr is set correctly
     * Also test if the Constructor work correctly
     */
    @Test
    public void test_Constructor_Ohne_Fehler() {
        // Test the main constructor
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5);
        assertEquals(1000, artikel1.getArtikelNr());
        assertEquals("Erdbeere", artikel1.getArt());
        assertEquals(10, artikel1.getBestand());
        assertEquals(5, artikel1.getPreis());

        // Test the second constructor
        Artikel artikel2 = new Artikel(9999, "  Test Artikel 2  ", 3.0);
        assertEquals(9999, artikel2.getArtikelNr());
        assertEquals("Test Artikel 2", artikel2.getArt());
        assertEquals(0, artikel2.getBestand());
        assertEquals(3.0, artikel2.getPreis());
        
        // Test the third constructor
        Artikel artikel3 = new Artikel(5000, "Test Artikel 3",3.0);
        assertEquals(5000, artikel3.getArtikelNr());
        assertEquals("Test Artikel 3", artikel3.getArt());
        assertEquals(0, artikel3.getBestand());
        assertEquals(3.0, artikel3.getPreis());

    }

    /**
     * Test if the Constructor throw an Exception if the ArtikelNr is not valid
     */
    @Test
    public void test_Constructor_Mit_Fehler() {

        assertThrows(IllegalArgumentException.class, () -> new Artikel(-1, "Test Artikel 3", 3.0));
        assertThrows(IllegalArgumentException.class, () -> new Artikel(1, "Test Artikel 3", 3.0));
        assertThrows(IllegalArgumentException.class, () -> new Artikel(10000, "Test Artikel 4", 3.0));
        assertThrows(IllegalArgumentException.class, () -> new Artikel(999, "Test Artikel 5", 3.0));
    }

    /**
     * Test bucheZugang works correctly
     */
    @Test
    public void test_Buche_Zugang_Ohne_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(10, artikel1.getBestand());

        artikel1.bucheZugang(1);
        assertEquals(11, artikel1.getBestand());

        Artikel artikel2 = new Artikel(2000, "Erdbeere", 20, 10.0);
        assertEquals(20, artikel2.getBestand());

        artikel2.bucheZugang(10);
        assertEquals(30, artikel2.getBestand());
    }

    /**
     * Test bucheZugang throw an Exception if the value is not valid
     */
    @Test
    public void test_Buche_Zugang_Mit_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(10, artikel1.getBestand());

        assertThrows(IllegalArgumentException.class, () -> artikel1.bucheZugang(0));
        assertThrows(IllegalArgumentException.class, () -> artikel1.bucheZugang(-1));
        assertThrows(IllegalArgumentException.class, () -> artikel1.bucheZugang(-100));
    }

    /**
     * Test bucheAbgang works correctly
     */
    @Test
    public void test_Buche_Abgang_Ohne_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(10, artikel1.getBestand());

        artikel1.bucheAbgang(1);
        assertEquals(9, artikel1.getBestand());

        Artikel artikel2 = new Artikel(2000, "Erdbeere", 20, 10.0);
        assertEquals(20, artikel2.getBestand());

        artikel2.bucheAbgang(20);
        assertEquals(0, artikel2.getBestand());
    }

    /**
     * Test bucheAbgang throw an Exception if the value is not valid
     */
    @Test
    public void test_Buche_Abgang_Mit_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(10, artikel1.getBestand());

        assertThrows(IllegalArgumentException.class, () -> artikel1.bucheAbgang(0));
        assertThrows(IllegalArgumentException.class, () -> artikel1.bucheAbgang(-1));
        assertThrows(IllegalArgumentException.class, () -> artikel1.bucheAbgang(-100));
        assertThrows(IllegalArgumentException.class, () -> artikel1.bucheAbgang(11));

    }

    /**
     * Test for setArtikelNr without error
     */
    @Test
    public void test_Set_ArtikelNr_Ohne_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(1000, artikel1.getArtikelNr());

        artikel1.setArtikelNr(2000);
        assertEquals(2000, artikel1.getArtikelNr());

        Artikel artikel2 = new Artikel(2000, "Erdbeere", 20, 10.0);
        assertEquals(2000, artikel2.getArtikelNr());

        artikel2.setArtikelNr(3000);
        assertEquals(3000, artikel2.getArtikelNr());
    }

    /**
     * Test for setArtikelNr with error
     */
    @Test
    public void test_Set_ArtikelNr_Mit_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(1000, artikel1.getArtikelNr());

        assertThrows(IllegalArgumentException.class, () -> artikel1.setArtikelNr(-1));
        assertThrows(IllegalArgumentException.class, () -> artikel1.setArtikelNr(0));
        assertThrows(IllegalArgumentException.class, () -> artikel1.setArtikelNr(1));
        assertThrows(IllegalArgumentException.class, () -> artikel1.setArtikelNr(999));
        assertThrows(IllegalArgumentException.class, () -> artikel1.setArtikelNr(10000));
    }

    /**
     * Test for setArt without error
     */
    @Test
    public void test_Set_Art_Ohne_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals("Erdbeere", artikel1.getArt());

        artikel1.setArt("Apfel");
        assertEquals("Apfel", artikel1.getArt());

        Artikel artikel2 = new Artikel(2000, "Erdbeere", 20, 10.0);
        assertEquals("Erdbeere", artikel2.getArt());

        artikel2.setArt("Birne");
        assertEquals("Birne", artikel2.getArt());
    }

    /**
     * Test for setArt with error
     */
    @Test
    public void test_Set_Art_Mit_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals("Erdbeere", artikel1.getArt());

        assertThrows(IllegalArgumentException.class, () -> artikel1.setArt(""));
        assertThrows(IllegalArgumentException.class, () -> artikel1.setArt(" "));
    }

    /**
     * Test for setBestand without error
     */
    @Test
    public void test_Set_Bestand_Ohne_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(10, artikel1.getBestand());

        artikel1.setBestand(20);
        assertEquals(20, artikel1.getBestand());

        Artikel artikel2 = new Artikel(2000, "Erdbeere", 20, 10.0);
        assertEquals(20, artikel2.getBestand());

        artikel2.setBestand(30);
        assertEquals(30, artikel2.getBestand());
    }

    /**
     * Test for setBestand with error
     */
    @Test
    public void test_Set_Bestand_Mit_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(10, artikel1.getBestand());

        assertThrows(IllegalArgumentException.class, () -> artikel1.setBestand(-1));
        assertThrows(IllegalArgumentException.class, () -> artikel1.setBestand(-100));
    }

    /**
     * Test for setPreis without error
     */
    @Test
    public void test_Set_Preis_Ohne_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(5.0, artikel1.getPreis());

        artikel1.setPreis(0.0);
        assertEquals(0.0, artikel1.getPreis());

        Artikel artikel2 = new Artikel(2000, "Erdbeere", 20, 10.0);
        assertEquals(10.0, artikel2.getPreis());

        artikel2.setPreis(20.0);
        assertEquals(20.0, artikel2.getPreis());
    }

    /**
     * Test for setPreis with error
     */
    @Test
    public void test_Set_Preis_Mit_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(5.0, artikel1.getPreis());

        assertThrows(IllegalArgumentException.class, () -> artikel1.setPreis(-1));
        assertThrows(IllegalArgumentException.class, () -> artikel1.setPreis(-100));
    }

    /**
     * Test for aenderePreis ohne Fehler
     */
    @Test
    public void test_Aendere_Preis_Ohne_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(5.0, artikel1.getPreis());

        artikel1.aenderePreis(10.0);
        assertEquals(5.5, artikel1.getPreis());

        Artikel artikel2 = new Artikel(2000, "Erdbeere", 20, 10.0);
        assertEquals(10.0, artikel2.getPreis());

        artikel2.aenderePreis(20.0);
        assertEquals(12.0, artikel2.getPreis());

        Artikel artikel3 = new Artikel(3000, "Erdbeere", 30, 15.0);
        assertEquals(15.0, artikel3.getPreis());

        artikel3.aenderePreis(-30.0);
        assertEquals(10.5, artikel3.getPreis());
    }

    /**
     * Test for aenderePreis mit Fehler
     */
    @Test
    public void test_Aendere_Preis_Mit_Fehler() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(5.0, artikel1.getPreis());

        assertThrows(IllegalArgumentException.class, () -> artikel1.aenderePreis(-200));
        assertThrows(IllegalArgumentException.class, () -> artikel1.aenderePreis(-500));
    }

    /**
     * Test for gesamtPreis
     */
    @Test
    public void test_Gesamt_Preis() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(50.0, artikel1.gesamtPreis());

        Artikel artikel2 = new Artikel(2000, "Erdbeere", 20, 10.0);
        assertEquals(200.0, artikel2.gesamtPreis());

        Artikel artikel3 = new Artikel(3000, "Erdbeere", 30, 15.0);
        assertEquals(450.0, artikel3.gesamtPreis());
    }

    /**
     * Test if the toString method works correctly
     */
    @Test
    public void test_toString() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals("\nArtikel: 1000, Art: Erdbeere, Bestand: 10, Preis: 5.0", artikel1.toString());
    }

    /**
     * Test if the equals method works correctly
     */
    @Test
    public void test_Equals() {
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        Artikel artikel2 = new Artikel(1000, "Erdbeere", 10, 5.0);
        Artikel artikel3 = new Artikel(1000, "Erdbeere", 10, 5.5);
        Artikel artikel4 = new Artikel(1000, "Erdbeere", 11, 5.0);
        Artikel artikel5 = new Artikel(1111, "Erdbeere", 10, 5.0);
        Artikel artikel6 = new Artikel(1000, "Himbeere", 10, 5.0);

        // Test equality
        assertEquals(artikel1, artikel2);

        // Test inequality
        assertNotEquals(artikel1, artikel3);
        assertNotEquals(artikel1, artikel4);
        assertNotEquals(artikel1, artikel5);
        assertNotEquals(artikel1, artikel6);
    }

    /**
     * Test if the hashCode method works correctly
     */
    @Test
    public void test_hashCode(){
        Artikel artikel1 = new Artikel(1000, "Erdbeere", 10, 5.0);
        assertEquals(Objects.hash(1000, "Erdbeere", 10, 5.0), artikel1.hashCode());
    }
}
