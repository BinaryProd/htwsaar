/**
 * <h1> Uhrzeit </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */

import java.util.Objects;

public class Uhrzeit implements Comparable<Uhrzeit> {
    
    private int stunde, minute;

    private static final String BEGIN_STUNDE_ERROR = "Die beginn Stunde soll kleiner als die end Stunde sein";
    private static final String BEGIN_MINUTE_ERROR = "Die beginn Minute soll kleiner als die end Minute sein";

    /**
     * Creates a new Uhrzeit object with the given stunde and minute.
     *
     * @param stunde the hours as an int
     * @param minute the minutes as an int
     * @throws UhrzeitException if the stunde or minute negative is
     */
    public Uhrzeit(int stunde, int minute) throws UhrzeitException {
        UhrzeitException.checkIfValidHour(stunde);
        UhrzeitException.checkIfValidMinute(minute);
        this.stunde = stunde;
        this.minute = minute;
    }

    /**
     * Return the Stunde of the Uhrzeit
     * @return stunde
     */
    public int getStunde() {
        return stunde;
    }

    /**
     * Return the Minute of the Uhrzeit
     * @return minute
     */
    public int getMinute() {
        return minute;
    }

    /** 
     * This function check if the Uhrzeit given is befor the current one 
     *
     * @param Uhrzeit
     * @throws UhrzeitException if the current Uhrzeit is befor the param
    */
    public void istNachBegin(Uhrzeit beginn) throws UhrzeitException {
        if ( beginn.getStunde() > this.stunde ) {
            throw new UhrzeitException(BEGIN_STUNDE_ERROR);
        } else if ( beginn.getStunde() == this.stunde && beginn.getMinute() > this.minute ) {
            throw new UhrzeitException(BEGIN_MINUTE_ERROR);
        } 
    }

    /**
     * Compares this Uhrzeit with another Uhrzeit .
     *
     * @param andere the Uhrzeit to be compared
     * @return a negative integer, zero, or a positive integer as this Uhrzeit is
     * less than, equal to, or greater than the specified Uhrzeit .
     */
    @Override
    public int compareTo(Uhrzeit andere) {
        int uhrzeitCompare = Integer.compare(this.stunde, andere.stunde);
        if (uhrzeitCompare != 0) {
            return uhrzeitCompare;
        }
        return Integer.compare(this.minute, andere.minute);
    }


    /**
     * Returns a string representation of this Uhrzeit.
     *
     * @return a string in the format "{stunde}:{minute} Uhr"
     */
    @Override
    public String toString() {
        return String.format("%d:%d Uhr", stunde, minute);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || !(object instanceof Uhrzeit)) {
            return false;
        }
        Uhrzeit that = (Uhrzeit) object;
        return stunde == that.stunde && 
            minute == that.minute;
    }
}
