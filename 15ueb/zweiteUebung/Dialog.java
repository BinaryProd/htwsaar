/**
 * The QueueDialog class is a class that allows the user, 
 * to interact with a bla  and its bla
 * through a command line interface.
 * It includes functionality to create and remove bla, 
 * blu and blo , change blo of bla, 
 * and retrieve information about the bli and its bla. 
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2023-01-12
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Dialog {
    private static final int ANONYM_ANLEGEN_INT = 1;
    private static final int TOPLEVEL_ANLEGEN_INT = 2;
    private static final int EXIT_INT = 3;

    private static final String ANONYM_ANLEGEN_STRING = " : Number Cruncher Anonym anlegen";
    private static final String TOPLEVEL_ANLEGEN_STRING = " : Number Cruncher Top Level anlegen";
    private static final String EXIT_STRING = " : Programm beenden";

    private static final int SUM_INT = 1;
    private static final int SWIRL_INT = 2;
    private static final int DIVIDE_INT = 3;
    private static final int SUBTRACT_INT = 4;
    private static final int AVERAGE_INT = 5;
    private static final int MULTIPLE_THINGS_INT = 6;
    private static final int PRINT_INT = 7;
    private static final int REMOVE_INT = 8;

    private static final String SUM_STRING = " : Elemente Sumen anfügen";
    private static final String SWIRL_STRING = " : Elemente zufaelig Vertauschen";
    private static final String DIVIDE_STRING = " : Elemente teilen";
    private static final String SUBTRACT_STRING = " : Elemente minux machen";
    private static final String AVERAGE_STRING = " : Durschnitt bestimmen";
    private static final String MULTIPLE_STRING = " : Mehrere Operationen machen";
    private static final String PRINT_STRING = " : Liste ausgeben";
    private static final String REMOVE_STRING = " : Alles entfernen";

    private static final String SUM = "sum";
    private static final String SWIRL = "swirl";
    private static final String DIVIDE = "divide";
    private static final String SUBTRACT = "subtract";
    private static final String AVERAGE = "average";

    private NumberCruncherAnonym numberAnonym;
    private NumberCruncherTopLevel numberTopLevel;
    private int userInput;
    private Scanner scanner = EingabeUtils.scanOpen();

    /**
     * The main function starts a new QueueDialog object.
     */
    public static void main( String[] args) {
        new Dialog().start();
    }

    /**
     * This method is used to read the user input and return it
     * @return userInput as an Integer
     */
    public int eingabeLesen() {
        int userInput = EingabeUtils.scanInt(scanner);
        return userInput;
    }

    /**
     * The start method is the main loop of the program. It initializes the queue to null and prompts the user for input to interact with the Queue and its Artikel. 
     * The method also includes exception handling for illegal argument, input mismatch, and general exceptions.
     */
    public void start() {

        this.numberAnonym = null;
        this.numberAnonym = null;
        userInput = 0;

        while (userInput != EXIT_INT) {
            try {
                ErstellenMenuAusgabe();
                userInput = eingabeLesen();
                ErstellenEingabeBearbeitung(userInput);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                scanner.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }

        }

    }

    /**
     * This method is used to print the different choices for interacting with the Queue and its Artikel.
     * It uses a StringBuilder to append the different menu options and their corresponding int and string values and prints them to the console.
     */
    public void ErstellenMenuAusgabe() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n")
            .append(ANONYM_ANLEGEN_INT).append(ANONYM_ANLEGEN_STRING).append("\n")
            .append(TOPLEVEL_ANLEGEN_INT).append(TOPLEVEL_ANLEGEN_STRING).append("\n")
            .append(EXIT_INT).append(EXIT_STRING).append("\n")
            .append(">>> ");

        System.out.print(sb.toString());
    } 

    public void ErstellenEingabeBearbeitung(int userInput) {
        switch(userInput) {
            case ANONYM_ANLEGEN_INT:
                AnonymAnlegen();
                Bearbeiten();
                break;
            case TOPLEVEL_ANLEGEN_INT:
                TopLevelAnlegen();
                Bearbeiten();
                break;
            case EXIT_INT:
                System.out.println("Programm wird beendet");
                EingabeUtils.scanClose(scanner);
                break;
            default:
                System.out.println(userInput + " ist keine gültige Nummer !");
                break;
        }
    }

    public void Bearbeiten(){
        userInput = 0;
        while (userInput != REMOVE_INT) {
            try {
                MenuAusgabe();
                userInput = eingabeLesen();
                EingabeBearbeitung(userInput);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                scanner.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }

        }
    }


    public void MenuAusgabe(){
        StringBuilder sb = new StringBuilder();    

        sb.append("\n")    
            .append(SUM_INT).append(SUM_STRING).append("\n")
            .append(SWIRL_INT).append(SWIRL_STRING).append("\n")
            .append(DIVIDE_INT).append(DIVIDE_STRING).append("\n")
            .append(SUBTRACT_INT).append(SUBTRACT_STRING).append("\n")
            .append(AVERAGE_INT).append(AVERAGE_STRING).append("\n")
            .append(MULTIPLE_THINGS_INT).append(MULTIPLE_STRING).append("\n")
            .append(PRINT_INT).append(PRINT_STRING).append("\n")
            .append(REMOVE_INT).append(REMOVE_STRING).append("\n")
            .append(">>> ");

        System.out.print(sb.toString());    

    }

    /**
     * This method is used to execute the user choice.
     * @param userInput The input from the user
     */
    public void EingabeBearbeitung(int userInput) {
        switch (userInput) {
            case SUM_INT:
                sum();
                break;
            case SWIRL_INT:
                swirl();
                break;
            case DIVIDE_INT:
                divide();
                break;
            case SUBTRACT_INT:
                subtract();
                break;
            case AVERAGE_INT:
                average();
                break;
            case MULTIPLE_THINGS_INT:
                multipleThings();
                break;
            case PRINT_INT:
                print();
                break;
            case REMOVE_INT:
                System.out.println("Der Number Cruncher wird entfernt, und es wird zurück zum Hauptmenü gewechselt");
                this.numberAnonym = null;
                this.numberTopLevel = null;
                break;
            default:
                System.out.println(userInput + " ist keine gültige Nummer !");
                break;
        }
    }


    /**
     * This method is used to create a new StringQueue object and assign it to the queue variable.
     */
    public void AnonymAnlegen() {
        float[] floatArray = createFloatArray();
        this.numberAnonym = new NumberCruncherAnonym(floatArray);
        System.out.println("Das Array wurde erstellt");
    }

    /**
     * This method is used to create a new PersonQueue object and assign it to the queue variable.
     */
    public void TopLevelAnlegen() {
        float[] floatArray = createFloatArray();
        this.numberTopLevel = new NumberCruncherTopLevel(floatArray);
        System.out.println("Die PersonQueue wurde angelegt");
    }

    public float[] createFloatArray() {
        System.out.println("Möchten Sie ein Array von float manuell oder automatisch erstellen ? (m/a)");
        String userInput = EingabeUtils.scanString(scanner);

        while (!userInput.equals("m") && !userInput.equals("a")) {
            System.out.println("Bitte geben Sie m oder a ein !");
            userInput = EingabeUtils.scanString(scanner);
        }

        if (userInput.equals("m")) {
            System.out.println("Wie viele float möchten Sie in Ihrem Array haben ?");

            int arrayLength = EingabeUtils.scanInt(scanner);
            float[] floatArray = new float[arrayLength];

            for (int i = 0; i < arrayLength; i++) {
                System.out.println("Bitte geben Sie den " + (i + 1) + ". float ein");
                floatArray[i] = EingabeUtils.scanFloat(scanner);
            }

            return floatArray;

        } else {
            System.out.println("Wie viele float möchten Sie in Ihrem Array haben ?");

            int arrayLength = EingabeUtils.scanInt(scanner);
            float[] floatArray = new float[arrayLength];

            for (int i = 0; i < arrayLength; i++) {
                floatArray[i] = (float) Math.random() * 100;
            }

            return floatArray;
        }
    }

    public void sum() {
        String[] stringArray = new String[1];
        stringArray[0] = SUM;
        if ( numberAnonym != null ) {
            numberAnonym.crunch(stringArray);
        } else {
            numberTopLevel.crunch(stringArray);
        }
    }

    public void swirl() {
        String[] stringArray = new String[1];
        stringArray[0] = SWIRL;
        if ( numberAnonym != null ) {
            numberAnonym.crunch(stringArray);
        } else {
            numberTopLevel.crunch(stringArray);
        }
    }

    public void divide() {
        String[] stringArray = new String[1];
        stringArray[0] = DIVIDE;
        if ( numberAnonym != null ) {
            numberAnonym.crunch(stringArray);
        } else {
            numberTopLevel.crunch(stringArray);
        }
    }

    public void subtract() {
        String[] stringArray = new String[1];
        stringArray[0] = SUBTRACT;
        if ( numberAnonym != null ) {
            numberAnonym.crunch(stringArray);
        } else {
            numberTopLevel.crunch(stringArray);
        }
    }

    public void average() {
        String[] stringArray = new String[1];
        stringArray[0] = AVERAGE;
        if ( numberAnonym != null ) {
            numberAnonym.crunch(stringArray);
        } else {
            numberTopLevel.crunch(stringArray);
        }
    }

    public void multipleThings() {
        System.out.println("Wie viele Operationen möchten Sie auf einmal ausführen ?");
        int numberOfThings = EingabeUtils.scanInt(scanner);
        String[] stringArray = new String[numberOfThings];

        for (int i = 0; i < numberOfThings; i++) {
            System.out.println("Welche Operation möchten Sie als " + (i + 1) + ". ausführen ? (sum, swirl, divide, subtract, average)");
             
            String userInput = EingabeUtils.scanString(scanner);
            while (!userInput.equals(SUM) && !userInput.equals(SWIRL) && !userInput.equals(DIVIDE) && !userInput.equals(SUBTRACT) && !userInput.equals(AVERAGE)) {
                System.out.println("Bitte geben Sie eine gültige Operation ein !");
                userInput = EingabeUtils.scanString(scanner);
            }
            stringArray[i] = userInput;
        }
        System.out.println("Diese Operationen werden ausgeführt:" + Arrays.toString(stringArray));
        if ( numberAnonym != null ) {
            numberAnonym.crunch(stringArray);
        } else {
            numberTopLevel.crunch(stringArray);
        }
    }

    public void print() {
        if ( numberAnonym != null ) {
            System.out.println(Arrays.toString(numberAnonym.getNumbers()));
        } else {
            System.out.println(Arrays.toString(numberTopLevel.getNumbers()));
        }
    }

}
