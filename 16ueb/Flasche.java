/**
 * <h1> Flasche </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class Flasche < T extends Getraenk > {
    private T inhalt;
    private boolean istGefuellt;

    /**
     * constructor
     */
    public Flasche() {
        this.inhalt = null;
        this.istGefuellt = false;
    }

    /**
     * constructor
     * @param inhalt
     */
    public Flasche(T inhalt) {
        this.inhalt = inhalt;
        this.istGefuellt = true;
    }

    /**
     * fuellen
     * @param inhalt
     * @throws FlascheException
     */
    public void fuellen(T inhalt) throws FlascheException {
        if (!istGefuellt) {
            this.inhalt = inhalt;
            this.istGefuellt = true;
        } else {
            throw new FlascheException("Flasche ist bereits gefuellt");
        }
    }

    /**
     * leeren
     * @throws FlascheException
     */
    public void leeren() throws FlascheException {
        if (istGefuellt) {
            this.inhalt = null;
            this.istGefuellt = false;
        } else {
            throw new FlascheException("Flasche ist bereits leer");
        }
    }

    /**
     * getInhalt
     * @return T
     */
    public T getInhalt() {
        return inhalt;
    }

    /**
     * istGefuellt
     * @return boolean
     */
    public boolean istGefuellt() {
        return istGefuellt;
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        if (istGefuellt) {
            return inhalt.toString();
        }
        return "Flasche ist leer";
    }

    /**
     * equals
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Flasche) {
            Flasche other = (Flasche) obj;
            return this.inhalt.equals(other.inhalt) 
                && this.istGefuellt == other.istGefuellt;
        }
        return false;
    }

    /**
     * hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return this.inhalt.hashCode() + Boolean.hashCode(this.istGefuellt);
    }
}
