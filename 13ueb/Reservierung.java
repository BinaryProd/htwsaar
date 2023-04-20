/**
 * <h1> Reservierung </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */

import java.util.Objects;

public class Reservierung {

    private String bemerkung;
    private Uhrzeit beginn, ende;
    private Mitarbeiter mitarbeiter;

    /**
     * Creates a new Reservierung object with the given beginn and ende.
     *
     * @param beginn the beginn of the Reservierung as a Uhrzeit
     * @param ende the ende of the Reservierung as a Uhrzeit 
     * @throws UhrzeiException if ende is before beginn
     */
    public Reservierung(Uhrzeit beginn, Uhrzeit ende) {
        ende.istNachBegin(beginn);

        this.beginn = beginn;
        this.ende = ende;
    }

    /**
     * This method is use to set the value of bemerkung 
     *
     * @param bemerkung the new value of the attribute bemerkung 
     * @throws ReservierungException if the string is empty
     */
    public void setBemerkung(String bemerkung) throws ReservierungException {
        ReservierungException.checkBemerkung(bemerkung);
        this.bemerkung = bemerkung.strip();
    }

    /** 
     * Set the Mitarbeiter
     *
     * @param Mitarbeiter
     */
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    /** 
     * Set the Raum 
     *
     * @param Raum 
     */
    public void setRaum(Raum raum) {
        raum.addReservierung(this);
    }


    /** 
     * Get the the beginn Uhrzeit
     *
     * @return Uhrzeit;
     */
    public Uhrzeit getBeginn() {
        return beginn;
    }

    /** 
     * Get the the ende Uhrzeit
     *
     * @return Uhrzeit;
     */
    public Uhrzeit getEnde() {
        return ende;
    }

    /**
     * Returns a string representation of this Reservierung.
     *
     * @return a string in the format "gebucht von {mitarbeiter} von {beginn} bis {ende} fuer {bemerkung}"
     */
    @Override
    public String toString() {    
        return String.format("gebucht von %s von %s bis %s fuer %s", mitarbeiter, beginn, ende, bemerkung);    
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !(object instanceof Reservierung)) return false;
        if (!super.equals(object)) return false;
        Reservierung that = (Reservierung) object;
        return Objects.equals(bemerkung, that.bemerkung) && Objects.equals(beginn, that.beginn) && Objects.equals(ende, that.ende) && Objects.equals(mitarbeiter, that.mitarbeiter);
    }
}
