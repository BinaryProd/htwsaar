/**
 * <h1> GetreankeautomatTest </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.0
 * @since 2023-04-11
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

public class GetraenkeautomatTest {
    private Getraenkeautomat<Getraenk> automat;
    private Getraenkeautomat<Wasser> wasserAutomat;

    private Wasser Adelholzener;
    private Wasser Gerolsteiner;
    private Wasser Vilsa;
    private Softdrink Fanta;
    private Weisswein Riesling;
    private Rotwein Merlot;
    private Bier Augustiner;
    private Flasche<Weisswein> RieslingFlasche;
    private Flasche<Rotwein> MerlotFlasche;
    private Flasche<Bier> AugustinerFlasche;
    private Flasche<Wasser> AdelholzenerFlasche;
    private Flasche<Wasser> GerolsteinerFlasche;
    private Flasche<Wasser> VilsaFlasche;
    private Flasche<Softdrink> FantaFlasche;

    @BeforeEach
    public void setUp() {
        automat = new Getraenkeautomat<Getraenk>(4);
        wasserAutomat = new Getraenkeautomat<Wasser>(2);

        Adelholzener = new Wasser("Adelholzener", "Adelholzener AlpenQuelle GmbH", "Adelholzener AlpenQuelle");
        Gerolsteiner = new Wasser("Gerolsteiner", "Gerolsteiner Brunnen GmbH & Co. KG", "Gerolsteiner Quelle");
        Vilsa = new Wasser("Vilsa", "Vilsa-Brunnen Otto Rodekohr GmbH & Co. KG", "Vilsa Quelle");
        Fanta = new Softdrink("Orangina", "Schweppes International Limited", 42.3f);
        Riesling = new Weisswein("Riesling Kabinett", 11.5f, "Schloss Johannisberg");
        Merlot = new Rotwein("Chateauneuf-du-Pape", 14.5f, "Domaine du Vieux Telegraphe");
        Augustiner = new Bier("Augustiner Hell", 3f, "Augustiner-Braeu");

        RieslingFlasche = new Flasche<Weisswein>(Riesling);
        MerlotFlasche = new Flasche<Rotwein>(Merlot);
        AugustinerFlasche = new Flasche<Bier>(Augustiner);
        AdelholzenerFlasche = new Flasche<Wasser>(Adelholzener);
        GerolsteinerFlasche = new Flasche<Wasser>(Gerolsteiner);
        VilsaFlasche = new Flasche<Wasser>(Vilsa);
        FantaFlasche = new Flasche<Softdrink>(Fanta);
    }

    @Test
    public void testAutomatMitKapazitaetNull() {
        assertThrows(GetraenkeautomatException.class, () -> {
            new Getraenkeautomat<Getraenk>(0);
        });
    }

    @Test
    public void testKonstruktor() {
        assertEquals(4, automat.getKapazitaet());
        assertEquals(2, wasserAutomat.getKapazitaet());
        assertEquals(0, automat.getAnzahlFlaschen());
        assertEquals(0, wasserAutomat.getAnzahlFlaschen());
        assertEquals(false, automat.istEmpty());
    }

    @Test
    public void testFlascheEinlegenAutomat() {
        automat.flascheEinlegen(AugustinerFlasche);
        assertEquals(1, automat.getAnzahlFlaschen());
    }

    @Test
    public void testFlascheEinlegenMitVollemAutomat() {
        automat.flascheEinlegen(AugustinerFlasche);
        automat.flascheEinlegen(RieslingFlasche);
        automat.flascheEinlegen(MerlotFlasche);
        automat.flascheEinlegen(FantaFlasche);
        assertThrows(GetraenkeautomatException.class, () -> automat.flascheEinlegen(AdelholzenerFlasche));
    }

    @Test
    public void testFlascheEinlegenWasserAutomatMitFalscherFlasche() {
        wasserAutomat.flascheEinlegen(AdelholzenerFlasche);
        assertEquals(1, wasserAutomat.getAnzahlFlaschen());
        assertThrows(GetraenkeautomatException.class, () -> wasserAutomat.flascheEinlegen(RieslingFlasche));
        assertThrows(GetraenkeautomatException.class, () -> wasserAutomat.flascheEinlegen(MerlotFlasche));
    }

    public void testFlascheEinlegenAutomatMitLeererFlasche() {
        AdelholzenerFlasche.leeren();
        assertThrows(GetraenkeautomatException.class, () -> automat.flascheEinlegen(AdelholzenerFlasche));
    }

    @Test
    public void testFlascheAusgebenAutomat() {
        automat.flascheEinlegen(AugustinerFlasche);
        automat.flascheEinlegen(RieslingFlasche);
        automat.flascheEinlegen(MerlotFlasche);
        automat.flascheEinlegen(FantaFlasche);
        assertEquals(4, automat.getAnzahlFlaschen());
        assertEquals(AugustinerFlasche, automat.flascheAusgeben());
        assertEquals(3, automat.getAnzahlFlaschen());
        assertEquals(RieslingFlasche, automat.flascheAusgeben());
        assertEquals(2, automat.getAnzahlFlaschen());
        assertEquals(MerlotFlasche, automat.flascheAusgeben());
        assertEquals(1, automat.getAnzahlFlaschen());
        assertEquals(FantaFlasche, automat.flascheAusgeben());
        assertEquals(0, automat.getAnzahlFlaschen());
    }

    public void testFlascheAusgebenAutomatMitLeeremAutomat() {
        assertThrows(GetraenkeautomatException.class, () -> automat.flascheAusgeben());
    }
/*
    @Test
    public void testToString() {
        automat.flascheEinlegen(AugustinerFlasche);
        automat.flascheEinlegen(RieslingFlasche);
        automat.flascheEinlegen(MerlotFlasche);
        automat.flascheEinlegen(FantaFlasche);
    }
*/

}
