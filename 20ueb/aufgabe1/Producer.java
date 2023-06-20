import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;

public class Producer {

    Random random;    
    Queue<Integer> queue;

    /**
     * Constructor
     */
    public Producer() {
        random = new Random();
        queue = new LinkedList<>();
    } 

    /**
     * Produce a random number and add it to the queue
     * @return the number produced
     */
    public int produce() {
        int number = random.nextInt(1000);
        queue.add(number);
        return number;
    }

    /**
     * Get the first element of the queue
     * @return the first element of the queue
     */
    public int getFirst() {
        return queue.poll();
    }

    /**
     * Get the queue
     * @return the queue
     */
    public Queue<Integer> getQueue() {
        return queue;
    }

}
