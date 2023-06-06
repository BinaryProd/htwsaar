public class CheckUtils {
    public static void checkIfIndexIsInRange(int index, int size) {
        if (index < 0 || index >= size) {
            throw new MyIndexOutOfBoundsException("Der Index muss zwischen 0 und " + (size - 1) + " liegen.");
        }
    }

    public static void checkIfIndexIsInRange(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new MyIndexOutOfBoundsException("Der Index muss zwischen 0 und " + (size - 1) + " liegen.");
        }
    }

    public static void checkIfListIsEmpty(int size) {
        if (size == 0) {
            throw new MyNoSuchElementException("Die Liste ist leer.");
        }
    }

    public static void checkIfObjectIsNull(Object object) {
        if (object == null) {
            throw new MyNullPointerException("Das Objekt darf nicht null sein.");
        }
    }
}
