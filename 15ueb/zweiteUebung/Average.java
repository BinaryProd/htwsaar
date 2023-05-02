/**
 * <h1> Average </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class Average implements CrunchOperation {

    /**
     * Bestimmt den Durchschnitt aller Werte im Array und speichert den 
     * Durchschnittswert im Datenfeld mit dem größten Wert.
     */
    public void crunch(float numbers[]) {      

        float sum = 0;    
        float biggestNumber = Float.NEGATIVE_INFINITY;    
        int maxIndex = -1;    

        for(int i = 0; i < numbers.length; i++) {    
            sum += numbers[i];    
            if (numbers[i] > biggestNumber) {    
                biggestNumber = numbers[i];    
                maxIndex = i;    
            }    
        }    

        numbers[maxIndex] = sum / numbers.length;    
    }
}
