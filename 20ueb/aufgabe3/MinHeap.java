import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;

public class MinHeap<E extends Comparable<E>> implements Queue<E> {
    private E[] heap;
    private int size;
    private Comparator<E> comparator;

    public MinHeap(int capacity) {
        heap = (E[]) new Comparable[capacity];
        size = 0;
        comparator = Comparator.naturalOrder();
    }

    @Override
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null elements not allowed");
        }
        if (size == heap.length) {
            return false;
        }

        heap[size] = e;
        heapifyUp(size);
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }

        E root = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown(0);

        return root;
    }

    @Override
    public E peek() {
        return (size == 0) ? null : heap[0];
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(java.util.Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(java.util.Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(java.util.Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(java.util.Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E element() {
        throw new UnsupportedOperationException();
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < size && comparator.compare(heap[leftChild], heap[smallest]) < 0) {
            smallest = leftChild;
        }

        if (rightChild < size && comparator.compare(heap[rightChild], heap[smallest]) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        if (index > 0 && comparator.compare(heap[index], heap[parent]) < 0) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    private void swap(int i, int j) {
        E temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
