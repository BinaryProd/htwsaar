import java.util.Objects;

public class Bier extends AlkoholischesGetraenk {
    private String brauerei;

    public Bier() {
        super();
        this.brauerei = "Brauerei";
    }

    public Bier(float alkoholgehalt, String brauerei) {
        super(alkoholgehalt);
        this.brauerei = brauerei;
    }

    public Bier(String name, float alkoholgehalt, String brauerei) {
        super(name, alkoholgehalt);
        this.brauerei = brauerei;
    }

    public String getBrauerei() {
        return brauerei;
    }

    public void setBrauerei(String brauerei) {
        this.brauerei = brauerei;
    }

    @Override
    public String toString() {
        return super.toString() + ", Brauerei: " + brauerei;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { 
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if(obj instanceof Bier) {
            Bier bier = (Bier) obj;
            return Objects.equals(this.brauerei, bier.brauerei);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brauerei);
    }
}
