public class Bier extends AlkoholischesGetraenk {
    private String brauerei;

    public Bier() {
        super();
        this.brauerei = "";
    }

    public Bier(float alkoholgehalt, String brauerei) {
        super(alkoholgehalt);
        this.brauerei = brauerei;
    }

    public Bier(String name, double preis, float alkoholgehalt, String brauerei) {
        super(name, preis, alkoholgehalt);
        this.brauerei = brauerei;
    }

    public String getBrauerei() {
        return brauerei;
    }

    public void setBrauerei(String brauerei) {
        this.brauerei = brauerei;
    }

    @Override
    public String getTyp() {
        return "Bier";
    }

    @Override
    public String toString() {
        return super.toString() + " Brauerei: " + brauerei;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bier) {
            Bier other = (Bier) obj;
            return super.equals(obj) && brauerei.equals(other.brauerei);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + brauerei.hashCode();
    }
}
