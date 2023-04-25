/**
 * <h1>PalindromAuswertung</h1> 
 * Java program to check if a word is a Palindrom based on different methodes, 
 * evaluating the time for each methode.
 * 
 * @author Victor Plage, David Glaser
 * @version 1.1.1
 * @since 19.04.2023
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PalindromAuswertung {

    private PalindromIterativ palIter;
    private PalindromRekursiv palRek;

    public PalindromAuswertung() {
        palRek = new PalindromRekursiv();
        palIter = new PalindromIterativ();
    }

    /**
     * This is the main method of the PalindromAuswertung class. It creates an
     * instance of the PalindromAuswertung class and runs the program by calling the
     * 'run' method with the provided command line arguments.
     * 
     * @param args An array of command line arguments that can include a string or
     *             file input to be checked for palindromes. If no arguments are
     *             provided, the 'usage' method is called to display program usage
     *             instructions.
     */
    public static void main(String[] args) {
        PalindromAuswertung palindrom = new PalindromAuswertung();
        palindrom.run(args);
    }

    /**
     * This method executes the checkStringorFile method with the input arguments.
     * 
     * @param args an array of strings representing the input, either a file path or
     *             a string to be checked.
     */
    public void run(String[] args) {
        checkStringOrFile(args);
    }

    /**
     * This method checks if the input is a file or a string, and applies the
     * palindrome check on the content. If the input is a file, it reads the content
     * of the file, splits the words and applies the palindrome check on each word.
     * If the input is a string, it applies the palindrome check directly on the
     * string.
     * 
     * @param args an array of strings representing the input, either a file path or
     *             a string to be checked.
     */
    public void checkStringOrFile(String[] args) {
        if (args.length == 0) {
            usage();
            System.exit(0);
        }

        for (String arg : args) {
            File file = new File(arg);
            if (file.isFile()) {
                System.out.println("Die Eingabe ist eine Datei.");
                System.out.println("Die Datei " + arg + " wird eingelesen.");

                String content = readFiles(arg);
                String[] worte = content.split("\\n"); // this is for sentences

                for (String wort : worte) {
                    sendToCheckPalindrome(wort);
                }
            } else {
                System.out.println("Die Eingabe ist ein String.");
                System.out.println("Der String " + arg + " wird eingelesen.");
                sendToCheckPalindrome(arg);
            }
        }
    }

    public void sendToCheckPalindrome(String wort) {
        try {
            PalindromResult result = checkPalindrome(wort);
            PalindromOutput.ausgabe(result);
        } catch (PalindromException e) {
            System.out.println(e);
        } catch ( Exception e ) {
            System.out.println(e);
        }
    }

    /**
     * This method reads the content of a text file specified by the input argument.
     * 
     * @param arg a string representing the path of the text file to be read.
     * @return a string representing the content of the text file.
     */
    public String readFiles(String arg) {
        String content = "";
        if (isTextFile(arg)) {
            try {
                content = Files.readString(Paths.get(arg));
            } catch (IOException e) {
                System.out.println("Fehler beim Lesen der Datei " + arg);
            }
        }
        return content;
    }

    /**
     * This method checks if the input file is a text file and can be read.
     * 
     * @param arg a string representing the path of the file to be checked.
     * @return a boolean value indicating whether the input file is a text file and
     *         can be read.
     */
    public boolean isTextFile(String arg) {
        Path path = Paths.get(arg);
        String contentType = "";

        try {
            contentType = Files.probeContentType(path);

            if (!path.toFile().isFile() || !path.toFile().exists()) {
                throw new PalindromException("Die Datei " + arg + " existiert nicht.");
            }
            if (!path.toFile().canRead()) {
                throw new PalindromException("Die Datei " + arg + " kann nicht gelesen werden.");
            }
            if (contentType == null || !contentType.startsWith("text/")) {
                throw new PalindromException("Die Datei " + arg + " ist keine Text Datei.");
            }

            return true;

        } catch (PalindromException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei " + arg);
        }

        return false;

    }

    /**
     * This method checks whether the input string is a palindrome or not.
     * 
     * @param input a string to be checked for palindrome.
     * @throws PalindromException if the word is empty
     * @return a PalindromResult object representing the input string, whether it's
     *         a palindrome or not, and the time it took to check using iterative
     *         and recursive algorithms.
     */
    public PalindromResult checkPalindrome(String input) throws PalindromException {
        String cleanInput = input.strip().replaceAll("[^a-zA-Z]", "").toLowerCase();
        PalindromException.stringTest(cleanInput);

        long startTimeIterativ = System.nanoTime();
        boolean istPalindromIterativ = palIter.istPalindrom(cleanInput);
        long endTimeIterativ = System.nanoTime();

        long startTimeRekursiv = System.nanoTime();
        boolean istPalindromRekursiv = palRek.istPalindrom(cleanInput);
        long endTimeRekursiv = System.nanoTime();

        return new PalindromResult(
                cleanInput, 
                istPalindromIterativ, 
                endTimeIterativ - startTimeIterativ,
                istPalindromRekursiv, 
                endTimeRekursiv - startTimeRekursiv
                );
    }

    /**
     * This method prints usage instructions for running the PalindromAuswertung
     * program.
     */
    public void usage() {
        System.out.println("Usage: java PalindromAuswertung <String> <Datei>");
        System.out.println("String: Palindrom wird auf der Konsole ausgegeben.");
        System.out.println("Datei: Palindrom wird aus der Datei ausgegeben.");
    }

}
