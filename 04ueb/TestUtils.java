public class TestUtils {
    
    /**
	 * This method is used to check if the value is negativ 
	 * @param zahl this is the value that will be checked 
	 */
    public static void checkIsNonNegativ(long zahl, String name){
        if (zahl < 0){
            throw new IllegalArgumentException("Die Variable " + name + " muss groesser gleich 0 sein.");
        }
    }   

	/**
     * This method is used to check if the value giving is above 26
     * @param zahl the value with wich we will make the calculation with 
     */
    public static void checkAboveTwentsix(long zahl) {
        if (zahl > 26) {
                throw new IllegalArgumentException("Die Zahl darf nicht groesser als 26 sein.");
        }
    }


	/**
     * This method is used to check if the value giving for isbn is isbn-10
     * @param isbn the value with wich we will make the calculation with
     */
	public static void checkIsbnInput(long isbn) {
		if (100000000L > isbn || isbn > 1000000000L) {
		    	throw new IllegalArgumentException("Der ISBN muss 9 Ziffern lang sein");
		}
	}

    /**
     * This method is used to check if the value giving is above one
     * @param zahl the value with wich we will make the calculation 
     */
	public static void checkEqualZero(double zahl, String name) {
		if (zahl == 0.0) {
		    	throw new IllegalArgumentException("Die Variable " + name  + " darf nicht 0 sein.");
		}
	}

    /**
     * This method is used to check if the value from both numbers is equal to zero
     * @param zahl1 the first value with wich we will make the calculation
     * @param zahl2 the second value with wich we will make the calculation  
     */
    public static void checkBothNumbersZero(double zahl1, double zahl2) {
        if (zahl1 == 0 && zahl2 == 0) {
            throw new IllegalArgumentException("Eine der Zahlen kann nicht 0 sein.");
        }
    }
}
