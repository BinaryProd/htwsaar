import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

public class CDTest {

    /**
     * Test of get methods, of class CD.
     */
    @Test
    public void test_Get(){
        CD cd = new CD(1111, 0, 0.0, "Eminem","The Slim Shady LP", 20);
        assertEquals("Eminem", cd.getInterpret());
        assertEquals("The Slim Shady LP", cd.getTitel());
        assertEquals(20, cd.getAnzahlTitel());
    }

    /**
     * Constructor test for CD class without error.
     * Creates a new CD object and checks if the values are set correctly.
     */
    @Test
    public void test_Constructor_Ohne_Fehler() {
        CD cd1 = new CD(1111, 1, 2, "test", "titel", 1);

        assertEquals(1111, cd1.getArtikelNr());
        assertEquals(1, cd1.getBestand());
        assertEquals(2, cd1.getPreis());
        assertEquals("test", cd1.getInterpret());
        assertEquals("titel", cd1.getTitel());
        assertEquals(1, cd1.getAnzahlTitel());
    }
    
    /**
     * Test for setInterpret without error.
     * Sets the interpret of the CD object and checks if the value is set correctly.
     */
    @Test
    public void test_Set_Interpret_Ohne_Fehler() {
        CD cd1 = new CD(1111, 1, 2, "test", "titel", 1);

        cd1.setInterpret("test2");
        assertEquals("test2", cd1.getInterpret());

        cd1.setInterpret("3");
        assertEquals("3", cd1.getInterpret());
    }

    /**
     * Test for setInterpret with error.
     * Tries to set an empty interpret for the CD object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_Set_Interpret_Mit_Fehler() {
        CD cd1 = new CD(1111, 1, 2, "test", "titel", 1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            cd1.setInterpret("");
        });
    }

    /**
     * Test for setTitel without error.
     * Sets the Titel of the CD object and checks if the value is set correctly.
     */
    @Test
    public void test_Set_Titel_Ohne_Fehler() {
        CD cd1 = new CD(1111, 1, 2, "test", "titel", 1);
        
        cd1.setTitel("titel2");
        assertEquals("titel2", cd1.getTitel());

        cd1.setTitel("4");
        assertEquals("4", cd1.getTitel());
    }

    /**
     * Test for setTitel with error.
     * Tries to set an empty titel for the CD object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_Set_Titel_Mit_Fehler() {
        CD cd1 = new CD(1111, 1, 2, "test", "titel", 1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            cd1.setTitel("");
        });
    }

    /**
     * Test for setAnzahlTitel without error.
     * Sets the anzahlTitel of the CD object and checks if the value is set correctly.
     */
    @Test
    public void test_Set_AnzahlTitel_Ohne_Fehler() {
        CD cd1 = new CD(1111, 1, 2, "test", "titel", 1);
        
        cd1.setAnzahlTitel(2);
        assertEquals(2, cd1.getAnzahlTitel());

        cd1.setAnzahlTitel(100);
        assertEquals(100, cd1.getAnzahlTitel());
    }

    /**
     * Test for setAnzahlTitel with error.
     * Tries to set an false anzahlTitel for the CD object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_Set_AnzahlTitel_Mit_Fehler() {
        CD cd1 = new CD(1111, 1, 2, "test", "titel", 1);

        assertThrows(IllegalArgumentException.class, () -> {
            cd1.setAnzahlTitel(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            cd1.setAnzahlTitel(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            cd1.setAnzahlTitel(-100);
        });
    }

    /**
     * Test for getBeschreibung.
     * Gets the description of the CD object and checks if the value is correct.
     */
    @Test
    public void test_Get_Beschreibung() {
        CD cd1 = new CD(1111, 1, 2, "test", "titel", 1);
        
        assertEquals("test: titel", cd1.getBeschreibung());
    }
    
    /**
     * Test for toString.
     * Gets the string representation of the CD object and checks if the value is correct.
     */
    @Test
    public void test_toString() {
        CD cd1 = new CD(1111, 1, 2, "test", "titel", 1);
        assertEquals("\nArtikel: 1111, Art: Medien, Bestand: 1, Preis: 2.0, CD interpret: test, titel: titel, anzahlTitel: 1", cd1.toString());

        CD cd2 = new CD(2222, 2, 3, "test2", "titel", 9);
        assertEquals("\nArtikel: 2222, Art: Medien, Bestand: 2, Preis: 3.0, CD interpret: test2, titel: titel, anzahlTitel: 9", cd2.toString());
    }

    /**
     * Test for equals.
     * Compares two CD objects and checks if they are equal.
     */
    @Test
    public void test_equals() {
        CD cd1 = new CD(1111, 1, 2, "Titel 1", "bla", 2);
        CD cd2 = new CD(1111, 1, 2, "Titel 1", "bla", 2);
        CD cd3 = new CD(1234, 1, 2,"Titel 2", "bla", 2);
        CD cd4 = new CD(1234, 1, 2, "Titel 1", "bi", 2);
        CD cd5 = new CD(1234, 1, 2, "Titel 1", "bla", 1);
        CD cd6 = new CD(1234, 2, 2, "Titel 1", "bla", 2);
        CD cd7 = new CD(1234, 1, 2, "Titel 1", "bla", 2);
        CD cd8 = new CD(1234, 1, 3, "Titel 1", "bla", 2);

        // Test for equality
        assertEquals(cd1, cd2);

        // Test for inequality
        assertNotEquals(cd1, cd3);
        assertNotEquals(cd1, cd4);
        assertNotEquals(cd1, cd5);
        assertNotEquals(cd1, cd6);
        assertNotEquals(cd1, cd7);
        assertNotEquals(cd1, cd8);
    }

    /**
     * Test for hashCode.
     * Gets the hash code of the CD object and checks if the value is correct.
     */
    @Test
    public void test_hashCod() {
        CD cd1= new CD(1111, 1, 2, "test", "titel", 1);
        Artikel artikel1 = new Artikel(1111, "Medien",1, 2);

        assertEquals(Objects.hash(artikel1.hashCode(), "test", "titel", 1), cd1.hashCode());
    }
}
