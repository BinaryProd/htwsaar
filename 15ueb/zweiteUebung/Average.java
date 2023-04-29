public class Average implements CrunchOperation {
    private Iterator iterator;

    public void crunch(float numbers[]) {    
        iterator = new Iterator(numbers.length);
        iterator.setCurrentIndex(0);    
        
        float sum = 0;
        float biggestNumber = Float.NEGATIVE_INFINITY;
        int maxIndex = -1;

        while (iterator.hasNext()) {
            int i = iterator.getCurrentIndex();
            sum += numbers[i];
            if (numbers[i] > biggestNumber) {
                biggestNumber = numbers[i];
                maxIndex = i;
            }
            iterator.updateIndex();
        }
        
        numbers[maxIndex] = sum / numbers.length; 
    }
}
