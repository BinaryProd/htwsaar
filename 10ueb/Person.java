public class Person {

    private String name;
    private String vorname;

    /**
     * Creates a new Person object with the given first and last name.
     * The names are trimmed and cannot be empty.
     *
     * @param vorname the person's first name
     * @param name the person's last name
     * @throws IllegalArgumentException if the name is empty
     */
    public Person(String vorname, String name){
        CheckUtils.checkIfEmpty(name);
        CheckUtils.checkIfEmpty(vorname);
        this.name = name.trim();
        this.vorname = vorname.trim();
    }

    /**
     * Returns the person's last name.
     *
     * @return the person's last name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the person's first name.
     *
     * @return the person's first name
     */
    public String getVorname(){
        return vorname;
    }

    /**
     * Sets the person's last name.
     * The name is trimmed and cannot be empty.
     *
     * @param name the person's last name
     * @throws IllegalArgumentException if the name is empty
     */
    public void setName(String name){
        CheckUtils.checkIfEmpty(name);
        this.name = name.trim();
    }

    /**
     * Sets the person's first name.
     * The name is trimmed and cannot be empty.
     *
     * @param vorname the person's first name
     * @throws IllegalArgumentException if the name is empty
     */
    public void setVorname(String vorname){
        CheckUtils.checkIfEmpty(vorname);
        this.vorname = vorname.trim();
    }

    /**
     * Returns a string representation of the person's name in the format "first last".
     *
     * @return the person's name as a string
     */
    @Override
    public String toString(){
        return vorname + " " + name;
    }

    /**
     * Compares this Person object to another object.
     * Returns true if the other object is also a Person and has the same first and last name as this object.
     *
     * @param o the object to compare to this Person
     * @return true if the other object is equal to this Person, false otherwise
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Person){
            Person p = (Person) o;
            return name.equals(p.name) && vorname.equals(p.vorname);
        }
        return false;
    }
}
