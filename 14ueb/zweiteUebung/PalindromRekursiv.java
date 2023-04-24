/**
 * <h1>PalindromRekursiv</h1> The class implements the Palindrom interface and
 * provides the functionality to check if a given String is a palindrome or not,
 * recursively.
 * 
 * @author Victor Plage, David Glaser
 * @version 1.0.0
 * @since 19.04.2023
 */
public class PalindromRekursiv implements Palindrom {

    /**
     * Constructs a new instance of the PalindromRekursiv class.
     */
    public PalindromRekursiv() {
    }

    /**
     * Checks if the given String is a palindrome or not, recursively.
     * 
     * @param wort the String to be checked for palindrome
     * @return true if the String is a palindrome, false otherwise
     */
    public boolean istPalindrom(String wort) {
        if (wort.length() <= 1) {
            return true;
        }

        if (wort.charAt(0) == wort.charAt(wort.length() - 1)) {
            return istPalindrom(wort.substring(1, wort.length() - 1));
        } else {
            return false;
        }
    }

    /**
     * Returns a string representation of the PalindromRekursiv object.
     * 
     * @return a string representation of the object
     */
    public String toString() {
        return "Rekursiv";
    }
}
