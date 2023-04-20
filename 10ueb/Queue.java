public interface Queue {
    public void addLast(Object o);
    public Object removeFirst();
    public Object get(int i);
    public boolean empty();
    public boolean full();
    public int size();
    public void addFirst(Object o);
    public void addAtIndex(Object o, int i);
    public Object removeLast();
    public Object removeAtIndex(int i);
    public int capacity();
    public void clear();
    public void print();
}
