import java.util.Scanner;
import java.time.Year;

public class name {
	public static void main( String[] args) {
		String first ;
		String second ;
		int geburtjahr;
		int current_year = Year.now().getValue();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ihr Vorname : " );
		first  = scanner.next();
		System.out.print("Ihr Nachname : " );
		second = scanner.next();
		System.out.print("Ihr Geburtsjahr : " );
		geburtjahr = scanner.nextInt();
		int alter = current_year - geburtjahr;
		System.out.println("Sie heißen : "+ first+ ", " + second);
		System.out.println("Sie sind " +alter + " Jahre alt");
		scanner.close();
	}
}

