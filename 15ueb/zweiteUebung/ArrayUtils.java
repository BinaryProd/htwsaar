/**
 * <h1> ArrayUtils </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Arrays;

public class ArrayUtils {
    /**
     * Resizes an array to a an array with array length + 1 size.
     * 
     * @param array the original array to be resized
     * @return the resized array
     */
    public static <T> T[] resizeArray(T[] array) {
        T[] newArray = Arrays.copyOf(array, array.length + 1);
        return newArray;
    }

    /**
     * Check if at the index a valid object
     * 
     * @param T[] array the original array 
     * @param int index 
     * @throws ArrayUtilsException if the value is null 
     */
    public static <T> void indexIsValid(T[] array, int index) throws ArrayUtilsException {
        if ( array[index] == null ) {
            throw new ArrayUtilsException("Index ist nicht valide");
        } 
    }

    /**
     * Outputs the array as a string
     *
     * @param array the array to be outputted
     * @return the string representation of the array
     */
    public static String toString(float[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

}
