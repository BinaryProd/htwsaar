/**
 * <h1> Swirl </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Random;

public class Swirl implements CrunchOperation {

    /**
     * Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch 
     * die Länge des float-Arrays gegeben.
     */
    public void crunch(float numbers[]) {
        Random random = new Random();

        for(int i = 0; i < numbers.length; i++) {
            int j = random.nextInt(numbers.length);
            int k = random.nextInt(numbers.length);
            float temp = numbers[k];

            numbers[k] = numbers[j];
            numbers[j] = temp;
        }
    }
}
