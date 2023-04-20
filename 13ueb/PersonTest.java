/**
 * <h1> PersonTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() throws Exception {
        person = new Person("Max", "Mustermann");
    }

    @Test
    public void testGetVorname() {
        assertEquals("Max", person.getVorname());
    }

    @Test
    public void testGetNachname() {
        assertEquals("Mustermann", person.getNachname());
    }

    @Test
    public void testToString() {
        assertEquals("Max Mustermann", person.toString());
    }

    @Test
    public void testEmptyVorname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person("", "Mustermann"));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testEmptyNachname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person("Max", ""));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testNullVorname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person(null, "Mustermann"));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testNullNachname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person("Max", null));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testWhitespaceVorname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person("  ", "Mustermann"));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testWhitespaceNachname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person("Max", "  "));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testEquals() {
        Person person1 = new Person("Max", "Mustermann");
        Person person2 = new Person("Max", "Mustermann");
        Person person3 = new Person("Hans", "Mueller");

        assertTrue(person1.equals(person1)); 
        assertTrue(person1.equals(person2));
        assertFalse(person1.equals(person3)); 
    }
}
