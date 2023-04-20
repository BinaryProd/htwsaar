/**
 * <h1> Raum </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */

import java.util.Objects;

public class Raum {

    private int gebaeude, etage, raum;
    private Reservierung[] reservierungen;
    private int reservierungLength = 0;

    private static final int ARRAY_GROESSE = 10;

    private static final String FEHLER_BEGIN_BESETZT = "Der Beginn faengt waerend eine Reservierung."; 
    private static final String FEHLER_ENDE_BESETZT = "Das Ende endet waerend eine Reservierung.";

    /**
     * Creates a new Raum object with the given geb and etage and raum.
     *
     * @param gebaeude int 
     * @param etage int 
     * @param raum int 
     */
    public Raum( int gebaeude, int etage, int raum) throws RaumException {
        RaumException.checkIfPositive(gebaeude);
        RaumException.checkIfPositive(etage);
        RaumException.checkIfPositive(raum);

        this.gebaeude = gebaeude;
        this.etage = etage;
        this.raum = raum;

        reservierungen = new Reservierung[ARRAY_GROESSE];
    }

    /**
    * Returns the reservation object at the specified index.
    * @param index the index of the reservation object to retrieve
    * @return the reservation object at the specified index
    */
    public Reservierung getReservierung(int index) throws RaumException {
        RaumException.checkIndex(index, reservierungen);
        return reservierungen[index];
    }

    public int getAnzahlReservierungen() {
        return reservierungLength;
    }

    /**
     * Add a Reservierung for the current Raum
     *
     * @param Reservierung
     */
     public void addReservierung(Reservierung reservierung) {
        if (reservierungLength == reservierungen.length) {
            //reservierungen = (Reservierung[])ArrayUtils._resizeArray(reservierungen);
            reservierungen = ArrayUtils.resizeArray(reservierungen);
        }
        reservierungen[reservierungLength] = reservierung;
        reservierungLength++;
    }

    /**
     * Checks if a beginn to ende is not occupied by any reservations.
     *
     * @param beginn the starting time 
     * @param ende the ending time 
     * @throws IllegalArgumentException if the begin or ende is occupied 
     */
    public void istNichtBesetzt(Uhrzeit beginn, Uhrzeit ende) {
        for (Reservierung reservierung : reservierungen) {
            if (reservierung != null) {
                Uhrzeit reservierungBeginn = reservierung.getBeginn();
                Uhrzeit reservierungEnde = reservierung.getEnde();

                if (reservierungBeginn.compareTo(beginn) <= 0
                        && reservierungEnde.compareTo(beginn) >= 0) {
                    throw new RaumException(FEHLER_BEGIN_BESETZT);
                } else if (reservierungBeginn.compareTo(ende) <= 0
                        && reservierungEnde.compareTo(ende) >= 0) {
                    throw new RaumException(FEHLER_ENDE_BESETZT);
                        }
            }
        }
    }


    /**
     * Returns a string representation of the Raum.
     *
     * @return a string in the format "Raum {geb}-{etage}.{rau}"
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Raum %s-%s.%s%n", gebaeude, etage, raum));
        for (Reservierung reservierung : reservierungen) {
            if (reservierung != null) {
                output.append(String.format("%s%n", reservierung));
            }
        }
        return output.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !(object instanceof Raum)) return false;
        Raum that = (Raum) object;
        return gebaeude == that.gebaeude &&
                etage == that.etage &&
                raum == that.raum;
    }
}
