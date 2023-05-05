import java.util.ArrayList;

public class Getraenkeautomat < T extends Getraenk> {
    private ArrayList<Flasche<T>> flaschenlager;
    private int kapazitaet;

    public Getraenkeautomat(int kapazitaet) throws GetraenkeautomatException {
        if (kapazitaet <= 0) {
            throw new GetraenkeautomatException("Kapazitaet muss groesser 0 sein");
        }

        this.kapazitaet = kapazitaet;
        this.flaschenlager = new ArrayList<Flasche<T>>();
    }

    public void flascheEinlegen(Flasche<T> flasche) throws GetraenkeautomatException {
        if (this.flaschenlager.size() >= this.kapazitaet) {
            throw new GetraenkeautomatException("Kapazitaet ist voll");
        }
        if (!flasche.istGefuellt()) {
            throw new GetraenkeautomatException("Flasche ist nicht gefuellt");
        }

        this.flaschenlager.add(flasche);
    }

    public Flasche<T> flascheAusgeben() throws GetraenkeautomatException {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Getraenkeautomat: \n");
        sb.append("Kapazitaet: " + this.kapazitaet + "\n");
        sb.append("Anzahl Flaschen: " + this.getAnzahlFlaschen() + "\n");
        sb.append("Flaschen: \n");
        sb.append(ArrayUtils.toStringPretty(this.flaschenlager.toArray()));
        //for (Flasche<T> flasche : this.flaschenlager) {
        //    sb.append(flasche.toString() + "\n");
        //}
        return sb.toString();
    }
}
