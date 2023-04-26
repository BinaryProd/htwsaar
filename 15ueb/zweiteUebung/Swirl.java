import java.util.Random;

public class Swirl implements CrunchOperation {
    private Iterator iterator;

    public void crunch(float numbers[]) {
        iterator = new Iterator(numbers.length);
        iterator.setCurrentIndex(0);
        Random random = new Random();
        while (iterator.hasNext()) {
            int j = random.nextInt(numbers.length);
            int k = random.nextInt(numbers.length);
            float temp = numbers[k];
            numbers[k] = numbers[j];
            numbers[j] = temp;
            iterator.updateIndex();
        }
    }
}
