public class Rotwein extends Wein {

    public Rotwein() {
        super();
    }

    public Rotwein(float alkoholgehalt, String weingut) {
        super(alkoholgehalt, weingut);
    }

    public Rotwein(String name, double preis, float alkoholgehalt, String weingut) {
        super(name, preis, alkoholgehalt, weingut);
    }

    @Override
    public String getTyp() {
        return "Rotwein";
    }

    @Override
    public String toString() {
        return super.toString() + " Rotwein";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rotwein) {
            Rotwein other = (Rotwein) obj;
            return super.equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
