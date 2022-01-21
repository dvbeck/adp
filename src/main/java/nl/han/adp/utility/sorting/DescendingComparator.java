package nl.han.adp.utility.sorting;

public class DescendingComparator<T extends Comparable<T>> implements CompareValues<T> {
    @Override
    public boolean keyComesBeforeValue(T key, T value) {
        return value == null || key != null && (value.compareTo(key) < 0);
    }

    @Override
    public boolean keyComesBeforeValueOrTie(T key, T value) {
        return value == null || key != null && (value.compareTo(key) <= 0);
    }
}
