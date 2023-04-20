/**
 * <h1> PalindromTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromTest {

    private String palindrom1;
    private String palindrom2;
    private String palindrom3;
    private String palindrom4;
    private String palindrom5;
    private String wort1;
    private String wort2;
    private String wort3;
    private String wort4;
    private String wort5;

    private PalindromRekursiv palRek = new PalindromRekursiv();
    private PalindromIterativ palIter = new PalindromIterativ();

    public PalindromTest() {
        palIter = new PalindromIterativ();
        palRek = new PalindromRekursiv();
    }

    @BeforeEach
    public void setUp() {
        palindrom1 = "Rentner";
        palindrom2 = "Lagerregal";
        palindrom3 = "Reittier";
        palindrom4 = "Reliefpfeiler";
        palindrom5 = "Reliefventil";
        wort1 = "Sonnenschein";
        wort2 = "Blumenstrauß";
        wort3 = "Telefonnummer";
        wort4 = "Schokolade";
        wort5 = "Fahrrad";
    }

    @Test
    public void testpalIter() {
        assertTrue(palIter.istPalindrom(palindrom1));
        assertTrue(palIter.istPalindrom(palindrom2));
        assertTrue(palIter.istPalindrom(palindrom3));
        assertTrue(palIter.istPalindrom(palindrom4));
        assertTrue(palIter.istPalindrom(palindrom5));

        assertFalse(palIter.istPalindrom(wort1));
        assertFalse(palIter.istPalindrom(wort2));
        assertFalse(palIter.istPalindrom(wort3));
        assertFalse(palIter.istPalindrom(wort4));
        assertFalse(palIter.istPalindrom(wort5));
    }

    @Test
    public void testpalRek() {
        assertTrue(palRek.istPalindrom(palindrom1));
        assertTrue(palRek.istPalindrom(palindrom2));
        assertTrue(palRek.istPalindrom(palindrom3));
        assertTrue(palRek.istPalindrom(palindrom4));
        assertTrue(palRek.istPalindrom(palindrom5));

        assertFalse(palRek.istPalindrom(wort1));
        assertFalse(palRek.istPalindrom(wort2));
        assertFalse(palRek.istPalindrom(wort3));
        assertFalse(palRek.istPalindrom(wort4));
        assertFalse(palRek.istPalindrom(wort5));
    }
}

