/**
 * <h1> Divide </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class Divide implements CrunchOperation {
    private Iterator iterator;

    /**
     * Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten und speichert den
     * neuen Wert im Datenfeld des jeweils größeren Wertes. 
     * D.h. der größte Wert wird durch den Kleinsten geteilt. 
     * Der Zweitgrößte durch den Zweitkleinsten usw.
     */
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
}
