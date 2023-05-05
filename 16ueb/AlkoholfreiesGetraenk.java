public abstract class AlkoholfreiesGetraenk extends Getraenk {
    private String hersteller;

    public AlkoholfreiesGetraenk() {
        super();
        this.hersteller = "";
    }

    public AlkoholfreiesGetraenk(String name, double preis, String hersteller) {
        super(name, preis);
        this.hersteller = hersteller;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    @Override
    public String toString() {
        return super.toString() + " Hersteller: " + hersteller;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AlkoholfreiesGetraenk) {
            AlkoholfreiesGetraenk other = (AlkoholfreiesGetraenk) obj;
            return super.equals(obj) && hersteller.equals(other.hersteller);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + hersteller.hashCode();
    }
}
