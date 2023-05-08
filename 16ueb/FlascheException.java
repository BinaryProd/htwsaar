/**
 * <h1> FlascheException </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class FlascheException extends RuntimeException {

    public FlascheException() {
        super();
    }

    public FlascheException(String message) {
        super(message);
    }

    /**
     * Checks if the given string is null or empty and throws an exception if it is.
     * @param s the string to check
     * @throws FlascheException if the string is null or empty
     */
    public static void checkString(String s) throws FlascheException{
        if (s == null || s.isEmpty()) {
            throw new FlascheException("String is empty");
        }
    }

    /**
     * Checks if the given float is negative and throws an exception if it is.
     * @param f the float to check
     * @throws FlascheException if the float is negative
     */
    public static void checkFloat(float number) throws FlascheException {
        if (number < 0) {
            throw new FlascheException("Number is negative: " + number);
        } else if (Float.isNaN(number)) {
            throw new FlascheException("Number is NaN");
        } else if (Float.isInfinite(number)) {
            throw new FlascheException("Number is infinite");
        } else if (Math.abs(number) > Float.MAX_VALUE) {
            // value is too big
            if (number > 0) {
                throw new FlascheException("Number is positive too big: " + number);
            } else {
                throw new FlascheException("Number is negative too big: " + number);
            }
        } else if (Math.abs(number) < Float.MIN_NORMAL) {
            // value is too small
            if (number > 0) {
                throw new FlascheException("Number is positive too small: " + number);
            } else {
                throw new FlascheException("Number is negative too small: " + number);
            }
        }
    }
}
