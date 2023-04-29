public class NumberCruncherTopLevel {
    private float[] numbers;

    public NumberCruncherTopLevel(float[] numbers) {
        this.numbers = numbers;
    }

    public void crunch(String[] operations) {    
        CrunchOperation sum = new Sum();
        CrunchOperation substract = new Substract();
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
                case "substract":    
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
