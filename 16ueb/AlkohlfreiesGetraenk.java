public abstract class AlkohlfreiesGetraenk extends Getraenk {
    private String hersteller;

    public AlkohlfreiesGetraenk() {
        super();
    }

    public AlkohlfreiesGetraenk(String hersteller) {
        super();
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
        if (obj instanceof AlkohlfreiesGetraenk) {
            AlkohlfreiesGetraenk other = (AlkohlfreiesGetraenk) obj;
            return super.equals(obj) && hersteller.equals(other.hersteller);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + hersteller.hashCode();
    }
}
