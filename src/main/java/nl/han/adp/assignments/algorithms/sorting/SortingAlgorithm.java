package nl.han.adp.assignments.algorithms.sorting;

public interface SortingAlgorithm<T extends Comparable<T>> {

    public void sort(T[] array);
}
