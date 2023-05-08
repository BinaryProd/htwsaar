import java.util.Objects;

public abstract class AlkoholischesGetraenk extends Getraenk {
    private float alkoholgehalt;

    public AlkoholischesGetraenk() {
        super();
        this.alkoholgehalt = 0.0f;
    }

    public AlkoholischesGetraenk(float alkoholgehalt) {
        super();
        this.alkoholgehalt = alkoholgehalt;
    }

    public AlkoholischesGetraenk(String name, float alkoholgehalt) {
        super(name);
        this.alkoholgehalt = alkoholgehalt;
    }

    public float getAlkoholgehalt() {
        return alkoholgehalt;
    }

    public void setAlkoholgehalt(float alkoholgehalt) {
        this.alkoholgehalt = alkoholgehalt;
    }

    @Override
    public String toString() {
        return super.toString() + ", Alkoholgehalt: " + alkoholgehalt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.equals(obj)) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof AlkoholischesGetraenk) {
            AlkoholischesGetraenk other = (AlkoholischesGetraenk) obj;
            return Objects.equals(this.alkoholgehalt, other.alkoholgehalt);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), alkoholgehalt);
    }
}
