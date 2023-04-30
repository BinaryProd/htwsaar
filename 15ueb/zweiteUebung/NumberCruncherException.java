/**
 * <h1> NumberCruncherException </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */

class NumberCruncherException extends RuntimeException    
{    
    public NumberCruncherException(){    
        super();
    }    

    public NumberCruncherException(String message){
        super(message);
    }

    /**    
     *
     *     
     * @param
     * @throws NumberCruncherException    
     *     
     */
    public static void checkFloat(float number) throws NumberCruncherException {
        if (Float.isNaN(number)) {
            throw new NumberCruncherException("Number is NaN");
        } else if (Float.isInfinite(number)) {
            throw new NumberCruncherException("Number is infinite");
        } else if (number == 0.0f) {
            // zero is neither negative nor positive
            throw new NumberCruncherException("Number is zero");
        } else if (Math.abs(number) > Float.MAX_VALUE) {
            // value is too big
            if (number > 0) {
                throw new NumberCruncherException("Number is positive too big: " + number);
            } else {
                throw new NumberCruncherException("Number is negative too big: " + number);
            }
        } else if (Math.abs(number) < Float.MIN_NORMAL) {
            // value is too small
            if (number > 0) {
                throw new NumberCruncherException("Number is positive too small: " + number);
            } else {
                throw new NumberCruncherException("Number is negative too small: " + number);
            }
        }
    }

    public static void checkforPositiveNonZero(int index) throws NumberCruncherException {
        if (index <= 0) {
            throw new NumberCruncherException("Index is not positive: " + index);
        }
    }
}
