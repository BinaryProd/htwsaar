public class CheckUtils {

    public static void checkQueueFull(int size, int capacity) {
        if (size == capacity) {
            throw new QueueException("Die Queue ist voll.");
        }
    }

    public static void checkObjectNull(Object object) {
        if (object == null) {
            throw new QueueException("Das Objekt ist null.");
        }
    }

    public static void checkIfPerson(Object object) {
        if (!(object instanceof Person)) {
            throw new QueueException("Das Objekt ist keine Person.");
        }
    }

    public static void checkIfString(Object object) {
        if (!(object instanceof String)) {
            throw new QueueException("Das Objekt ist kein String.");
        }
    }

    public static void checkQueueEmpty(int size) {
        if (size == 0) {
            throw new QueueException("Die Queue ist leer.");
        }
    }

    public static void checkIndex(int index, int capacity) {
        if (index < 0 || index > capacity) {
            throw new QueueException("Der Index ist nicht gültig.");
        }
    }

    public static void checkIfEmpty(String str) {
        if (str.isBlank()) {
            throw new QueueException("Der String ist leer.");
        }
    }
}
