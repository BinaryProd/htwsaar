/**
 * <h1> Dialog </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {

    private Uhrzeit[] uhrzeit;
    private Mitarbeiter[] mitarbeiter;
    private Raum[] raum;
    private int uhrzeitLength, mitarbeiterLength, raumLength = 0;
    private static Scanner scanner = EingabeUtils.scanOpen();

    private static final int ARRAY_GROESSE = 10;

    //private fields for various menu options and their corresponding int and String values
    private static final int CREATE_UHRZEIT = 1;
    private static final int GET_UHRZEIT = 2;
    private static final int CREATE_MITARBEITER = 3;
    private static final int GET_MITARBEITER = 4;
    private static final int CREATE_RAUM = 5;
    private static final int GET_RAUM = 6;
    private static final int RESERVIEREN = 7;
    private static final int RESERVIEREN_VOM_RAUM = 8;
    private static final int EXIT = 10;

    private static final String CREATE_UHRZEIT_STRING = " : Eine Uhrzeit erstellen";
    private static final String GET_UHRZEIT_STRING = " : Information ueber Uhrzeit";
    private static final String CREATE_MITARBEITER_STRING = " : Ein Mitarbeiter erstellen";
    private static final String GET_MITARBEITER_STRING = " : Information ueber Mitarbeiter";
    private static final String CREATE_RAUM_STRING = " : Ein Raum erstellen";
    private static final String GET_RAUM_STRING = " : Information ueber Raum";
    private static final String RESERVIEREN_STRING = " : Reservieren";
    private static final String RESERVIEREN_VOM_RAUM_STRING = " : Reservierung fuer einem Raum ausgeben";
    private static final String EXIT_STRING = " : Das Programm beenden";


    /**
     * The main function starts a new Dialog object.
     */
    public static void main( String[] args) {
        new Dialog().start();
    }

    /**
     * The start method is the main loop of the program. It initializes the lager to null and prompts the user for input to interact with the program and its. 
     * The method also includes exception handling for illegal argument, input mismatch, and general exceptions.
     */
    public void start() {

        uhrzeit= new Uhrzeit[ARRAY_GROESSE];
        raum = new Raum[ARRAY_GROESSE];
        mitarbeiter = new Mitarbeiter[ARRAY_GROESSE];
        int userInput = 0;

        while (userInput != EXIT) {
            try {
                lagerMenuAusgabe();
                userInput = eingabeLesen();
                lagerEingabeBearbeitung(userInput);
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
     * This method is used to print the different choices for interacting with the Dialog.
     * It uses a StringBuilder to append the different menu options and their corresponding int and string values and prints them to the console.
     */
    public void lagerMenuAusgabe() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n")
            .append(CREATE_UHRZEIT).append(CREATE_UHRZEIT_STRING).append("\n")
            .append(GET_UHRZEIT).append(GET_UHRZEIT_STRING).append("\n")
            .append(CREATE_MITARBEITER).append(CREATE_MITARBEITER_STRING).append("\n")
            .append(GET_MITARBEITER).append(GET_MITARBEITER_STRING).append("\n")
            .append(CREATE_RAUM).append(CREATE_RAUM_STRING).append("\n")
            .append(GET_RAUM).append(GET_RAUM_STRING).append("\n")
            .append(RESERVIEREN).append(RESERVIEREN_STRING).append("\n")
            .append(RESERVIEREN_VOM_RAUM).append(RESERVIEREN_VOM_RAUM_STRING).append("\n")
            .append(EXIT).append(EXIT_STRING).append("\n")
            .append(">>> ");

        System.out.print(sb.toString());

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
     * This method is used to execute the user choice.
     * @param userInput The input from the user
     */
    public void lagerEingabeBearbeitung(int userInput) {
        switch (userInput) {
            case CREATE_UHRZEIT:
                createUhrzeit();
                break;
            case GET_UHRZEIT:
                getUhrzeit();
                break;
            case CREATE_MITARBEITER:
                createMitarbeiter();
                break;
            case GET_MITARBEITER:
                getMitarbeiter();
                break;
            case CREATE_RAUM:
                createRaum();
                break;
            case GET_RAUM:
                getRaum();
                break;
            case RESERVIEREN:
                reservieren();
                break;
            case RESERVIEREN_VOM_RAUM:
                reservierungRaumAusgeben();
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
     * Create an Uhrzeit and put it in the uhrzeit array 
     */
    public void createUhrzeit() {
        System.out.println("Stunde:");
        System.out.print(">>> ");
        int stunde = EingabeUtils.scanInt(scanner);

        System.out.println("Minute:");
        System.out.print(">>> ");
        int minute = EingabeUtils.scanInt(scanner);

        if ( uhrzeitLength == uhrzeit.length) {
            //uhrzeit = (Uhrzeit[])ArrayUtils._resizeArray(uhrzeit);
            uhrzeit = ArrayUtils.resizeArray(uhrzeit);
        }
        uhrzeit[ uhrzeitLength] = new Uhrzeit(stunde, minute);
        uhrzeitLength++;
    }

    /**
     * Print the array Uhrzeit if it is not empty
     */
    public void getUhrzeit() {
        if (isEmpty(uhrzeit)) {
            System.out.println("Es gibt noch keine Uhrzeit .");
        } else {
            toPrint(uhrzeit);
        }
    }

    /** 
     * Create an Mitarbeiter and put it in the mitarbeiter array 
     */
    public void createMitarbeiter() {
        System.out.println("Vorname:");
        System.out.print(">>> ");
        String vorname = EingabeUtils.scanString(scanner);

        System.out.println("Nachname:");
        System.out.print(">>> ");
        String nachname = EingabeUtils.scanString(scanner);

        System.out.println("email:");
        System.out.print(">>> ");
        String email = EingabeUtils.scanString(scanner);

        if ( mitarbeiterLength == mitarbeiter.length) {
            //mitarbeiter= (Mitarbeiter[])ArrayUtils._resizeArray(mitarbeiter);
            mitarbeiter= ArrayUtils.resizeArray(mitarbeiter);
        }
        mitarbeiter[mitarbeiterLength] = new Mitarbeiter(vorname, nachname, email);
        mitarbeiterLength++;
    }

    /**
     * Print the array Mitarbeiter if it is not empty
    */
    public void getMitarbeiter() {
        if (isEmpty(mitarbeiter)) {
            System.out.println("Es gibt noch kein Mitarbeiter.");
        } else {
            toPrint(mitarbeiter);
        }
    }

    /** 
     * Create an Raum and put it in the raum array 
     */
    public void createRaum() {
        System.out.println("Gebaude:");
        System.out.print(">>> ");
        int gebaude = EingabeUtils.scanInt(scanner);

        System.out.println("Etage:");
        System.out.print(">>> ");
        int etage = EingabeUtils.scanInt(scanner);

        System.out.println("Raum:");
        System.out.print(">>> ");
        int nummer = EingabeUtils.scanInt(scanner);

        if ( raumLength == raum.length) {
            //raum = (Raum[])ArrayUtils._resizeArray(raum);
            raum = ArrayUtils.resizeArray(raum);
        }
        raum[raumLength] = new Raum(gebaude, etage, nummer);
        raumLength++;
    }

    /**
     * Print the array Raum if it is not empty
    */
    public void getRaum() {
        if (isEmpty(raum)) {
            System.out.println("Es gibt noch kein Raum.");
        } else {
            toPrint(raum); 
        }
    }

    /**
     * Create a new reservierung
    */
    public void reservieren() {
        if ( isEmpty(raum)) {
            System.out.println("Es gibt noch kein Raum.");
        } else if ( isEmpty(mitarbeiter)) {
            System.out.println("Es gibt noch kein Mitarbeiter.");
        } else {
            System.out.println("Den Index vom Mitarbeiter geben");
            System.out.print(">>> ");
            int mitarbeiterIndex = EingabeUtils.scanInt(scanner);
            ArrayUtils.indexIsValid(mitarbeiter, mitarbeiterIndex);
            Mitarbeiter mitarbeite = mitarbeiter[mitarbeiterIndex];

            System.out.println("Den Index vom Raum geben");
            System.out.print(">>> ");
            int raumIndex = EingabeUtils.scanInt(scanner);
            ArrayUtils.indexIsValid(raum, raumIndex);
            Raum raumm = raum[raumIndex];

            System.out.println("Uhrzeit beginn Stunde");
            System.out.print(">>> ");
            int uhrzeitBeginnStunde = EingabeUtils.scanInt(scanner);

            System.out.println("Uhrzeit beginn Minute");
            System.out.print(">>> ");
            int uhrzeitBeginnMinute = EingabeUtils.scanInt(scanner);

            System.out.println("Uhrzeit ende Stunde");
            System.out.print(">>> ");
            int uhrzeitEndeStunde = EingabeUtils.scanInt(scanner);

            System.out.println("Uhrzeit ende Minute");
            System.out.print(">>> ");
            int uhrzeitEndeMinute = EingabeUtils.scanInt(scanner);

            System.out.println("Bemerkung");
            System.out.print(">>> ");
            String bemerkung = EingabeUtils.scanString(scanner);

            mitarbeite.reserviere(
                    raumm, 
                    new Uhrzeit(uhrzeitBeginnStunde, uhrzeitBeginnMinute), 
                    new Uhrzeit(uhrzeitEndeStunde, uhrzeitEndeMinute), 
                    bemerkung
                    );
        }
    }

    public void reservierungRaumAusgeben() {
        if ( isEmpty(raum)) {
            System.out.println("Es gibt noch kein Raum.");
        } else if ( isEmpty(mitarbeiter)) {
            System.out.println("Es gibt noch kein Mitarbeiter.");
        } else {
            System.out.println("Den Index vom Raum geben");
            System.out.print(">>> ");
            int raumIndex = EingabeUtils.scanInt(scanner);
            ArrayUtils.indexIsValid(mitarbeiter, raumIndex);
            Raum choosenRaum = raum[raumIndex];

            System.out.println("Den Index von der Reservierung geben");
            System.out.print(">>> ");
            int reservierungIndex = EingabeUtils.scanInt(scanner);
            Reservierung choosenReservierung = choosenRaum.getReservierung(reservierungIndex);

            System.out.println(choosenReservierung);
        }
    }

    /**
     * Check if the given array has no value inside it
     * return true if the array is empty else false
     *
     * @return boolean 
     */
    public boolean isEmpty(Object[] objArray) {
        for (Object obj : objArray) {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Print the object in the array if there are not null
    */
    public void toPrint(Object[] objArray) {
        for ( Object obj: objArray) {
            if (obj != null) {
                System.out.println(obj);
            }
        }
    }
}
