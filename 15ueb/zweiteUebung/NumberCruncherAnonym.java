public class NumberCruncherAnonym implements NumberCruncher {
    private float[] numbers;

    public NumberCruncherAnonym(float[] numbers) {
        this.numbers = numbers;
    }

    public void crunch(String[] operations) {
        for (String operation : operations) {
            if (operation.equals("sum")){

            }
        }
    }

    public float[] getNumbers() {
        return numbers;
    }
}
