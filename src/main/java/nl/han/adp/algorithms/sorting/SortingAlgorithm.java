package nl.han.adp.algorithms.sorting;

public interface SortingAlgorithm<T extends Comparable<T>> {

    public void sort(T[] array);
}
