package pr22.Deux.Student;


import java.util.Optional;
import java.util.function.Function;

public class LinearSearch<T> implements SearchFunction<T> {

    @Override
    public <E extends Comparable<E>> Optional<Integer> apply(T[] ts, E e, Function<T, E> function) {
        Integer index = null;
        for (int i = 0; i < ts.length; i++) {
            if (function.apply(ts[i]).compareTo(e) == 0) {
                index = i;
                break;
            }
        }
        return Optional.ofNullable(index);
    }
}
