/**
 * <h1>Create Objects</h1>
 * Allows the user to use MathFunctions
 * to make some calculation
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.0
 * @since 2022-11-16
 */

import java.lang.Math;
public class MathFunctions{

	private static final double DELTA_NUL = 0.000000001;

	/**
	 * Calculate the sum of the divisor for a number
	 * and return it as a long
	 * @param take the number as a long
	 * @return  the sum of the divisor
	 */
	public static long berechneTeilersumme (long zahl) {
		TestUtils.checkEqualZero(zahl, "zahl");
		TestUtils.checkIsNonNegativ(zahl, "zahl");

		long result = 0;

		if (zahl == 1){
			return 1;
		}

		for (int i = 2; i <= Math.sqrt(zahl); i++) {
			if (zahl % i == 0) {
				if (i == (zahl / i)) {
					result += i;
				} else {
					result += (i + zahl / i);
				}
			}
		}
		return (result + zahl + 1);
	}

	/**
	 * Check if the isbn number giving is a valid ONE 
	 * It just check for ISBN-10
	 * @param  take the isbn number as a long
	 * @return X if the cheked digit is 10 else the value of the digit 
	 */
	public static String berechneChecksummeIsbn(long isbn) {
		TestUtils.checkIsbnInput(isbn);
		
		long result = 0;
		long isbnMod = isbn;
		for (int i = 9; i > 0; i--) {
			long j = isbnMod % 10; // convert to int j
			isbnMod = isbnMod / 10;
			result += j * i;

		}
		result = result % 11;
		if (result == 10) {
			return "X";
		}
		return Long.toString(result);
	}

	/**
	 	* This method is used to Determine the ZEROs of a quadratic  
	* quadratic equation and return them as a formatted string
	 	* @param p is the first value as a double
	 	* @param q is the second value as a double
	* @return x1, x1 and x2 or nothing
	 	*/
	public static String berechneNullstellen (double p, double q) {
		TestUtils.checkBothNumbersZero(p, q);
		double delta = (p * p / 4.0) - q;
		double sqrtdelta = Math.sqrt(delta);
			if (delta >= -DELTA_NUL && delta < DELTA_NUL) {
				double x1 = -p/2.0 + sqrtdelta;;
	 
				return "Doppelte Nullstelle: " + x1;

			} else if (delta < -DELTA_NUL) {
				
				return "Komplexe Nullstellen";
				
			} else {
				double x1 = -p/2.0 + sqrtdelta;;
				double x2 = -p/2.0 - sqrtdelta;
			
				return "Zwei Nullstellen: " + x1 + "|" + x2;
			}
		}

	/**
	 * This method is used to Determine the Ggt
	 * and return them as a int
	 * @param zahl1 takes a number as input that is not 0 or negative
	 * @param zahl2 takes a number as input that is not 0 or negative
	 * @warning if both numbers are 0 it will return an error
	 * @return zahl as the Ggt in int
	 */
	public static int berechneGgt(int zahl1, int zahl2) {
		TestUtils.checkIsNonNegativ(zahl1, "zahl1");
		TestUtils.checkIsNonNegativ(zahl2, "zahl2");
		TestUtils.checkBothNumbersZero(zahl1, zahl2);

		if (zahl1 == 0) {
			return zahl2;
		} else if (zahl2 == 0) {
			return zahl1;
		}
		
		if (zahl2 > zahl1) {
			int temp = zahl2;
			zahl2 = zahl1;
			zahl1 = temp;	
		}

		while (zahl2 != 0) {
			int temp = zahl1;
			zahl1 = zahl2;
			zahl2 = temp % zahl1;

		}

		return Math.abs(zahl1);

	}

	/**
	 * This method is used to calulate the Faktorial of a number
	 * and return them as a long
	 * @param zahl takes a number between 1 and 25 as input
	 * @return sum as the result of the factorial as a long
	 */
	public static long berechneFakultaet(long zahl){
		TestUtils.checkIsNonNegativ(zahl, "zahl");
		TestUtils.checkAboveTwentsix(zahl);

		if (zahl == 0 || zahl == 1) {

			return 1;
		}
		
		long sum = 1;

		while (zahl > 1) {
			sum *= zahl; 
			zahl -= 1;
		}
		
		return sum;
	}
	/**
	 * This method is used to calulate to check if a number
	 * can be written as a^4+b^3+c^2
	 * @param zahl takes a number as input that is not 0 or negative
	 * @return true if it's possible else false
	 */
	public static boolean istSummeVonPotenzen(long zahl) {
		TestUtils.checkEqualZero(zahl, "zahl");
		TestUtils.checkIsNonNegativ(zahl, "zahl");

		double doubleZahl = (double)zahl;
		// double squareRootZahlDouble = Math.sqrt(doubleZahl);
		double cubeRootZahlDouble = Math.cbrt(doubleZahl);
		double quarticRootZahlDouble = Math.pow(doubleZahl, 0.25);

		// long squareRootZahl = (long)squareRootZahlDouble;
		long cubeRootZahl = (long)cubeRootZahlDouble;
		long quarticRootZahl = (long)quarticRootZahlDouble;

		long a, b, c;
		for (long i = 1; i <= quarticRootZahl; i++) {
			a = i * i * i * i;
			for (long j = 1; j <= cubeRootZahl; j++) {
				b = j * j * j;
				c = (long)Math.sqrt(zahl - a - b);
				if(c == 0){
					return false;
				}
				if (zahl == a + b + c * c) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method is used to calulate the sum of a serie
	 * @param anzahl takes a number as input that is not 0 or negative
	 * @param x takes a number as input that is not 0
	 * @return the sum as a double
	 */
	public static double berechneReihensumme(int anzahl, double x) {
		TestUtils.checkEqualZero(anzahl, "anzahl");
		TestUtils.checkEqualZero(x, "x");
		TestUtils.checkIsNonNegativ(anzahl, "anzahl");
		
		double division = (x-1)/x;
		double sum = division;
		double temp = division;
		for (int i = 2; i <= anzahl; ++i) {
			temp *= division;
			sum += temp / i;
		}
		return sum;
	}
}
