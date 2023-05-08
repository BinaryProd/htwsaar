import java.util.Objects;

public abstract class AlkoholfreiesGetraenk extends Getraenk {
    private String hersteller;

    public AlkoholfreiesGetraenk() {
        super();
        this.hersteller = "Hersteller";
    }

    public AlkoholfreiesGetraenk(String hersteller) {
        super();
        this.hersteller = hersteller;
    }

    public AlkoholfreiesGetraenk(String name, String hersteller) {
        super(name);
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
        return super.toString() + ", Hersteller: " + hersteller;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) { // ruft Getraenk.equals() auf
            return false;
        }
        if (obj instanceof AlkoholfreiesGetraenk) {
            AlkoholfreiesGetraenk other = (AlkoholfreiesGetraenk) obj;
            return Objects.equals(this.hersteller, other.hersteller);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hersteller);
    }
}
