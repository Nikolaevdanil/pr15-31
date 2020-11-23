package pr22.Deux.Student;
import java.util.Optional;
import java.util.function.Function;

public class RecursiveBinarySearch<T> implements SearchFunction<T> {

    @Override
    public <E extends Comparable<E>>  Optional<Integer> apply(T[] ts, E e, Function<T, E> function) {
        return search(ts, e, function, 0, ts.length - 1);
    }

    private <E extends Comparable<E>> Optional<Integer> search(T[] ts, E e, Function<T, E> function, int low, int high) {
        int middle = (low + high) / 2;

        if (high < low) {
            return Optional.empty();
        }

        if (function.apply(ts[middle]).compareTo(e) == 0) {
            return Optional.of(middle);
        } else if (function.apply(ts[middle]).compareTo(e) > 0) {
            return search(ts, e, function, low, middle - 1);
        } else {
            return search(ts, e, function, middle + 1, high);
        }
    }
}
