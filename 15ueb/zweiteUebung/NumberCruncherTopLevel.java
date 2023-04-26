public class NumberCruncherTopLevel {
    private float[] numbers;

    public NumberCruncherTopLevel(float[] numbers) {
        this.numbers = numbers;
    }

    public void crunch(String[] operations) {    
        Sum sum = new Sum();
        Substract substract = new Substract();
        Swirl swirl = new Swirl();
        Divide divide = new Divide();
        Average average = new Average();

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
                    substract.crunch(numbers);
                    break;    
                case "average":    
                    average.crunch(numbers);
                    break;    
            }    
        }    
    }

    public float[] getNumbers() {
        return numbers;
    }
}
