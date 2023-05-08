/**
 * <h1> Softdrink </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Objects;

public class Softdrink extends AlkoholfreiesGetraenk {
    private float zuckergehalt;

    /**
     * Default constructor
     */
    public Softdrink() {
        super();
    }

    /**
     * constructor
     * @param hersteller as String
     * @param zuckergehalt as float
     * @throws FlascheException
     */
    public Softdrink(String hersteller, float zuckergehalt) throws FlascheException{
        super(hersteller);
        FlascheException.checkFloat(zuckergehalt);
        this.zuckergehalt = zuckergehalt;
    }

    /**
     * constructor
     * @param name as String
     * @param hersteller as String
     * @param zuckergehalt as float
     * @throws FlascheException
     */
    public Softdrink(String name, String hersteller, float zuckergehalt) throws FlascheException{
        super(name, hersteller);
        FlascheException.checkFloat(zuckergehalt);
        this.zuckergehalt = zuckergehalt;
    }
    
    /**
     * getter zuckergehalt
     * @return zuckergehalt as float
     */
    public float getZuckergehalt() {
        return zuckergehalt;
    }

    /**
     * setter zuckergehalt
     * @param zuckergehalt as float
     * @throws FlascheException
     */
    public void setZuckergehalt(float zuckergehalt) throws FlascheException {
        FlascheException.checkFloat(zuckergehalt);
        this.zuckergehalt = zuckergehalt;
    }

    /**
     * To String
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + ", Zuckergehalt: " + zuckergehalt + ", Softdrink";
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
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof Softdrink) {
            Softdrink softdrink = (Softdrink) obj;
            return Objects.equals(zuckergehalt, softdrink.zuckergehalt);
        }
        return false;
    }

    /**
     * hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zuckergehalt);
    }
}
