import java.util.Objects;

public abstract class Getraenk {
    private String name;

    public Getraenk() {
        this.name = "Name";
    }

    public Getraenk(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public String toString() {
        return "Getraenk: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (obj instanceof Getraenk) {
            Getraenk other = (Getraenk) obj;
            return Objects.equals(this.name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);// Objects.hash() because it handles null values
    } 
}
