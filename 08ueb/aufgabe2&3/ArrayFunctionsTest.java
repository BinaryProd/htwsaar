import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayFunctionsTest {

    /**
     * Tests the stringsAuswerten method with an array of strings containing 3 valid strings.
     */
    @Test
    public void test_Strings_Auswerten_expecte_2() {
        String[] strings1 = {"HTW", "saarland", "Saarbruecken"};
        int result1 = ArrayFunctions.stringsAuswerten(strings1);
        assertEquals(2, result1);
    }

    /**
     * Tests the stringsAuswerten method with an array of strings containing 3 valid strings.
     */
    @Test
    public void test_Strings_Auswerten_expecte_3() {
        String[] strings2 = {"HTW", "saarland", "Saarbruecken", "MERZIG", "UNIversitaet"};
        int result2 = ArrayFunctions.stringsAuswerten(strings2);
        assertEquals(3, result2);
    } 

    /**
     * Tests the stringsAuswerten method with an array of strings containing 2 valid strings.
     */
    @Test
    public void test_Strings_Auswerten_expecte_2_() {
        String[] strings3 = {"123", "abc", "def"};
        int result3 = ArrayFunctions.stringsAuswerten(strings3);
        assertEquals(2, result3);
    }

    /**
     * Tests the stringsAuswerten method with an array of strings containing 0 valid strings.
     */
    @Test
    public void test_Strings_Auswerten_expecte_0() {
        String[] strings4 = {};
        int result4 = ArrayFunctions.stringsAuswerten(strings4);
        assertEquals(0, result4);
    }

    /**
     * Tests the stringsAuswerten method with an array of strings containing 0 valid strings.
     */
    @Test
    public void test_Strings_Auswerten_expected_0() {
        String[] strings5 = {"12fa"};
        int result5 = ArrayFunctions.stringsAuswerten(strings5);
        assertEquals(0, result5);
    }

    /**
     * Tests the stringsAuswerten method with an array of strings containing 0 valid strings.
     */
    @Test
    public void test_Strings_Auswerten_expected_0_() {
        String[] strings6 = {""};
        int result6 = ArrayFunctions.stringsAuswerten(strings6);
        assertEquals(0, result6);
    }

    /**
     *  Tests the getter method of the class ArrayFunctions.
     */
    @Test
    public void test_Getters_Mittelwert() {
        Mittelwert mittelwert = new Mittelwert(10.5, 9.5, 11.5);
        assertEquals(10.5, mittelwert.getMittelwert(), 0.0001);
        assertEquals(9.5, mittelwert.getNaehesterWert(), 0.0001);
        assertEquals(11.5, mittelwert.getEntferntesterWert(), 0.0001);
    }

    /**
     * Tests the mittelwertBerechnen method
     */
    @Test
    public void test_Berechne_Mittelwert_1() {
        double[] values1 = {1.0, 2.0, 3.0, 4.0};
        Mittelwert result1 = ArrayFunctions.berechneMittelwert(values1);
        assertEquals(2.5, result1.getMittelwert(), 0.0001);
        assertEquals(2.0, result1.getNaehesterWert(), 0.0001);
        assertEquals(1.0, result1.getEntferntesterWert(), 0.0001);
    }

    /**
     * Tests the mittelwertBerechnen method
     */
    @Test
    public void test_Berechne_Mittelwert_2() {
        double[] values2 = {1.5, 2.5, 3.5, 4.5};
        Mittelwert result2 = ArrayFunctions.berechneMittelwert(values2);
        assertEquals(3.0, result2.getMittelwert(), 0.0001);
        assertEquals(2.5, result2.getNaehesterWert(), 0.0001);
        assertEquals(1.5, result2.getEntferntesterWert(), 0.0001);
    }

    /**
     * Tests the mittelwertBerechnen method
     */
    @Test
    public void test_BerechneMittelwert_3() {
        double[] values3 = {1.0, 1.0, 1.0, 1.0};
        Mittelwert result3 = ArrayFunctions.berechneMittelwert(values3);
        assertEquals(1.0, result3.getMittelwert(), 0.0001);
        assertEquals(1.0, result3.getNaehesterWert(), 0.0001);
        assertEquals(1.0, result3.getEntferntesterWert(), 0.0001);
    }

    /**
     * tests the mittelwertberechnen method
     */
    @Test
    public void test_berechnemittelwert_4() {
        double[] values4 = {1.0};
        Mittelwert result4 = ArrayFunctions.berechneMittelwert(values4);
        assertEquals(1.0, result4.getMittelwert(), 0.0001);
        assertEquals(1.0, result4.getNaehesterWert(), 0.0001);
        assertEquals(1.0, result4.getEntferntesterWert(), 0.0001);
    }

    /**
     * tests the mittelwertberechnen method
     */
    @Test
    public void test_berechnemittelwert_5() {
        double[] values5 = {1.0, 2.0, 3.0, 4.0, 5.0};
        Mittelwert result5 = ArrayFunctions.berechneMittelwert(values5);
        assertEquals(3.0, result5.getMittelwert(), 0.0001);
        assertEquals(3.0, result5.getNaehesterWert(), 0.0001);
        assertEquals(1.0, result5.getEntferntesterWert(), 0.0001);
    }

    /**
     * tests the mittelwertberechnen method
     */
    @Test
    public void test_berechnemittelwert_6() {
        double[] values6 = {5.0, 4.0, 3.0, 2.0, 1.0};
        Mittelwert result6 = ArrayFunctions.berechneMittelwert(values6);
        assertEquals(3.0, result6.getMittelwert(), 0.0001);
        assertEquals(3.0, result6.getNaehesterWert(), 0.0001);
        assertEquals(5.0, result6.getEntferntesterWert(), 0.0001);
    }

    /**
     * tests the mittelwertberechnen method
     */
    @Test
    public void test_berechnemittelwert_7() {
        double[] values7 = {-1.0, -2.0, -3.0, -4.0, -5.0};
        Mittelwert result7 = ArrayFunctions.berechneMittelwert(values7);
        assertEquals(-3.0, result7.getMittelwert(), 0.0001);
        assertEquals(-3.0, result7.getNaehesterWert(), 0.0001);
        assertEquals(-1.0, result7.getEntferntesterWert(), 0.0001);
    }

    /**
     * tests the mittelwertberechnen method
     */
    @Test
    public void test_berechnemittelwert_9() {
        double[] values7 = {};
        Mittelwert result7 = ArrayFunctions.berechneMittelwert(values7);
        assertEquals(0, result7.getMittelwert(), 0.0001);
        assertEquals(0, result7.getNaehesterWert(), 0.0001);
        assertEquals(0, result7.getEntferntesterWert(), 0.0001);
    }
}
