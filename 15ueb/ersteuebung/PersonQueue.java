public class PersonQueue extends PrimaryQueue {

    /**
     * Creates a new PersonQueue with the given capacity.
     *
     * @param capacity the maximum number of Person objects that can be stored in the queue
     */
    public PersonQueue(int capacity) {
        super(capacity);
    }

    /**
     * Creates a new PersonQueue with the default capacity.
     */
    public PersonQueue() {
        super();
    }

    /**
     * Adds a Person object to the end of the queue.
     *
     * @param person the Person object to add to the queue
     * @throws IllegalArgumentException if the object passed is not an instance of Person
     */
    @Override
    public void addLast(Object person) {
        CheckUtils.checkObjectNull(person);
        CheckUtils.checkIfPerson(person);
        super.addLast(person);
    }

    /**
     * Adds a Person object to the front of the queue.
     *
     * @param person the Person object to add to the queue
     * @throws IllegalArgumentException if the object passed is not an instance of Person
     */
    @Override
    public void addFirst(Object person) {
        CheckUtils.checkObjectNull(person);
        CheckUtils.checkIfPerson(person);
        super.addFirst(person);
    }

    /**
     * Adds a Person object to the queue at the specified index.
     *
     * @param person the Person object to add to the queue
     * @param index the index at which to add the Person object
     * @throws IllegalArgumentException if the object passed is not an instance of Person
     * @throws IllegalArgumentException if the index is out of range
     */
    @Override
    public void addAtIndex(Object person, int index) {
        CheckUtils.checkObjectNull(person);
        CheckUtils.checkIfPerson(person);
        CheckUtils.checkIndex(index, size());
        super.addAtIndex(person, index);
    }

    /**
     * Removes and returns the Person object at the front of the queue.
     *
     * @return the Person object at the front of the queue
     */
    @Override
    public Person removeFirst() {
        return (Person)super.removeFirst();
    }

    /**
     * Removes and returns the Person object at the back of the queue.
     *
     * @return the Person object at the back of the queue
     */
    @Override
    public Person removeLast() {
        return (Person)super.removeLast();
    }

    /**
     * Removes and returns the Person object at the specified index.
     *
     * @param i the index at which to remove the Person object
     * @return the Person object at the specified index
     * @throws IllegalArgumentException if the index is out of range
     */
    @Override
    public Person removeAtIndex(int i) {
        CheckUtils.checkIndex(i, size());
        return (Person)super.removeAtIndex(i);
    }

    /**
     * Returns the Person object at the specified index.
     *
     * @param i the index of the Person object to retrieve
     * @return the Person object at the specified index
     * @throws IllegalArgumentException if the index is out of range
     */
    @Override
    public Person get(int i) {
        CheckUtils.checkIndex(i, size());
        return (Person)super.get(i);
    }

    /**
     * Prints the contents of the PersonQueue to the console.
     *
     * @param q the PersonQueue to toString
     */
    @Override
    public String toString() {
        return super.toString();
    }

    private class Iterator implements PersonIterator {
        private int currentIndex;

        public Iterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        @Override
        public Person next() {
            return get(currentIndex++);
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        Iterator iter = new PersonQueue.Iterator(); 

        sb.append(iter.next() + "\n");
        while ( iter.hasNext()) {
            sb.append(iter.next() + "\n");
        }  
        System.out.println(sb.toString());
    }

    public String smallest() {
        Iterator iter = new PersonQueue.Iterator(); 
        String min = iter.next().getVorname();

        while ( iter.hasNext()) {
            String next = iter.next().getVorname();
            if (next.compareTo(min) < 0) {
                min = next;
            }
        }  
        return min;
    } 

}
