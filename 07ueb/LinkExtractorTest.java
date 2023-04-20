/**
 * JUnit test class for the LinkExtractor class.
 *
 * @author Victor Plage and David Glaser
 * @version 1.1.0
 * @since 2022-12-13
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.PrintStream;
import java.io.IOException;
import java.util.Scanner;

public class LinkExtractorTest {
    private LinkExtractor extractor = new LinkExtractor();
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Helper method for running the LinkExtractor's `run()` method with a given test input.
     * @param testInput the test input to pass to the LinkExtractor
     */
    private void runExtractor(String testInput) {
        try (ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes())){
            extractor.scanner = new Scanner(in);
            extractor.run();
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }

    /**
     * Method called before each test to redirect test output to the outContent stream.
     */
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Method called after each test to restore normal output.
     */
    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    /**
     * Tests that the LinkExtractor's `linkCount` and `lineCount` fields are set correctly
     * for normal hypertext links.
     */
    @Test
    public void normal_hypertextlinks_expected_value2_linkCount_lineCount() {
        String testInput = "<a href=\"http://example.com\">Example</a>\n<a href=\"http://test.com\">Test</a>";
        int expectedLinkCount = 2;
        int expectedLineCount = 2;

        runExtractor(testInput);

        assertEquals(expectedLinkCount, extractor.linkCount);
        assertEquals(expectedLineCount, extractor.lineCount);
    }

    /**
     * Tests that the LinkExtractor's `printf()` method produces the correct output
     * for normal hypertext links.
     */
    @Test
    public void printf_output_correct_normal_hypertextlinks() {
        String linkText1 = "Example";
        String linkUrl1 = "http://example.com";
        int linkUrlLength1 = linkUrl1.length();

        String linkText2 = "Test";
        String linkUrl2 = "http://test.com";
        int linkUrlLength2 = linkUrl2.length();

        extractor.printf("%s: %s, Anzahl Zeichen: %d", linkText1, linkUrl1, linkUrlLength1);
        extractor.printf("%s: %s, Anzahl Zeichen: %d", linkText2, linkUrl2, linkUrlLength2);

        String expectedOutput = String.format("%s: %s, Anzahl Zeichen: %d\n%s: %s, Anzahl Zeichen: %d\n", linkText1, linkUrl1, linkUrlLength1, linkText2, linkUrl2, linkUrlLength2);
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests that the LinkExtractor's `run` method produces the correct output
     * for normal hypertext links.
     */
    @Test
    public void printf_run_output_normal_hypertextlinks() {
        String testInput = "<a href=\"http://example.com\">Example</a>\n<a href=\"http://test.com\">Test</a>";
        int expectedLinkCount = 2;
        int expectedLineCount = 2;

        String linkText1 = "Example";
        String linkUrl1 = "http://example.com";
        int linkUrlLength1 = linkUrl1.length();

        String linkText2 = "Test";
        String linkUrl2 = "http://test.com";
        int linkUrlLength2 = linkUrl2.length();

        String expectedOutput = String.format("%s: %s, Anzahl Zeichen: %d\n%s: %s, Anzahl Zeichen: %d\n%d Links wurden in %d Zeilen gefunden.\n", linkText1, linkUrl1, linkUrlLength1, linkText2, linkUrl2, linkUrlLength2, expectedLinkCount, expectedLineCount);
        
        runExtractor(testInput);
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests the LinkExtractor with multiple hypertext links.
     * Expected values: linkCount = 3, lineCount = 5.
     */
    @Test
    public void multiple_hypertextlinks_expected_value3_linkCount_value5_lineCount() {
        String testInput = "<p>\n" +
            "  <li><a href=\"http://www.htwsaar.de/\">htwsaar</a></li>\n" +
            "  <li><a href=\"http://www.google.com\">Google</a></li>\n" +
            "  <a href=\"http://www.heise.de\">Heise Online</a>\n" +
            "</p>";
        int expectedLinkCount = 3;
        int expectedLineCount = 5;

        runExtractor(testInput);

        assertEquals(expectedLinkCount, extractor.linkCount);
        assertEquals(expectedLineCount, extractor.lineCount);
    }

    /**
     * Tests the LinkExtractor's printf method with multiple hypertext links.
     * Verifies that the output is correct.
     */
    @Test
    public void printf_output_correct_multiple_hypertextlinks() {
        String linkText1 = "htwsaar";
        String linkUrl1 = "http://www.htwsaar.de/";
        int linkUrlLength1 = linkUrl1.length();

        String linkText2 = "Google";
        String linkUrl2 = "http://www.google.com";
        int linkUrlLength2 = linkUrl2.length();

        String linkText3 = "Heise Online";
        String linkUrl3 = "http://www.heise.de";
        int linkUrlLength3 = linkUrl3.length();

        extractor.printf("%s: %s, Anzahl Zeichen: %d", linkText1, linkUrl1, linkUrlLength1);
        extractor.printf("%s: %s, Anzahl Zeichen: %d", linkText2, linkUrl2, linkUrlLength2);
        extractor.printf("%s: %s, Anzahl Zeichen: %d", linkText3, linkUrl3, linkUrlLength3);

        String expectedOutput = String.format("%s: %s, Anzahl Zeichen: %d\n%s: %s, Anzahl Zeichen: %d\n%s: %s, Anzahl Zeichen: %d\n", linkText1, linkUrl1, linkUrlLength1, linkText2, linkUrl2, linkUrlLength2, linkText3, linkUrl3, linkUrlLength3);
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests the LinkExtractor with a hypertext link that has a class attribute.
     * Expected values: linkCount = 1, lineCount = 1.
     */
    @Test
    public void hypertextlink_with_class_attribute_expected_value1_linkCount_lineCount() {
        String testInput = "<li><a class=\"hello\" href=\"http://www.htwsaar.de/\">htwsaar</a></li>";
        int expectedLinkCount = 1;
        int expectedLineCount = 1;

        runExtractor(testInput);

        assertEquals(expectedLinkCount, extractor.linkCount);
        assertEquals(expectedLineCount, extractor.lineCount);
    }

    /**
     * Tests the LinkExtractor's printf method with a hypertext link that has a class attribute.
     * Verifies that the output is correct.
     */
    @Test
    public void printf_output_correct_hypertextlink_with_class_attribute() {
        String linkText = "htwsaar";
        String linkUrl = "http://www.htwsaar.de/";
        int linkUrlLength = linkUrl.length();

        extractor.printf("%s: %s, Anzahl Zeichen: %d", linkText, linkUrl, linkUrlLength);

        String expectedOutput = String.format("%s: %s, Anzahl Zeichen: %d\n", linkText, linkUrl, linkUrlLength);
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests the LinkExtractor with a hypertext link that has a class attribute at the end.
     * Expected values: linkCount = 1, lineCount = 1.
     */
    @Test
    public void hypertextlink_with_class_attribute_at_end_expected_value1_linkCount_lineCount() {
        String testInput = "<li><a href=\"http://www.htwsaar.de/\" class=\"hello\">htwsaar</a></li>";
        int expectedLinkCount = 1;
        int expectedLineCount = 1;

        runExtractor(testInput);

        assertEquals(expectedLinkCount, extractor.linkCount);
        assertEquals(expectedLineCount, extractor.lineCount);
    }

    /**
     * Tests the LinkExtractor with a hypertext link that has a target attribute.
     * Expected values: linkCount = 1, lineCount = 1.
     */
    @Test
    public void hypertextlink_with_target_attribute_expected_value1_linkCount_lineCount() {
        String testInput = "<li><a target=\"_blank\" href=\"http://www.htwsaar.de/\">htwsaar</a></li>";
        int expectedLinkCount = 1;
        int expectedLineCount = 1;

        runExtractor(testInput);

        assertEquals(expectedLinkCount, extractor.linkCount);
        assertEquals(expectedLineCount, extractor.lineCount);
    }

    /**
     * Tests the LinkExtractor with a hypertext link that has a target attribute at the end.
     * Expected values: linkCount = 1, lineCount = 1.
     */
    @Test
    public void hypertextlink_with_target_attribute_at_end_expected_value1_linkCount_lineCount() {
        String testInput = "<li><a href=\"http://www.htwsaar.de/\" target=\"_blank\">htwsaar</a></li>";
        int expectedLinkCount = 1;
        int expectedLineCount = 1;

        runExtractor(testInput);

        assertEquals(expectedLinkCount, extractor.linkCount);
        assertEquals(expectedLineCount, extractor.lineCount);
    }

   /**
     * Tests the LinkExtractor with a hypertext link that has an uppercase "http" value.
     * Expected values: linkCount = 0, lineCount = 1.
     */
    @Test
    public void hypertextlink_with_uppercase_http_expected_value0_linkCount_lineCount() {
        String testInput = "<li><a href=\"Http://www.htwsaar.de/\">htwsaar</a></li>";
        int expectedLinkCount = 0;
        int expectedLineCount = 1;
        runExtractor(testInput);

        assertEquals(expectedLinkCount, extractor.linkCount);
        assertEquals(expectedLineCount, extractor.lineCount);

    }

    /**
     * Tests the LinkExtractor's printf method with a hypertext link that has an uppercase "http" value.
     * Verifies that the output is correct.
     */
    @Test
    public void printf_run_output_hypertextlink_with_uppercase_http() {
        String testInput = "<li><a href=\"Http://www.htwsaar.de/\">htwsaar</a></li>";
        int expectedLinkCount = 0;
        int expectedLineCount = 1;

        String expectedOutput = String.format("%d Links wurden in %d Zeilen gefunden.\n", expectedLinkCount, expectedLineCount);
        
        runExtractor(testInput);
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests the LinkExtractor's printf method with a hypertext link on two lines.
     * Verifies that the output is correct.
     */
    @Test
    public void printf_run_output_with_hypertextlinks_on_2_lines() {
        String testInput = "<a href=\"http://example.com\"\n>Example</a>";
        int expectedLinkCount = 0;
        int expectedLineCount = 2;

        String expectedOutput = String.format("%d Links wurden in %d Zeilen gefunden.\n", expectedLinkCount, expectedLineCount);
        
        runExtractor(testInput);
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests the LinkExtractor's printf method with multiple hypertext link on one lines.
     * Verifies that the output is correct.
     */
    @Test
    public void printf_run_output_multiple_hypertextlinks_on_1_lines() {
        String testInput = "<p>\n<li><a href=\"http://www.htwsaar.de/\">htwsaar</a></li><li><a href=\"http://www.google.com\">Google</a></li><a href=\"http://www.heise.de\">Heise Online</a>\n</p>";
        int expectedLinkCount = 3;
        int expectedLineCount = 5;

        String expectedOutput = String.format("htwsaar: http://www.htwsaar.de/, Anzahl Zeichen: 22\nGoogle: http://www.google.com, Anzahl Zeichen: 21\nHeise Online: http://www.heise.de, Anzahl Zeichen: 19\n3 Links wurden in 3 Zeilen gefunden.\n");

        runExtractor(testInput);
        assertEquals(expectedOutput, outContent.toString());

    }
}
