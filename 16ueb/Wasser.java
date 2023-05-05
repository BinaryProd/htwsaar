public class Wasser extends AlkoholfreiesGetraenk {
    private String quelle;

    public Wasser() {
        super();
        this.quelle = "";
    }

    public Wasser(String hersteller, String quelle) {
        super(hersteller);
        this.quelle = quelle;
    }

    public Wasser(String name, double preis, String hersteller, String quelle) {
        super(name, preis, hersteller);
        this.quelle = quelle;
    }

    public String getQuelle() {
        return quelle;
    }

    public void setQuelle(String quelle) {
        this.quelle = quelle;
    }

    @Override
    public String getTyp() {
        return "Wasser";
    }

    @Override
    public String toString() {
        return super.toString() + " Quelle: " + quelle;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Wasser) {
            Wasser other = (Wasser) obj;
            return super.equals(obj) && quelle.equals(other.quelle);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + quelle.hashCode();
    }
}
