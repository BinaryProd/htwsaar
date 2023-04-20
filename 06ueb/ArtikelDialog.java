/**
 * <h1>Dialogue to Create Objects</h1>
 * Allows the user to create objects with a number, 
 * a type and a quantity. Then the user can interact 
 * with his items using methods with an interactif way.
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2022-11-04
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArtikelDialog {
	private Artikel artikel;

	private static final int ARTIKEL_MIT_BESTAND_INT = 1;
	private static final int ARTIKEL_OHNE_BESTAND_INT = 2;
	private static final int BUCHE_ZUGANG_INT = 3;
	private static final int BUCHE_ABGANG_INT = 4;
	private static final int ARTIKEL_NUMMMER_SETZEN_INT = 5;
	private static final int BESTAND_SETZEN_INT = 6;
	private static final int ART_SETZEN_INT = 7;
	private static final int PREIS_SETZEN_INT = 8;
	private static final int ARKTIKEL_INFORMATION_INT = 9;
	private static final int EXIT_INT = 10;

	private static final String ARTIKEL_MIT_BESTAND_STRING= " : Ein Artikel mit bestand anlegen";
	private static final String ARTIKEL_OHNE_BESTAND_STRING =" : Ein Artikel ohne bestand anlegen";
	private static final String BUCHE_ZUGANG_STRING = " : Ein Zugang buchen";
	private static final String BUCHE_ABGANG_STRING = " : Ein Abgang buchen";
	private static final String ARTIKEL_NUMMMER_SETZEN_STRING = " : Eine Artikelnummer setzen";
	private static final String BESTAND_SETZEN_STRING = " : Ein Bestand setzen";
	private static final String ART_SETZEN_STRING = " : Die Art setzen";
	private static final String PREIS_SETZEN_STRING = " : Der Preis setzen";
	private static final String ARKTIKEL_INFORMATION_STRING = " : Die Attribute des Artikels anzeigen";
	private static final String EXIT_STRING = " : Das Programm beenden";

        private static Scanner scanner = EingabeUtils.scanOpen();

	/**
	 * This constructor is the main entry point for the ArtikelDialog class
	 */
	public ArtikelDialog(){
	}

	/**
	 * The main Funktion start a new ArtikelDialog Objekt
	 */
	public static void main( String[] args) {
		new ArtikelDialog().start();
	}

	/** 
	 * Main loop of the Programm
	 */
	public void start() {

		artikel = null;
		int userInput = 0;

		while (userInput != EXIT_INT) {
			try {
				menuAusgabe();
				userInput = eingabeLesen();
				eingabeBearbeitung(userInput);
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
	 */
	public void menuAusgabe() {
		System.out.print("\n"+
				ARTIKEL_MIT_BESTAND_INT +  ARTIKEL_MIT_BESTAND_STRING + "\n" +
				ARTIKEL_OHNE_BESTAND_INT + ARTIKEL_OHNE_BESTAND_STRING + "\n" +
				BUCHE_ZUGANG_INT + BUCHE_ZUGANG_STRING +  "\n" +
				BUCHE_ABGANG_INT + BUCHE_ABGANG_STRING + "\n" + 
				ARTIKEL_NUMMMER_SETZEN_INT + ARTIKEL_NUMMMER_SETZEN_STRING + "\n" +
				BESTAND_SETZEN_INT + BESTAND_SETZEN_STRING + "\n" +
				ART_SETZEN_INT + ART_SETZEN_STRING + "\n" +
				PREIS_SETZEN_INT + PREIS_SETZEN_STRING + "\n" +
				ARKTIKEL_INFORMATION_INT + ARKTIKEL_INFORMATION_STRING + "\n" +
				EXIT_INT + EXIT_STRING + "\n" +
				">>> "
				);
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
	 * This method is use to execute the user choice 
	 * @param userInput The input from the user
	 */
	public void eingabeBearbeitung(int userInput) {
		switch (userInput) {
			case ARTIKEL_MIT_BESTAND_INT: 
                            artikelMitBestandAnlegen();
                            break;
			case ARTIKEL_OHNE_BESTAND_INT: 
                            artikelOhneBestandAnlegen();
                            break;
			case BUCHE_ZUGANG_INT: 
                            bucheZugang();
                            break;
			case BUCHE_ABGANG_INT: 
                            bucheAbgang();
                            break;
			case ARTIKEL_NUMMMER_SETZEN_INT: 
                            artikelNummerSetzen();
                            break;
			case BESTAND_SETZEN_INT: 
                            bestandSetzen();
                            break;
			case ART_SETZEN_INT: 
                            artSetzen();
                            break;
                        case PREIS_SETZEN_INT:
                            preisSetzen();
                            break;
			case ARKTIKEL_INFORMATION_INT: 
                            artikelInformation();
                            break;
			case EXIT_INT: 
                            System.out.println("Das Programm wird beendet");
                            EingabeUtils.scanClose(scanner);
                            break;
			default: 
                            System.out.println(userInput + " ist keine gültige Nummer !");
                            break;
		}
	}


	/**
	 * This method is used to create a new Artikel 
	 * It will ask the user to provide :
	 * - artikelNr that must be an Integer with 4 digits
	 * - art that must be a String
	 * - bestand that must be an positive Integer
	 * - preis that must be an positive double
	 */
	public void artikelMitBestandAnlegen() {
		if (artikel != null) {
			System.out.println("Das Artikel existiert bereits und kann nicht ueberchrieben werden");
		} else {
			System.out.println("\nEin Artikel wird angelegt");

			System.out.print("Artikelnummer (eine positive vierstellige Zahl) : ");
			int artikelNr = EingabeUtils.scanInt(scanner);

			System.out.print("Die Art des Artikels : ");
			String art = EingabeUtils.scanString(scanner);

			System.out.print("Der Bestand des Artikels : ");
			int bestand = EingabeUtils.scanInt(scanner);

                        System.out.print("Der Preis des Artikels : ");
                        double preis = EingabeUtils.scanDouble(scanner);

			artikel = new Artikel( artikelNr, art, bestand, preis);

			artikelInformation();
		}
	}

	/**
	 * This method is used to create a new Artikel but without a bestand 
	 * It will ask the user to provide :
	 * - artikelNr that must be an Integer with 4 digits
	 * - art that must be a String
	 * - preis that must be a Positiv double
	 */
	public void artikelOhneBestandAnlegen() {
		if (artikel != null) {
			System.out.println("Das Artikel existiert schon und kann nicht ueberchrieben werden");
		} else {
			System.out.println("\nEin Artikel ohne bestand wird angelet");

			System.out.print("Artikelnummer (eine positive Vierstelligezahl) : ");
			int artikelNr = scanner.nextInt();

			System.out.print("Die Art des Artikels : ");
			String art = scanner.next();

                        System.out.print("Der Preis des Artikels : ");
                        double preis = EingabeUtils.scanDouble(scanner);

			artikel = new Artikel( artikelNr, art, preis);

			artikelInformation();
		}
	}

	/**
	 * This method is used to increase the value of the attribute bestand
	 * It will ask the user to provide :
	 * - menge that must be a positive Integer 
	 */
	public void bucheZugang() {
		if (artikel == null) {
			System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
			"Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 10 um das Programm zu verlassen.");
		} else {
			System.out.println("\nDer Bestand ist " + artikel.getBestand() + ", wie viel soll hinzugefuegt werden ?");
			System.out.print(">>> ");
			int menge = scanner.nextInt();

			artikel.bucheZugang(menge);
			System.out.println("\nDer neue Bestand ist " + artikel.getBestand());
		}
	}

	/**
	 * This method is used to decrease the value of the attribute bestand
	 * It will ask the user to provide :
	 * - menge that must be a positive Integer 
	 */
	public void bucheAbgang() {
		if (artikel == null) {
			System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
			"Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 10 um das Programm zu verlassen.");
		} else {
			System.out.println("\nDer Bestand ist " + artikel.getBestand() + ", wie viel soll abgezogen werden ?");
			System.out.print(">>> ");
			int menge = scanner.nextInt();

			artikel.bucheAbgang(menge);
			System.out.println("\nDer neue Bestand ist " + artikel.getBestand());
		}
	}

	/**
	 * This method is use to set the value of ArtikelNr
	 * It will ask the user to provide :
	 * - artikelNr that must be an Integer with 4 digits
	 */
	public void artikelNummerSetzen() {
		if (artikel == null) {
			System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
			"Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 10 um das Programm zu verlassen.");
		} else {
			System.out.println("\nDie Aktuelle Artikel Nummer ist " + artikel.getArtikelNr() + ", geben Sie die neue Artikelnummer ein (eine positive Vierstelligezahl) :");
			System.out.print(">>> ");
			int neuerArtikelNr = scanner.nextInt();

			artikel.setArtikelNr(neuerArtikelNr);
			System.out.println("\nDie neue Artikel Nummer ist " + artikel.getArtikelNr());
		}
	}

	/**
	 * This method is use to set the value of Bestand
	 * It will ask the user to provide :
	 * - bestand that must be an positive Integer
	 */
	public void bestandSetzen() {
		if (artikel == null) {
			System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
			"Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 10 um das Programm zu verlassen.");
		} else {
			System.out.println("\nDie Aktuelle Artikel Nummer ist " + artikel.getBestand() + ", geben Sie den neuen Bestand ein :");
			System.out.print(">>> ");
			int neuerBestand = scanner.nextInt();

			artikel.setBestand(neuerBestand);
			System.out.println("\nDer neue Bestand ist " + artikel.getBestand());
		}
	}

	/**
	 * This method is use to set the value of Art 
	 * It will ask the user to provide :
	 * - art that must be a String
	 */
	public void artSetzen() {
		if (artikel == null) {
			System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
			"Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 10 um das Programm zu verlassen.");
		} else {
			System.out.println("\nDie Aktuelle Artikel Nummer ist " + artikel.getArt() + ", geben Sie die neue Art des Artikels ein :");
			System.out.print(">>> ");
			String neuerArt= scanner.next();

			artikel.setArt(neuerArt);
			System.out.println("\nDie neue Art ist " + artikel.getArt());
		}
	}

	/**
	 * This method is use to set the value of Preis
	 * It will ask the user to provide :
	 * - preis that must be a positive double
	 */
	public void preisSetzen() {
		if (artikel == null) {
			System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
			"Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 10 um das Programm zu verlassen.");
		} else {
			System.out.println("\nDer aktuelle Preis ist " + artikel.getPreis() + ", geben Sie den  neuen Preis des Artikels ein :");
			System.out.print(">>> ");
			double neuerPreis = EingabeUtils.scanDouble(scanner);

			artikel.setPreis(neuerPreis);
			System.out.println("\nDer neue Preis  ist " + artikel.getPreis());
		}
	}

	/**
	 * This method is used to return the values of the attributes of the class Artikel
	 */
	public void artikelInformation() {
		if (artikel == null) {
			System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
			"Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 10 um das Programm zu verlassen.");
		} else {
			System.out.println(artikel);
		}
	}
}