package pr22.Deux.Student;



import java.util.Optional;
import java.util.function.Function;

public class RecursiveLinearSearch<T> implements SearchFunction<T> {

    @Override
    public <E extends Comparable<E>> Optional<Integer> apply(T[] ts, E e, Function<T, E> function) {
        return search(ts, e, function, 0);
    }

    private <E extends Comparable<E>> Optional<Integer> search(T[] ts, E e, Function<T, E> function, int index) {
        if (index == ts.length) {
            return Optional.empty();
        }
        if (function.apply(ts[index]).compareTo(e) == 0) {
            return Optional.of(index);
        }
        return search(ts, e, function, index + 1);
    }
}

