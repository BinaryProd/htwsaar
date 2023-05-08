import java.util.Objects;

public class Wein extends AlkoholischesGetraenk {
    private String weingut;

    public Wein() {
        super();
        this.weingut = "Weingut";
    }

    public Wein(float alkoholgehalt, String weingut) {
        super(alkoholgehalt);
        this.weingut = weingut;
    }

    public Wein(String name, float alkoholgehalt, String weingut) {
        super(name, alkoholgehalt);
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
        return super.toString() + ", Weingut: " + weingut;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof Wein) {
            Wein other = (Wein) obj;
            return Objects.equals(weingut, other.weingut);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weingut);
    }
}
