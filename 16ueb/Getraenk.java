public abstract class Getraenk {
    private String name;
    private double preis;

    public Getraenk() {
        this.name = "";
        this.preis = 0.0;
    }

    public Getraenk(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    public String getName() {
        return this.name;
    }

    public double getPreis() {
        return this.preis;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public abstract String getTyp();

    @Override
    public String toString() {
        return "Getraenk: " + name + "preis:" + preis;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Getraenk) {
            Getraenk getraenk = (Getraenk) obj;
            return this.name.equals(getraenk.name) 
                && this.preis == getraenk.preis;
        }
        return false;
    }

     @Override
    public int hashCode() {
        return this.name.hashCode() + Double.hashCode(this.preis);
    }
}
