public class Check {

    public static void checkNaturalNumber(int i, int j) {
        if ( i < 1 || j < 1 ) {
            throw new MyIllegalArgumentException("j und i sollen natuerliche Zahlen sein"); 
        }
    }
}
