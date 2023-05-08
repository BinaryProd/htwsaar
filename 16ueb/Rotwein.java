public class Rotwein extends Wein {

    public Rotwein() {
        super();
    }

    public Rotwein(float alkoholgehalt, String weingut) {
        super(alkoholgehalt, weingut);
    }

    public Rotwein(String name, float alkoholgehalt, String weingut) {
        super(name, alkoholgehalt, weingut);
    }

    @Override
    public String toString() {
        return super.toString() + ", Rotwein";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof Rotwein) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
