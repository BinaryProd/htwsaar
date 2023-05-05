public class Softdrink extends AlkoholfreiesGetraenk {
    private float zuckergehalt;

    public Softdrink(String herteller,float zuckergehalt) {
        super(herteller);
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
        return super.toString() + " Zuckergehalt: " + zuckergehalt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Softdrink) {
            Softdrink other = (Softdrink) obj;
            return super.equals(obj) && zuckergehalt == other.zuckergehalt;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Float.hashCode(zuckergehalt);
    }
}
