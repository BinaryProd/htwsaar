/**
 * <h1> Swirl </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Random;

public class Swirl implements CrunchOperation {
    private Iterator iterator;

    /**
     * Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch 
     * die Länge des float-Arrays gegeben.
     */
    public void crunch(float numbers[]) {
        iterator = new Iterator(numbers.length -1);
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
