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

import java.util.Map;
import java.util.LinkedHashMap;

import java.util.ArrayList;
import java.util.Arrays;

public final class Lager {
    private Map<Integer, Artikel> lagerMap;
    private static final int STANDARD_LAGER_SIZE = 10;
    private static final int ART_NR_WIDTH = 5;    
    private static final int BESCHREIBUNG_WIDTH = 42;
    private static final int PREIS_WIDTH = 10;
    private static final int BESTAND_WIDTH = 11;
    private static final int GESAMT_WIDTH = 16;
    private static final int GESAMTWERT_WIDTH = 11;

    public Map<Integer,Artikel> getSorted(BiPredicate<Artikel, Artikel> condition) {
        return getSorted(condition, this.lagerMap);
    }

    public Map<Integer,Artikel> getSorted(BiPredicate<Artikel,Artikel> condition, Map<Integer,Artikel> map) {
        Map<Integer,Artikel> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue((a1, a2) -> condition.test(a1, a2) ? 1 : -1))
            .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }

    public void applyToArticles(Consumer<Artikel> operation) {
        applyToArticles(operation, this.lagerMap);
    }

    public void applyToArticles(Consumer<Artikel> operation, Map<Integer,Artikel> map) {
        map.values().forEach(operation);
    }

    public Map<Integer,Artikel> filter(Predicate<Artikel> condition) {
        return filter(condition, this.lagerMap);
    }

    public Map<Integer,Artikel> filter(Predicate<Artikel> condition, Map<Integer,Artikel> map) {
        Map<Integer,Artikel> filteredMap = new LinkedHashMap<>();
        map.entrySet().stream()
            .filter(x -> condition.test(x.getValue()))
            .forEachOrdered(x -> filteredMap.put(x.getKey(), x.getValue()));
        return filteredMap;
    }

    public void applyToSomeArticles(Predicate<Artikel> condition, Consumer<Artikel> operation) {
        Map<Integer,Artikel> filteredMap = filter(condition);
        applyToArticles(operation, filteredMap);
    }

    public Map<Integer,Artikel> getArticles(Predicate<Artikel> condition, BiPredicate<Artikel,Artikel> operation) {
        Map<Integer,Artikel> filteredMap = filter(condition);
        return getSorted(operation, filteredMap);
    }

    public Map<Integer,Artikel> filterAll(Predicate<Artikel> ... conditions) {
        Map<Integer,Artikel> filteredMap = this.lagerMap;
        for (Predicate<Artikel> condition : conditions) {
            filteredMap = filter(condition, filteredMap);
        }
        return filteredMap;
    }

    /**
     * Constructor that creates a Lager object with a given maximum number of articles that can be stored in the array.
     * @param maxArtikel The maximum number of articles that can be stored in the array.
     */
    public Lager(int maxArtikel) {
        CheckUtils.checkGreaterThan(maxArtikel, 0, "lager");
        lagerMap = new LinkedHashMap<>(maxArtikel);
    }

    /**
     * Constructor that creates a Lager object with a standard maximum number of articles that can be stored in the array.
     */
    public Lager() {
        this(STANDARD_LAGER_SIZE);
    }

    /**
     * This method used to add an object to the array lager.
     * @param artikel The object that is added to the array lager.
     */
    public final void legeAnArtikel(Artikel artikel){
        CheckUtils.checkIfInLager(artikel.getArtikelNr(), lagerMap);
        lagerMap.put(artikel.getArtikelNr(), artikel);
    }

    /**
     * This method is used to remove an object from the array lager.
     * @param artikelNr The object that is removed from the array lager.
     */
    public final void entferneArtikel(int artikelNr){
        CheckUtils.checkIfLagerIsEmpty(lagerMap);
        CheckUtils.checkArtikelNr(artikelNr);
        CheckUtils.checkIfNotInLager(artikelNr, lagerMap);

        lagerMap.remove(artikelNr);
    }

    /**
     * This method is used to add a quantity to the attribute bestand
     * @param artikelNr This is the target Artikel
     * @param zugang This is the quantity that is added to the attribute bestand
     */
    public final void bucheZugang(int artikelNr, int zugang){ 
        CheckUtils.checkIfLagerIsEmpty(lagerMap);
        CheckUtils.checkArtikelNr(artikelNr);
        CheckUtils.checkIfNotInLager(artikelNr, lagerMap);

        lagerMap.get(artikelNr).bucheZugang(zugang);
    }

    /**
     * This method is used to remove a quantity from the attribute bestand
     * @param artikelNr This is the target Artikel
     * @param abgang This is the quantity that is removed from the attribute bestand
     */
    public final void bucheAbgang(int artikelNr, int abgang){
        CheckUtils.checkIfLagerIsEmpty(lagerMap);
        CheckUtils.checkArtikelNr(artikelNr);
        CheckUtils.checkIfNotInLager(artikelNr, lagerMap);

        lagerMap.get(artikelNr).bucheAbgang(abgang);
    }

    /**
     * This method is used to change the price of a specific Artikel by a certain percentage
     * @param artikelNr This is the target Artikel
     * @param prozent This is the percentage that is added or removed from the target Artikel's price
     */
    public final void aenderePreisEinesArtikels(int artikelNr, double prozent){
        CheckUtils.checkIfLagerIsEmpty(lagerMap);
        CheckUtils.checkArtikelNr(artikelNr);
        CheckUtils.checkIfNotInLager(artikelNr, lagerMap);

        lagerMap.get(artikelNr).aenderePreis(prozent);
    }

    /**
     * This method is used to change the price of all Artikel in the array lager by a certain percentage
     * @param prozent This is the percentage that is added or removed from all the Artikel's prices in the array lager
     */
    public final void aenderePreisAllerArtikel(double prozent){
        CheckUtils.checkIfLagerIsEmpty(lagerMap);

        for (Artikel artikel : lagerMap.values()) {
            artikel.aenderePreis(prozent);
        }
    }

    /**
     * This method is used to get the value of a target Artikel
     * @param index This is the index of target Artikel in the array lager
     * @return the target Artikel from the array lager at the given index
     */
    public final Artikel getArtikel(int key){
        CheckUtils.checkIfLagerIsEmpty(lagerMap);
        CheckUtils.checkIfNotInLager(key, lagerMap);

        return lagerMap.get(key);
    }

    /**
     * This method is used to print all the Artikel from the array lager
     * @return a string representation of all the Artikel in the array lager
     */
    @Override    
    public String toString() {    
        StringBuilder output = new StringBuilder();    
        for (Artikel artikel : lagerMap.values()) {    
            output.append(artikel.toString()).append("\n");    
        }
        return output.toString();    
    }

    /**
     * This method is used to get the size of the Map lagerMap
     * 
     * The Map size is the same as the number of Artikel in the map lagerMap 
     * since it is the Artikels are added dynamically
     * @return the size of the Map lagerMap
     */
    public final int getLagerGroesse(){
        return lagerMap.size();
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
        CheckUtils.checkIfLagerIsEmpty(lagerMap);
        CheckUtils.checkArtikelNr(artikelNr);

        return lagerMap.containsKey(artikelNr);
    }

    /**
     * This method is used to generate a list of all the Artikel in the array lager
     * including their details such as description, price, stock and total value.
     * @return a string representation of the list of all the Artikel in the array lager
     */
    public final String ausgebenBestandsListe(){    
        CheckUtils.checkIfLagerIsEmpty(lagerMap);    
        double sum = 0;    
        StringBuilder output = new StringBuilder();    

        int lineWidth = ART_NR_WIDTH + BESCHREIBUNG_WIDTH + PREIS_WIDTH + BESTAND_WIDTH + GESAMT_WIDTH + 4;
        int lastLineWidth = BESCHREIBUNG_WIDTH + PREIS_WIDTH + BESTAND_WIDTH - 4;
        String line = new String(new char[lineWidth]).replace("\\0", "-");    
        output.append(String.format("%-"+ ART_NR_WIDTH +"s %-"+ BESCHREIBUNG_WIDTH +"s %-"+ PREIS_WIDTH +"s %-"
                    + BESTAND_WIDTH +"s %-"+ GESAMT_WIDTH +"s", "ArtNr", "Beschreibung", "Preis", "Bestand", "Gesamt")).append("\n");
        output.append(line).append("\n");    
        for (Artikel artikel : lagerMap.values()) {
            output.append(String.format("%-"+ ART_NR_WIDTH +"d %-"+ BESCHREIBUNG_WIDTH +"s %-"+ PREIS_WIDTH 
                +".2f %-"+ BESTAND_WIDTH +"d %-"+ GESAMT_WIDTH +".2f", artikel.getArtikelNr(),
                artikel.getBeschreibung(), artikel.getPreis(), artikel.getBestand(), artikel.gesamtPreis())).append("\n");
            sum += artikel.gesamtPreis();    
        }    
        output.append(line).append("\n");    
        output.append(String.format("%"+ GESAMTWERT_WIDTH +"s %-" + lastLineWidth + "s %-"+ GESAMT_WIDTH +".2f", "Gesamtwert:", " ", sum )).append("\n");
        return output.toString();
    }

}
