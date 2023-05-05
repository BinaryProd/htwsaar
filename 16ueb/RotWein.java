public class RotWein extends Wein {

    public RotWein() {
        super();
    }

    public RotWein(String name, double preis, float alkoholgehalt, String weingut) {
        super(name, preis, alkoholgehalt, weingut);
    }

    @Override
    public String toString() {
        return super.toString() + " Rotwein";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RotWein) {
            RotWein other = (RotWein) obj;
            return super.equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
