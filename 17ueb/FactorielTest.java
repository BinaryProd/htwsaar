import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorielTest {
    Factoriel factoriel;

    @BeforeEach
    public void setup() {
        this.factoriel = new Factoriel();
    }

    @Test
    public void testWith0_expected1() {
        int result = factoriel.apply(0);
        assertEquals(1, result);
    }

    @Test
    public void testWith1_expected1() {
        int result = factoriel.apply(1);
        assertEquals(1, result);
    }

    @Test
    public void testWith5_expected120() {
        int result = factoriel.apply(5);
        assertEquals(120, result);
    }

    @Test
    public void testWith12() {
        int result = factoriel.apply(12);
        assertEquals(479001600, result);
    }
}
