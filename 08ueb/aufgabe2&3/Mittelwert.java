public class Mittelwert {
    private double mittelwert;
    private double naehstewert;
    private double entferntesterwert;

    /**
     * Constructs a new Mittelwert with the given values.
     * @param mittelwert the average value
     * @param naehstewert the nearest value
     * @param entferntesterwert the farthest value
     */
    public Mittelwert(double mittelwert, double naehstewert, double entferntesterwert) {
        this.mittelwert = mittelwert;
        this.naehstewert = naehstewert;
        this.entferntesterwert = entferntesterwert;
    }

    /**
     * Returns the average value of this Mittelwert.
     * @return the average value
     */
    public double getMittelwert() {
        return mittelwert;
    }

    /**
     * Returns the nearest value of this Mittelwert.
     * @return the nearest value
     */
    public double getNaehesterWert() {
        return naehstewert;
    }

    /**
     * Returns the farthest value of this Mittelwert.
     * @return the farthest value
     */
    public double getEntferntesterWert() {
        return entferntesterwert;
    }

    /**
     * Returns a string representation of this Mittelwert.
     * @return a string in the format "Mittelwert: {mittelwert}, Naehstewert: {naehstewert}, Weitestenwert: {entferntesterwert}"
     */
    @Override
    public String toString() {
        return "Mittelwert: " + mittelwert + ", Naehstewert: " + naehstewert + ", Weitestenwert: " + entferntesterwert;
    }
}
