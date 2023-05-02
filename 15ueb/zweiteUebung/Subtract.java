/**
 * <h1> Subtract </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class Subtract implements CrunchOperation {

    /**
     * Subtract die Elemente des Arrays paarweise von links nach rechts auf und 
     * speichert den neuen Wert in dem jeweils rechten Datenfeld
     */
    public void crunch(float numbers[]) {    

        for(int i = 0; i < numbers.length - 1; i++) {    
            float result = numbers[i] - numbers[i+1];    
            NumberCruncherException.checkFloat(result);    
            numbers[i+1] = result;    
        }                                    
    }
}
