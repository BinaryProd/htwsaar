public class Substract implements CrunchOperation {
    private Iterator iterator;

    public void crunch(float numbers[]) {
        iterator = new Iterator(numbers.length);
        iterator.setCurrentIndex(0);    
        while (iterator.hasNext()) {    
            int currentIndex = iterator.getCurrentIndex();    
            numbers[currentIndex+1] -= numbers[currentIndex];    
            iterator.updateIndex();    
        }    
    }
}
