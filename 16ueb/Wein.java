/**
 * <h1> Wein </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Objects;

public class Wein extends AlkoholischesGetraenk {
    private String weingut;

    /**
     * Default constructor
     */
    public Wein() {
        super();
        this.weingut = "Weingut";
    }

    /**
     * Constructor
     * @param alkoholgehalt as float
     * @param weingut as String
     * @throws FlascheException
     */
    public Wein(float alkoholgehalt, String weingut) throws FlascheException {
        super(alkoholgehalt);
        FlascheException.checkString(weingut);
        this.weingut = weingut;
    }

    /**
     * Constructor
     * @param name as String
     * @param alkoholgehalt as float
     * @param weingut as String
     * @throws FlascheException
     */
    public Wein(String name, float alkoholgehalt, String weingut) throws FlascheException {
        super(name, alkoholgehalt);
        FlascheException.checkString(weingut);
        this.weingut = weingut;
    }

    /**
     * get Weingut
     * @return String
     */
    public String getWeingut() {
        return weingut;
    }

    /**
     * set Weingut
     * @param weingut as String
     * @throws FlascheException
     */
    public void setWeingut(String weingut) throws FlascheException {
        FlascheException.checkString(weingut);
        this.weingut = weingut;
    }

    /**
     * To String
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + ", Weingut: " + weingut;
    }

    /**
     * Equals
     * @param obj as Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof Wein) {
            Wein other = (Wein) obj;
            return Objects.equals(weingut, other.weingut);
        }
        return false;
    }

    /**
     * Hash Code
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weingut);
    }
}
