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

    public static Object[] _resizeArray(Object[] array) {
        Object[] newArray = Arrays.copyOf(array, array.length + 1);
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

    public static void _indexIsValid(Object[] array, int index) throws IllegalArgumentException {
        if ( array[index] == null ) {
            throw new IllegalArgumentException("Index ist nicht valide");
        } 
    }
}
