import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

public class DoppeltVerketteteListe<E> implements List<E> {

    private class Node {
        private E value;
        private Node next;
        private Node prev;

        public Node(E value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoppeltVerketteteListe() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        CheckUtils.checkIfObjectIsNull(o);
        if (head == null) {
            return false;
        }
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public <T> T[] toArray(T[] a) {
        CheckUtils.checkIfListIsEmpty(a.length);
        CheckUtils.checkIfListIsEmpty(size);
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        Node current = head;
        for (int i = 0; i < size; i++) {
            a[i] = (T) current.value;
            current = current.next;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    public boolean add(E e) {
        CheckUtils.checkIfObjectIsNull(e);
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean remove(Object o) {
        CheckUtils.checkIfListIsEmpty(size);
        CheckUtils.checkIfObjectIsNull(o);
        Node current = head;
        for(int i = 0; i < size; i++) {
            if (current.value.equals(o)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (E e : c) {
            add(e);
        }
        return true;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public E get(int index) {
        CheckUtils.checkIfListIsEmpty(size);
        CheckUtils.checkIfIndexIsInRange(index, size);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public E set(int index, E element) {
        CheckUtils.checkIfIndexIsInRange(index, size);
        CheckUtils.checkIfObjectIsNull(element);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldValue = current.value;
        current.value = element;
        return oldValue;
    }

    public void add(int index, E element) {
        CheckUtils.checkIfIndexIsInRange(index, size);
        CheckUtils.checkIfObjectIsNull(element);
        if (index == size) {
            add(element);
        } else {
            Node newNode = new Node(element);
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (current == head) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else {
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
            size++;
        }
    }

    public E remove(int index) {
        CheckUtils.checkIfListIsEmpty(size);
        CheckUtils.checkIfIndexIsInRange(index, size);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (current == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return current.value;
    }

    public int indexOf(Object o) {
        CheckUtils.checkIfObjectIsNull(o);
        CheckUtils.checkIfListIsEmpty(size);
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(o)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }
        
    public Iterator<E> iterator() { 
        return new Iterator<E>() {
            private Node current = head;
            
            public boolean hasNext() {
                return current != null;
            }
            
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return new ListIterator<E>() {
            private Node current = head;
            private int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < size;
            }

            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = current.value;
                current = current.next;
                currentIndex++;
                return value;
            }

            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            public E previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                E value = current.value;
                current = current.prev;
                currentIndex--;
                return value;
            }

            public int nextIndex() {
                return currentIndex + 1;
            }

            public int previousIndex() {
                return currentIndex - 1;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void set(E e) {
                throw new UnsupportedOperationException();
            }

            public void add(E e) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        for (int i = 0; i < size - 1; i++) {
            sb.append(current.value + " <-> ");
            current = current.next;
        }
        sb.append(current.value);
        sb.append("]");
        return sb.toString();
    }
}
