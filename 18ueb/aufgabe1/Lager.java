/**
 * <h1>Lager Class</h1>
 * This class allows the user to create, store, 
 * and manipulate multiple objects. The user can then 
 * interact with the objects using various methods 
 * provided by the class.
 *
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2022-11-04
 */

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import java.util.ArrayList;

public final class Lager {
    private Artikel[] lager;
    private static final int STANDARD_GROESSE = 10;
    private static final int ART_NR_WIDTH = 5;    
    private static final int BESCHREIBUNG_WIDTH = 42;
    private static final int PREIS_WIDTH = 10;
    private static final int BESTAND_WIDTH = 11;
    private static final int GESAMT_WIDTH = 16;
    private static final int GESAMTWERT_WIDTH = 11;

    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> condition) {
        return getSorted(condition, this.lager);
    }

    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> condition, Artikel[] artikel) {
        int artikelLength = artikel.length;
        boolean swapped;
        Artikel swap;

        for (int i = 0; i < artikelLength - 1; i++) {
            swapped = false;
            for (int j = 0; j < artikelLength - 1 - i; j++) {
                if (condition.test(artikel[j], artikel[j + 1])) {
                    swap = artikel[j];
                    artikel[j] = artikel[j + 1];
                    artikel[j + 1] = swap;
                    swapped = true;
                }
            }

            if (!swapped) {
                break; // Early termination if no swaps were made
            }
        }

        return artikel;
    }

    public void applyToArticles(Consumer<Artikel> operation) {
        applyToArticles(operation, this.lager);
    }

    public void applyToArticles(Consumer<Artikel> operation, Artikel[] artikel) {
        for (int i = 0; i < artikel.length; i++) {
            operation.accept(artikel[i]);
        }
    }

    public Artikel[] filter(Predicate<Artikel> condition) {
        return filter(condition, this.lager);
    }
    public Artikel[] filter(Predicate<Artikel> condition, Artikel[] artikel) {
        ArrayList<Artikel> filtertArtikel =  new ArrayList<>();
        for (int i = 0; i < artikel.length; i++) {
            if (condition.test(artikel[i])) {
                filtertArtikel.add(artikel[i]);
            }
        }
        return filtertArtikel.toArray(new Artikel[filtertArtikel.size()]);
    }

    public void applyToSomeArticles(Predicate<Artikel> condition, Consumer<Artikel> operation) {
        Artikel[] filtertArtikels = filter(condition, this.lager);
        applyToArticles(operation, filtertArtikels);
    }

    public Artikel[] getArticles(Predicate<Artikel> condition, BiPredicate<Artikel,Artikel> operation) {
        Artikel[] filtertArtikels = filter(condition, this.lager);
        return getSorted(operation, filtertArtikels);
    }

    public Artikel[] filterAll(Predicate<Artikel> ... conditions) {
        Artikel[] filtertArtikels = this.lager;
        for (Predicate<Artikel> condition : conditions) {
            filtertArtikels = filter(condition, filtertArtikels);
        }
        return filtertArtikels;
    }




    /**
     * Constructor that creates a Lager object with a given maximum number of articles that can be stored in the array.
     * @param maxArtikel The maximum number of articles that can be stored in the array.
     */
    public Lager(int maxArtikel) {
        CheckUtils.checkGreaterThan(maxArtikel, 0, "lager");

        lager = new Artikel[maxArtikel];
        for (int i = 0; i < lager.length; i++) {
            lager[i] = null;
        }
    }
    /**
     * Alternate constructor that creates a Lager object with the default maximum number of articles that can be stored in the array.
     */
    public Lager() {
        this(STANDARD_GROESSE);
    }

    /**
     * This method used to add an object to the array lager.
     * @param artikel The object that is added to the array lager.
     */
    public final void legeAnArtikel(Artikel artikel){
        CheckUtils.checkIfLagerIsFull(lager);
        CheckUtils.checkIfInLager(artikel.getArtikelNr(), lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i] == null) {
                lager[i] = artikel;
                break;
            }
        }
    }

    /**
     * This method is used to remove an object from the array lager.
     * @param artikelNr The object that is removed from the array lager.
     */
    public final void entferneArtikel(int artikelNr){
        CheckUtils.checkIfLagerIsEmpty(lager);
        CheckUtils.checkArtikelNr(artikelNr);
        CheckUtils.checkIfNotInLager(artikelNr, lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null && lager[i].getArtikelNr() == artikelNr) {
                lager[i] = null;
                break;
            }
        }

        sortLager();
    }

    /**
     * This method is used to add a quantity to the attribute bestand
     * @param artikelNr This is the target Artikel
     * @param zugang This is the quantity that is added to the attribute bestand
     */
    public final void bucheZugang(int artikelNr, int zugang){ 
        CheckUtils.checkIfLagerIsEmpty(lager);
        CheckUtils.checkArtikelNr(artikelNr);
        CheckUtils.checkIfNotInLager(artikelNr, lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i].bucheZugang(zugang);
                break;
            }
        }
    }

    /**
     * This method is used to remove a quantity from the attribute bestand
     * @param artikelNr This is the target Artikel
     * @param abgang This is the quantity that is removed from the attribute bestand
     */
    public final void bucheAbgang(int artikelNr, int abgang){
        CheckUtils.checkIfLagerIsEmpty(lager);
        CheckUtils.checkArtikelNr(artikelNr);
        CheckUtils.checkIfNotInLager(artikelNr, lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i].bucheAbgang(abgang);
                break;
            }
        }
    }

    /**
     * This method is used to change the price of a specific Artikel by a certain percentage
     * @param artikelNr This is the target Artikel
     * @param prozent This is the percentage that is added or removed from the target Artikel's price
     */
    public final void aenderePreisEinesArtikels(int artikelNr, double prozent){
        CheckUtils.checkIfLagerIsEmpty(lager);
        CheckUtils.checkArtikelNr(artikelNr);
        CheckUtils.checkIfNotInLager(artikelNr, lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i].aenderePreis(prozent);
                break;
            }
        }
    }

    /**
     * This method is used to change the price of all Artikel in the array lager by a certain percentage
     * @param prozent This is the percentage that is added or removed from all the Artikel's prices in the array lager
     */
    public final void aenderePreisAllerArtikel(double prozent){
        CheckUtils.checkIfLagerIsEmpty(lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                lager[i].aenderePreis(prozent);
            }
        }
    }

    /**
     * This method is used to get the value of a target Artikel
     * @param index This is the index of target Artikel in the array lager
     * @return the target Artikel from the array lager at the given index
     */
    public final Artikel getArtikel(int index){
        CheckUtils.checkIfLagerIsEmpty(lager);
        CheckUtils.checkIfIndexIsInRange(index, lager.length);
        CheckUtils.checkIfIndexIsNull(lager, index);

        return lager[index];
    }

    /**
     * This method is used to print all the Artikel from the array lager
     * @return a string representation of all the Artikel in the array lager
     */
    @Override    
    public String toString() {    
        StringBuilder output = new StringBuilder();    
        for (int i = 0; i < lager.length; i++) {    
            if (lager[i] != null) {    
                output.append(lager[i].toString()).append("\n");    
            }    
        }    
        return output.toString();    
    }

    /**
     * This method is used to get the quantity of Artikel in the array lager
     * @return the quantity of Artikel in the array lager
     */
    public final int getArtikelAnzahl(){

        int count = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method is used to get the size of the array lager
     * @return the size of the array lager
     */
    public final int getLagerGroesse(){
        return lager.length;
    }

    public final int getFreierPlatzImLager(){
        int count = getArtikelAnzahl();
        int size = getLagerGroesse();

        return size - count;
    }


    /**
     * This method sort the Null in the array to the end 
     */
    public final void sortLager() {

        int lagerLaenge = getLagerGroesse();

        for (int i = 0; i < lagerLaenge; i++) {
            if (lager[i] == null) {
                for (int j = i; j < lagerLaenge; j++) {
                    if (lager[j] != null) {
                        lager[i] = lager[j];
                        lager[j] = null;
                        break;
                    }
                }
            }
        }
    }

    /**
     * This a method that search for a Artikel in the array lager
     * it return true if the Artikel is in the array lager
     * else it return false
     * @param artikelNr This is the target Artikel
     * @return true if the Artikel is in the array lager
     * @return false if the Artikel is not in the array lager
     */
    public final boolean sucheArtikel(int artikelNr){
        CheckUtils.checkIfLagerIsEmpty(lager);
        CheckUtils.checkArtikelNr(artikelNr);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                if (lager[i].getArtikelNr() == artikelNr) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method is used to generate a list of all the Artikel in the array lager
     * including their details such as description, price, stock and total value.
     * @return a string representation of the list of all the Artikel in the array lager
     */
    public final String ausgebenBestandsListe(){    
        CheckUtils.checkIfLagerIsEmpty(lager);    
        double sum = 0;    
        StringBuilder output = new StringBuilder();    

        int lineWidth = ART_NR_WIDTH + BESCHREIBUNG_WIDTH + PREIS_WIDTH + BESTAND_WIDTH + GESAMT_WIDTH + 4;
        int lastLineWidth = BESCHREIBUNG_WIDTH + PREIS_WIDTH + BESTAND_WIDTH - 4;
        String line = new String(new char[lineWidth]).replace("\0", "-");    
        output.append(String.format("%-"+ ART_NR_WIDTH +"s %-"+ BESCHREIBUNG_WIDTH +"s %-"+ PREIS_WIDTH +"s %-"
                    + BESTAND_WIDTH +"s %-"+ GESAMT_WIDTH +"s", "ArtNr", "Beschreibung", "Preis", "Bestand", "Gesamt")).append("\n");
        output.append(line).append("\n");    
        for (int i = 0; i < lager.length; i++) {    
            if (lager[i] != null) {    
                output.append(String.format("%-"+ ART_NR_WIDTH +"d %-"+ BESCHREIBUNG_WIDTH +"s %-"+ PREIS_WIDTH 
                            +".2f %-"+ BESTAND_WIDTH +"d %-"+ GESAMT_WIDTH +".2f", lager[i].getArtikelNr(), 
                            lager[i].getBeschreibung(), lager[i].getPreis(), lager[i].getBestand(), lager[i].gesamtPreis())).append("\n");
                sum += lager[i].gesamtPreis();    
            }    
        }    
        output.append(line).append("\n");    
        output.append(String.format("%"+ GESAMTWERT_WIDTH +"s %-" + lastLineWidth + "s %-"+ GESAMT_WIDTH +".2f", "Gesamtwert:", " ", sum )).append("\n");
        return output.toString();
    }

}
