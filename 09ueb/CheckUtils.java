public class CheckUtils {
    private static final int MIN_ARTIKELNR = 1000;
    private static final int MAX_ARTIKELNR = 9999;

    public static void checkBuchung(int menge) {
        if (menge <= 0) {
            throw new IllegalArgumentException("Menge darf nicht negativ, oder 0 sein");
        }
    }

    public static void checkAbgangBuchung(int bestand, int menge) {
        if (bestand - menge < 0) {
            throw new IllegalArgumentException("Menge darf nicht größer als Bestand sein," 
                    + " sonst ist der Bestand negativ");
        }
    }

    /**
     * This method is used to validate that the input for the new stock variable is non-negative.
     * @param inputBestand The new stock to be validated
     * @throws IllegalArgumentException if the stock is less than 0
     */
    public static void checkBestand(int inputBestand) {
        if (inputBestand < 0) {
            throw new IllegalArgumentException("Der Bestand muss positiv sein.");
        }
    }

    /**
     * This method is used to validate that the price is non-negative.
     * @param preis The price to be validated.
     * @throws IllegalArgumentException if the price is less than 0
     */
    public static void checkPreis(double preis){
        if (preis < 0.0){
            throw new IllegalArgumentException("Der Preis " + preis + " muss groesser als 0 sein.");
        }
    }   

    /**
     * This method is used to validate that the input for the new art variable is not empty and does not contain leading or trailing whitespaces.
     * @param inputArt The new art to be validated
     * @throws IllegalArgumentException if the input is empty or contains leading or trailing whitespaces
     */
    public static void checkIfEmpty(String inputArt) {
        if (inputArt.isBlank()) {
            throw new IllegalArgumentException("Die Art kann nicht leer sein.");    
        } 
        /* else if (!inputArt.equals(inputArt.strip())){
           throw new IllegalArgumentException("Sie koennen keine Leerzeichen vor oder nach dem Objekt eingeben.");    
           }*/
    }

    /**
     * This method is used to validate that the input for the new article number variable is a four-digit positive number.
     * @param inputArtikelNr The new article number to be validated
     * @throws IllegalArgumentException if the article number is less than 1000 or greater than 9999
     */
    public static void checkArtikelNr(int inputArtikelNr) { 
        if (inputArtikelNr < MIN_ARTIKELNR  || inputArtikelNr > MAX_ARTIKELNR) {
            throw new IllegalArgumentException("Die Artikelnummer muss groesser als 1000 und eine positive vierstellige Zahl sein.");
        }
    }

    /**
     * This method is used to check if the article number is already in use.
     * @param artikelNr The article number to be checked
     * @param artikel The array of articles to check the given article number against
     * @throws IllegalArgumentException if the article number is already in use
     */
    public static void checkIfInLager(int artikelNr, Artikel[] artikel){
        for (int i = 0; i < artikel.length; i++) {
            if (artikel[i] != null && artikel[i].getArtikelNr() == artikelNr) {
                throw new IllegalArgumentException("Die Artikelnummer " + artikelNr + " ist bereits vergeben.");
            }
        }
    }

    /**
     * This method checks if a given article number is present in the given array of articles.
     * @param artikelNr The article number to check for in the array of articles
     * @param artikel The array of articles to check the given article number against
     * @throws IllegalArgumentException if the article number is not found in the array
     */
    public static void checkIfNotInLager(int artikelNr, Artikel[] artikel){
        for (int i = 0; i < artikel.length; i++) {
            if (artikel[i] != null && artikel[i].getArtikelNr() == artikelNr) {
                return;
            }
        }
        throw new IllegalArgumentException("Die Artikelnummer " + artikelNr + " ist nicht im Lager.");
    }

    /**
     * This method is used to check if the inventory is full.
     * @param lager The inventory to be checked
     * @throws IllegalArgumentException if the inventory is full
     */
    public static void checkIfLagerIsFull(Artikel[] lager) {
        int count = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null ){
                count++;
            }
        }
        if (count == lager.length) {
            throw new IllegalArgumentException("Das Lager ist voll, wenn Sie an dem Lager aederungen vornehmen wollen," + "\n"
                    + "muessen Sie erst einen Artikel loeschen.");
        }
    }


    public static void checkIfLagerIsEmpty(Artikel[] lager) {
        int count = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null ){
                count++;
            }
        }
        if (count == 0){
            throw new IllegalArgumentException("Das Lager ist leer. Sie muessen erstmal Artikel hinzufuegen.");
        }
    }

    /**
     * This method is used to check if the index is valid
     * @param index The index to be checked
     * @param length The length of the inventory
     * @throws IllegalArgumentException if the index is not in the range of the inventory
     */
    public static void checkIfIndexIsInRange(int index, int length) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Der Index ist nicht im Bereich des Lagers." + "\n"
                    + " Er muss zwischen 0 und " + (length - 1) + " liegen.");
        }
    }

    /**
     * This method is used to check if the index is null
     * @param lager The inventory
     * @param index The index to be checked
     * @throws IllegalArgumentException if the index is null
     */
    public static void checkIfIndexIsNull(Artikel[] lager, int index) {
        if (lager[index] == null) {
            throw new IllegalArgumentException("An dem Index ist kein Artikel.");
        }
    }

    /**
     * This method checks if a given value is greater than the specified minimum value.
     * @param value The value to be checked
     * @param minValue The minimum value to be compared against
     * @param valueName The name of the value for error message
     * @throws IllegalArgumentException if the value is less than the minimum value
     */
    public static void checkGreaterThan(int anzahl, int number, String string) {
        if (anzahl < number || anzahl == number) {
            if(string.equals("lager")){
                throw new IllegalArgumentException("Das Lager muss mindestens ein Artikel enthalten können.");
            }
            if(string.equals("spieldauer")){
                throw new IllegalArgumentException("Der Film muss mindestens 1 min lang sein.");
            }
            if(string.equals("anzahlTitel")){
                throw new IllegalArgumentException("Die CD muss mindestens 1 Titel enthalten können.");
            }
        }
    }

    /**
     * This method is used to check if the input of the user is greater than 100%
     * @param prozent The input of the user
     * @throws IllegalArgumentException if the input is greater than 100
     */
    public static void checkProzent(double prozent){
        if (prozent < -100.0){
            throw new IllegalArgumentException("Sie können nicht mehr als 100% rabattieren.");
        }
    }

    /**
     * This method is used to check if the input of the user is greater than 100%
     * @param prozent The input of the user
     * @throws IllegalArgumentException if the input is greater than 100
     */
    public static void checkJahr(int jahr){
        if (jahr < 1900 || jahr > 2022){
            throw new IllegalArgumentException("Das Jahr muss zwischen 1900 und 2022 liegen.");
        }
    }

    /**
     * This method is used to check if the year input is between 1900 and current year
     * @param jahr The year to be checked
     * @throws IllegalArgumentException if the year is not between 1900 and current year                                                                                                                                                                                                                                                                                                                                                    
     */
    public static void checkIfSame(int artikelNr1, int artikelNr2){
        if (artikelNr1 == artikelNr2){
            throw new IllegalArgumentException("Sie haben zweimal das gleiche Objekt eingegeben.");
        }
    }

    /**
     * This method is used to check if the two input article numbers are the same.
     * @param artikelNr1 The first article number to be checked
     * @param artikelNr2 The second article number to be checked
     * @throws IllegalArgumentException if the two input article numbers are the same
     */
    public static void checkType(Artikel artikel1, Artikel artikel2){
        if (artikel1.getArt() != artikel2.getArt()){
            throw new IllegalArgumentException("Sie haben zwei verschiedene Objekte eingegeben.");
        }
    }
}
