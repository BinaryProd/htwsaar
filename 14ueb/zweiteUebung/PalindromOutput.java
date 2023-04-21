import java.io.FileWriter;
import java.io.IOException;

public class PalindromOutput {

    private static final String FILENAME = "palindrom.txt";

    /**
     * This method prints the result of palindrome check to the console and writes
     * it to a file.
     * 
     * @param palindromResult A {@link PalindromResult} object containing the result
     *                        of palindrome check.
     */
    public static void ausgabe(PalindromResult palindromResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("Das Wort " + palindromResult.getWort() + " ist ");

        if (palindromResult.istBooleanInterativ() && palindromResult.istBooleanRekursiv()) {
            sb.append("ein Palindrom.");
        } else {
            sb.append("kein Palindrom.");
        }

        sb.append("\n Die Iterative Methode hat : " + palindromResult.getTimeIterativ() + " Nanosekunden gebraucht.");
        sb.append("\n Die Rekursive Methode hat : " + palindromResult.getTimeRekursiv() + " Nanosekunden gebraucht.");

        System.out.println(sb);

        writeToFile(palindromResult);
    }

    public static void writeToFile(PalindromResult palindromResult) {
        long timeRekursiv = palindromResult.getTimeRekursiv();
        long timeIterativ = palindromResult.getTimeIterativ();
        String wort = palindromResult.getWort();

        try (FileWriter fw = new FileWriter(FILENAME, true)) {
            fw.write(timeIterativ + ", " + timeRekursiv + ", \n");
            System.out.println("Wrote to file: " + wort);
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben in die Datei " + FILENAME + ": " + e.getMessage());
        } catch (PalindromException e) {
            System.out.println(e.getMessage());
        }
    }

}
