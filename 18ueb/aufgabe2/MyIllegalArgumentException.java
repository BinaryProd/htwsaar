/**
 * <h1> FunctionException </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
public class MyIllegalArgumentException extends RuntimeException {


    /**
     * Constructor of the class FunctionException
     */
    public MyIllegalArgumentException() {
        super();
    }

    /**
     * Constructor of the class FunctionException
     * @param message String
     */
    public MyIllegalArgumentException(String message) {
        super(message);
    }

}
