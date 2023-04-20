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
        palindrom1 = "rentner";
        palindrom2 = "lagerregal";
        palindrom3 = "reittier";
        palindrom4 = "reliefpfeiler";
        palindrom5 = "litneventil";
        wort1 = "sonnenschein";
        wort2 = "blumenstrauß";
        wort3 = "telefonnummer";
        wort4 = "schokolade";
        wort5 = "fahrrad";
    }

    @Test
    public void test_pal_Iter_True() {
        assertTrue(palIter.istPalindrom(palindrom1));
        assertTrue(palIter.istPalindrom(palindrom2));
        assertTrue(palIter.istPalindrom(palindrom3));
        assertTrue(palIter.istPalindrom(palindrom4));
        assertTrue(palIter.istPalindrom(palindrom5));
    }

    @Test
    public void test_pal_Iter_False() {
        assertFalse(palIter.istPalindrom(wort1));
        assertFalse(palIter.istPalindrom(wort2));
        assertFalse(palIter.istPalindrom(wort3));
        assertFalse(palIter.istPalindrom(wort4));
        assertFalse(palIter.istPalindrom(wort5));
    }

    @Test
    public void test_pal_Rek_True() {
        assertTrue(palRek.istPalindrom(palindrom1));
        assertTrue(palRek.istPalindrom(palindrom2));
        assertTrue(palRek.istPalindrom(palindrom3));
        assertTrue(palRek.istPalindrom(palindrom4));
        assertTrue(palRek.istPalindrom(palindrom5));
    }

    @Test
    public void test_pal_Rek_False() {
        assertFalse(palRek.istPalindrom(wort1));
        assertFalse(palRek.istPalindrom(wort2));
        assertFalse(palRek.istPalindrom(wort3));
        assertFalse(palRek.istPalindrom(wort4));
        assertFalse(palRek.istPalindrom(wort5));
    }
}

