/**
 * <h1> Getraenkeautomat </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.ArrayList;

public class Getraenkeautomat <T extends Getraenk> {
    private ArrayList<Flasche<? extends T>> flaschenlager;
    private int kapazitaet;

    public Getraenkeautomat(int kapazitaet) throws GetraenkeautomatException {
        if (kapazitaet <= 0) {
            throw new GetraenkeautomatException("Kapazitaet muss groesser 0 sein");
        }

        this.kapazitaet = kapazitaet;
        this.flaschenlager = new ArrayList<Flasche<? extends T>>();
    }

    public void flascheEinlegen(Flasche<? extends T> flasche) throws GetraenkeautomatException {
        if (this.flaschenlager.size() >= this.kapazitaet) {
            throw new GetraenkeautomatException("Kapazitaet ist voll");
        }
        if (!flasche.istGefuellt()) {
            throw new GetraenkeautomatException("Flasche ist nicht gefuellt");
        }

        this.flaschenlager.add(flasche);
    }

    public Flasche<? extends T> flascheAusgeben() throws GetraenkeautomatException {
        if (this.flaschenlager.size() == 0) {
            throw new GetraenkeautomatException("Keine Flaschen mehr vorhanden");
        }

        return this.flaschenlager.remove(0);
    }

    public int getKapazitaet() {
        return this.kapazitaet;
    }

    public int getAnzahlFlaschen() {
        return this.flaschenlager.size();
    }

    public boolean istEmpty() {
        return this.flaschenlager.size() == 0;
    }

    @Override
    public String toString() {
        if (this.flaschenlager.size() == 0) {
            return "Getraenkeautomat ist leer";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nKapazitaet: " + this.kapazitaet + "\n");
        sb.append("Anzahl Flaschen: " + this.getAnzahlFlaschen() + "\n");
        sb.append("Flaschen: \n");
        sb.append(ArrayUtils.toStringPretty(this.flaschenlager.toArray()));
        return sb.toString();
    }
}
