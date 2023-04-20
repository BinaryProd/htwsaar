/**
 * <h1> MitarbeiterTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MitarbeiterTest {

    private Mitarbeiter mitarbeiter;

    @BeforeEach
    public void setUp() {
        mitarbeiter = new Mitarbeiter("Max", "Mustermann", "max.mustermann@example.com");
    }

    @Test
    public void testConstructor() {
        assertEquals("Max", mitarbeiter.getVorname());
        assertEquals("Mustermann", mitarbeiter.getNachname());
        assertEquals("max.mustermann@example.com", mitarbeiter.getEmail());
    }

    @Test
    public void testConstructorWithEmptyVorname() {
        assertThrows(PersonException.class, () -> new Mitarbeiter("", "Mustermann", "max.mustermann@example.com"));
    }

    @Test
    public void testConstructorWithEmptyNachname() {
        assertThrows(PersonException.class, () -> new Mitarbeiter("Max", "", "max.mustermann@example.com"));
    }

    @Test
    public void testConstructorWithEmptyEmail() {
        assertThrows(MitarbeiterException.class, () -> new Mitarbeiter("Max", "Mustermann", ""));
    }

    @Test
    public void testToString() {
        assertEquals("Max Mustermann (max.mustermann@example.com)", mitarbeiter.toString());
    }

    @Test
    public void testEquals() {
        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Max", "Mustermann", "max.mustermann@example.com");
        Mitarbeiter mitarbeiter2 = new Mitarbeiter("Max", "Mustermann", "max.mustermann@example.com");
        Mitarbeiter mitarbeiter3 = new Mitarbeiter("Hans", "Mueller", "hans.mueller@example.com");

        assertTrue(mitarbeiter1.equals(mitarbeiter2));
        assertFalse(mitarbeiter1.equals(mitarbeiter3));
    }
}
