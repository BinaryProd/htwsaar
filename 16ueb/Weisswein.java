public class Weisswein extends Wein {

    public Weisswein() {
        super();
    }

    public Weisswein(float alkoholgehalt, String weingut) {
        super(alkoholgehalt, weingut);
    }

    public Weisswein(String name, float alkoholgehalt, String weingut) {
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
        if (obj instanceof Weisswein) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
