/**
 * <h1> Person </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */

import java.util.Objects;

public class Person {

    private String vorname, nachname;

    /**
     * Creates a new Person object with the given first and last name.
     * The names are trimmed and cannot be empty.
     *
     * @param vorname the person's first name
     * @param nachname the person's last name
     * @throws PersonException if the vorname or nachname is empty
     */
    public Person(String vorname, String nachname) throws PersonException {
        PersonException.checkName(vorname);
        PersonException.checkName(nachname);

        this.vorname = vorname.strip();
        this.nachname = nachname.strip();
    }

    /**    
     * Returns the person's last name.    
     *    
     * @return the person's last name    
     */    
    public String getVorname() {
        return vorname;
    }

    /**    
     * Returns the person's last name.    
     *    
     * @return the person's last name    
     */    
    public String getNachname() {
        return nachname;
    }

    /**
     * Returns a string representation of the person's name in the format "first last".
     *
     * @return the person's name as a string
     */
    @Override
    public String toString() {
        return String.format("%s %s", vorname, nachname);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !(object instanceof Person)) return false;
        Person that = (Person) object;
        return Objects.equals(vorname, that.vorname) && Objects.equals(nachname, that.nachname);
    }
}
