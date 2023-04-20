import java.util.Scanner;

public class rectangle {
    public static void main(String[] args){
        double first;
        double sec;
        Scanner input = new Scanner(System.in);
        System.out.print("Geben Sie die Länge der Seite a ein : ");
        first = input.nextDouble();
        System.out.print("Geben Sie die Länge der Seite b ein : ");
        sec = input.nextDouble();

        double aire = first * sec;
        double perimetre = 2 * first + 2 * sec;

        System.out.println("Das Rechteck hat die folgenden Seiten :");
        System.out.println("Laenge der Seite a: " + first + " cm");
        System.out.println("Laenge der Seite b: " + sec + " cm");
        System.out.println("Flaecheninhalt A = " + aire + " qcm");
        System.out.println("Umfang U = " + perimetre + " cm");
        input.close();
    }
}
