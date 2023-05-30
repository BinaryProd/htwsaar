public class Check {

    public static void checkPositiveNumberOrZero(int i) {
        if ( i < 0 ) {
            throw new MyIllegalArgumentException("i soll eine positive Zahl oder 0 sein"); 
        }
    }

    public static void checkPositiveNumber(int i) {
        if ( i <= 0 ) {
            throw new MyIllegalArgumentException("i soll eine positive Zahl sein"); 
        }
    }
}
