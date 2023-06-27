import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

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
        Assertions.assertTrue(cache.containsKey(number));
        Assertions.assertEquals(time, cache.get(number));
    }

    @Test
    void push_NegativeNumber_ThrowsIllegalArgumentException() {
        int number = -5;
        long time = 10L;

        Assertions.assertThrows(IllegalArgumentException.class, () -> quersumme.push(number, time));
    }

    @Test
    void push_NegativeTime_ThrowsIllegalArgumentException() {
        int number = 5;
        long time = -10L;

        Assertions.assertThrows(IllegalArgumentException.class, () -> quersumme.push(number, time));
    }

    @Test
    void setSum_ValidSum_SumIsSet() {
        int sum = 15;

        quersumme.setSum(sum);

        Assertions.assertEquals(sum, quersumme.getSum());
    }

    @Test
    void setNumber_ValidNumber_NumberIsSet() {
        int number = 5;

        quersumme.setNumber(number);

        Assertions.assertEquals(number, quersumme.getNumber());
    }
}

