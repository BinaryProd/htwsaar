/**
 * <h1> Bier </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Objects;

public class Bier extends AlkoholischesGetraenk {
    private String brauerei;

    /**
     * Default constructor
     */
    public Bier() {
        super();
        this.brauerei = "Brauerei";
    }

    /**
     * Constructor
     * @param alkoholgehalt as float
     * @param brauerei as String
     * @throws FlascheException if string is empty
     */
    public Bier(float alkoholgehalt, String brauerei) throws FlascheException {
        super(alkoholgehalt);
        FlascheException.checkString(brauerei);
        this.brauerei = brauerei;
    }

    /**
     * Constructor
     * @param name as String
     * @param alkoholgehalt as float
     * @param brauerei as String
     * @throws FlascheException if string is empty
     */
    public Bier(String name, float alkoholgehalt, String brauerei) throws FlascheException {
        super(name, alkoholgehalt);
        FlascheException.checkString(brauerei);
        this.brauerei = brauerei;
    }

    /**
     * get the brauerei 
     * @return brauerei
     */
    public String getBrauerei() {
        return brauerei;
    }

    /**
     * set the brauerei
     * @param brauerei as String
     * @throws FlascheException if string is empty
     */
    public void setBrauerei(String brauerei) throws FlascheException{
        FlascheException.checkString(brauerei);
        this.brauerei = brauerei;
    }

    /**
     * ToString method
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + ", Brauerei: " + brauerei;
    }

    /**
     * Equals method
     * @param obj
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
        if(obj instanceof Bier) {
            Bier bier = (Bier) obj;
            return Objects.equals(this.brauerei, bier.brauerei);
        }
        return false;
    }

    /**
     * Hashcode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brauerei);
    }
}
