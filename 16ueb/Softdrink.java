import java.util.Objects;

public class Softdrink extends AlkoholfreiesGetraenk {
    private float zuckergehalt;

    public Softdrink() {
        super();
    }

    public Softdrink(String hersteller, float zuckergehalt) {
        super(hersteller);
        this.zuckergehalt = zuckergehalt;
    }

    public Softdrink(String name, String hersteller, float zuckergehalt) {
        super(name, hersteller);
        this.zuckergehalt = zuckergehalt;
    }
    
    public float getZuckergehalt() {
        return zuckergehalt;
    }

    public void setZuckergehalt(float zuckergehalt) {
        this.zuckergehalt = zuckergehalt;
    }

    @Override
    public String toString() {
        return super.toString() + ", Zuckergehalt: " + zuckergehalt + ", Softdrink";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { 
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof Softdrink) {
            Softdrink softdrink = (Softdrink) obj;
            return Objects.equals(zuckergehalt, softdrink.zuckergehalt);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zuckergehalt);
    }
}
