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

    public Flasche() {
        this.inhalt = null;
        this.istGefuellt = false;
    }

    public Flasche(T inhalt) {
        this.inhalt = inhalt;
        this.istGefuellt = true;
    }

    public void fuellen(T inhalt) throws FlascheException {
        if (!istGefuellt) {
            this.inhalt = inhalt;
            this.istGefuellt = true;
        } else {
            throw new FlascheException("Flasche ist bereits gefuellt");
        }
    }

    public void leeren() throws FlascheException {
        if (istGefuellt) {
            this.inhalt = null;
            this.istGefuellt = false;
        } else {
            throw new FlascheException("Flasche ist bereits leer");
        }
    }

    public T getInhalt() {
        return inhalt;
    }

    public boolean istGefuellt() {
        return istGefuellt;
    }

    @Override
    public String toString() {
        if (istGefuellt) {
            return inhalt.toString();
        }
        return "Flasche ist leer";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Flasche) {
            Flasche other = (Flasche) obj;
            return this.inhalt.equals(other.inhalt) 
                && this.istGefuellt == other.istGefuellt;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.inhalt.hashCode() + Boolean.hashCode(this.istGefuellt);
    }
}
