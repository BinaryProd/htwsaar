public class Sum implements CrunchOperation {
    private Iterator iterator;

    public void crunch(float numbers[]) {
        iterator = new Iterator(numbers.length -1 );
        iterator.setCurrentIndex(0);    

        while (iterator.hasNext()) {    
            int currentIndex = iterator.getCurrentIndex();    
            numbers[currentIndex+1] += numbers[currentIndex];    

            iterator.updateIndex();    
        }    
    }
}
