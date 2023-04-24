import javax.annotation.processing.SupportedOptions;

public class PrimaryQueue implements Queue {
    private Object[] queue;
    private int size;
    private int capacity;

    private static final int DEFAULT_SIZE = 10;

    /**
     * Creates a new PrimaryQueue with the given capacity.
     *
     * @param capacity the maximum number of objects that can be stored in the queue
     */
    public PrimaryQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        size = 0;
    }

    /**
     * Creates a new PrimaryQueue with the default capacity.
     */
    public PrimaryQueue() {
        this(DEFAULT_SIZE);
    }

    /**
     * Adds an object to the end of the queue.
     *
     * @param o the object to add to the queue
     * @throws IllegalArgumentException if the object passed is null
     * @throws IllegalStateException if the queue is full
     */
    public void addLast(Object o) {
        CheckUtils.checkObjectNull(o);
        CheckUtils.checkQueueFull(size, capacity);
        queue[size] = o;
        size++;
        sort();
    }

    /**
     * Adds an object to the front of the queue.
     *
     * @param o the object to add to the queue
     * @throws IllegalArgumentException if the object passed is null
     * @throws IllegalStateException if the queue is full
     */
    public void addFirst(Object o) {
        CheckUtils.checkObjectNull(o);
        CheckUtils.checkQueueFull(size, capacity);
        for (int i = size; i > 0; i--) {
            queue[i] = queue[i-1];
        }
        queue[0] = o;
        size++;
        sort();
    }

    /**
     * Adds an object to the queue at the specified index.
     *
     * @param o the object to add to the queue
     * @param i the index at which to add the object
     * @throws IllegalArgumentException if the object passed is null
     * @throws IllegalArgumentException if the index is out of range
     * @throws IllegalStateException if the queue is full
     */
    public void addAtIndex(Object o, int i) {
        CheckUtils.checkObjectNull(o);
        CheckUtils.checkQueueFull(size, capacity);
        CheckUtils.checkIndex(i, capacity);
        if (i >= size) {
            queue[size] = o;
            System.out.println("Added " + o + " at index " + size);
        } else {
            for (int j = size; j > i; j--) {
                queue[j] = queue[j-1];
            }
            queue[i] = o;
            System.out.println("Added " + o + " at index " + i);
        }
        size++;
        sort();
    }

    /**
     * Removes and returns the object at the front of the queue.
     *
     * @return the object at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public Object removeFirst() {
        CheckUtils.checkQueueEmpty(size);
        Object removedObject = queue[0];
        for (int i = 0; i < size-1; i++) {
            queue[i] = queue[i+1];
        }
        size--;
        sort();
        return removedObject;
    }

    /**
     * Removes and returns the object at the back of the queue.
     *
     * @return the object at the back of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public Object removeLast() {
        CheckUtils.checkQueueEmpty(size);
        Object removedObject = queue[size-1];
        queue[size-1] = null;
        size--;
        sort();
        return removedObject;
    }

    /**
     * Removes and returns the object at the specified index.
     *
     * @param i the index at which to remove the object
     * @return the object at the specified index
     * @throws IllegalArgumentException if the index is out of range
     * @throws IllegalStateException if the queue is empty
     */
    public Object removeAtIndex(int i) {
        CheckUtils.checkQueueEmpty(size);
        CheckUtils.checkIndex(i, capacity);
        Object removedObject = queue[i];
        for (int j = i; j < size-1; j++) {
            queue[j] = queue[j+1];
        }
        size--;
        sort();
        return removedObject;
    }

    /**
     * Returns the object at the specified index.
     *
     * @param i the index of the object to retrieve
     * @return the object at the specified index
     * @throws IllegalArgumentException if the index is out of range
     * @throws IllegalStateException if the queue is empty
     */
    public Object get(int i) {
        CheckUtils.checkQueueEmpty(size);
        CheckUtils.checkIndex(i, capacity);
        return queue[i];
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * Returns true if the queue is full, false otherwise.
     *
     * @return true if the queue is full, false otherwise
     */
    public boolean full() {
        return size == capacity;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Returns the maximum capacity of the queue.
     *
     * @return the maximum capacity of the queue
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Clears the queue by setting its size to 0 and creating a new array of the original capacity.
     *
     * @throws IllegalStateException if the queue is already empty
     */
    public void clear() {
        CheckUtils.checkQueueEmpty(size);
        queue = new Object[capacity];
        size = 0;
    }

    /**
     * Prints the contents of the queue to the console.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null) {
                sb.append("\n" + queue[i]);
            }
        }
        return sb.toString();
    }

    public void sort() {
        for (int i = 0; i < capacity; i++) {
            if (queue[i] == null) {
                for (int j = i; j < capacity; j++) {
                    if (queue[j] != null) {
                        queue[i] = queue[j];
                        queue[j] = null;
                        break;
                    }
                }
            }
        }
    }

}
