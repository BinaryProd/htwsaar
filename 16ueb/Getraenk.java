/**
 * <h1> Getraenk </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Objects;

public abstract class Getraenk {
    private String name;

    /**
     * Default constructor
     */
    public Getraenk() {
        this.name = "Name";
    }

    /**
     * Constructor
     * @param name
     * @throws FlascheException if string is empty
     */
    public Getraenk(String name) throws FlascheException{
        FlascheException.checkString(name);
        this.name = name;
    }

    /**
     * get the name of the drink
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of the drink
     * @param newName
     * @throws FlascheException if string is empty
     */
    public void setName(String newName) throws FlascheException{
        FlascheException.checkString(newName);
        this.name = newName;
    }

    /**
     * ToString method
     * @return String
     */
    @Override
    public String toString() {
        return "Getraenk: " + name;
    }

    /**
     * Equals method
     * @param obj
     * @return boolean
     */
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

    /**
     * HashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);// Objects.hash() because it handles null values
    } 
}
