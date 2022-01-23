package nl.han.adp.utility;

public interface CompareValues<T extends Comparable<T>> {
    boolean keyComesBeforeValue(T key, T value);
    boolean keyComesBeforeValueOrTie(T key, T value);
}
