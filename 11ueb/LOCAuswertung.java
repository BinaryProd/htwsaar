/**
 * LOCAuswertung - Java program for evaluating lines of code in Java files.
 * 
 * @author Victor Plage, David Glaser
 * @version 1.1.1
 * @since 28.01.2023
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;

public class LOCAuswertung {

    private static final Pattern COMMENT_PATTERN = Pattern.compile("^\\s*//");
    private static final Pattern BLANK_PATTERN = Pattern.compile("^\\s*$");

    private File[] filesArray;

    private int codeLines = 0;
    private int totalCodeLines = 0;
    private int numberOfFile = 0;

    /**
     * Main method that runs the program.
     * 
     * @param args The input Java files.
     */
    public static void main(String[] args) {
        LOCAuswertung loc = new LOCAuswertung();
        loc.run(args);
    }

    /**
     * Method that starts the evaluation process.
     * 
     * @param args The input Java files.
     */
    public void run(String[] args) {
        collectFiles(args);
        readFiles();
        outputResult();
    }

    /**
     * Method that collects and validates the input Java files.
     * 
     * @param args The input Java files.
     */
    public void collectFiles(String[] args) {
        if (args == null || args.length == 0) {
            usage();
            System.exit(0);
        }
        filesArray = new File[args.length];
        int i = 0;
        for ( String arg : args) {
            File file = new File(arg);
            try {
            if (!file.isFile()) { 
                throw new NotAFileException("Die Datei " + arg + " existiert nicht.");
            }
            if (!file.exists()) {
                throw new NotExistingFileException("Die Datei " + arg + " existiert nicht.");
            }
            if (!file.canRead()) {
                throw new NotAReadableFileException("Die Datei " + arg + " kann nicht gelesen werden.");
            }
            if (!arg.endsWith(".java")) {
                throw new NotAJavaFileException("Die Datei " + arg + " ist keine Java Datei.");
            }
            } catch (NotAFileException e) {
                System.out.println(e.getMessage());
            } catch (NotExistingFileException e) {
                System.out.println(e.getMessage());
            } catch (NotAReadableFileException e) {
                System.out.println(e.getMessage());
            } catch (NotAJavaFileException e) {
                System.out.println(e.getMessage());
            } finally {
                if (file.isFile() && file.exists() && file.canRead() && arg.endsWith(".java")) {
                    filesArray[i] = file;
                    i++;
                }
            }
        }
    }

    /**
     * Reads files and evaluates the number of lines of code (LOC) for each file.
     * Prints the LOC count for each file and the total LOC count of all files.
     */
    public void readFiles() {
        System.out.println("\nAuswertung Lines of Code (LOC)");
        for (int i = 0; i < filesArray.length; i++) {
            if (filesArray[i] != null) {
                codeLines = 0;
                numberOfFile++;
                readFiles(filesArray[i]);
                System.out.println(filesArray[i].getName() + ": " + codeLines);
            }
        }
    }

    /**
     * Evaluates the number of lines of code (LOC) for a given file.
     * @param file the file to evaluate
     */
    public void readFiles(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                Matcher commentMatcher = COMMENT_PATTERN.matcher(line);
                Matcher blankMatcher = BLANK_PATTERN.matcher(line);
                if (!commentMatcher.find() && !blankMatcher.find()) {
                    codeLines++;
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei " + file.getName());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            totalCodeLines += codeLines;
        }
    }

    /**
     * Outputs the total number of files evaluated and the total LOC count.
     */
    public void outputResult() {
        System.out.println("\nGesamt:");
        System.out.println( numberOfFile + " Dateien " + totalCodeLines + " LOC");
    }
    
    /**
     * Prints the usage of the program.
     */
    public void usage() {
        System.out.println("Usage: java LOCAuswertung <file1> <file2> ...");
    }
}
