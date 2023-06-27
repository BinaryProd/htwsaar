/**
 * <h1>CD Class</h1>
 * Allows the user to create objects with a artist, 
 * a title and a song quantity. Then the user can interact 
 * with his items using methods
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2022-11-04
 */

import java.util.Objects;

public final class CD extends Artikel {
    private String interpret;
    private String titel;
    private int anzahlTitel;

    private static final String ARTIKEL_ART = "Medien";

    /**
     * Creates a new CD object with the specified properties.
     *
     * @param artikelNr the article number of the CD
     * @param bestand the stock of the CD
     * @param preis the price of the CD
     * @param interpret the artist of the CD
     * @param title the title of the CD
     * @param anzahlTitel the number of tracks on the CD
     */
    public CD(int artikelNr, int bestand, double preis, String interpret, String title, int anzahlTitel) {
        super(artikelNr, ARTIKEL_ART, bestand, preis);

        CheckUtils.checkIfEmpty(interpret);
        CheckUtils.checkIfEmpty(title);
        CheckUtils.checkGreaterThan(anzahlTitel, 0, "anzahlTitel");


        this.interpret = interpret;
        this.titel = title;
        this.anzahlTitel = anzahlTitel;
    }

    /**
     * Sets the artist of the CD.
     * @param interpret the artist to set
     */
    public final void setInterpret(String interpret) {
        CheckUtils.checkIfEmpty(interpret);
        this.interpret = interpret.trim();
    }

    /**
     * Sets the title of the CD.
     * @param titel the title to set
     */
    public final void setTitel(String titel) {
        CheckUtils.checkIfEmpty(titel);
        this.titel = titel.trim();
    }

    /**
     * Sets the number of tracks on the CD.
     * @param anzahlTitel the number of tracks to set
     */
    public final void setAnzahlTitel(int anzahlTitel) {
        CheckUtils.checkGreaterThan(anzahlTitel, 0, "anzahlTitel");
        this.anzahlTitel = anzahlTitel;
    }

    /**
     * Returns the artist of the CD.
     * @return the artist
     */
    public final String getInterpret() {
        return interpret;
    }

    /**
     * Returns the title of the CD.
     * @return the title
     */
    public final String getTitel() {
        return titel;
    }

    /**
     * Returns the number of tracks on the CD.
     * @return the number of tracks
     */
    public final int getAnzahlTitel() {
        return anzahlTitel;
    }

    /**
     * Returns a description of the CD in the format "artist: title".
     * @return the description
     */
    @Override
    public final String getBeschreibung() {
        return interpret + ": " + titel;
    }

    /**
     * Returns a string representation of the CD.
     * @return the string representation
     */
    @Override
    public final String toString(){
        return super.toString() + ", CD interpret: " + interpret + ", titel: " + titel + ", anzahlTitel: " + anzahlTitel;
    }

    /**
     * Checks if the provided object is equal to this CD.
     * @param object the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || !(object instanceof CD)){
            return false;
        }
        if (!super.equals(object)){ 
            return false;
        }

        CD cd = (CD) object;

        return Objects.equals(interpret, cd.interpret) &&
            Objects.equals(titel, cd.titel) &&
            anzahlTitel == cd.anzahlTitel;
    }

    /**
     * Returns the hash code for this CD.
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interpret, titel, anzahlTitel);
    }

}
