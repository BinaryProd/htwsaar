public class Wein extends AlkoholischesGetraenk {
    private String weingut;

    public Wein() {
        super();
        this.weingut = "";
    }

    public Wein(String name, double preis, float alkoholgehalt, String weingut) {
        super(name, preis, alkoholgehalt);
        this.weingut = weingut;
    }

    public String getWeingut() {
        return weingut;
    }

    public void setWeingut(String weingut) {
        this.weingut = weingut;
    }

    @Override
    public String toString() {
        return super.toString() + " Weingut: " + weingut;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Wein) {
            Wein other = (Wein) obj;
            return super.equals(obj) && weingut.equals(other.weingut);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + weingut.hashCode();
    }
}
