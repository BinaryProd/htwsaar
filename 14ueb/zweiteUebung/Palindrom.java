/**
 * <h1>Palindrom</h1> The interface provides the method signature for
 * determining whether a given word is a palindrome or not. A palindrome is a
 * word, phrase, number, or other sequence of characters that reads the same
 * forward and backward.
 * 
 * @author Victor Plage, David Glaser
 * @version 1.0.0
 * @since 19.04.2023
 */
public interface Palindrom {
    /**
     * This method takes a string and checks whether it is a palindrome or not.
     * 
     * @param wort The input string to be checked for palindrome.
     * @return true if the input string is a palindrome, false otherwise.
     */
    public abstract boolean istPalindrom(String wort);

    /**
     * This method returns a string representation of the type of palindrome method
     * used.
     * 
     * @return A string that describes the type of palindrome method used.
     */
    public String toString();
}
