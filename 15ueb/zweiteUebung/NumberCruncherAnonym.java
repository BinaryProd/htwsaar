import java.util.Random;

public class NumberCruncherAnonym {
    private float[] numbers;
    private Iterator iterator;

    private CrunchOperation sum;
    private CrunchOperation swirl;
    private CrunchOperation divide;
    private CrunchOperation subtract;
    private CrunchOperation average;


    public NumberCruncherAnonym(float[] numbers) {
        this.numbers = numbers;
        this.iterator = new Iterator(numbers.length); // ou -1 ?
        anonymousClass();
    }

    public void crunch(String[] operations) {
        for ( String operation: operations) {
            switch(operation) {
                case "sum":
                    this.sum.crunch(this.numbers);
                    break;
                case "swirl":
                    this.swirl.crunch(this.numbers);
                    break;
                case "divide":
                    this.divide.crunch(this.numbers);
                    break;
                case "subtract":
                    this.subtract.crunch(this.numbers);
                    break;
                case "average":
                    this.average.crunch(this.numbers);
                    break;
            }
        }
    }

    public void anonymousClass() {

        this.sum = new CrunchOperation() {
            public void crunch(float numbers[]) {
                iterator.setCurrentIndex(0);
                while (iterator.hasNext()) {
                    int currentIndex = iterator.getCurrentIndex();
                    numbers[currentIndex+1] += numbers[currentIndex];
                    iterator.updateIndex();
                }
            }
        };

        this.swirl = new CrunchOperation() {
            public void crunch(float numbers[]) {
                iterator.setCurrentIndex(0);
                Random random = new Random();
                while (iterator.hasNext()) {
                    int j = random.nextInt(numbers.length);
                    int k = random.nextInt(numbers.length);
                    float temp = numbers[k];
                    numbers[k] = numbers[j];
                    numbers[j] = temp;
                    iterator.updateIndex();
                }
            }
        };

        this.divide= new CrunchOperation() {
            public void crunch(float numbers[]) {
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
                    numbers[indexes.get(i)] = temp.get(i) / temp.get(j);
                    j++;
                }
            }
        };

        this.subtract = new CrunchOperation() {
            public void crunch(float numbers[]) {
                iterator.setCurrentIndex(0);
                while (iterator.hasNext()) {
                    int currentIndex = iterator.getCurrentIndex();
                    numbers[currentIndex+1] -= numbers[currentIndex];
                    iterator.updateIndex();
                }
            }
        };

        this.average = new CrunchOperation() {
            public void crunch(float numbers[]) {
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
        };

    }

    public float[] getNumbers() {
        return numbers;
    }
}
