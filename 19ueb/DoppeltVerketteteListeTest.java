import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// toArray to test

public class DoppeltVerketteteListeTest {
    private DoppeltVerketteteListe<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new DoppeltVerketteteListe<>();
        for ( int i = 0; i < 10; i++ ) {
            list.add(i);
        }
    }

    @Test
    public void testSize() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertEquals(0, list.size());
        Assertions.assertEquals(10, this.list.size());
    }

    @Test
    public void testIsEmptyTrue() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void testContainsTrue() {
        Assertions.assertTrue(list.contains(0));
        Assertions.assertTrue(list.contains(9));
    }

    @Test
    public void testContainsFalse() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertFalse(list.contains(-1));
        Assertions.assertFalse(this.list.contains(-1));
        Assertions.assertFalse(this.list.contains(10));
    }

    @Test
    public void testContainsWithError() {
        Assertions.assertThrows(MyNullPointerException.class, () -> list.contains(null));
    }

    @Test
    public void testAddTrue() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertTrue(list.add(0));
        Assertions.assertTrue(list.add(1));

        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(0, list.get(0));
        Assertions.assertEquals(1, list.get(1));
    }

    @Test
    public void testAddWithError() {
        Assertions.assertThrows(MyNullPointerException.class, () -> list.add(null));
    }

    @Test
    public void testRemoveTrue() {
        Assertions.assertTrue(list.remove(Integer.valueOf(0)));
        Assertions.assertTrue(list.remove(Integer.valueOf(9)));

        Assertions.assertEquals(8, list.size());
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(8, list.get(7));
    } 

    @Test
    public void testRemoveFalse() {
        Assertions.assertFalse(list.remove(Integer.valueOf(-1)));
        Assertions.assertFalse(list.remove(Integer.valueOf(10)));

        Assertions.assertEquals(10, list.size());
        Assertions.assertEquals(0, list.get(0));
        Assertions.assertEquals(9, list.get(9));
    }

    @Test
    public void testRemoveWithError() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertThrows(MyNoSuchElementException.class, () -> list.remove(null));
        Assertions.assertThrows(MyNoSuchElementException.class, () -> list.remove(0));
    }

    @Test
    public void testAddAllTrue() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        list.add(0);
        list.add(1);
        list.add(2);

        DoppeltVerketteteListe<Integer> list2 = new DoppeltVerketteteListe<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);

        Assertions.assertTrue(list.addAll(list2));

        Assertions.assertEquals(6, list.size());
        Assertions.assertEquals(0, list.get(0));
        Assertions.assertEquals(5, list.get(5));
    }

    @Test 
    public void testAddAllFalse() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        list.add(0);
        list.add(1);
        list.add(2);

        DoppeltVerketteteListe<Integer> list2 = new DoppeltVerketteteListe<>();
        Assertions.assertFalse(list.addAll(list2));

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(0, list.get(0));
        Assertions.assertEquals(2, list.get(2));
    }

    @Test
    public void testClear() {
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testGet() {
        Assertions.assertEquals(0, list.get(0));
        Assertions.assertEquals(9, list.get(9));
    }

    @Test
    public void testGetWithError() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertThrows(MyNoSuchElementException.class, () -> list.get(0));

        Assertions.assertThrows(MyIndexOutOfBoundsException.class, () -> this.list.get(-1));
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, () -> this.list.get(10));
    }

    @Test 
    public void testSet() {
        Assertions.assertEquals(0, list.set(0, 10));
        Assertions.assertEquals(9, list.set(9, 20));

        Assertions.assertEquals(10, list.get(0));
        Assertions.assertEquals(20, list.get(9));
    }

    @Test
    public void testSetWithError() {
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, () -> this.list.set(100, 0));
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, () -> this.list.set(-1, 10));
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, () -> this.list.set(10, 10));

        Assertions.assertThrows(MyNullPointerException.class, () -> this.list.set(0, null));
    } 

    @Test
    public void testRemoveWithElementReturn() {
        Assertions.assertEquals(0, list.remove(0));
        Assertions.assertEquals(9, list.remove(8));

        Assertions.assertEquals(8, list.size());
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(8, list.get(7));
    }

    @Test
    public void testRemoveWithElementReturnError() {
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, () -> list.remove(100));
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, () -> list.remove(-1));
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, () -> list.remove(10));

        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertThrows(MyNoSuchElementException.class, () -> list.remove(0));
    }

    @Test
    public void testIndexOf() {
        Assertions.assertEquals(0, list.indexOf(0));
        Assertions.assertEquals(9, list.indexOf(9));
    }

    @Test
    public void testIndexOfWithError() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertThrows(MyNoSuchElementException.class, () -> list.indexOf(0));
        Assertions.assertThrows(MyNullPointerException.class, () -> list.indexOf(null));
    }
}
