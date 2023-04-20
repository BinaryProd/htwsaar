import java.io.FileWriter;
import java.io.IOException;

public class PalindromWriter {

    private static final String FILENAME = "palindrom.txt";

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
