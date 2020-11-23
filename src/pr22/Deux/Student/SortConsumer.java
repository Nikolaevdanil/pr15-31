package pr22.Deux.Student;


import java.util.Comparator;
import java.util.function.BiConsumer;

public interface SortConsumer<T> extends BiConsumer<T[], Comparator<T>> {
}

