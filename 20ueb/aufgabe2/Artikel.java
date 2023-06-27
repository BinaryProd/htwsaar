/**
 * <h1>ArtiKel Class</h1>
 * Allows the user to create objects with an Id, an art 
 * a quantity and a price. Then the user can interact 
 * with his items using methods
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2022-11-04
 */

import java.util.Objects;

public class Artikel {
    private int artikelNr;
    private int bestand;
    private String art;
    private double preis;

    /**    
     * This constructor is the main entry point for the Artikel class    
     * @param artikelNr This is the first attribute of the class Artikel     
     * @param art This is the second attribute of the class Artikel    
     * @param bestand This is the third attribute of the class Artikel    
     */
    public Artikel(int artikelNr, String art, int bestand, double preis) { 
        CheckUtils.checkArtikelNr(artikelNr);
        CheckUtils.checkIfEmpty(art);
        CheckUtils.checkBestand(bestand);
        CheckUtils.checkPreis(preis);

        this.artikelNr = artikelNr;
        this.art = art.trim();
        this.bestand = bestand;
        this.preis = preis;
    }

    /**    
     * This constructor is the second entry of the class Artikel    
     * @param artikelNr This is the first attribute of the class Artikel     
     * @param art This is the second attribute of the class Artikel     
     */
    public Artikel(int artikelNr, String art, double preis) { 
        this(artikelNr, art, 0, preis);
    }

    /**    
     * This method is used to increase the value of the attribute bestand    
     * @param bestand This is the third attribute of the class Artikel    
     */
    public final void bucheZugang(int menge) {
        CheckUtils.checkBuchung(menge);
        this.bestand += menge;
    }

    /**    
     * This method is used to decrease the value of the attribute bestand    
     * @param bestand This is the third attribute of the class Artikel    
     */
    public final void bucheAbgang(int menge) { 
        CheckUtils.checkBuchung(menge);
        CheckUtils.checkAbgangBuchung(bestand, menge);
        this.bestand -= menge;
    }

    /**    
     * This method is used to return the value of the attribute artikelNr    
     * @param artikelNr This is the first attribute of the class Artikel    
     * @return string This returns the content of art    
     */
    public final int getArtikelNr() { 
        return artikelNr;
    }

    /**
     * This method is used to return the value of the attribute 'art'
     * @return string This returns the value of 'art'
     */
    public final String getArt() { 
        return art;
    }

    /**
     * This method is used to return the value of the attribute 'bestand'
     * @return int This returns the value of 'bestand'
     */
    public final int getBestand() { 
        return bestand;
    }

    /**    
     * This method is used to return the value of the attribute preis    
     * @param preis This is the fourth attribute of the class Artikel    
     * @return double This returns the value of preis    
     */
    public final double getPreis() {
        return preis;
    }

    /**    
     * This method is use to set the value of artikelNr    
     * @param artikelNr The new value of the attribute artikelNr    
     */
    public final void setArtikelNr(int neueArtikelNr) {
        CheckUtils.checkArtikelNr(neueArtikelNr);
        this.artikelNr = neueArtikelNr;
    }

    /**    
     * This method is use to set the value of bestand    
     * @param neuerBestand The new value of the attribute bestand    
     */
    public final void setBestand(int neuerBestand) { 
        CheckUtils.checkBestand(neuerBestand);
        this.bestand = neuerBestand;
    }

    /**    
     * This method is use to set the value of art    
     * @param neuerArt The new value of the art attribute    
     */
    public final void setArt(String neuerArt) {
        CheckUtils.checkIfEmpty(neuerArt);
        this.art = neuerArt.trim();
    }

    /**
     * This method is used to set the value of preis.
     * @param neuerPreis The new value for the preis attribute.
     */
    public final void setPreis(double neuerPreis) {
        CheckUtils.checkPreis(neuerPreis);
        this.preis = neuerPreis;
    }

    /**
     * This method is used to change the value of the 'preis' attribute by a certain percentage.
     * @param prozent The percentage by which to change the preis attribute.
     */
    public final void aenderePreis(double prozent) {
        CheckUtils.checkProzent(prozent);
        this.preis = this.preis * (1 + prozent / 100);
    }

    /**
     * This method is used to calculate the total price of all items in stock.
     * @return The total price of all items in stock.
     */
    public final double gesamtPreis() {
        return this.bestand * this.preis;
    }

    /**
     * This method is used to return the description of the article in the form of a string
     * @return The description of the article
     */
    public String getBeschreibung() {
        return "Artikel: " + art;
    }

    /**
     * This method is used to return a string representation of the object
     * @return string A string representation of the object
     */
    @Override
    public String toString() { 
        return "\nArtikel: " + artikelNr + ", Art: " + art + ", Bestand: " + bestand + ", Preis: " + preis;
    }

    /**
     * This method is used to compare two objects of the class Artikel
     * @param obj The object to be compared with
     * @return boolean true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || !(obj instanceof Artikel)) {
            return false;
        }
        Artikel artikel = (Artikel) obj;
        return artikelNr == artikel.artikelNr &&
            bestand == artikel.bestand &&
            Double.compare(artikel.preis, preis) == 0 &&
            Objects.equals(art, artikel.art);
    }

    /**
     * This method is used to generate a unique hash code for the object
     * @return int The hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(artikelNr, art, bestand, preis);
    }
}
