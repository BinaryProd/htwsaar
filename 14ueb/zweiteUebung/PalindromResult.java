/**
 * <h1>PalindromResult</h1> This class represents the result of a Palindrom
 * analysis for a given word. It stores the word, boolean result of Iterative
 * and Recursive methods, and the time taken by each method.
 * 
 * @author Victor Plage, David Glaser
 * @version 1.0.0
 * @since 19.04.2023
 */
public class PalindromResult {

    private boolean booleanInterativ;
    private boolean booleanRekursiv;
    private long timeInterativ;
    private long timeRekursiv;
    private String wort;

    /**
     * Constructs a PalindromResult object with the given parameters.
     * 
     * @param wort             the word analyzed
     * @param booleanInterativ the boolean result of Iterative method
     * @param timeInterativ    the time taken by Iterative method
     * @param booleanRekursiv  the boolean result of Recursive method
     * @param timeRekursiv     the time taken by Recursive method
     */
    public PalindromResult(String wort, boolean booleanInterativ, long timeInterativ, boolean booleanRekursiv,
            long timeRekursiv) {
        this.wort = wort;
        this.booleanInterativ = booleanInterativ;
        this.booleanRekursiv = booleanRekursiv;
        this.timeInterativ = timeInterativ;
        this.timeRekursiv = timeRekursiv;
    }

    /**
     * Returns the word analyzed.
     * 
     * @return the word analyzed
     */
    public String getWort() {
        return wort;
    }

    /**
     * Returns the boolean result of Iterative method.
     * 
     * @return the boolean result of Iterative method
     */
    public boolean istBooleanInterativ() {
        return booleanInterativ;
    }

    /**
     * Returns the boolean result of Recursive method.
     * 
     * @return the boolean result of Recursive method
     */
    public boolean istBooleanRekursiv() {
        return booleanRekursiv;
    }

    /**
     * Returns the time taken by Iterative method.
     * 
     * @return the time taken by Iterative method
     */
    public long getTimeIterativ() {
        return timeInterativ;
    }

    /**
     * Returns the time taken by Recursive method.
     * 
     * @return the time taken by Recursive method
     */
    public long getTimeRekursiv() {
        return timeRekursiv;
    }
}
