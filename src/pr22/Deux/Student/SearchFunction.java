package pr22.Deux.Student;


import java.util.Optional;
import java.util.function.Function;

public interface SearchFunction<T> {

    <E extends Comparable<E>> Optional<Integer> apply(T[] ts, E e, Function<T, E> function);

}