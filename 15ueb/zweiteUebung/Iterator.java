/**
 * <h1> Iterator </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class Iterator {
    private int currentIndex;
    private int arrayLength;

    /**
     * Constructor for Iterator
     * @param arrayLength the length of the array
     */
    public Iterator(int arrayLength) {
        this.arrayLength = arrayLength;
        currentIndex = 0;
    }
    
    /**
     * Checks if there is a next element in the array
     * @return true if there is a next element, false otherwise
     */
    public boolean hasNext() {
        return currentIndex < arrayLength;
    }

    /**
     * Updates the index to the next element in the array
     */
    public void updateIndex() {
        this.currentIndex++;
    }

    /**
     * Gets the current index
     * @return the current index
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    /**
     * Gets the length of the array
     * @return the length of the array
     */
    public int getArrayLength() {
        return arrayLength;
    }

    /**
     * Sets the current index to the new value
     * @param new_value the new value of the current index
     */
    public void setCurrentIndex(int new_value) {
        this.currentIndex = new_value;
    }

    /**
     * Sets the length of the array to the new value
     * @param new_value the new value of the length of the array
     */
    public void setArrayLength(int new_value) {
        this.arrayLength = new_value;
    }
}
