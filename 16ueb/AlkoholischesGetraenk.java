public abstract class AlkoholischesGetraenk extends Getraenk {
    private float alkoholgehalt;

    public AlkoholischesGetraenk() {
        super();
        this.alkoholgehalt = 0.0f;
    }

    public AlkoholischesGetraenk(String name, double preis, float alkoholgehalt) {
        super(name, preis);
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
        return super.toString() + " Alkoholgehalt: " + alkoholgehalt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AlkoholischesGetraenk) {
            AlkoholischesGetraenk other = (AlkoholischesGetraenk) obj;
            return super.equals(obj) && alkoholgehalt == other.alkoholgehalt;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Float.hashCode(alkoholgehalt);
    }
}
