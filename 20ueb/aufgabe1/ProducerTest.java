import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Queue;

class ProducerTest {

    private Producer producer;

    @BeforeEach
    void setUp() {
        producer = new Producer();
    }

    @Test
    void testProduce() {
        Integer number = producer.produce();
        Queue<Integer> queue = producer.getQueue();
        
        Assertions.assertNotNull(number);
        Assertions.assertEquals(1, queue.size());
        Assertions.assertTrue(queue.contains(number));
    }

    @Test
    void testGetFirst() {
        Integer number = producer.produce();
        Integer first = producer.getFirst();

        Assertions.assertEquals(number, first);
        Assertions.assertTrue(producer.getQueue().isEmpty());
    }

    @Test
    void testGetQueue() {
        Queue<Integer> queue = producer.getQueue();

        Assertions.assertNotNull(queue);
        Assertions.assertTrue(queue.isEmpty());
    }
}

