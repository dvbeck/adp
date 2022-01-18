package nl.han.adp.utility.sorting;

public interface CompareValues<T extends Comparable<T>> {
    boolean keyComesBeforeValue(T key, T value);
    boolean keyComesBeforeValueOrAreEqual(T key, T value);
}
