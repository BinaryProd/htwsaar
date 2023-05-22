/**
 * <h1> MyFunction </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
@FunctionalInterface
public interface MyFunction{
    /**
     * Method that applies a function to an integer
     * @param i int
     * @return int
     */
    public int apply(int i);
}
