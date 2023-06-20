import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;

public class Consumer {
    
    Queue<Quersumme> queue;
    

    public Consumer() {
        queue = new LinkedList<>();
    }

    public int consume(Integer number) {
        Quersumme qs = new Quersumme();
        qs.setNumber(number);
        int sum = 0;
        int tmp = 0;
        int iterations = 0;
        while ( number > 0 ) {
            qs.push(iterations, System.currentTimeMillis());
            tmp = number % 10;
            sum += tmp;
            number /= 10;
            iterations++;
        }
        qs.setSum(sum);
        queue.add(qs);
        return sum;
    }

    public int numberOfDifferentResults() {
        Set<Integer> set = new HashSet<>();
        for ( Quersumme qs : queue ) {
            set.add(qs.getSum());
        }
        return set.size();
    }

    public int numberOfOccurrences(int number) {
        int count = 0;
        for ( Quersumme qs : queue ) {
            if ( qs.getSum() == number ) {
                count++;
            }
        }
        return count;
    }

    public Collection<Integer> getCrossTotalsAscending() {
        Map<Integer, Integer> map = new HashMap<>();
        for ( Quersumme qs : queue ) {
            map.put(qs.getSum(), qs.getNumber());
        }
        Collection<Integer> collection = map.values();

        List<Integer> sortedList = new LinkedList<>(collection);
        Collections.sort(sortedList);
    
        return sortedList;
    }

    public Collection<Integer> getCrossTotalsDescending() {
        Map<Integer, Integer> map = new HashMap<>();
        for ( Quersumme qs : queue ) {
            map.put(qs.getSum(), qs.getNumber());
        }
        Collection<Integer> collection = map.values();

        List<Integer> sortedList = new LinkedList<>(collection);
        Collections.sort(sortedList, Collections.reverseOrder());

        return sortedList;
    }

    public Collection<Quersumme> getTimestampsForResult(int number) {
        List<Quersumme> list = new LinkedList<>();
        for ( Quersumme qs : queue ) {
            if ( qs.getSum() == number ) {
                list.add(qs);
            }
        }
        return list;
    }
}
