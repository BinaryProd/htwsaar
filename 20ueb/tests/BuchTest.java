import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

public class BuchTest {

    /**
     * Test of get methods, of class Buch.
     */
    @Test
    public void test_Get() {
        Buch buch = new Buch(1111, 0, 0.0, "Java ist auch eine Insel", "Christian Ullenboom", "Rheinwerk");
        assertEquals("Java ist auch eine Insel", buch.getTitel());
        assertEquals("Christian Ullenboom", buch.getAutor());
        assertEquals("Rheinwerk", buch.getVerlag());
    }

    /**
     * Constructor test for Buch class without error.
     * Creates a new Buch object and checks if the values are set correctly.
     */
    @Test
    public void test_Constructor_Ohne_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");

        assertEquals(1111, buch1.getArtikelNr());
        assertEquals(1, buch1.getBestand());
        assertEquals(2, buch1.getPreis());
        assertEquals("titel", buch1.getTitel());
        assertEquals("autor", buch1.getAutor());
        assertEquals("verlag", buch1.getVerlag());
    }

    /**
     * Test for setTitel without error.
     * Sets the title of the Buch object and checks if the value is set correctly.
     */
    @Test
    public void test_SetTitel_Ohne_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");

        buch1.setTitel("test2");
        assertEquals("test2", buch1.getTitel());

        buch1.setTitel(" 3 ");
        assertEquals("3", buch1.getTitel());
    }

    /**
     * Test for setTitel with error.
     * Tries to set an empty title for the Buch object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_Set_Titel_Mit_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");

        assertThrows(IllegalArgumentException.class, () -> {
            buch1.setTitel("");
        });
    }

    /**
     * Test for setAutor without error.
     * Sets the autor of the Buch object and checks if the value is set correctly.
     */
    @Test
    public void test_Set_Autor_Ohne_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");

        buch1.setAutor("autor2");
        assertEquals("autor2", buch1.getAutor());

        buch1.setAutor("4");
        assertEquals("4", buch1.getAutor());
    }

    /**
     * Test for setAutor with error.
     * Tries to set an empty autor for the Buch object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_Set_Autor_Mit_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");

        assertThrows(IllegalArgumentException.class, () -> {
            buch1.setAutor("");
        });
    }

    /**
     * Test for setVerlag without error.
     * Sets the verlag of the Buch object and checks if the value is set correctly.
     */
    @Test
    public void test_Set_Verlag_Ohne_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");

        buch1.setVerlag("verlag2");
        assertEquals("verlag2", buch1.getVerlag());

        buch1.setVerlag("5");
        assertEquals("5", buch1.getVerlag());
    }

    /**
     * Test for setVerlag with error.
     * Tries to set an empty verlag for the Buch object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_Set_Verlag_Mit_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");

        assertThrows(IllegalArgumentException.class, () -> {
            buch1.setVerlag("");
        });
    }

    /**
     * Test for getBeschreibung.
     * Gets the description of the Buch object and checks if the value is correct.
     */
    @Test
    public void test_Get_Beschreibung() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");

        assertEquals("autor: titel", buch1.getBeschreibung());
    }

    /**
     * Test for toString.
     * Gets the string representation of the Buch object and checks if the value is correct.
     */
    @Test
    public void test_toString() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");
        assertEquals("\nArtikel: 1111, Art: Medien, Bestand: 1, Preis: 2.0, Buch titel: titel, autor: autor, verlag: verlag", buch1.toString());

        Buch buch2 = new Buch(2222, 2, 3, "titel1", "autor1", "verlag1");
        assertEquals("\nArtikel: 2222, Art: Medien, Bestand: 2, Preis: 3.0, Buch titel: titel1, autor: autor1, verlag: verlag1", buch2.toString());
    }

    /**
     * Test for equals.
     * Compares two Buch objects and checks if they are equal.
     */
    @Test
    public void test_equals() {

        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");
        Buch buch2 = new Buch(1111, 1, 2, "titel", "autor", "verlag");
        Buch buch3 = new Buch(1111, 1, 2, "titel1", "autor", "verlag");
        Buch buch4 = new Buch(1111, 1, 2, "titel", "autor1", "verlag");
        Buch buch5 = new Buch(1111, 1, 2, "titel", "autor", "verlag1");
        Buch buch6 = new Buch(1111, 2, 2, "titel", "autor", "verlag");
        Buch buch7 = new Buch(1234, 1, 2, "titel", "autor", "verlag");
        Buch buch8 = new Buch(1111, 1, 3, "titel", "autor", "verlag");

        // Test for equality
        assertEquals(buch1, buch2);

        // Test for inequality
        assertNotEquals(buch1, buch3);
        assertNotEquals(buch1, buch4);
        assertNotEquals(buch1, buch5);
        assertNotEquals(buch1, buch6);
        assertNotEquals(buch1, buch7);
        assertNotEquals(buch1, buch8);
    }

    /**
     * Test for hashCode.
     * Gets the hash code of the Buch object and checks if the value is correct.
     */
    @Test
    public void test_hashCode() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "autor", "verlag");
        Artikel artikel1 = new Artikel(1111, "Medien",1, 2);

        assertEquals(Objects.hash(artikel1.hashCode(), "titel", "autor", "verlag"), buch1.hashCode());
    }
}
