public class Average implements CrunchOperation {
    private Iterator iterator;
    
    public void crunch(float numbers[]) {    
        iterator = new Iterator(numbers.length -1);
        iterator.setCurrentIndex(0);    

        float avg = 0;    
        float biggestNumber = 0;    
        int maxIndex = 0;    

        while (iterator.hasNext()) {    
            int i = iterator.getCurrentIndex();    
            avg += numbers[i];    
            if (numbers[i] > biggestNumber) {    
                biggestNumber = numbers[i];    
                maxIndex = i;    
            }    
            iterator.updateIndex();    
        }    
        numbers[maxIndex] = avg / numbers.length;    
    }
}
