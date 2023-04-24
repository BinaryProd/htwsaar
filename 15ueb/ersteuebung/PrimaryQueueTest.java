import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimaryQueueTest {

    @Test
    public void test_Constructor() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertEquals(0, q.size());
        assertEquals(10, q.capacity());
    }

    @Test
    public void test_Default_Constructor() {
        PrimaryQueue q = new PrimaryQueue();
        assertEquals(0, q.size());
        assertEquals(10, q.capacity());
    }

    @Test
    public void test_AddLast() {
        PrimaryQueue q = new PrimaryQueue(10);
        q.addLast(1);
        q.addLast(2);
        q.addLast(3);
        assertEquals(3, q.size());
        assertEquals(1, q.get(0));
        assertEquals(2, q.get(1));
        assertEquals(3, q.get(2));
    }

    @Test
    public void test_AddLast_With_Null_Object() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertThrows(IllegalArgumentException.class, () -> {
            q.addLast(null);
        });
    }

    @Test
    public void test_AddLast_With_Full_Queue() {
        PrimaryQueue q = new PrimaryQueue(3);
        assertThrows(IllegalArgumentException.class, () -> {
            q.addLast(1);
            q.addLast(2);
            q.addLast(3);
            q.addLast(4);
        });
    }

    @Test
    public void test_AddFirst() {
        PrimaryQueue q = new PrimaryQueue(10);
        q.addFirst(3);
        q.addFirst(2);
        q.addFirst(1);
        assertEquals(3, q.size());
        assertEquals(1, q.get(0));
        assertEquals(2, q.get(1));
        assertEquals(3, q.get(2));
    }

    @Test
    public void test_AddFirst_With_Null_Object() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertThrows(IllegalArgumentException.class, () -> {
            q.addFirst(null);
        });
    }

    @Test
    public void test_AddFirst_With_Full_Queue() {
        PrimaryQueue q = new PrimaryQueue(3);
        assertThrows(IllegalArgumentException.class, () -> {
            q.addFirst(1);
            q.addFirst(2);
            q.addFirst(3);
            q.addFirst(4);
        });
    }

    @Test
    public void test_AddAtIndex() {
        PrimaryQueue q = new PrimaryQueue(10);
        q.addAtIndex(1, 0);
        q.addAtIndex(3, 1);
        q.addAtIndex(2, 1);
        q.addAtIndex(8, 8);
        q.print();
        assertEquals(4, q.size());
        assertEquals(1, q.get(0));
        assertEquals(2, q.get(1));
        assertEquals(3, q.get(2));
        assertEquals(8, q.get(3));
    }

    @Test
    public void test_AddAtIndex_With_Null_Object() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertThrows(IllegalArgumentException.class, () -> {
            q.addAtIndex(null, 0);
        });
    }

    @Test
    public void test_AddAtIndex_With_Full_Queue() {
        PrimaryQueue q = new PrimaryQueue(3);
        assertThrows(IllegalArgumentException.class, () -> {
            q.addAtIndex(1, 0);
            q.addAtIndex(2, 1);
            q.addAtIndex(3, 2);
            q.addAtIndex(4, 3);
        });
    }

    @Test
    public void test_AddAtIndex_With_Invalid_Index() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertThrows(IllegalArgumentException.class, () -> {
            q.addAtIndex("jon", -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            q.addAtIndex("ja", 11);
        });
    }

    
    @Test
    public void test_RemoveFirst() {
        PrimaryQueue q = new PrimaryQueue(10);
        q.addLast(1);
        q.addLast(2);
        q.addLast(3);
        assertEquals(1, q.removeFirst());
        assertEquals(2, q.size());
        assertEquals(2, q.get(0));
        assertEquals(3, q.get(1));
    }

    @Test
    public void test_Remove_First_With_Empty_Queue() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertThrows(IllegalArgumentException.class, () -> {
            q.removeFirst();
        });
    }

    @Test
    public void test_RemoveLast() {
        PrimaryQueue q = new PrimaryQueue(10);
        q.addLast(1);
        q.addLast(2);
        q.addLast(3);
        assertEquals(3, q.removeLast());
        assertEquals(2, q.size());
        assertEquals(1, q.get(0));
        assertEquals(2, q.get(1));
    }

    @Test
    public void test_RemoveLast_With_Empty_Queue() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertThrows(IllegalArgumentException.class, () -> {
            q.removeLast();
        });
    }

    @Test
    public void test_RemoveAtIndex() {
        PrimaryQueue q = new PrimaryQueue(10);
        q.addLast(1);
        q.addLast(2);
        q.addLast(3);
        assertEquals(2, q.removeAtIndex(1));
        assertEquals(2, q.size());
        assertEquals(1, q.get(0));
        assertEquals(3, q.get(1));
    }

    @Test
    public void test_RemoveAtIndex_With_Empty_Queue() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertThrows(IllegalArgumentException.class, () -> {
            q.removeAtIndex(0);
        });
    }

    @Test
        public void test_Empty() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertTrue(q.empty());
        q.addLast(1);
        assertFalse(q.empty());
    }

    @Test
    public void test_Full() {
        PrimaryQueue q = new PrimaryQueue(3);
        q.addLast(1);
        q.addLast(2);
        assertFalse(q.full());
        q.addLast(3);
        assertTrue(q.full());
    }

    @Test
    public void test_Size() {
        PrimaryQueue q = new PrimaryQueue(10);
        q.addLast(1);
        q.addLast(2);
        q.addLast(3);
        assertEquals(3, q.size());
    }

    @Test
    public void test_Capacity() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertEquals(10, q.capacity());
    }

    @Test
    public void test_Clear() {
        PrimaryQueue q = new PrimaryQueue(10);
        q.addLast(1);
        q.addLast(2);
        q.addLast(3);
        q.clear();
        assertEquals(0, q.size());
    }

    @Test
    public void test_Clear_With_Empty_Queue() {
        PrimaryQueue q = new PrimaryQueue(10);
        assertThrows(IllegalArgumentException.class, () -> {
            q.clear();
        });
    }
}

