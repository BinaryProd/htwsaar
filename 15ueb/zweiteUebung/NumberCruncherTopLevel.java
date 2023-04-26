public class NumberCruncherTopLevel implements NumberCruncher {
    private float[] numbers;
    private itarator = new Iterator(numbers.length);

    public NumberCruncherTopLevel(float[] numbers) {
        this.numbers = numbers;
    }

    public void crunch(String[] operations) {
        for (operation : operations) {
            switch(operation) {
                case "sum":
                    while (iterator.hasNext()) {
                        int i = iterator.getCurrentIndex();
                        numbers[i+1] = numbers[i] + numbers[i+1];
                        iterator.updateIndex();
                    }
                    break;
                case "swirl":
                    Random random = new Random();
                    while (iterator.hasNext()) {
                        int j = random.nextInt(numbers.length);
                        int k = random.nextInt(numbers.length);
                        float temp = numbers[k];
                        numbers[k] = numbers[j];
                        numbers[j] = temp;
                        iterator.updateIndex();
                    }
                    break;
                case "divide":
                    while (iterator.hasNext()) {
                        ArrayFunction temp = new ArrayFunction(numbers.length);
                        ArrayFunction indexes = new ArrayFunction(numbers.length);
                        int i = iterator.getCurrentIndex();
                        int testNumber = 0;

                        boolean added = false; 

                        for (int j = 0; j < temp.getSize(); j++) {
                            if (numbers[i] < temp.get(j)) {
                                temp.addAtIndex(j, numbers[i]);
                                indexes.addAtIndex(j, i);
                                added = true;
                                break;
                            }
                        }

                        if (!added) {
                            temp.addEnd(numbers[i]);
                            indexes.addEnd(i);
                        }

                        iterator.updateIndex();
                    }
                    int j = 0;
                    for(int i = numbers.length; i > numbers.length/2; i--) { // attention if numbers.length is odd
                        numbers[indexes.get(i)] = temp.get(i) / temp.get(j);
                        j++;
                    }

                    break;
                case "subtract":
                    while (iterator.hasNext()) {
                        int i = iterator.getCurrentIndex();
                        numbers[i+1] = numbers[i] - numbers[i+1];
                        iterator.updateIndex();
                    }
                    break;
                case "average":
                    float avg = 0;
                    float biggestNumber = 0;
                    int index = 0;
                    while (iterator.hasNext()) {
                        int i = iterator.getCurrentIndex();
                        avg += numbers[i];
                        if (numbers[i] > biggestNumber) {
                            biggestNumber = numbers[i];
                            index = i;
                        }
                        iterator.updateIndex();
                    }
                    numbers[index] = avg / numbers.length;
                    break;

            }
        }
    }
}

public float[] getNumbers() {
    return numbers;
}
}
