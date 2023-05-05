import java.util.ArrayList;

public class Getraenkeautomat < T extends Getraenk> {
    private ArrayList<Flasche<T>> flaschenlager;
    private int kapazitaet;

    public Getraenkeautomat(int kapazitaet) {
        // check kapazitaet
        this.kapazitaet = kapazitaet;
        this.flaschenlager = new ArrayList<Flasche<T>>();
    }

    public void flascheEinlegen(Flasche<T> flasche) {
        // check if kapazitaet voll
        // check if flashce gefiuellt flasche.istGefuellt()
        this.flaschenlager.add(flasche);
    }

    public Flasche<T> flascheAusgeben() {
        // test if empty else eroor => is null or size 0
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
