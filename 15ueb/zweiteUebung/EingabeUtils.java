/**
 * <h1> EingabeUtils </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class EingabeUtils {

	/**
	 * This method is used to create the scanner
	 */
	public static Scanner scanOpen(){
		Scanner scanner = new Scanner(System.in);
		return scanner;
    	}

	/**
	 * This mehtod is used to close the scanner 
	 */
    	public static void scanClose(Scanner scanner){
		scanner.close();
    	}

	/**
	 * This methode is used to scann the value of the input and check
	 * if it is a String else it will give an error 
	 * @param scanner scanns a string
	 * @return the user input as a string 
	 */
	public static String scanString(Scanner scanner){
		String userInput;
		try {
			userInput = scanner.next();
            		scanner.nextLine();
		} catch (InputMismatchException e){
            		scanner.nextLine();
			throw new IllegalArgumentException("Input has to be a String");
		}
		return userInput;
	}

	/**
	 * This methode is used to scann the value of the input and check
	 * if it is a Int else it will give an error 
	 * @param scanner scanns an int
	 * @return the user input as a int
	 */
    	public static int scanInt(Scanner scanner){
        	int userInput;
        	try {
            		userInput = scanner.nextInt();
            		scanner.nextLine();
        	} catch (InputMismatchException e){
            		scanner.nextLine();
            		throw new IllegalArgumentException("Input has to be an Integer");
        	}
        	return userInput;
    	}

	/**
	 * This methode is used to scann the value of the input and check
	 * if it is a long else it will give an error 
	 * @param scanner scanns a long
	 * @return the user input as a long
	 */
    	public static long scanLong(Scanner scanner){
		long userInput;
		try{
		    	userInput = scanner.nextLong();
		    	scanner.nextLine();
		} catch (InputMismatchException e){
		    	scanner.nextLine();
		    	throw new IllegalArgumentException("Input has to be a Long");
		}
		return userInput;
    	}

	/**
	 * This methode is used to scann the value of the input and check
	 * if it is a double else it will give an error 
	 * @param scanner scanns a double
	 * @return the user input as a double
	 */
    	public static double scanDouble(Scanner scanner){
        	double userInput;
        	try{
            		userInput = scanner.nextDouble();
            		scanner.nextLine();
        	} catch (InputMismatchException e){
            		scanner.nextLine();
            		throw new IllegalArgumentException("Input has to be a Double");
        	}
        	return userInput;
    	}

	/**
	 * This methode is used to scann the value of the input and check
	 * if it is a short else it will give an error 
	 * @param scanner scanns a short
	 * @return the user input as a short
	 */
    	public static short scanShort(Scanner scanner){
		short userInput;
		try{
		    	userInput = scanner.nextShort();
		    	scanner.nextLine();
		} catch (InputMismatchException e){
		    	scanner.nextLine();
		    	throw new IllegalArgumentException("Input has to be a Short");
		}    
		return userInput;
	}

	/**
	 * This methode is used to scann the value of the input and check
	 * if it is a float else it will give an error 
	 * @param scanner scanns a float
	 * @return the user input as a float 
	 */
    	public static float scanFloat(Scanner scanner){
		float userInput;
		try{
			userInput = scanner.nextFloat();
		    	scanner.nextLine();
		} catch (InputMismatchException e){
		    	scanner.nextLine();
		    	throw new IllegalArgumentException("Input has to be a Float");
		}
		return userInput;
	}

	/**
	 * This methode is used to scann the value of the input and check
	 * if it is a boolean else it will give an error 
	 * @param scanner scanns a boolean
	 * @return the user input as a boolean
	 */
    	public static boolean scanBoolean(Scanner scanner){
        	boolean userInput; 
        	try{
            		userInput = scanner.nextBoolean();
            		scanner.nextLine();
        	} catch (InputMismatchException e){
            		scanner.nextLine();
            		throw new IllegalArgumentException("Input has to be a Boolean");
        	}
        	return userInput;
    	}

}
