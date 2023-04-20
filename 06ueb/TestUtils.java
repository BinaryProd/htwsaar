public class TestUtils {
    private static final int MIN_ARTIKELNR = 1000;
    private static final int MAX_ARTIKELNR = 9999;

    /**
	 * This method is used to check if the value is negativ 
	 * @param preis this is the value that will be checked 
	 */
    public static void checkPreis(double preis){
        if (preis < 0.0){
            throw new IllegalArgumentException("Der Preis " + preis + " muss groesser als 0 sein.");
        }
    }   

    /**
     * This method is used to check if new Art variable can be used
     * @param inputArt This is the new Art that will be checked
     */
    public static void checkArt(String inputArt) {
        if (inputArt.strip().isEmpty()) {
            throw new IllegalArgumentException("Die Art kann nicht leer sein.");    
        } else if (!inputArt.equals(inputArt.strip())){
            throw new IllegalArgumentException("Sie koennen keine Leerzeichen vor oder nach dem Objekt eingeben.");    
        }
    }

    /**
     * This method is used to check if new bestand variable can be used
     * @param inputBestand This is the new bestand that will be checked
     */
    public static void checkBestand(int inputBestand) {
        if (inputBestand < 0) {
            throw new IllegalArgumentException("Der Bestand muss positiv sein.");
        }
    }

    /**
     * This method is used to check if new ArtikelNr variable can be used
     * @param inputArtikelNr This is the new ArtikelNr that will be checked
     */
    public static void checkArtikelNr(int inputArtikelNr) { 
            if (inputArtikelNr < MIN_ARTIKELNR  || inputArtikelNr > MAX_ARTIKELNR) {
                   throw new IllegalArgumentException("Die Artikelnummer muss groesser als 1000 und eine positive vierstellige Zahl sein.");
        }
    }

    /**
     * This method is used to check if the Artikelnr is already in use
     * @param artikelNr This is the ArtikelNr that will be checked
     */
    public static void checkIfInLager(int artikelNr, Artikel[] artikel){
        for (int i = 0; i < artikel.length; i++) {
            if (artikel[i] != null && artikel[i].getArtikelNr() == artikelNr) {
                throw new IllegalArgumentException("Die Artikelnummer " + artikelNr + " ist bereits vergeben.");
            }
        }
    }

    public static void checkIfNotInLager(int artikelNr, Artikel[] artikel){
        for (int i = 0; i < artikel.length; i++) {
            if (artikel[i] != null && artikel[i].getArtikelNr() == artikelNr) {
                return;
            }
        }
        throw new IllegalArgumentException("Die Artikelnummer " + artikelNr + " ist nicht im Lager.");
    }

    /**
     * This method is used to check if the Lager is empty
     * @param lager This is the Lager that will be checked
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


     /**
     * This method is used to check if the Lager is empty
     * @param lager This is the Lager that will be checked
     */
    public static void checkIfLagerIsEmpty(Artikel[] lager) {
        int count = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null ){
                count++;
            }
        }
        if (count == 0){
            throw new IllegalArgumentException("Das Lager ist leer, wenn Sie an dem Lager aederungen vornehmen wollen," + "\n" 
            + "muessen Sie erst ein Artikel hinzufuegen.");
        }
    }
    
    /**
     * This method is used to check if the index is valid
     * @param index This is the index that will be checked
     */
    public static void checkIfIndexIsInRange(int index, int length) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Der Index ist nicht im Bereich des Lagers." + "\n" 
            + " Er muss zwischen 0 und " + (length - 1) + " liegen.");
        }
    }

    public static void checkIfIndexIsNull(Artikel[] lager, int index) {
        if (lager[index] == null) {
            throw new IllegalArgumentException("An dem Index ist kein Artikel.");
        }
    }

    /**
     * This method is used to check if the input of the user is lower than 1
     * @param maxArtikel This is the input of the user
     * @param string This is the name of the variable that will be checked
     */
    public static void checkLagerSize(int maxArtikel) {
        if (maxArtikel < 1) {
            throw new IllegalArgumentException("Das Lager muss mindestens ein Artikel enthalten können.");
        }
    }
    public static void checkProzent(double prozent){
        if (prozent < -100.0){
            throw new IllegalArgumentException("Sie können nicht mehr als 100% rabattieren.");
        }
    }
}

