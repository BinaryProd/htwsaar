/**
 * <h1> AlkoholfreiesGetraenk </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Objects;

public abstract class AlkoholfreiesGetraenk extends Getraenk {
    private String hersteller;

    /**
     * Default constructor
     */
    public AlkoholfreiesGetraenk() {
        super();
        this.hersteller = "Hersteller";
    }

    /**
     * constructor
     * @param hersteller as String
     * @throws FlascheException
     */
    public AlkoholfreiesGetraenk(String hersteller) throws FlascheException {
        super();
        FlascheException.checkString(hersteller);
        this.hersteller = hersteller;
    }

    /**
     * constructor
     * @param name as String
     * @param hersteller as String
     * @throws FlascheException
     */
    public AlkoholfreiesGetraenk(String name, String hersteller) throws FlascheException {
        super(name);
        FlascheException.checkString(hersteller);
        this.hersteller = hersteller;
    }

    /**
     * getter hersteller
     * @return hersteller as String
     */
    public String getHersteller() {
        return hersteller;
    }

    /**
     * setter hersteller
     * @param hersteller as String
     * @throws FlascheException
     */
    public void setHersteller(String hersteller) throws FlascheException {
        FlascheException.checkString(hersteller);
        this.hersteller = hersteller;
    }

    /**
     * To String
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + ", Hersteller: " + hersteller;
    }

    /**
     * equals
     * @param obj as Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) { // ruft Getraenk.equals() auf
            return false;
        }
        if (obj instanceof AlkoholfreiesGetraenk) {
            AlkoholfreiesGetraenk other = (AlkoholfreiesGetraenk) obj;
            return Objects.equals(this.hersteller, other.hersteller);
        }
        return false;
    }

    /**
     * hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hersteller);
    }
}
