import java.util.LinkedList;

public class Tester {

    public static void main(String[] args) {
        Producer producer = new Producer();
        System.out.println("Queue before producing: " + producer.getQueue());
        for (int i = 0; i < 10; i++) {
            producer.produce();
        }

        System.out.println("Queue after producing: " + producer.getQueue());

        System.out.println("Queue get first element: " + producer.getFirst());
        System.out.println("Queue after getting first element: " + producer.getQueue());

        
        Consumer consumer = new Consumer();

        System.out.println("Queue before consuming: " + consumer);
        int size = producer.getQueue().size();
        LinkedList<Integer> quersummeList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            int number = producer.getFirst();
            int quersummer = consumer.consume(number);
            quersummeList.add(quersummer);
            System.out.println("Quersumme von " + number + " = " + quersummer);
        }
        System.out.println("Queue after consuming: " + consumer);

        System.out.println("Number of different results: " + consumer.numberOfDifferentResults());
        
        System.out.println("getCrossTotalsAscending: " + consumer.getCrossTotalsAscending());

        System.out.println("getCrossTotalsDescending: " + consumer.getCrossTotalsDescending());

        for (int i = 0; i < quersummeList.size(); i++) {
            System.out.println("Timestamps for " + quersummeList.get(i) + ": " + consumer.getTimestampsForResult(quersummeList.get(i)));
        }

    }
    
}
