/**
 * <h1> Mitarbeiter </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */

import java.util.Objects;

public class Mitarbeiter extends Person {

    private String email;

    /**
     * Creates a new Mitarbeiter object with the given first and last name and email.
     * The names are trimmed and cannot be empty.
     *
     * @param vorname the person's first name
     * @param nachname the person's last name
     * @param email the person's email 
     * @throws MitarbeiterException if the vorname or nachname or email is empty
     */
    public Mitarbeiter(String vorname, String nachname, String email) throws MitarbeiterException {
        super(vorname, nachname);
        
        MitarbeiterException.checkEMail(email);
        MitarbeiterException.checkIfValidMail(email);
        this.email = email.strip();
    }

    /** 
     * Add a new Reservierung for the current Mitarbeiter
     *
     * @param Raum
     * @param Uhrzeit beginn
     * @param Uhrzeit ende
     * @param String bemmerkung
     */
    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung) {
        Reservierung reservierung = new Reservierung(beginn, ende);

        raum.istNichtBesetzt(beginn, ende);
        reservierung.setRaum(raum);
        reservierung.setBemerkung(bemerkung);
        reservierung.setMitarbeiter(this);
    }

    /**
     * return the email 
     *
     * @return email 
     */
    public String getEmail(){
        return email;
    }

    /**
     * Returns a string representation of this Mitarbeiter.
     *
     * @return a string in the format "{Person} ({email})"
     */
    @Override
    public String toString() {
        return String.format("%s (%s)", super.toString(), email);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !(object instanceof Mitarbeiter)) return false;
        if (!super.equals(object)) return false;
        Mitarbeiter that = (Mitarbeiter) object;
        return Objects.equals(email, that.email);
    }
}
