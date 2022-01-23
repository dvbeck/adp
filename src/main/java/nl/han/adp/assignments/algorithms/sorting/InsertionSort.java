package nl.han.adp.assignments.algorithms.sorting;

import nl.han.adp.utility.sorting.CompareValues;

public class InsertionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    private final CompareValues<T> comparator;

    public InsertionSort(CompareValues<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(T[] array) {
        for (int j = 1; j < array.length; j++) {
            T key = array[j];
            int i = j - 1;
            while (i >= 0 && comparator.keyComesBeforeValue(key, array[i])) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
    }


}
