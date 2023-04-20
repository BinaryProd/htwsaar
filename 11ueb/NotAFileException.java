/**
 * This class is an implementation of Exception and is used to represent a custom exception for Lines of Code (LOC) errors.
 * @author Victor Plage
 * @author David Glaser
 * @version 1.1.1
 * @since 28.01.2023
 */
public class NotAFileException extends RuntimeException {
    /**
     * Constructs a new LOCError with a specified message.
     * @param message The detail message.
     */
    public NotAFileException(String message) {
        super(message);
    }

    /**
     * Constructs a new LOCError with no specified message.
     */
    public NotAFileException() {
        super();
    }
}
