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

public class MathFunctionsDialog{
	
	private static final int BERECHNE_TEILERSUMME 		= 1;
	private static final int BERECHNER_CHECKSUMME_ISBN 	= 2;
	private static final int BERECHNER_NULLSTELLEN 		= 3;
	private static final int BERECHNER_GGT				= 4;
	private static final int BERECHNER_FAKULTAET 		= 5;
	private static final int BERECHNER_SUMME_POTENZEN 	= 6;
	private static final int BERECHNER_SUMME_SERIE 		= 7;
	private static final int EXIT_INT 					= 8;

	private static final String BERECHNE_TEILERSUMME_STRING 		= " : Berechne die Teilersumme einer Zahl";
	private static final String BERECHNER_CHECKSUMME_ISBN_STRING 	=" : Berechne die Checksum von einer ISBN-10";
	private static final String BERECHNER_NULLSTELLEN_STRING 		= " : Berechne die Nullstellen von p und q";
	private static final String BERECHNER_GGT_STRING 				= " : Berechne der GGT von zahl1 und zahl2";
	private static final String BERECHNER_FAKULTAET_STRING 			= " : Berechne die Fakultaet von einer Zahl";
	private static final String BERECHNER_SUMME_POTENZEN_STRING 	= " : Berechne die Summe von Potenzen";
	private static final String BERECHNER_SUMME_SERIE_STRING 		= " : Berechne die Summe von der Serie";
	private static final String EXIT_STRING 						= " : Das Programm beenden";

	private static Scanner scanner = EingabeUtils.scanOpen();

	/**
	 * The main Funktion start a new ArtikelDialog Objekt
	 */
	public static void main( String[] args) {
		new MathFunctionsDialog().start();
	}

	/** 
	 * Main loop of the Programm
	 */
	public void start() {

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
			BERECHNE_TEILERSUMME +  BERECHNE_TEILERSUMME_STRING + "\n" +
			BERECHNER_CHECKSUMME_ISBN + BERECHNER_CHECKSUMME_ISBN_STRING + "\n" +
			BERECHNER_NULLSTELLEN + BERECHNER_NULLSTELLEN_STRING +  "\n" +
			BERECHNER_GGT + BERECHNER_GGT_STRING +  "\n" +
			BERECHNER_FAKULTAET + BERECHNER_FAKULTAET_STRING +  "\n" +
			BERECHNER_SUMME_POTENZEN + BERECHNER_SUMME_POTENZEN_STRING +  "\n" +
			BERECHNER_SUMME_SERIE + BERECHNER_SUMME_SERIE_STRING +  "\n" +
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
		System.out.println(userInput);
		return userInput;
	}

	/**
	 * This method is use to execute the user choice 
	 * @param userInput The input from the user
	 */
	public void eingabeBearbeitung(int userInput) {
		switch(userInput) {
		 	case BERECHNE_TEILERSUMME: 
				berechneTeilersumme();
				break;
			case BERECHNER_CHECKSUMME_ISBN: 
				berechneChecksummeIsbn();
				break;
			case BERECHNER_NULLSTELLEN: 
				berechneNullstellen();
				break;
			case BERECHNER_GGT:
			 	berechneGgt();
				break;
			case BERECHNER_FAKULTAET:
				berechneFakultaet();
				break;
			case BERECHNER_SUMME_POTENZEN:
				berechnePotenz();
				break;
			case BERECHNER_SUMME_SERIE:
				berechneReihensumme();
				break;
			case EXIT_INT: 
				System.out.println("Das Programm wird beendet!");
				EingabeUtils.scanClose(scanner);
				break;
			default: 
				System.out.println(userInput + " ist keine gueltige Nummer!");
				break;
		 }
	}

	/**
	 * This method is used to call the berechneTeilersumme in MathFunctions
	 * It will ask the user to provide :
	 * - zahl that must be a positive long 
	 */
	public void berechneTeilersumme() {

		System.out.print("Teilersumme: ");
		long zahl = EingabeUtils.scanLong(scanner);

		System.out.println("Die Summe aller moeglichen Teiler: " + MathFunctions.berechneTeilersumme(zahl));
	}

	/**
	 * This method is used to call the berechneChecksummeIsbn in MathFunctions
	 * It will ask the user to provide :
	 * - zahl that must be a isbn-10
	 */
	public void berechneChecksummeIsbn() {

		System.out.print("ISBN: ");

		long zahl = EingabeUtils.scanLong(scanner);

		System.out.println("Die errechnete Pruefziffer: " + MathFunctions.berechneChecksummeIsbn(zahl));
	}

	/**
	 * This method is used to call the berechneNullstellen in MathFunctions
	 * It will ask the user to provide :
	 * - p that must be a double
	 * - q that must be a double
	 */
	public void berechneNullstellen() {

		System.out.print("The value of p: ");
		double pvalue = EingabeUtils.scanDouble(scanner);

		System.out.print("The value of q: ");
		double qvalue = EingabeUtils.scanDouble(scanner);

		System.out.println(MathFunctions.berechneNullstellen(pvalue, qvalue));
		
	}

	/**
	 * This method is used to call the berechneGgt in MathFunctions 
	 * It will ask the user to provide :
	 * - zahl1 that must be a int
	 * - zahl2 that must be a int
	 */
	public void berechneGgt() {

		System.out.print("The value of zahl 1: ");
		int zahl1 = EingabeUtils.scanInt(scanner);

		System.out.print("The value of zahl 2: ");
		int zahl2 = EingabeUtils.scanInt(scanner);

		System.out.println(MathFunctions.berechneGgt(zahl1, zahl2));
	}	

	/**
	 * This method is used to call the berechneFakultaet in MathFunctions 
	 * It will ask the user to provide :
	 * - zahl that must be a int
	 */
	public void berechneFakultaet(){

		System.out.println("The value of zahl: ");
		
		int zahl = EingabeUtils.scanInt(scanner);
		// BigInteger result = MathFunctions.berechneFakultaet(zahl);

		System.out.println(MathFunctions.berechneFakultaet(zahl));
	}

	/**
	 * This method is used to call the istSummeVonPotenzen in MathFunctions 
	 * It will ask the user to provide :
	 * - zahl that must be a long
	 */
	public void berechnePotenz() {

		System.out.print("The value of Zahl : ");
		long zahl = EingabeUtils.scanLong(scanner);

		System.out.println(MathFunctions.istSummeVonPotenzen(zahl));
	}

	/**
	 * This method is used to call the berechneReihensumme in MathFunctions 
	 * It will ask the user to provide :
	 * - x that must be a double
	 * - anzahl that must be a int
	 */
	public void berechneReihensumme() {

		System.out.print("The value of anzahl: ");
		int anzahl = EingabeUtils.scanInt(scanner);

		System.out.print("The value of x: ");
		double xValue = EingabeUtils.scanDouble(scanner);

		System.out.println(MathFunctions.berechneReihensumme(anzahl, xValue));
	}
}
