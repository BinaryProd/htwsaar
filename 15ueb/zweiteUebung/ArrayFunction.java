/**
 * <h1> ArrayFunction </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class ArrayFunction {

    private Object[] array;    
    private int size;    

    /**
     * Constructor for ArrayFunction
     * @param capacity the capacity of the array
     */
    public ArrayFunction(int capacity) {    
        array = new Object[capacity];    
        size = 0;    
    }    

    /**
     * Adds a value to the beginning of the array
     * @param value the value to be added
     */
    public void addFirst(Object value) {    
        if (size == array.length) {    
            System.err.println("Error: Array is full.");    
            return;    
        }    
        for (int i = size - 1; i >= 0; i--) {    
            array[i + 1] = array[i];    
        }    
        array[0] = value;    
        size++;    
    }    

    /**
     * Removes the first element of the array
     */
    public void removeFirst() {    
        if (size == 0) {    
            System.err.println("Error: Array is empty.");    
            return;    
        }    
        for (int i = 1; i < size; i++) {    
            array[i - 1] = array[i];    
        }    
        array[size - 1] = null;    
        size--;    
    }    

    /**
     * Adds a value to the end of the array
     * @param value the value to be added
     */
    public void addEnd(Object value) {    
        if (size == array.length) {    
            System.err.println("Error: Array is full.");    
            return;    
        }    
        array[size] = value;    
        size++;    
    }    

    /**
     * Removes the last element of the array
     */
    public void removeEnd() {    
        if (size == 0) {    
            System.err.println("Error: Array is empty.");    
            return;    
        }    
        array[size - 1] = null;    
        size--;    
    }    

    /**
     * Adds a value to the array at the specified index
     * @param index the index to add the value
     * @param value the value to be added
     */
    public void addAtIndex(int index, Object value) {    
        if (size == array.length) {    
            System.err.println("Error: Array is full.");    
            return;    
        }    
        if (index < 0 || index > size) {    
            System.err.println("Error: Invalid index.");    
            return;    
        }    
        for (int i = size - 1; i >= index; i--) {    
            array[i + 1] = array[i];    
        }    
        array[index] = value;    
        size++;    
    }    

    /**
     * Removes the value at the specified index
     * @param index the index to remove the value
     */
    public void removeAtIndex(int index) {    
        if (size == 0) {    
            System.err.println("Error: Array is empty.");    
            return;
        }                                                                                                                                                                                                                                                   
        if (index < 0 || index >= size) {
            System.err.println("Error: Invalid index.");
            return;
        }         
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    /**
     * Gets the size of the array
     * @return the size of the array
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the value at the specified index
     * @param index the index to get the value
     * @return the value at the specified index
     */
    public float get(int index) {
        if (index < 0 || index >= size) {
            System.err.println("Error: Invalid index.");
            return -1;  // or any other default value
        }
        return (float)array[index];
    }
    
    /**
     * Gets the value at the specified index
     * @param index the index to get the value
     * @return the value at the specified index
     */
    public int getValue(int index) {
        if (index < 0 || index >= size) {
            System.err.println("Error: Invalid index.");
            return -1;  // or any other default value
        }
        return (int)array[index];
    } 

    public Object[] getArray() {                                                                                                                                                                                                         
        Object[] copyArray = new Object[size];
        System.arraycopy(array, 0, copyArray, 0, size);
        return copyArray;
    }
}  
