/**
 * <h1> Wasser </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Objects;

public class Wasser extends AlkoholfreiesGetraenk {
    private String quelle;

    /**
     * Default constructor
     */
    public Wasser() {
        super();
        this.quelle = "Quelle";
    }

    /**
     * constructor
     * @param quelle as String
     * @throws FlascheException
     */
    public Wasser(String hersteller, String quelle) throws FlascheException{
        super(hersteller);
        FlascheException.checkString(quelle);
        this.quelle = quelle;
    }

    /**
     * constructor
     * @param name as String
     * @param quelle as String
     * @throws FlascheException
     */
    public Wasser(String name, String hersteller, String quelle) throws FlascheException {
        super(name, hersteller);
        FlascheException.checkString(quelle);
        this.quelle = quelle;
    }

    /**
     * getter quelle
     * @return quelle as String
     */
    public String getQuelle() {
        return quelle;
    }

    /**
     * setter quelle
     * @param quelle as String
     * @throws FlascheException
     */
    public void setQuelle(String quelle) throws FlascheException {
        FlascheException.checkString(quelle);
        this.quelle = quelle;
    }

    /**
     * To String
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + ", Quelle: " + quelle + ", Wasser";
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
        if (obj instanceof Wasser) {
            Wasser wasser = (Wasser) obj;
            return Objects.equals(this.quelle, wasser.quelle);
        }
        return false;
    }

    /**
     * hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.quelle);
    }
}
