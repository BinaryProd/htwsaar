public class Sum implements CrunchOperation {      
    private Iterator iterator;      
      
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
