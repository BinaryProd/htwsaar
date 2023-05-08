/**
 * <h1> Weisswein </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class Weisswein extends Wein {

    /**
     * Default constructor
     */
    public Weisswein() {
        super();
    }

    /**
     * Constructor
     * @param alkoholgehalt as float
     * @param weingut as String
     * @throws FlascheException
     */
    public Weisswein(float alkoholgehalt, String weingut) throws FlascheException {
        super(alkoholgehalt, weingut);
    }

    /**
     * Constructor
     * @param name as String
     * @param alkoholgehalt as float
     * @param weingut as String
     * @throws FlascheException
     */
    public Weisswein(String name, float alkoholgehalt, String weingut) throws FlascheException{
        super(name, alkoholgehalt, weingut);
    }

    /**
     * To String
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + ", Weisswein";
    }

    /**
     * Equals
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
        if (obj instanceof Weisswein) {
            return true;
        }
        return false;
    }

    /**
     * Hash Code
     * @return int
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
