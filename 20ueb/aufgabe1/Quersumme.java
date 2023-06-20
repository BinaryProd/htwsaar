import java.util.Map;
import java.util.HashMap;

public class Quersumme {

    Map<Integer, Long> cache;
    int sum = 0;
    int number = 0;

    public Quersumme() {
        cache = new HashMap<>();
    }

    public void push(int number, Long time) {
        if ( number < 0 || time < 0 ) {
            throw new IllegalArgumentException("Number or time must be positive");
        }
        cache.put(number, time);
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSum() {
        return this.sum;
    }

    public int getNumber() {
        return this.number;
    }

}
