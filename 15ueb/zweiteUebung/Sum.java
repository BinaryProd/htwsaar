/**
 * <h1> Sum </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class Sum implements CrunchOperation {      
    private Iterator iterator;      
      
    /**
     * Summiert die Elemente des Arrays paarweise von links nach rechts auf und 
     * speichert den neuen Wert in dem jeweils rechten Datenfeld
     */
    public void crunch(float numbers[]) {
        iterator = new Iterator(numbers.length - 1);      
        iterator.setCurrentIndex(0);        
      
        while (iterator.hasNext()) {        
            int currentIndex = iterator.getCurrentIndex();
            float result = numbers[currentIndex] + numbers[currentIndex + 1];
            NumberCruncherException.checkFloat(result); // check the sum for valid float value
            numbers[currentIndex + 1] = result;
            iterator.updateIndex();    
        }                                  
    }            
}
