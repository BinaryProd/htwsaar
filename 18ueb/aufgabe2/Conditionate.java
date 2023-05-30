/**
 * <h1> Conditionate </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.function.Predicate;

public interface Conditionate extends MyFunction {

    /**
     * Method that conditionates the input of a function
     * @param predicate Predicate
     * @return MyFunction
     */
    default MyFunction conditionateInput(Predicate predicate) {
        MyFunction result = x -> predicate.test(x) ? apply(x) : 0;  
        return result;
    }

    /**
     * Method that conditionates the output of a function
     * @param predicate Predicate
     * @return MyFunction
     */
    default MyFunction conditionateOutput(Predicate predicate) {
        MyFunction result = x -> predicate.test(apply(x)) ? apply(x) : 0;
        return result;
    }
}
