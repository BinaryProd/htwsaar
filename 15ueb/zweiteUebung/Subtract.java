public class Subtract implements CrunchOperation {
    private Iterator iterator;

    public void crunch(float numbers[]){
        iterator = new Iterator(numbers.length - 1);
        iterator.setCurrentIndex(0);

        while (iterator.hasNext()) {
            int currentIndex = iterator.getCurrentIndex();
            float result = numbers[currentIndex] - numbers[currentIndex+1];
            NumberCruncherException.checkFloat(result); // check the result for valid float range
            numbers[currentIndex+1] = result;
            iterator.updateIndex();
        }
    }
}

