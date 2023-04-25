import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

public class PersonTest {

    /**
     * Test if the ArtikelNr is set correctly
     * Also test if the Constructor work correctly
     */
    @Test
    public void test_Constructor_Ohne_Fehler() {
        Person person = new Person("Ele", "Phant");
        assertEquals("Ele", person.getVorname());
        assertEquals("Phant", person.getName());

        Person person2 = new Person("Tom", "Ate");
        assertEquals("Tom", person2.getVorname());
        assertEquals("Ate", person2.getName());

        Person person3 = new Person("Ana", "Nas");
        assertEquals("Ana", person3.getVorname());
        assertEquals("Nas", person3.getName());
    }

    /**
     * Test if the Constructor throw an Exception if the ArtikelNr is not valid
     */
    @Test
    public void test_Constructor_Mit_Fehler() {
        assertThrows(QueueException.class, () -> {
            Person person = new Person("Ele", "");
        });
        assertThrows(QueueException.class, () -> {
            Person person = new Person("", "Phant");
        });
        assertThrows(QueueException.class, () -> {
            Person person = new Person("", "");
        });
    }

    @Test
    public void test_setName() {
        Person person = new Person("Ele", "Phant");
        person.setName("Nas");
        assertEquals("Nas", person.getName());
    }

    @Test
    public void test_setVorname() {
        Person person = new Person("Ele", "Phant");
        person.setVorname("Ana");
        assertEquals("Ana", person.getVorname());
    }

    @Test
    public void test_setName_Mit_Fehler() {
        Person person = new Person("Ele", "Phant");
        assertThrows(QueueException.class, () -> {
            person.setName("");
        });
    }

    @Test
    public void test_setVorname_Mit_Fehler() {
        Person person = new Person("Ele", "Phant");
        assertThrows(QueueException.class, () -> {
            person.setVorname("");
        });
    }

    @Test
    public void test_toString() {
        Person person = new Person("Ele", "Phant");
        assertEquals("Ele Phant", person.toString());
    }

    @Test
    public void test_equals() {
        Person person = new Person("Ele", "Phant");
        Person person2 = new Person("Ele", "Phant");
        Person person3 = new Person("Tom", "Ate");

        assertTrue(person.equals(person2));

        assertFalse(person.equals(person3));

    }
}
