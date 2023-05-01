/**
 * <h1> NumberCruncherAnonym </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.Random;

public class NumberCruncherAnonym {
    private float[] numbers;
    private Iterator iterator;

    private CrunchOperation sum;
    private CrunchOperation swirl;
    private CrunchOperation divide;
    private CrunchOperation subtract;
    private CrunchOperation average;


    /**
     * Konstruktor der Klasse NumberCruncherAnonym
     * @param numbers Array mit float-Werten
     */
    public NumberCruncherAnonym(float[] numbers) {
        this.numbers = numbers;
        this.iterator = new Iterator(numbers.length -1);
        anonymousClass();
    }

    /**
     * Führt die Operationen aus, die in dem String-Array operations übergeben werden.
     * @param operations String-Array mit den Operationen, die ausgeführt werden sollen.
     */
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

        /**
         * Summiert die Elemente des Arrays paarweise von links nach rechts auf und 
         * speichert den neuen Wert in dem jeweils rechten Datenfeld
         */
        this.sum = new CrunchOperation() {
            public void crunch(float numbers[]) {
                iterator.setCurrentIndex(0);

                while (iterator.hasNext()) {
                    int currentIndex = iterator.getCurrentIndex();
                    float result = numbers[currentIndex] + numbers[currentIndex + 1];
                    NumberCruncherException.checkFloat(result);
                    numbers[currentIndex+1] = result;

                    iterator.updateIndex();
                }
            }
        };

        /**
         * Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch 
         * die Länge des float-Arrays gegeben.
         */
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

        /**
         * Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten und speichert den
         * neuen Wert im Datenfeld des jeweils größeren Wertes. 
         * D.h. der größte Wert wird durch den Kleinsten geteilt. 
         * Der Zweitgrößte durch den Zweitkleinsten usw.
         */
        this.divide= new CrunchOperation() {
            public void crunch(float numbers[]) {
                iterator.setCurrentIndex(0);
                iterator.setArrayLength(numbers.length);

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

                iterator.setArrayLength(numbers.length -1 );

                int j = 0;
                if ( numbers.length % 2 == 0) {
                    for(int i = numbers.length - 1 ; i >= numbers.length/2; i--) {
                        numbers[indexes.getValue(i)] = temp.get(i) / temp.get(j);
                        j++;
                    }
                } else {
                    for(int i = numbers.length - 1 ; i >= (numbers.length/2 + 1); i--) {
                        numbers[indexes.getValue(i)] = temp.get(i) / temp.get(j);
                        j++;
                    }
                }
            }
        };

        /**
         * Subtract die Elemente des Arrays paarweise von links nach rechts auf und 
         * speichert den neuen Wert in dem jeweils rechten Datenfeld
         */
        this.subtract = new CrunchOperation() {
            public void crunch(float numbers[]) {
                iterator.setCurrentIndex(0);    

                while (iterator.hasNext()) {    
                    int currentIndex = iterator.getCurrentIndex();    
                    float result = numbers[currentIndex] - numbers[currentIndex+1];
                    NumberCruncherException.checkFloat(result);
                    numbers[currentIndex+1] = result;

                    iterator.updateIndex();    
                }    
            }
        };

        /**
         * Bestimmt den Durchschnitt aller Werte im Array und speichert den 
         * Durchschnittswert im Datenfeld mit dem größten Wert.
         */
        this.average = new CrunchOperation() {
            public void crunch(float numbers[]) {    
                iterator.setCurrentIndex(0);    
                iterator.setArrayLength(numbers.length);

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
                iterator.setArrayLength(numbers.length -1 );

                numbers[maxIndex] = sum / numbers.length; 
            }
        };
    }

    /**
     * getter für das Array mit den float-Werten
     * @return Array mit float-Werten
     */
    public float[] getNumbers() {
        return this.numbers;
    }
}
