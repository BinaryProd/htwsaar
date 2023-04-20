/**
 * <h1> GcdDialog </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class GcdDialog {

    // private fields for various menu options and their corresponding int and
    // String values
    private static final int GCD = 1;
    private static final int EXIT = 10;

    private static final String GCD_STRING = " : Gcd berechnen";
    private static final String EXIT_STRING = " : Das Programm beenden";

    private Scanner scanner = EingabeUtils.scanOpen();

    /**
     * The main function starts a new Dialog object.
     */
    public static void main(String[] args) {
        new GcdDialog().start();
    }

    /**
     * The start method is the main loop of the program. It initializes the lager to
     * null and prompts the user for input to interact with the program and its. The
     * method also includes exception handling for illegal argument, input mismatch,
     * and general exceptions.
     */
    public void start() {

        int userInput = 0;

        while (userInput != EXIT) {
            try {
                gcdMenuAusgabe();
                userInput = eingabeLesen();
                gcdEingabeBearbeitung(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }

        }

    }

    /**
     * This method is used to print the different choices for interacting with the
     * Dialog. It uses a StringBuilder to append the different menu options and
     * their corresponding int and string values and prints them to the console.
     */
    public void gcdMenuAusgabe() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n").append(GCD).append(GCD_STRING)
            .append("\n").append(EXIT).append(EXIT_STRING).append("\n")
            .append(">>> ");

        System.out.print(sb.toString());

    }

    /**
     * This method is used to read the user input and return it
     * 
     * @return userInput as an Integer
     */
    public int eingabeLesen() {
        return EingabeUtils.scanInt(scanner);
    }

    /**
     * This method is used to execute the user choice.
     * 
     * @param userInput The input from the user
     */
    public void gcdEingabeBearbeitung(int userInput) {
        switch (userInput) {
            case GCD:
                gcd();
                break;
            case EXIT:
                System.out.println("Das Programm wird beendet");
                EingabeUtils.scanClose(scanner);
                break;
            default:
                System.out.println(userInput + " ist keine gültige Nummer !");
                break;
        }
    }

    /**
     * This method give the gcd of the two number giving by the user
     */
    public void gcd() {
        System.out.println("Erste zahl:");
        System.out.print(">>> ");
        long zahl1 = EingabeUtils.scanLong(scanner);

        System.out.println("Zweite zahl:");
        System.out.print(">>> ");
        long zahl2 = EingabeUtils.scanLong(scanner);

        System.out.println(Gcd.gcd(zahl1, zahl2));
    }

}
