public class RotWein extends Wein {

    public RotWein() {
        super();
    }

    public RotWein(float alkoholgehalt, String weingut) {
        super(alkoholgehalt, weingut);
    }

    public RotWein(String name, float alkoholgehalt, String weingut) {
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
        if (obj instanceof RotWein) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
