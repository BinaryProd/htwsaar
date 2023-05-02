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
                
                for(int i = 0; i < numbers.length - 1; i++) {
                    float result = numbers[i] + numbers[i + 1];
                    NumberCruncherException.checkFloat(result);
                    numbers[i+1] = result;
                }
            }
        };

        /**
         * Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch 
         * die Länge des float-Arrays gegeben.
         */
        this.swirl = new CrunchOperation() {
            public void crunch(float numbers[]) {
                Random random = new Random();
                
                for(int i = 0; i < numbers.length; i++) {
                    int j = random.nextInt(numbers.length);
                    int k = random.nextInt(numbers.length);
                    float temp = numbers[k];

                    numbers[k] = numbers[j];
                    numbers[j] = temp;
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

                ArrayFunction temp = new ArrayFunction(numbers.length);
                ArrayFunction indexes = new ArrayFunction(numbers.length);

                for(int i = 0; i < numbers.length; i++) {
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
                }

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

                for(int i = 0; i < numbers.length - 1; i++) {
                    float result = numbers[i] - numbers[i+1];
                    NumberCruncherException.checkFloat(result);
                    numbers[i+1] = result;
                }    
            }
        };

        /**
         * Bestimmt den Durchschnitt aller Werte im Array und speichert den 
         * Durchschnittswert im Datenfeld mit dem größten Wert.
         */
        this.average = new CrunchOperation() {
            public void crunch(float numbers[]) {    

                float sum = 0;
                float biggestNumber = Float.NEGATIVE_INFINITY;
                int maxIndex = -1;

                for(int i = 0; i < numbers.length; i++) {
                    sum += numbers[i];
                    if (numbers[i] > biggestNumber) {
                        biggestNumber = numbers[i];
                        maxIndex = i;
                    }
                }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (float number: this.numbers) {
            sb.append(number + "\n");
        }
        return sb.toString();
    }
}
