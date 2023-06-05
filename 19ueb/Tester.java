import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Tester {
    private static final String red = "\u001B[31m";
    private static final String green = "\u001B[32m";
    private static final String blue = "\u001B[34m";
    private static final String bold = "\033[0;1m";
    private static final String reset = "\u001B[0m";


    private DoppeltVerketteteListe<Integer> intListe;
    private DoppeltVerketteteListe<String> stringListe;

    public static void main(String[] args) {
        new Tester().run();
    }

    public void run() {
        setUp();
        testIntListe();
        testStringListe();
    }

    public void setUp() {
        intListe = new DoppeltVerketteteListe<>();
        stringListe = new DoppeltVerketteteListe<>();
    }

    public void testIntListe() {
        System.out.println(bold + blue + "\nTesting intListe..." + reset);

        // Test size()
        System.out.println("Size: " + intListe.size());

        // Test isEmpty()
        System.out.println("Is Empty: " + intListe.isEmpty());

        // Test add()
        intListe.add(10);
        intListe.add(20);
        intListe.add(30);
        System.out.println("After " + green + "adding " + reset + "elements: " + intListe.toString() + "\n");

        // Test contains()
        System.out.println("Contains 20: " + intListe.contains(20));
        System.out.println("Contains 40: " + intListe.contains(40));

        // Test toArray()
        Integer[] arr = new Integer[intListe.size()];
        arr = intListe.toArray(arr);
        System.out.println("Array: " + Arrays.toString(arr));

        // Test remove()
        intListe.remove(Integer.valueOf(20)); // need Integer.valueOf() to remove the object, else it will remove the element at index 20 and throw an IndexOutOfBoundsException
        System.out.println("After " + red + "removing " + reset + "20: " + intListe.toString() + "\n");

        // Test addAll()
        List<Integer> tempList = new ArrayList<>();
        tempList.add(40);
        tempList.add(50);
        intListe.addAll(tempList);
        System.out.println("After " + green + "adding " + reset + "all: " + intListe.toString() + "\n");

        // Test clear()
        intListe.clear();
        System.out.println("After clearing: " + intListe.toString() + "\n");

        // Test get()
        intListe.add(60);
        intListe.add(70);
        System.out.println("After " + green + "adding " + reset + "60 and 70: " + intListe.toString() + "\n");
        System.out.println("Get element at index 0: " + intListe.get(0));
        System.out.println("Get element at index 1: " + intListe.get(1));

        // Test set()
        intListe.set(1, 80);
        System.out.println("After setting element at index 1 to 80: " + intListe.toString() + "\n");

        // Test add(index, element)
        intListe.add(1, 90);
        System.out.println("After " + green + "adding " + reset + "element 90 at index 1: " + intListe.toString() + "\n");

        // Test remove(index)
        intListe.remove(0);
        System.out.println("After " + red + "removing " + reset + "element at index 0: " + intListe.toString() + "\n");

        // Test indexOf()
        System.out.println("Index of 80: " + intListe.indexOf(80));
        System.out.println("Index of 100: " + intListe.indexOf(100));
    }

    public void testStringListe() {
        System.out.println(bold + blue + "\nTesting stringListe..." + reset);

        // Test size()
        System.out.println("Size: " + stringListe.size());

        // Test isEmpty()
        System.out.println("Is Empty: " + stringListe.isEmpty());

        // Test add()
        stringListe.add("a");
        stringListe.add("b");
        stringListe.add("c");
        System.out.println("After " + green + "adding " + reset + "elements: " + stringListe.toString() + "\n");

        // Test contains()
        System.out.println("Contains b: " + stringListe.contains("b"));
        System.out.println("Contains d: " + stringListe.contains("d"));

        // Test toArray()
        String[] arr = new String[stringListe.size()];
        arr = stringListe.toArray(arr);
        System.out.println("Array: " + Arrays.toString(arr));

        // Test remove()
        stringListe.remove("b");
        System.out.println("After " + red + "removing " + reset + "b: " + stringListe.toString() + "\n");

        // Test addAll()
        List<String> tempList = new ArrayList<>();
        tempList.add("d");
        tempList.add("e");
        stringListe.addAll(tempList);
        System.out.println("After " + green + "adding " + reset + "all: " + stringListe.toString() + "\n");

        // Test clear()
        stringListe.clear();
        System.out.println("After clearing: " + stringListe.toString() + "\n");

        // Test get()
        stringListe.add("f");
        stringListe.add("g");
        System.out.println("Get element at index 0: " + stringListe.get(0));
        System.out.println("Get element at index 1: " + stringListe.get(1));

        // Test set()
        stringListe.set(1, "h");
        System.out.println("After setting element at index 1 to h: " + stringListe.toString() + "\n");

        // Test add(index, element)
        stringListe.add(1, "i");
        System.out.println("After " + green + "adding " + reset + "element i at index 1: " + stringListe.toString() + "\n");

        // Test remove(index)
        stringListe.remove(0);
        System.out.println("After " + red + "removing " + reset + "element at index 0: " + stringListe.toString() + "\n");

        // Test indexOf()
        System.out.println("Index of h: " + stringListe.indexOf("h"));
        System.out.println("Index of j: " + stringListe.indexOf("j"));
    }
}
