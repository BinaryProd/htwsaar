import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.Map;


class QuersummeTest {

    private Quersumme quersumme;

    @BeforeEach
    void setUp() {
        quersumme = new Quersumme();
    }

    @Test
    void push_ValidNumberAndTime_CacheContainsNumberAndTime() {
        int number = 5;
        long time = 10L;

        quersumme.push(number, time);

        Map<Integer, Long> cache = quersumme.cache;
        assertTrue(cache.containsKey(number));
        assertEquals(time, cache.get(number));
    }

    @Test
    void push_NegativeNumber_ThrowsIllegalArgumentException() {
        int number = -5;
        long time = 10L;

        assertThrows(IllegalArgumentException.class, () -> quersumme.push(number, time));
    }

    @Test
    void push_NegativeTime_ThrowsIllegalArgumentException() {
        int number = 5;
        long time = -10L;

        assertThrows(IllegalArgumentException.class, () -> quersumme.push(number, time));
    }

    @Test
    void setSum_ValidSum_SumIsSet() {
        int sum = 15;

        quersumme.setSum(sum);

        assertEquals(sum, quersumme.getSum());
    }

    @Test
    void setNumber_ValidNumber_NumberIsSet() {
        int number = 5;

        quersumme.setNumber(number);

        assertEquals(number, quersumme.getNumber());
    }
}

