import java.util.Objects;

public class Wasser extends AlkoholfreiesGetraenk {
    private String quelle;

    public Wasser() {
        super();
        this.quelle = "Quelle";
    }

    public Wasser(String hersteller, String quelle) {
        super(hersteller);
        this.quelle = quelle;
    }

    public Wasser(String name, String hersteller, String quelle) {
        super(name, hersteller);
        this.quelle = quelle;
    }

    public String getQuelle() {
        return quelle;
    }

    public void setQuelle(String quelle) {
        this.quelle = quelle;
    }

    @Override
    public String toString() {
        return super.toString() + ", Quelle: " + quelle + ", Wasser";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof Wasser) {
            Wasser wasser = (Wasser) obj;
            return Objects.equals(this.quelle, wasser.quelle);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.quelle);
    }
}
