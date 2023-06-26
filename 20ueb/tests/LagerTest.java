import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LagerTest {

    /**
     * Test the Lager constructor with a valid size
     */
    @Test
    public void test_Constructor_With_Valid_Size() {
        int size = 5;
        Lager lager = new Lager(size);

        assertEquals(size, lager.getLagerGroesse());

        int size2 = 100;
        Lager lager2 = new Lager(size2);

        assertEquals(size2, lager2.getLagerGroesse());
    }

    /**
     * Test the Lager constructor without an argument
     * The default size should be 10
     */
    @Test
    public void test_Constructor_Without_Argument() {
        Lager lager = new Lager();

        assertEquals(10, lager.getLagerGroesse());
    }

    /**
     * Test the lager constructor with an invalid size
     */
    @Test
    public void test_Constructor_With_Invalid_Size() {
        int size = -1;
        int size2 = 0;
        int size3 = -101;

        assertThrows(IllegalArgumentException.class, () -> {
            Lager lager = new Lager(size);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Lager lager = new Lager(size2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Lager lager = new Lager(size3);
        });
    }

    /**
     * Test the legeArtikelAn method with a valid article
     */
    @Test
    public void test_Lege_Artikel_An_With_Valid_Article() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 0.0);
        lager.legeAnArtikel(artikel);

        assertTrue(lager.sucheArtikel(artikel.getArtikelNr()));

        Artikel artikel2 = new Artikel(9999, "Test article 2", 0, 0.0);
        lager.legeAnArtikel(artikel2);

        assertTrue(lager.sucheArtikel(artikel2.getArtikelNr()));

        Buch buch1 = new Buch(1234, 0, 0.0, "author", "title", "verlag");
        lager.legeAnArtikel(buch1);

        assertTrue(lager.sucheArtikel(buch1.getArtikelNr()));

        Video video1 = new Video(9876, 0, 0.0, "title", 60, 2020);
        lager.legeAnArtikel(video1);

        assertTrue(lager.sucheArtikel(video1.getArtikelNr()));

        CD cd1 = new CD(1111, 0, 0.0, "interpret", "title", 1);
        lager.legeAnArtikel(cd1);

        assertTrue(lager.sucheArtikel(cd1.getArtikelNr()));

    }

    /**
     * Test the legeArtikelAn method with an article that already exists in the lager
     */
    @Test
    public void test_Lege_Artikel_An_With_Existing_Article() {
        Lager lager = new Lager();

        Artikel artikel1 = new Artikel(1000, "Test article", 0, 0);
        Artikel artikel2 = new Artikel(1000, "Test article", 0, 0);

        lager.legeAnArtikel(artikel1);
        assertThrows(IllegalArgumentException.class, () -> lager.legeAnArtikel(artikel2));

        Artikel artikel3 = new Artikel(9999, "Test article", 0, 0);
        Artikel artikel4 = new Artikel(9999, "Test article", 0, 0);

        lager.legeAnArtikel(artikel3);
        assertThrows(IllegalArgumentException.class, () -> lager.legeAnArtikel(artikel4));
    }

    /**
     * Test the legeArtikelAn method with a full lager
     */
    @Test
    public void test_Lege_Artikel_An_With_Full_Lager() {
        int size = 1;
        Lager lager = new Lager(size);

        Artikel artikel1 = new Artikel(1000, "Test article", 0, 0);
        Artikel artikel2 = new Artikel(2000, "Test article", 0, 0);

        lager.legeAnArtikel(artikel1);
        assertThrows(IllegalArgumentException.class, () -> lager.legeAnArtikel(artikel2));
    }

    /**
     * Test the entferneArtikel method with a valid article number
     */
    @Test
    public void test_Entferne_Artikel_With_Valid_Article_Number() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 0);
        Artikel artikel2 = new Artikel(2000, "Test article", 0, 0);

        lager.legeAnArtikel(artikel);
        lager.legeAnArtikel(artikel2);
        lager.entferneArtikel(artikel.getArtikelNr());

        assertFalse(lager.sucheArtikel(artikel.getArtikelNr()));
    }

    /**
     * Test the entferneArtikel method with an invalid article number
     */
    @Test
    public void test_Entferne_Artikel_With_Invalid_Article_Number() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 0);
        lager.legeAnArtikel(artikel);

        assertThrows(IllegalArgumentException.class, () -> lager.entferneArtikel(2000));
    }

    /**
     * Test the bucheZugang method with a valid article number and quantity
     */
    @Test
    public void test_Buche_Zugang() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "TestArtikel", 1);
        lager.legeAnArtikel(artikel);

        lager.bucheZugang(1000, 10);

        assertEquals(10, artikel.getBestand());

        Artikel artikel2 = new Artikel(2000, "TestArtikel", 1);
        lager.legeAnArtikel(artikel2);

        lager.bucheZugang(2000, 100);

        assertEquals(100, artikel2.getBestand());
    }

    /**
     * Test the bucheZugang method with an invalid article number
     */
    @Test
    public void test_Buche_Zugang_With_Invalid_Article_Number_And_Quantity() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 0);
        lager.legeAnArtikel(artikel);

        assertThrows(IllegalArgumentException.class, () -> lager.bucheZugang(2000, 10));
        
    }

    /**
     * Test the bucheAbgang method with an invalid article number
     */
    @Test
    public void test_Buche_Abgang_With_Invalid_Article_Number_And_Quantity() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 0);
        lager.legeAnArtikel(artikel);

        assertThrows(IllegalArgumentException.class, () -> lager.bucheAbgang(2000, 10));

        assertThrows(IllegalArgumentException.class, () -> lager.bucheAbgang(1000, 1));
    }

    /**
     * Test the bucheZugang method with a valid article number and quantity
     */
    @Test
    public void test_Buche_Abgang() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "TestArtikel", 1, 2);
        lager.legeAnArtikel(artikel);

        lager.bucheAbgang(1000, 1);

        assertEquals(0, artikel.getBestand());

        Artikel artikel2 = new Artikel(2000, "TestArtikel", 100, 2);
        lager.legeAnArtikel(artikel2);

        lager.bucheAbgang(2000, 99);

        assertEquals(1, artikel2.getBestand());
    }

    /**
     * Test the aenderePreisEinesArtikels method with a valid article number and price increase
     */
    @Test
    public void test_Aendere_Preis_Eines_Artikels_With_Valid_Article_Number_And_Price_Increase() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 10);
        lager.legeAnArtikel(artikel);

        lager.aenderePreisEinesArtikels(1000, 10);
        assertEquals(11, artikel.getPreis());

        Artikel artikel2 = new Artikel(2000, "Test article", 0, 10);
        lager.legeAnArtikel(artikel2);

        lager.aenderePreisEinesArtikels(2000, 100);
        assertEquals(20, artikel2.getPreis());

    }

    /**
     * Test the aenderePreisEinesArtikels method with a valid article number and price decrease
     */
    @Test
    public void test_Aendere_Preis_Eines_Artikels_With_Valid_Article_Number_And_Price_Decrease() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 10);
        lager.legeAnArtikel(artikel);

        lager.aenderePreisEinesArtikels(1000, -10);
        assertEquals(9, artikel.getPreis());

        Artikel artikel2 = new Artikel(2000, "Test article", 0, 10);
        lager.legeAnArtikel(artikel2);

        lager.aenderePreisEinesArtikels(2000, -100);
        assertEquals(0, artikel2.getPreis());

    }

    /**
     * Test the aenderePreisEinesArtikels method with an invalid article number
     */
    @Test
    public void test_Aendere_Preis_Eines_Artikels_With_Invalid_Article_Number() {
        Lager lager = new Lager();
        Artikel artikel = new Artikel(1000, "Test article", 0, 10);
        lager.legeAnArtikel(artikel);

        assertThrows(IllegalArgumentException.class, () -> lager.aenderePreisEinesArtikels(2000, 10));
    }

    /**
     * Test the aenderePreisEinesArtikels method with a negative price change
     */
    @Test
    public void test_Aendere_Preis_Eines_Artikels_With_Negative_Price_Change() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 1);
        lager.legeAnArtikel(artikel);

        assertThrows(IllegalArgumentException.class, () -> lager.aenderePreisEinesArtikels(1000, -101));
    }

    @Test
    public void test_Get_Artikel_Ohne_Fehler() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 1);
        lager.legeAnArtikel(artikel);

        Artikel artikel2 = new Artikel(2000, "Test article", 0, 1);
        lager.legeAnArtikel(artikel2);

        assertEquals(artikel, lager.getArtikel(0));
        assertEquals(artikel2, lager.getArtikel(1));
    }

    @Test
    public void test_Get_Artikel_Mit_Fehler() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 1);
        lager.legeAnArtikel(artikel);

        Artikel artikel2 = new Artikel(2000, "Test article", 0, 1);
        lager.legeAnArtikel(artikel2);

        assertThrows(IllegalArgumentException.class, () -> lager.getArtikel(2));
    }
    
    @Test
    public void test_Get_Artikel_Anzahl() {
        Lager lager = new Lager();

        assertEquals(0, lager.getArtikelAnzahl());

        Artikel artikel = new Artikel(1000, "Test article", 0, 1);
        lager.legeAnArtikel(artikel);

        Artikel artikel2 = new Artikel(2000, "Test article", 0, 1);
        lager.legeAnArtikel(artikel2);

        assertEquals(2, lager.getArtikelAnzahl());
    }

    @Test
    public void test_Get_Lager_Groesse() {
        Lager lager = new Lager();
        assertEquals(10, lager.getLagerGroesse());

        Lager lager2 = new Lager(20);
        assertEquals(20, lager2.getLagerGroesse());
    }

    @Test
    public void test_Get_Freier_Platz_Im_Lager() {        
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 1);
        lager.legeAnArtikel(artikel);

        Artikel artikel2 = new Artikel(2000, "Test article", 0, 1);
        lager.legeAnArtikel(artikel2);

        assertEquals(8, lager.getFreierPlatzImLager());


        Lager lager2 = new Lager(20);
        
        Artikel artikel3 = new Artikel(3000, "Test article", 0, 1);
        lager2.legeAnArtikel(artikel3);

        Artikel artikel4 = new Artikel(4000, "Test article", 0, 1);
        lager2.legeAnArtikel(artikel4);

        Artikel artikel5 = new Artikel(5000, "Test article", 0, 1);
        lager2.legeAnArtikel(artikel5);

        assertEquals(17, lager2.getFreierPlatzImLager());
    }
}
