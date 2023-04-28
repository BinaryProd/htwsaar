public class Divide implements CrunchOperation {
    private Iterator iterator;

    public void crunch(float numbers[]) {
        iterator = new Iterator(numbers.length);
        iterator.setCurrentIndex(0);    
        ArrayFunction temp = new ArrayFunction(numbers.length);    
        ArrayFunction indexes = new ArrayFunction(numbers.length);    
        while (iterator.hasNext()) {    

            int currentIndex = iterator.getCurrentIndex();    
            boolean added = false;    

            for (int j = 0; j < temp.getSize(); j++) {    
                if (numbers[currentIndex] < temp.get(j)) {    
                    temp.addAtIndex(j, numbers[currentIndex]);    
                    indexes.addAtIndex(j, currentIndex);    
                    added = true;    
                    break;    
                }    
            }    

            if (!added) {    
                temp.addEnd(numbers[currentIndex]);    
                indexes.addEnd(currentIndex);    
            }    

            iterator.updateIndex();    
        }    
        int j = 0;    
        for(int i = numbers.length; i > numbers.length/2; i--) { // attention if numbers.length is odd    
            //numbers[indexes.get(i)] = temp.get(i) / temp.get(j);    
            numbers[i] = temp.get(i) / temp.get(j);    
            j++;    
        }    
    }
}
