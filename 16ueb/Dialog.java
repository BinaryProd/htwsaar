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
import java.util.ArrayList;
import java.util.List;

public class Dialog {
    private static final int GETRAENKEAUTOMAT_INT = 0;
    private static final int ALKOHOLISCHE_GETRAENKEAUTOMAT_INT = 1;
    private static final int ALKOHOLFREIE_GETRAENKEAUTOMAT_INT = 2;
    private static final int WASSER_GETRAENKEAUTOMAT_INT = 3;
    private static final int SOFTDRINK_GETRAENKEAUTOMAT_INT = 4;
    private static final int BIER_GETRAENKEAUTOMAT_INT = 5;
    private static final int WEIN_GETRAENKEAUTOMAT_INT = 6;
    private static final int ROTWEIN_GETRAENKEAUTOMAT_INT = 7;
    private static final int WEISSWEIN_GETRAENKEAUTOMAT_INT = 8;

    private static final String GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat anlegen";
    private static final String ALKOHOLISCHE_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit alkoholischen Getraenken anlegen";
    private static final String ALKOHOLFREIE_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit alkoholfreien Getraenken anlegen";
    private static final String WASSER_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Wasser anlegen";
    private static final String SOFTDRINK_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Softdrinks anlegen";
    private static final String BIER_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Bier anlegen";
    private static final String WEIN_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Wein anlegen";
    private static final String ROTWEIN_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Rotwein anlegen";
    private static final String WEISSWEIN_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Weisswein anlegen";

    private static final int FLASCHE_EINLEGEN_INT = 9;
    private static final int FLASCHE_AUSGEBEN_INT = 10;
    private static final int GETRAENKE_AUSGEBEN_INT = 11;

    private static final String FLASCHE_EINLEGEN_STRING = " : Eine Flasche in den Getraenkeautomat einlegen";
    private static final String FLASCHE_AUSGEBEN_STRING = " : Eine Flasche aus dem Getraenkeautomat ausgeben";
    private static final String GETRAENKE_AUSGEBEN_STRING = " : Die Getraenke im Getraenkeautomat ausgeben";

    private static final int EXIT_INT = 12;
    private static final String EXIT_STRING = " : Programm beenden";

    private static final int WASSER_INT = 0;
    private static final int SOFTDRINK_INT = 1;
    private static final int BIER_INT = 2;
    private static final int WEIN_INT = 3;
    private static final int ROTWEIN_INT = 4;
    private static final int WEISSWEIN_INT = 5;

    private static final String WASSER_STRING = "Wasser";
    private static final String SOFTDRINK_STRING = "Softdrink";
    private static final String BIER_STRING = "Bier";
    private static final String WEIN_STRING = "Wein";
    private static final String ROTWEIN_STRING = "Rotwein";
    private static final String WEISSWEIN_STRING = "Weisswein";

    private Getraenkeautomat<Getraenk> getraenkeautomat;
    private Getraenkeautomat<AlkoholischesGetraenk> alkoholischeGetraenkeautomat;
    private Getraenkeautomat<AlkoholfreiesGetraenk> alkoholfreieGetraenkeautomat;
    private Getraenkeautomat<Wasser> wasserGetraenkeautomat;
    private Getraenkeautomat<Softdrink> softdrinkGetraenkeautomat;
    private Getraenkeautomat<Bier> bierGetraenkeautomat;
    private Getraenkeautomat<Wein> weinGetraenkeautomat;
    private Getraenkeautomat<Rotwein> rotweinGetraenkeautomat;
    private Getraenkeautomat<Weisswein> weissweinGetraenkeautomat;

    private String[] menuAusgabeArray = {
        GETRAENKEAUTOMAT_STRING, 
        ALKOHOLISCHE_GETRAENKEAUTOMAT_STRING, 
        ALKOHOLFREIE_GETRAENKEAUTOMAT_STRING, 
        WASSER_GETRAENKEAUTOMAT_STRING, 
        SOFTDRINK_GETRAENKEAUTOMAT_STRING, 
        BIER_GETRAENKEAUTOMAT_STRING, 
        WEIN_GETRAENKEAUTOMAT_STRING, 
        ROTWEIN_GETRAENKEAUTOMAT_STRING, 
        WEISSWEIN_GETRAENKEAUTOMAT_STRING, 
    };

    private String[] menuAusgabeArray2 = {
        FLASCHE_EINLEGEN_STRING, 
        FLASCHE_AUSGEBEN_STRING, 
        GETRAENKE_AUSGEBEN_STRING
    };

    private Getraenkeautomat[] getraenkeautomatArray = {
        this.getraenkeautomat, 
        this.alkoholischeGetraenkeautomat, 
        this.alkoholfreieGetraenkeautomat, 
        this.wasserGetraenkeautomat, 
        this.softdrinkGetraenkeautomat, 
        this.bierGetraenkeautomat, 
        this.weinGetraenkeautomat, 
        this.rotweinGetraenkeautomat, 
        this.weissweinGetraenkeautomat
    };

    private String[] flaschenArray = {
        WASSER_GETRAENKEAUTOMAT_STRING, 
        SOFTDRINK_GETRAENKEAUTOMAT_STRING, 
        BIER_GETRAENKEAUTOMAT_STRING, 
        WEIN_GETRAENKEAUTOMAT_STRING, 
        ROTWEIN_GETRAENKEAUTOMAT_STRING, 
        WEISSWEIN_GETRAENKEAUTOMAT_STRING
    };

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

        userInput = 0;

        while (userInput != EXIT_INT) {
            try {
                MenuAusgabeErstellen();
                userInput = eingabeLesen();
                EingabeBearbeitung(userInput);
            } catch(FlascheException e) {
                System.out.println(e);
            } catch(GetraenkeautomatException e) {
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
        
        sb.append("\n");

        boolean isGetraenkeautomatNotEmpty = false;
        for ( int i = 0; i < getraenkeautomatArray.length; i++) {
            if (getraenkeautomatArray[i] == null) {
                sb.append(i).append(menuAusgabeArray[i]).append("\n");
            } else {
                isGetraenkeautomatNotEmpty = true;
            }
        }

        if (isGetraenkeautomatNotEmpty) {
            for ( int i = 0; i < menuAusgabeArray2.length; i++) {
                sb.append(getraenkeautomatArray.length + i).append(menuAusgabeArray2[i]).append("\n");
            }
        }

        
        sb.append(getraenkeautomatArray.length + menuAusgabeArray2.length).append(EXIT_STRING).append("\n")
            .append(">>> ");

        System.out.print(sb.toString());
    } 


    /**
     * This method is used to handle the user input.
     * @param userInput
     */
    public void EingabeBearbeitung(int userInput) {
        if (userInput >= 0 && userInput < getraenkeautomatArray.length) {
            if (getraenkeautomatArray[userInput] == null) {
                System.out.println("Bitte geben Sie die Kapazität des Getränkeautomaten ein: ");
                int capacity = eingabeLesen();
                while (capacity <= 0) {
                    System.out.println("Bitte geben Sie eine gültige Kapazituet ein: ");
                    capacity = eingabeLesen();
                }

                switch(userInput) {
                    case GETRAENKEAUTOMAT_INT:
                        getraenkeautomatArray[userInput] = new Getraenkeautomat<Getraenk>(capacity);
                        break;
                    case ALKOHOLISCHE_GETRAENKEAUTOMAT_INT:
                        getraenkeautomatArray[userInput] = new Getraenkeautomat<AlkoholischesGetraenk>(capacity);
                        break;
                    case ALKOHOLFREIE_GETRAENKEAUTOMAT_INT:
                        getraenkeautomatArray[userInput] = new Getraenkeautomat<AlkoholfreiesGetraenk>(capacity);
                        break;
                    case WASSER_GETRAENKEAUTOMAT_INT:
                        getraenkeautomatArray[userInput] = new Getraenkeautomat<Wasser>(capacity);
                        break;
                    case SOFTDRINK_GETRAENKEAUTOMAT_INT:
                        getraenkeautomatArray[userInput] = new Getraenkeautomat<Softdrink>(capacity);
                        break;
                    case BIER_GETRAENKEAUTOMAT_INT:
                        getraenkeautomatArray[userInput] = new Getraenkeautomat<Bier>(capacity);
                        break;
                    case WEIN_GETRAENKEAUTOMAT_INT:
                        getraenkeautomatArray[userInput] = new Getraenkeautomat<Wein>(capacity);
                        break;
                    case ROTWEIN_GETRAENKEAUTOMAT_INT:
                        getraenkeautomatArray[userInput] = new Getraenkeautomat<Rotwein>(capacity);
                        break;
                    case WEISSWEIN_GETRAENKEAUTOMAT_INT:
                        getraenkeautomatArray[userInput] = new Getraenkeautomat<Weisswein>(capacity);
                        break;
                    default:
                        System.out.println(userInput + " ist keine gueltige Nummer !");
                        break;
                }
            } else {
                System.out.println("Getraenkeautomat " + menuAusgabeArray[userInput] + " ist bereits vorhanden !");
            }
        } else if (userInput >= getraenkeautomatArray.length && userInput < getraenkeautomatArray.length + menuAusgabeArray2.length) {
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
                default:
                    System.out.println(userInput + " ist keine gueltige Nummer !");
                    break;
            }
        } else if (userInput == EXIT_INT) {
            System.out.println("\nProgramm wird beendet");
            EingabeUtils.scanClose(scanner);
        } else {
            System.out.println(userInput + " ist keine gueltige Nummer !");
        }
    }

    /**
     * This method is used to add a bottle to the vending machine.
     */
    public void FlascheEinlegen() {
        Integer userInput = getraenkeautomatNotNullAsugeben();

        List<Integer> list = new ArrayList<Integer>();
        
        switch(userInput) {
            case GETRAENKEAUTOMAT_INT:
                list.add(WASSER_INT);
                list.add(SOFTDRINK_INT);
                list.add(BIER_INT);
                list.add(WEIN_INT);
                list.add(ROTWEIN_INT);
                list.add(WEISSWEIN_INT);
                break;
            case ALKOHOLISCHE_GETRAENKEAUTOMAT_INT:
                list.add(BIER_INT);
                list.add(WEIN_INT);
                list.add(ROTWEIN_INT);
                list.add(WEISSWEIN_INT);
                break;
            case ALKOHOLFREIE_GETRAENKEAUTOMAT_INT:
                list.add(WASSER_INT);
                list.add(SOFTDRINK_INT);
                break;
            case WASSER_GETRAENKEAUTOMAT_INT:
                list.add(WASSER_INT);
                break;
            case SOFTDRINK_GETRAENKEAUTOMAT_INT:
                list.add(SOFTDRINK_INT);
                break;
            case BIER_GETRAENKEAUTOMAT_INT:
                list.add(BIER_INT);
                break;
            case WEIN_GETRAENKEAUTOMAT_INT:
                list.add(WEIN_INT);
                list.add(ROTWEIN_INT);
                list.add(WEISSWEIN_INT);
                break;
            case ROTWEIN_GETRAENKEAUTOMAT_INT:
                list.add(ROTWEIN_INT);
                break;
            case WEISSWEIN_GETRAENKEAUTOMAT_INT:
                list.add(WEISSWEIN_INT);
                break;
            default:
                System.out.println(userInput + " ist keine gueltige Nummer !");
                break;
        }


        System.out.println("Bitte geben Sie die Art der Flasche ein: ");
        StringBuilder sb2 = new StringBuilder();
        for ( int i = 0; i < flaschenArray.length; i++) {
            if (list.contains(i)) {
                sb2.append(i).append(" ").append(flaschenArray[i]).append("\n");
            }
        }
        sb2.append(">>> ");
        System.out.print(sb2.toString());

        int userInput2 = eingabeLesen();
        while (!list.contains(userInput2)) {
            System.out.println("Bitte geben Sie eine gueltige Nummer ein: ");
            userInput2 = eingabeLesen();
        }

        Flasche[] flasche = new Flasche[1];
        switch(userInput2) {
            case WASSER_INT:
                Wasser wasser = wasserEinlegen();
                Flasche<Wasser> flascheWasser = new Flasche<Wasser>(wasser);
                flasche[0] = flascheWasser;
                break;
            case SOFTDRINK_INT:
                Softdrink softdrink = softdrinkEinlegen();
                Flasche<Softdrink> flascheSoftdrink = new Flasche<Softdrink>(softdrink);
                flasche[0] = flascheSoftdrink;
                break;
            case BIER_INT:
                Bier bier = bierEinlegen();
                Flasche<Bier> flascheBier = new Flasche<Bier>(bier);
                flasche[0] = flascheBier;
                break;
            case WEIN_INT:
                Wein wein = weinEinlegen();
                Flasche<Wein> flascheWein = new Flasche<Wein>(wein);
                flasche[0] = flascheWein;
                break;
            case ROTWEIN_INT:
                Rotwein rotwein = rotweinEinlegen();
                Flasche<Rotwein> flascheRotwein = new Flasche<Rotwein>(rotwein);
                flasche[0] = flascheRotwein;
                break;
            case WEISSWEIN_INT:
                Weisswein weisswein = weissweinEinlegen();
                Flasche<Weisswein> flascheWeisswein = new Flasche<Weisswein>(weisswein);
                flasche[0] = flascheWeisswein;
                break;
            default:
                System.out.println(userInput2 + " ist keine gueltige Nummer !");
                break;
            }
            
        try {
            getraenkeautomatArray[userInput].flascheEinlegen(flasche[0]);
        } catch (FlascheException e) {
            System.out.println(e.getMessage());
        } catch (GetraenkeautomatException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Probablement pas le droit");
        }
             

    }

    /**
     * This method is used to create a Wasser bottle.
     * @return Wasser
     */
    public Wasser wasserEinlegen() {
        System.out.println("Bitte geben Sie den Hersteller des Wassers ein: ");
        String hersteller = EingabeUtils.scanString(scanner);
        System.out.println("Bitte geben Sie die Quelle des Wassers ein: ");
        String quelle = EingabeUtils.scanString(scanner);

        String name = name();
        if (!name.equals("")) {
            return new Wasser(name, hersteller, quelle);
        }

        return new Wasser(hersteller, quelle);
        
    }

    /**
     * This method is used to create a Softdrink bottle.
     * @return Softdrink
     */
    public Softdrink softdrinkEinlegen() {
        System.out.println("Bitte geben Sie den Hersteller des Softdrink ein: ");
        String hersteller = EingabeUtils.scanString(scanner);
        System.out.println("Bitte geben Sie den Zuckergehalt des Softdrink ein: ");
        float Zuckergehalt = EingabeUtils.scanFloat(scanner);

        String name = name();
        if (!name.equals("")) {
            return new Softdrink(name, hersteller, Zuckergehalt);
        }

        return new Softdrink(hersteller, Zuckergehalt);
    }

    /**
     * This method is used to create a Bier bottle.
     * @return Bier
     */
    public Bier bierEinlegen() {
        System.out.println("Bitte geben Sie die Brauerei des Biers ein: ");
        String brauerei = EingabeUtils.scanString(scanner);
        System.out.println("Bitte geben Sie den Alkoholgehalt des Biers ein: ");
        float Alkoholgehalt = EingabeUtils.scanFloat(scanner);

        String name = name();
        if (!name.equals("")) {
            return new Bier(name, Alkoholgehalt, brauerei);
        }

        return new Bier(Alkoholgehalt, brauerei);
    }

    /**
     * This method is used to create a Wein bottle.
     * @return Wein
     */
    public Wein weinEinlegen() {
        System.out.println("Bitte geben Sie den Weingut des Weins ein: ");
        String weingut = EingabeUtils.scanString(scanner);
        System.out.println("Bitte geben Sie den Alkoholgehalt des Weins ein: ");
        float Alkoholgehalt = EingabeUtils.scanFloat(scanner);

        String name = name();
        if (!name.equals("")) {
            return new Wein(name, Alkoholgehalt, weingut);
        }

        return new Wein(Alkoholgehalt, weingut);
    }

    /**
     * This method is used to create a Rotwein bottle.
     * @return Rotwein
     */
    public Rotwein rotweinEinlegen() {
        System.out.println("Bitte geben Sie den Weingut des Rotweins ein: ");
        String weingut = EingabeUtils.scanString(scanner);
        System.out.println("Bitte geben Sie den Alkoholgehalt des Rotweins ein: ");
        float Alkoholgehalt = EingabeUtils.scanFloat(scanner);

        String name = name();
        if (!name.equals("")) {
            return new Rotwein(name, Alkoholgehalt, weingut);
        }

        return new Rotwein(Alkoholgehalt, weingut);
    }

    /**
     * This method is used to create a Weisswein bottle.
     * @return Weisswein
     */
    public Weisswein weissweinEinlegen() {
        System.out.println("Bitte geben Sie den Weingut des Weissweins ein: ");
        String weingut = EingabeUtils.scanString(scanner);
        System.out.println("Bitte geben Sie den Alkoholgehalt des Weissweins ein: ");
        float Alkoholgehalt = EingabeUtils.scanFloat(scanner);

        String name = name();
        if (!name.equals("")) {
            return new Weisswein(name, Alkoholgehalt, weingut);
        }
        return new Weisswein(Alkoholgehalt, weingut);
    }

    /**
     * This method is used to create a name for a bottle.
     * @return String
     */
    public String name() {
        System.out.println("Moechten Sie einen Namen fuer den Softdrink eingeben? (y/n)");
        String userInput = EingabeUtils.scanString(scanner);
        String name = "";
        if (userInput.equals("y")) {
            System.out.println("Bitte geben Sie den Namen des Softdrink ein: ");
            name = EingabeUtils.scanString(scanner);
        } 

        return name;
    }

    /**
     * This method is used to output and remove a bottle from the vending machine.
     */
    public void FlascheAusgeben() {
        Integer userInput = getraenkeautomatNotNullAsugeben();
        
        try {
            System.out.println(getraenkeautomatArray[userInput].flascheAusgeben());
            if (getraenkeautomatArray[userInput].istEmpty()) {
                getraenkeautomatArray[userInput] = null;
            }
        } catch (FlascheException e) {
            System.out.println(e.getMessage());
        } catch (GetraenkeautomatException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("something");
        }
    }

    /**
     * This method is used to output a bottle from the vending machine.
     */
    public void GetraenkeAusgeben() {
        Integer userInput = getraenkeautomatNotNullAsugeben();

        try {
            System.out.println(getraenkeautomatArray[userInput]);
        } catch (FlascheException e) {
            System.out.println(e.getMessage());
        } catch (GetraenkeautomatException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("something");
        }
    }

    /**
     * This method is used to output the menu.
     */
    public Integer getraenkeautomatNotNullAsugeben() {
        List<Integer> list = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Bitte geben Sie die Nummer des Getreankeautomat ein: \n");
        for (int i = 0; i < getraenkeautomatArray.length; i++) {
            if (getraenkeautomatArray[i] != null) {
                String output = menuAusgabeArray[i].substring(1, menuAusgabeArray[i].toString().length() - 8);
                sb.append(i).append(output).append("\n");
                list.add(i);
            }
        }

        System.out.println(sb.toString());

        int userInput = eingabeLesen();
        while (!list.contains(userInput)) {
            System.out.println("Bitte geben Sie eine gueltige Nummer ein: ");
            userInput = eingabeLesen();
        }
        return userInput;
    }
}
