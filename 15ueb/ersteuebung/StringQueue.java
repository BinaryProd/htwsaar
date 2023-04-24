public class StringQueue extends PrimaryQueue {

    /**
     * Creates a new StringQueue with the given capacity.
     *
     * @param capacity the maximum number of String objects that can be stored in the queue
     */
    public StringQueue(int capacity) {
        super(capacity);
    }

    /**
     * Creates a new StringQueue with the default capacity.
     */
    public StringQueue() {
        super();
    }

    /**
     * Adds a String object to the end of the queue.
     *
     * @param str the String object to add to the queue
     * @throws IllegalArgumentException if the object passed is not a String
     * @throws IllegalArgumentException if the object passed is null
     */
    public void addLast(String str) {
        CheckUtils.checkObjectNull(str);
        super.addLast(str);
    }

    /**
     * Adds a String object to the front of the queue.
     *
     * @param str the String object to add to the queue
     * @throws IllegalArgumentException if the object passed is not a String
     * @throws IllegalArgumentException if the object passed is null
     */
    public void addFirst(String str) {
        CheckUtils.checkObjectNull(str);
        super.addFirst(str);
    }

    /**
     * Adds a String object to the queue at the specified index.
     *
     * @param str the String object to add to the queue
     * @param i the index at which to add the String object
     * @throws IllegalArgumentException if the object passed is not a String
     * @throws IllegalArgumentException if the object passed is null
     * @throws IllegalArgumentException if the index is out of range
     */
    public void addAtIndex(String str, int i) {
        CheckUtils.checkObjectNull(str);
        CheckUtils.checkIndex(i, size());
        super.addAtIndex(str, i);
    }

    /**
     * Removes and returns the String object at the front of the queue.
     *
     * @return the String object at the front of the queue
     */
    public String removeFirst() {
        return (String) super.removeFirst();
    }

    /**
     * Removes and returns the String object at the back of the queue.
     *
     * @return the String object at the back of the queue
     */
    public String removeLast() {
        return (String) super.removeLast();
    }

        /**
     * Removes and returns the String object at the specified index.
     *
     * @param i the index at which to remove the String object
     * @return the String object at the specified index
     * @throws IllegalArgumentException if the index is out of range
     */
    public String removeAtIndex(int i) {
        CheckUtils.checkIndex(i, size());
        return (String) super.removeAtIndex(i);
    }

    /**
     * Returns the String object at the specified index.
     *
     * @param i the index of the String object to retrieve
     * @return the String object at the specified index
     */
    public String get(int i) {
        return (String) super.get(i);
    }

    /**
     * Prints the contents of the StringQueue to the console.
     *
     * @param q the StringQueue to print
     */
    @Override
    public void print() {
        super.print();
    }
}

