/**
 * This class is used to extract links from a given input and display their text and URL.
 * It also counts the number of links found and the number of lines in the input.
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.0
 * @since 2022-12-13
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtractor {
    private static final Pattern LINK_PATTERN = Pattern.compile("<\\s*a.*?href\\s*=\\s*\"\\s*(.+?)\\s*\".*?>\\s*(.+?)\\s*<\\s*/a\\s*>");

    int linkCount = 0;
    int lineCount = 0;

    Scanner scanner = new Scanner(System.in);

    /**
     * Prints a formatted string to the console.
     * @param format format string
     * @param args arguments for the format string
     */
    public void printf(String format, Object... args) {
        System.out.printf(format + "\n", args);
    }

    /**
     * Main method for the LinkExtractor class.
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        new LinkExtractor().run();
    }

    /**
     * Extracts links from the input and displays their text and URL.
     */
    public void run() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineCount++;

            Matcher linkMatcher = LINK_PATTERN.matcher(line);
            while (linkMatcher.find()) {
                String linkUrl = linkMatcher.group(1);

                if (linkUrl.equals(linkUrl.toLowerCase())) {
                    linkCount++;
                    String linkText = linkMatcher.group(2);

                    printf("%s: %s, Anzahl Zeichen: %d", linkText, linkUrl, linkUrl.length());
                }
            }
        }

        printf("%d Links wurden in %d Zeilen gefunden.", linkCount, lineCount);

        scanner.close();
    }
}
