public class WeissWein extends Wein {

    public WeissWein() {
        super();
    }

    public WeissWein(float alkoholgehalt, String weingut) {
        super(alkoholgehalt, weingut);
    }

    public WeissWein(String name, float alkoholgehalt, String weingut) {
        super(name, alkoholgehalt, weingut);
    }

    @Override
    public String toString() {
        return super.toString() + ", Weisswein";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof WeissWein) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
