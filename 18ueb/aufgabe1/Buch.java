/**
 * <h1>Book Class</h1>
 * Allows the user to create objects with a title, 
 * a author, and a publisher. Then the user can interact 
 * with his items using methods
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2022-11-04
 */

import java.util.Objects;

public final class Buch extends Artikel {
    private String titel;
    private String autor;
    private String verlag;

    private static final String ARTIKEL_ART = "Medien";

    /**
     * Creates a new Buch object with the specified properties.
     *
     * @param artikelNr the article number of the book
     * @param bestand the stock of the book
     * @param preis the price of the book
     * @param titel the title of the book
     * @param autor the author of the book
     * @param verlag the publisher of the book
     */
    public Buch(int artikelNr, int bestand, double preis, String titel, String autor, String verlag) {
        super(artikelNr, ARTIKEL_ART, bestand, preis);

        CheckUtils.checkIfEmpty(titel);
        CheckUtils.checkIfEmpty(autor);
        CheckUtils.checkIfEmpty(verlag);
        
        this.titel = titel;
        this.autor = autor;
        this.verlag = verlag;
    }

    /**
     * Sets the title of the book.
     * @param titel the title to set
     */
    public final void setTitel(String titel) {
        CheckUtils.checkIfEmpty(titel);
        this.titel = titel.trim();
    }


    /**
     * Sets the author of the book.
     * @param autor the author to set
     */
    public final void setAutor(String autor) {
        CheckUtils.checkIfEmpty(autor);
        this.autor = autor.trim();
    }

    /**
     * Sets the publisher of the book.
     * @param verlag the publisher to set
     */
    public final void setVerlag(String verlag) {
        CheckUtils.checkIfEmpty(verlag);
        this.verlag = verlag.trim();
    }

    /**
     * Returns the title of the book.
     * @return the title
     */
    public final String getTitel() {
        return titel;
    }

    /**
     * Returns the author of the book.
     * @return the author
     */
    public final String getAutor() {
        return autor;
    }

    /**
     * Returns the publisher of the book.
     * @return the publisher
     */
    public final String getVerlag() {
        return verlag;
    }


    /**
     * Returns a description of the book in the format "author: title".
     * @return the description
     */
    @Override
    public final String getBeschreibung() {
        return autor + ": " + titel;
    }

    /**
     * Returns a string representation of the book.
     * @return the string representation
     */
    @Override
    public final String toString() {
        return super.toString() + ", Buch titel: " + titel + ", autor: " + autor + ", verlag: " + verlag;
    }
    /**
     * Checks if the provided object is equal to this book.
     * @param object the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (this == object){ 
            return true;
        }
        if (object == null || !(object instanceof Buch)) {
            return false;
        }
        if (!super.equals(object)){
            return false;
        }

        Buch buch = (Buch) object;

        return Objects.equals(titel, buch.titel) &&
            Objects.equals(autor, buch.autor) &&
            Objects.equals(verlag, buch.verlag);
    }

    /**
     * Returns the hash code for this book.
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), titel, autor, verlag);
    }
}

