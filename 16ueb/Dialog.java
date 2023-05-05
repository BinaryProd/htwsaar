/**
 * <h1> Dialog </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Dialog {
    private static final int ALKOHOLISCHE_GETRAENKE_INT = 1;
    private static final int ALKOHOLFREIE_GETRAENKE_INT = 2;
    private static final int EXIT_INT = 3;

    private static final String ALKOHOLISCHE_GETRAENKE_STRING = " : Getraenkeautomat mit alkoholischen Getraenken anlegen";
    private static final String ALKOHOLFREIE_GETRAENKE_STRING = " : Getraenkeautomat mit alkoholfreien Getraenken anlegen";
    private static final String EXIT_STRING = " : Programm beenden";

    private static final int FLASCHE_EINLEGEN_INT = 1;
    private static final int FLASCHE_AUSGEBEN_INT = 2;
    private static final int GETRAENKE_AUSGEBEN_INT = 3;
    private static final int ZURUECK_INT = 4;

    private static final String FLASCHE_EINLEGEN_STRING = " : Eine Flasche in den Getraenkeautomat einlegen";
    private static final String FLASCHE_AUSGEBEN_STRING = " : Eine Flasche aus dem Getraenkeautomat ausgeben";
    private static final String GETRAENKE_AUSGEBEN_STRING = " : Die Getraenke im Getraenkeautomat ausgeben";
    private static final String ZURUECK_STRING = " : Zurueck zum Hauptmenue";

    private Getraenkeautomat getraenkeautomat;
    private int userInput;
    private Scanner scanner = EingabeUtils.scanOpen();

    /**
     * The main function starts a new Dialog object.
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
     * The start method is the main loop of the program.
     */
    public void start() {

        this.numberAnonym = null;
        this.numberAnonym = null;
        userInput = 0;

        while (userInput != EXIT_INT) {
            try {
                ErstellenMenuAusgabe();
                userInput = eingabeLesen();
                EingabeBearbeitungErstellen(userInput);
            } catch(FlascheException e) {
                System.out.println(e);
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
     * This method is used to print the different choices
     * It uses a StringBuilder to append the different menu options and their corresponding int and string values and prints them to the console.
     */
    public void MenuAusgabeErstellen() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n")
            .append(ALKOHOLISCHE_GETRAENKE_INT).append(ALKOHOLISCHE_GETRAENKE_STRING).append("\n")
            .append(ALKOHOLFREIE_GETRAENKE_INT).append(ALKOHOLFREIE_GETRAENKE_STRING).append("\n")
            .append(EXIT_INT).append(EXIT_STRING).append("\n")
            .append(">>> ");

        System.out.print(sb.toString());
    } 

    public void EingabeBearbeitungErstellen(int userInput) {
        switch(userInput) {
            case ALKOHOLISCHE_GETRAENKE_INT:
                AlkoholischeGetraenkeautomatErstellen();
                Bearbeiten();
                break;
            case ALKOHOLFREIE_GETRAENKE_INT:
                AlkoholfreieGetraenkeautomatErstellen();
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
            } catch(FlascheException e) {
                System.out.println(e);
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

    public void MenuAusgabe() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n")
            .append(FLASCHE_EINLEGEN_INT).append(FLASCHE_EINLEGEN_STRING).append("\n")
            .append(FLASCHE_AUSGEBEN_INT).append(FLASCHE_AUSGEBEN_STRING).append("\n")
            .append(GETRAENKE_AUSGEBEN_INT).append(GETRAENKE_AUSGEBEN_STRING).append("\n")
            .append(ZURUECK_INT).append(ZURUECK_STRING).append("\n")
            .append(">>> ");

        System.out.print(sb.toString());
    }

    public void EingabeBearbeitung(int userInput){
        switch(userInput) {
            case FLASCHE_EINLEGEN_INT:
                FlascheEinlegen();
                break;
            case FLASCHE_AUSGEBEN_INT:
                FlascheAusgeben();
                break;
            case GETRAENKE_AUSGEBEN_INT:
                GetraenkeAusgeben();
                break;
            case ZURUECK_INT:
                MenuAusgabeErstellen();
                this.getraenkeautomat = null;
                break;
            default:
                System.out.println(userInput + " ist keine gültige Nummer !");
                break;
        }
    }

    public void AlkoholischeGetraenkeautomatErstellen() {
        System.out.println("Alkoholische Getraenkeautomat wird erstellt");
        this.getraenkeautomat = new Getraenkeautomat();
    }

    public void AlkoholfreieGetraenkeautomatErstellen() {
        System.out.println("Alkoholfreie Getraenkeautomat wird erstellt");
        this.getraenkeautomat = new Getraenkeautomat();
    }

    public void FlascheEinlegen() {
        System.out.println("Flasche wird eingeleget");
        System.out.println("Bitte geben Sie den Flaschenname ein: ");
        String name = eingabeLesen();
        System.out.println("Bitte geben Sie den Flaschenpreis ein: ");
        double preis = eingabeLesen();
        System.out.println("Bitte geben Sie die Flaschennummer ein: ");

        this.getraenkeautomat.flascheEinlegen(flasche);
    }

}
