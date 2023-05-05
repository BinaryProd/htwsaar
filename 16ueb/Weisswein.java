public class Weisswein extends Wein {

    public Weisswein() {
        super();
    }

    public Weisswein(float alkoholgehalt, String weingut) {
        super(alkoholgehalt, weingut);
    }

    public Weisswein(String name, double preis, float alkoholgehalt, String weingut) {
        super(name, preis, alkoholgehalt, weingut);
    }

    @Override
    public String getTyp() {
        return "Weisswein";
    }

    @Override
    public String toString() {
        return super.toString() + " Weisswein";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Weisswein) {
            Weisswein other = (Weisswein) obj;
            return super.equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
