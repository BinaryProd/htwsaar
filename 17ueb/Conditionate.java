import java.util.function.Predicate;

public interface Conditionate extends MyFunction {

    default MyFunction conditionateInput(Predicate predicate) {
        MyFunction result = x -> predicate.test(x) ? apply(x) : 0;  
        return result;
    }

    default MyFunction conditionateOutput(Predicate predicate) {
        MyFunction result = x -> predicate.test(apply(x)) ? apply(x) : 0;
        return result;
    }
}
