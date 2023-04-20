import java.util.InputMismatchException;
import java.util.Scanner;

public class EingabeUtils {
    public static Scanner scanOpen(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
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
    public static Float scanFloat(Scanner scanner){
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
    public static Boolean scanBoolean(Scanner scanner){
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
    public static void scanClose(Scanner scanner){


    }
}