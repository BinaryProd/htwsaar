public class Iterator {
    private int currentIndex;
    private int arrayLength;

    public Iterator(int arrayLength) {
        this.arrayLength = arrayLength;
        currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < arrayLength;
    }

    public void updateIndex() {
        this.currentIndex++;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getArrayLength() {
        return arrayLength;
    }

    public void setCurrentIndex(int new_value) {
        this.currentIndex = new_value;
    }

    public void getArrayLength(int new_value) {
        this.arrayLength = new_value;
    }
}
