public class ArrayFunctionWithGenerics<T> {
    
    private T[] array;    
    private int size;    
    
    public ArrayFunctionWithGenerics(int capacity) {    
        array = (T[]) new Object[capacity];    
        size = 0;    
    }    
    
    public void addFirst(T value) {    
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
    
    public void addEnd(T value) {    
        if (size == array.length) {    
            System.err.println("Error: Array is full.");    
            return;    
        }    
        array[size] = value;    
        size++;    
    }    
    
    public void removeEnd() {    
        if (size == 0) {    
            System.err.println("Error: Array is empty.");    
            return;    
        }    
        array[size - 1] = null;    
        size--;    
    }    
    
    public void addAtIndex(int index, T value) {    
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
    
    public T[] getArray() {    
        T[] copyArray = (T[]) new Object[size];    
        for (int i = 0; i < size; i++) {    
            copyArray[i] = array[i];    
        }    
        return copyArray;    
    }    
}
