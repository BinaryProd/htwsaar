
/**
 * <h1> Dialog </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
/*
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Dialog {
    private static final int GETRAENKEAUTOMAT_INT = 1;
    private static final int ALKOHOLISCHE_GETRAENKEAUTOMAT_INT = 2;
    private static final int ALKOHOLFREIE_GETRAENKEAUTOMAT_INT = 3;
    private static final int WASSER_GETRAENKEAUTOMAT_INT = 4;
    private static final int SOFTDRINK_GETRAENKEAUTOMAT_INT = 5;
    private static final int BIER_GETRAENKEAUTOMAT_INT = 6;
    private static final int WEIN_GETRAENKEAUTOMAT_INT = 7;
    private static final int ROTWEIN_GETRAENKEAUTOMAT_INT = 8;
    private static final int WEISSWEIN_GETRAENKEAUTOMAT_INT = 9;
    private static final int EXIT_INT = 10;

    private static final String GETRAENKEAUTOMAT_STRING = "Getraenkeautomat anlegen";
    private static final String ALKOHOLISCHE_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit alkoholischen Getraenken anlegen";
    private static final String ALKOHOLFREIE_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit alkoholfreien Getraenken anlegen";
    private static final String WASSER_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Wasser anlegen";
    private static final String SOFTDRINK_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Softdrinks anlegen";
    private static final String BIER_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Bier anlegen";
    private static final String WEIN_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Wein anlegen";
    private static final String ROTWEIN_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Rotwein anlegen";
    private static final String WEISSWEIN_GETRAENKEAUTOMAT_STRING = " : Getraenkeautomat mit Weisswein anlegen";
    private static final String EXIT_STRING = " : Programm beenden";

    private static final int FLASCHE_EINLEGEN_INT = 1;
    private static final int FLASCHE_AUSGEBEN_INT = 2;
    private static final int GETRAENKE_AUSGEBEN_INT = 3;
    private static final int ZURUECK_INT = 4;

    private static final String FLASCHE_EINLEGEN_STRING = " : Eine Flasche in den Getraenkeautomat einlegen";
    private static final String FLASCHE_AUSGEBEN_STRING = " : Eine Flasche aus dem Getraenkeautomat ausgeben";
    private static final String GETRAENKE_AUSGEBEN_STRING = " : Die Getraenke im Getraenkeautomat ausgeben";
    private static final String ZURUECK_STRING = " : Zurueck zum Hauptmenue";

    private Getraenkeautomat<T> getraenkeautomat;
    private int userInput;
    private Scanner scanner = EingabeUtils.scanOpen();

    public static void main( String[] args) {
        new Dialog().start();
    }

    public int intLesen() {
        int userInput = EingabeUtils.scanInt(scanner);
        return userInput;
    }

    public String stringLesen() {
        String userInput = EingabeUtils.scanString(scanner);
        return userInput;
    }

    public double doubleLesen() {
        double userInput = EingabeUtils.scanDouble(scanner);
        return userInput;
    }

    public float floatLesen() {
        float userInput = EingabeUtils.scanFloat(scanner);
        return userInput;
    }

    public void start() {
        userInput = 0;

        while (userInput != EXIT_INT) {
            try {
                MenuAusgabeErstellen();
                userInput = intLesen();
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

    public void MenuAusgabeErstellen() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n")
            .append(GETRAENKEAUTOMAT_INT).append(GETRAENKEAUTOMAT_STRING).append("\n")
            .append(ALKOHOLISCHE_GETRAENKEAUTOMAT_INT).append(ALKOHOLISCHE_GETRAENKEAUTOMAT_STRING).append("\n")
            .append(ALKOHOLFREIE_GETRAENKEAUTOMAT_INT).append(ALKOHOLFREIE_GETRAENKEAUTOMAT_STRING).append("\n")
            .append(WASSER_GETRAENKEAUTOMAT_INT).append(WASSER_GETRAENKEAUTOMAT_STRING).append("\n")
            .append(SOFTDRINK_GETRAENKEAUTOMAT_INT).append(SOFTDRINK_GETRAENKEAUTOMAT_STRING).append("\n")
            .append(BIER_GETRAENKEAUTOMAT_INT).append(BIER_GETRAENKEAUTOMAT_STRING).append("\n")
            .append(WEIN_GETRAENKEAUTOMAT_INT).append(WEIN_GETRAENKEAUTOMAT_STRING).append("\n")
            .append(ROTWEIN_GETRAENKEAUTOMAT_INT).append(ROTWEIN_GETRAENKEAUTOMAT_STRING).append("\n")
            .append(WEISSWEIN_GETRAENKEAUTOMAT_INT).append(WEISSWEIN_GETRAENKEAUTOMAT_STRING).append("\n")
            .append(EXIT_INT).append(EXIT_STRING).append("\n")
            .append(">>> ");

        System.out.print(sb.toString());
    } 

    public void EingabeBearbeitungErstellen(int userInput) {
        switch(userInput) {
            case GETRAENKEAUTOMAT_INT:
                GetraenkeautomatAnlegen<Getraenke>();
                Bearbeiten();
                break;
            case ALKOHOLISCHE_GETRAENKE_INT:
                GetraenkeautomatAnlegen<AlkoholischesGetraenk>();
                break;
            case ALKOHOLFREIE_GETRAENKE_INT:
                GetraenkeautomatAnlegen<AlkoholfreiesGetraenk>();
                Bearbeiten();
                break;
            case WASSER_GETRAENKEAUTOMAT_INT:
                GetraenkeautomatAnlegen<Wasser>();
                Bearbeiten();
                break;
            case SOFTDRINK_GETRAENKEAUTOMAT_INT:
                GetraenkeautomatAnlegen<Softdrink>();
                Bearbeiten();
                break;
            case BIER_GETRAENKEAUTOMAT_INT:
                GetraenkeautomatAnlegen<Bier>();
                Bearbeiten();
                break;
            case WEIN_GETRAENKEAUTOMAT_INT:
                GetraenkeautomatAnlegen<Wein>();
                Bearbeiten();
                break;
            case ROTWEIN_GETRAENKEAUTOMAT_INT:
                GetraenkeautomatAnlegen<Rotwein>();
                Bearbeiten();
                break;
            case WEISSWEIN_GETRAENKEAUTOMAT_INT:
                GetraenkeautomatAnlegen<Weisswein>();
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
        while (userInput != ZURUECK_INT) {
            try {
                MenuAusgabe();
                userInput = intLesen();
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

    public void GetraenkeautomatAnlegen<T>(){
        System.out.println("Bitte geben Sie die Kapaizität des Getränkeautomaten ein: ");
        int kapazität = intLesen();
        this.getraenkeautomat = new Getraenkeautomat<T>(kapazität);
    }

    public void FlascheEinlegen(){
        System.out.println("Bitte geben Sie den Namen der Flasche ein: ");
        int name = intLesen();
        System.out.println("Bitte geben Sie den Preis der Flasche ein: ");
        double preis = doubleLesen();
        if (getraenkeautomat<T instanceof AlkoholischesGetraenk>) {    
            System.out.println("Bitte geben Sie den Alkoholgehalt der Flasche ein: ");    
            double alkoholgehalt = doubleLesen();    
            if (getraenkeautomat<T instanceof Bier>) {    
                System.out.println("Bitte geben Sie die Brauerei ein: ");    
                String brauerei = StringLesen();
                Bier bier = new Bier(name, preis, alkoholgehalt, brauerei);
                Flasche<Bier> flasche = new Flasche<>(bier);
                getraenkeautomat.flascheEinlegen(flasche);
            } else if (getraenkeautomat<T instanceof Wein>) {    
                System.out.println("Bitte geben Sie das Weingut ein: ");    
                String weingut = StringLesen();
                if (getraenkeautomat<T instanceof Rotwein>) {
                    Rotwein rotwein = new Rotwein(name, preis, alkoholgehalt, weingut);
                    Flasche<Rotwein> flasche = new Flasche<>(rotwein);
                    getraenkeautomat.flascheEinlegen(flasche);
                } else if (getraenkeautomat<T instanceof Weisswein>) {
                    Weisswein weisswein = new Weisswein(name, preis, alkoholgehalt, weingut);
                    Flasche<Weisswein> flasche = new Flasche<>(weisswein);
                    getraenkeautomat.flascheEinlegen(flasche);
                } else {
                    String wineColor = "";
                    while(!wineColor.equals("R") && !wineColor.equals("W")) {
                        System.out.println("Geben Sie die Weinfarbe ein Rot(R) oder Weiss(W): ");
                        wineColor = StringLesen();
                        if(!weinTyp.equals("R") && !weinTyp.equals("W")) {
                            throw new IllegalArgumentException("Weinfarbe muss Rot(R) oder Weiss(W) sein");
                        }                                                                                                                                                                                                                                                           
                    }
                    if(wineColor.equals("R")) {
                        Rotwein rotwein = new Rotwein(name, preis, alkoholgehalt, weingut);
                        Flasche<Rotwein> flasche = new Flasche<>(rotwein);
                        getraenkeautomat.flascheEinlegen(flasche);
                    } else if(wineColor.equals("W")) {
                        Weisswein weisswein = new Weisswein(name, preis, alkoholgehalt, weingut);
                        Flasche<Weisswein> flasche = new Flasche<>(weisswein);
                        getraenkeautomat.flascheEinlegen(flasche);
                    }
                }
            } else {
                String getraenkeTyp = "";
                while(!getraenkeTyp.equals("B") && !getraenkeTyp.equals("W")) {
                    System.out.println("Geben Sie den Getränketyp ein Bier(B) oder Wein(W): ");
                    getraenkeTyp = StringLesen();
                    if(!getraenkeTyp.equals("B") && !getraenkeTyp.equals("W")) {
                        throw new IllegalArgumentException("Getränketyp muss Bier(B) oder Wein(W) sein");
                    }                                                                                                                                                                                                                                                           
                }
                if(getraenkeTyp.equals("B")) {
                    System.out.println("Bitte geben Sie die Brauerei ein: ");    
                    String brauerei = StringLesen();
                    Bier bier = new Bier(name, preis, alkoholgehalt, brauerei);
                    Flasche<Bier> flasche = new Flasche<>(bier);
                    getraenkeautomat.flascheEinlegen(flasche);
                } else if(getraenkeTyp.equals("W")) {
                    System.out.println("Bitte geben Sie das Weingut ein: ");    
                    String weingut = StringLesen();
                    String wineColor = "";
                    while(!wineColor.equals("R") && !wineColor.equals("W")) {
                        System.out.println("Geben Sie die Weinfarbe ein Rot(R) oder Weiss(W): ");
                        wineColor = StringLesen();
                        if(!weinTyp.equals("R") && !weinTyp.equals("W")) {
                            throw new IllegalArgumentException("Weinfarbe muss Rot(R) oder Weiss(W) sein");
                        }                                                                                                                                                                                                                                                           
                    }
                    if(wineColor.equals("R")) {
                        Rotwein rotwein = new Rotwein(name, preis, alkoholgehalt, weingut);
                        Flasche<Rotwein> flasche = new Flasche<>(rotwein);
                        getraenkeautomat.flascheEinlegen(flasche);
                    } else if(wineColor.equals("W")) {
                        Weisswein weisswein = new Weisswein(name, preis, alkoholgehalt, weingut);
                        Flasche<Weisswein> flasche = new Flasche<>(weisswein);
                        getraenkeautomat.flascheEinlegen(flasche);
                    }
                }
            }
        }    
    } else if (getraenkeautomat<T instanceof AlkoholfreiesGetraenk>) {    
        System.out.println("Bitte geben Sie den Hersteller der Flasche ein: ");    
        String hersteller = StringLesen();    
        if(getraenkeautomat<T instanceof Wasser>) {    
            System.out.println("Bitte geben Sie die Quelle ein: ");    
            String quelle = StringLesen();
            Wasser wasser = new Wasser(name, preis, hersteller, quelle);
            Flasche<Wasser> flasche = new Flasche<>(wasser);
            getraenkeautomat.flascheEinlegen(flasche);
        } else if(getraenkeautomat<T instanceof Softdrink>) {    
            System.out.println("Bitte geben Sie den Zuckergehalt ein: ");    
            String zuckergehalt = StringLesen();
            Softdrink softdrink = new Softdrink(name, preis, hersteller, zuckergehalt);
            Flasche<Softdrink> flasche = new Flasche<>(softdrink);
            getraenkeautomat.flascheEinlegen(flasche);

        } else {
            String getraenk = "";
            while(!wineColor.equals("R") && !wineColor.equals("W")) {
                System.out.println("Geben Sie die Getränkeart ein Wasser(W) oder Softdrink(S): ");
                getraenk = StringLesen();
                if(!getraenk.equals("W") && !getraenk.equals("S")) {
                    throw new IllegalArgumentException("Getränkeart muss Wasser(W) oder Softdrink(S) sein");
                }
            }
            if(getraenk.equals("W")) {
                Wasser wasser = new Wasser(name, preis, hersteller, quelle);
                Flasche<Wasser> flasche = new Flasche<>(wasser);
                getraenkeautomat.flascheEinlegen(flasche);
            } else if(getraenk.equals("S")) {
                Softdrink softdrink = new Softdrink(name, preis, hersteller, zuckergehalt);
                Flasche<Softdrink> flasche = new Flasche<>(softdrink);
                getraenkeautomat.flascheEinlegen(flasche);
            }
        }
    }
}
*/
