/**
 * <h1> AlkoholischesGetraenk </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Objects;

public abstract class AlkoholischesGetraenk extends Getraenk {
    private float alkoholgehalt;

    /**
     * Default constructor
     */
    public AlkoholischesGetraenk() {
        super();
        this.alkoholgehalt = 0.0f;
    }

    /**
     * constructor
     * @param alkoholgehalt as float
     * @throws FlascheException
     */
    public AlkoholischesGetraenk(float alkoholgehalt) throws FlascheException {
        super();
        FlascheException.checkFloat(alkoholgehalt);
        this.alkoholgehalt = alkoholgehalt;
    }

    /**
     * constructor
     * @param name as String
     * @param alkoholgehalt as float
     * @throws FlascheException
     */
    public AlkoholischesGetraenk(String name, float alkoholgehalt) {
        super(name);
        FlascheException.checkFloat(alkoholgehalt);
        this.alkoholgehalt = alkoholgehalt;
    }

    /**
     * getter alkoholgehalt
     * @return alkoholgehalt as float
     */
    public float getAlkoholgehalt() {
        return alkoholgehalt;
    }

    /**
     * setter alkoholgehalt
     * @param alkoholgehalt as float
     * @throws FlascheException
     */
    public void setAlkoholgehalt(float alkoholgehalt) {
        FlascheException.checkFloat(alkoholgehalt);
        this.alkoholgehalt = alkoholgehalt;
    }

    /**
     * To String
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + ", Alkoholgehalt: " + alkoholgehalt;
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
        if (obj instanceof AlkoholischesGetraenk) {
            AlkoholischesGetraenk other = (AlkoholischesGetraenk) obj;
            return Objects.equals(this.alkoholgehalt, other.alkoholgehalt);
        }
        return false;
    }

    /**
     * hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), alkoholgehalt);
    }
}
