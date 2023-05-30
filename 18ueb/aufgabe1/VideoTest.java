import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

public class VideoTest {

    /**
     * Test of get methods, of class Video.
     */
    @Test
    public void test_Get(){
        Video video = new Video(1111, 0, 0.0, "Interstellar", 169, 2014);
        assertEquals("Interstellar", video.getTitel());
        assertEquals(169, video.getSpieldauer());
        assertEquals(2014, video.getJahr());
    }

    /**
     * Constructor test for Video class without error.
     * Creates a new Video object and checks if the values are set correctly.
     */
    @Test
    public void test_Constructor_Ohne_Fehler() {
        Video v1 = new Video(1111, 1, 2, "test", 3, 2000);

        assertEquals(1111, v1.getArtikelNr());
        assertEquals(1, v1.getBestand());
        assertEquals(2, v1.getPreis());
        assertEquals("test", v1.getTitel());
        assertEquals(3, v1.getSpieldauer());
        assertEquals(2000, v1.getJahr());
    }

    /**
     * Test for setTitel without error.
     * Sets the title of the Video object and checks if the value is set correctly.
     */    
    @Test
    public void test_Set_Titel_Ohne_Fehler() {
        Video v1 = new Video(1111, 1, 2, "test", 3, 2000);

        v1.setTitel("test2");
        assertEquals("test2", v1.getTitel());

        v1.setTitel("3");
        assertEquals("3", v1.getTitel());
    }

    /**
     * Test for setTitel with error.
     * Tries to set an empty title for the Video object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_Set_Titel_Mit_Fehler() {
        Video v1 = new Video(1111, 1, 2, "test", 3, 2000);
        
        assertThrows(IllegalArgumentException.class, () -> {
            v1.setTitel("");
        });
    }

    /**
     * Test for setSpieldauer without error.
     * Sets the spieldauer of the Video object and checks if the value is set correctly.
     */
    @Test
    public void test_Set_Spieldauer_Ohne_Fehler() {
        Video v1 = new Video(1111, 1, 2, "test", 3, 2000);
        
        v1.setSpieldauer(4);
        assertEquals(4, v1.getSpieldauer());

        v1.setSpieldauer(100);
        assertEquals(100, v1.getSpieldauer());
    }

    /**
     * Test for setSpieldauer with error.
     * Tries to set an false spieldauer for the Video object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_Set_Spieldauer_Mit_Fehler() {
        Video v1 = new Video(1111, 1, 2, "test", 3, 2000);
        
        assertThrows(IllegalArgumentException.class, () -> {
            v1.setSpieldauer(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            v1.setSpieldauer(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            v1.setSpieldauer(-100);
        });
    }

    /**
     * Test for setJahr without error.
     * Sets the Jahr of the Video object and checks if the value is set correctly.
     */
    @Test
    public void test_Set_Jahr_Ohne_Fehler() {
        Video v1 = new Video(1111, 1, 2, "test", 3, 2000);
        
        v1.setJahr(2001);
        assertEquals(2001, v1.getJahr());

        v1.setJahr(2022);
        assertEquals(2022, v1.getJahr());

        v1.setJahr(1900);
        assertEquals(1900, v1.getJahr());
    }

    /**
     * Test for setJahr with error.
     * Tries to set an false Jahr for the Video object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_Set_Jahr_Mit_Fehler() {
        Video v1 = new Video(1111, 1, 2, "test", 3, 2000);

        assertThrows(IllegalArgumentException.class, () -> {
            v1.setJahr(1899);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            v1.setJahr(2023);
        });
    }

    /**
     * Test for getBeschreibung.
     * Gets the description of the Video object and checks if the value is correct.
     */
    @Test
    public void test_Get_Beschreibung() {
        Video v1 = new Video(1111, 1, 2, "test", 3, 2000);
        
        assertEquals("test", v1.getBeschreibung());
    }
    
    /**
     * Test for toString.
     * Gets the string representation of the Video object and checks if the value is correct.
     */
    @Test
    public void test_toString() {
        Video v1 = new Video(1111, 1, 2, "test", 3, 2000);
        assertEquals("\nArtikel: 1111, Art: Medien, Bestand: 1, Preis: 2.0, Video titel: test, spieldauer: 3, jahr: 2000", v1.toString());

        Video v2 = new Video(2222, 2, 3, "test2", 4, 1900);
        assertEquals("\nArtikel: 2222, Art: Medien, Bestand: 2, Preis: 3.0, Video titel: test2, spieldauer: 4, jahr: 1900", v2.toString());
    }

    /**
     * Test for equals.
     * Compares two Video objects and checks if they are equal.
     */
    @Test
    public void test_equals() {
        Video video1 = new Video(1111, 1, 2, "Titel 1", 3, 2020);
        Video video2 = new Video(1111, 1, 2, "Titel 1", 3, 2020);
        Video video3 = new Video(1234, 1, 2,"Titel 2", 3, 2020);
        Video video4 = new Video(1234, 1, 2, "Titel 1", 4, 2020);
        Video video5 = new Video(1234, 1, 2, "Titel 1", 3, 2021);
        Video video6 = new Video(1234, 2, 2, "Titel 1", 3, 2020);
        Video video7 = new Video(1234, 1, 2, "Titel 1", 3, 2020);
        Video video8 = new Video(1234, 1, 3, "Titel 1", 3, 2020);

        // Test for equality
        assertEquals(video1, video2);

        // Test for inequality
        assertNotEquals(video1, video3);
        assertNotEquals(video1, video4);
        assertNotEquals(video1, video5);
        assertNotEquals(video1, video6);
        assertNotEquals(video1, video7);
        assertNotEquals(video1, video8);
    }


    /**
     * Test for hashCode.
     * Compares the hashcode of two Video objects and checks if they are equal.
     */
    @Test
    public void test_hashCode() {
        Video video1= new Video(1111, 1, 2, "Titel 1", 2, 2020);
        Artikel artikel1 = new Artikel(1111, "Medien",1, 2);

        assertEquals(Objects.hash(artikel1.hashCode(), "Titel 1", 2, 2020), video1.hashCode());
    }
}
