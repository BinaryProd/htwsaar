/**
 * <h1> NumberCruncherTopLevel </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class NumberCruncherTopLevel {
    private float[] numbers;

    /**
     * Konstruktor der Klasse NumberCruncherTopLevel
     * @param numbers Array mit float-Werten
     */
    public NumberCruncherTopLevel(float[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Führt die Operationen aus, die in dem String-Array operations übergeben werden.
     * @param operations String-Array mit den Operationen, die ausgeführt werden sollen.
     */
    public void crunch(String[] operations) {    
        CrunchOperation sum = new Sum();
        CrunchOperation subtract = new Subtract();
        CrunchOperation swirl = new Swirl();
        CrunchOperation divide = new Divide();
        CrunchOperation average = new Average();

        for ( String operation: operations) {    
            switch(operation) {    
                case "sum":    
                    sum.crunch(numbers);
                    break;    
                case "swirl":    
                    swirl.crunch(numbers);
                    break;    
                case "divide":    
                    divide.crunch(numbers);
                    break;    
                case "subtract":    
                    subtract.crunch(numbers);
                    break;    
                case "average":    
                    average.crunch(numbers);
                    break;    
            }    
        }    
    }

    /**
     * getter für das Array mit den float-Werten
     * @return Array mit float-Werten
     */
    public float[] getNumbers() {
        return numbers;
    }
}
