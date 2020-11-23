package pr22.Deux.Student;


import java.util.Optional;
import java.util.function.Function;

public class BinarySearch<T> implements SearchFunction<T> {

    @Override
    public <E extends Comparable<E>> Optional<Integer> apply(T[] ts, E e, Function<T, E> function) {
        Integer index = null;
        int low = 0, high = ts.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (function.apply(ts[mid]).compareTo(e) < 0) {
                low = mid + 1;
            } else if (function.apply(ts[mid]).compareTo(e) > 0) {
                high = mid - 1;
            } else if (function.apply(ts[mid]).compareTo(e) == 0) {
                index = mid;
                break;
            }
        }
        return Optional.ofNullable(index);
    }
}
