import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class ConsumerTest {

    private Consumer consumer;

    @BeforeEach
    public void setUp() {
        consumer = new Consumer();
    }

    @Test
    public void consume_ValidNumber() {
        int number = 12345;
        int expectedSum = 15;

        int actualSum = consumer.consume(number);

        assertEquals(expectedSum, actualSum);

        Queue<Quersumme> queue = consumer.queue;
        assertEquals(1, queue.size());
        Quersumme qs = queue.peek();
        assertNotNull(qs);
        assertEquals(number, qs.getNumber());
        assertEquals(expectedSum, qs.getSum());
    }

    @Test
    public void numberOfDifferentResults() {
        consumer.queue.add(createQuersumme(1, 10));
        consumer.queue.add(createQuersumme(2, 20));
        consumer.queue.add(createQuersumme(3, 10));
        consumer.queue.add(createQuersumme(4, 30));
        consumer.queue.add(createQuersumme(5, 20));

        int expectedCount = 3;
        int actualCount = consumer.numberOfDifferentResults();

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void numberOfOccurrences() {
        consumer.queue.add(createQuersumme(1, 10));
        consumer.queue.add(createQuersumme(2, 20));
        consumer.queue.add(createQuersumme(3, 10));
        consumer.queue.add(createQuersumme(4, 30));
        consumer.queue.add(createQuersumme(5, 20));

        int number = 10;
        int expectedCount = 2;
        int actualCount = consumer.numberOfOccurrences(number);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getCrossTotalsAscending() {
        consumer.queue.add(createQuersumme(3, 10));
        consumer.queue.add(createQuersumme(2, 20));
        consumer.queue.add(createQuersumme(1, 30));

        Collection<Integer> expectedCollection = List.of(1, 2, 3);
        Collection<Integer> actualCollection = consumer.getCrossTotalsAscending();

        assertEquals(expectedCollection, actualCollection);
    }

    @Test
    public void getCrossTotalsDescending() {
        consumer.queue.add(createQuersumme(3, 10));
        consumer.queue.add(createQuersumme(2, 20));
        consumer.queue.add(createQuersumme(1, 30));

        Collection<Integer> expectedCollection = List.of(3, 2, 1);
        Collection<Integer> actualCollection = consumer.getCrossTotalsDescending();

        assertEquals(expectedCollection, actualCollection);
    }

    public Quersumme createQuersumme(int number, int sum) {
        Quersumme qs = new Quersumme();
        qs.setNumber(number);
        qs.setSum(sum);
        return qs;
    }
}
