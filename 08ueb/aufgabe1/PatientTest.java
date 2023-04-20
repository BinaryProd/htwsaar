import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    /**
     * Test that the Patient class correctly sets and gets the attributes with valid input.
     */
    @Test
    public void test_Patient_attribut_Ohne_Fehler() {
        Patient patient = new Patient(9999, "asdf", "sdfg");

        assertEquals(patient.getPatientenNr(), 9999);
        assertEquals(patient.getVorname(), "asdf");
        assertEquals(patient.getNachname(), "sdfg");
    }

    /**
     * Test that the Patient class correctly sets and gets the attributes with valid input.
     */
    @Test
    public void test_Patient_attribut_Ohne_Fehler_2() {
        Patient patient = new Patient(1000, "f", "2");

        assertEquals(patient.getPatientenNr(), 1000);
        assertEquals(patient.getVorname(), "f");
        assertEquals(patient.getNachname(), "2");
    }

    /**
     * Test that the Patient class throws an IllegalArgumentException when the number is above the maximum allowed value.
     */
    @Test
    public void test_Patient_Number_10000_Mit_Fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(10000, "asdf", "sdfg"));
    }

    /**
     * Test that the Patient class throws an IllegalArgumentException when the number is below the minimum allowed value.
     */
    @Test
    public void test_Patient_Number_999_Mit_Fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(999, "asdf", "sdfg"));
    }

    /**
     * Test that the Patient class throws an IllegalArgumentException when the first name is empty.
     */
    @Test
    public void test_Patient_Vorname_Mit_Fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(1000, "", "sdfg"));
    }

    /**
     * Test that the Patient class throws an IllegalArgumentException when the last name is empty.
     */
    @Test
    public void test_Patient_Nachname_Mit_Fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(1000, "asdf", ""));
    }

    /**
     * Test that the Patient class's toString method returns the correct string representation.
     */
    @Test
    public void test_ToString() {
        Patient patient = new Patient(9999, "asdf", "sdfg");
        assertEquals(patient.toString(), " 9999 asdf sdfg");
    }
}
