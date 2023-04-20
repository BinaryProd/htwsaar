/**
 * <h1>PalindromIterativ</h1> This class implements the Palindrom interface and
 * provides an iterative algorithm to check if a given word is a palindrome.
 * 
 * @author Victor Plage, David Glaser
 * @version 1.0.0
 * @since 19.04.2023
 */

public class PalindromIterativ implements Palindrom {

    /**
     * This is the default constructor for the PalindromIterativ class.
     */
    public PalindromIterativ() {
    }

    /**
     * This method checks whether the given word is a palindrome using an iterative
     * algorithm.
     * 
     * @param wort the input string to be checked
     * @return true if the input string is a palindrome, false otherwise
     */
    public boolean istPalindrom(String wort) {
        int links = 0;
        int rechts = wort.length() - 1;
        while (links < rechts) {
            if (wort.charAt(links) != wort.charAt(rechts)) {
                return false;
            }
            links++;
            rechts--;
        }
        return true;
    }

    /**
     * This method returns a string representation of the PalindromIterativ object.
     * 
     * @return a string indicating that the iterative algorithm is being used
     */
    public String toString() {
        return "Iterativ";
    }
}
