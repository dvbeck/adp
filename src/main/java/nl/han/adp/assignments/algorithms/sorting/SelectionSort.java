package nl.han.adp.assignments.algorithms.sorting;

import nl.han.adp.utility.sorting.CompareValues;

public class SelectionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    private final CompareValues<T> comparator;

    public SelectionSort(CompareValues<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(T[] array) {
        for (int sortedValues = 0; sortedValues < array.length - 1; sortedValues++) {
            int largestIndex = 0;
            for (int j = 1; j < array.length - sortedValues; j++) {
                if (comparator.keyComesBeforeValue(array[largestIndex], array[j])) {
                    largestIndex = j;
                }
            }
            T temp = array[array.length - sortedValues - 1];
            array[array.length - sortedValues - 1] = array[largestIndex];
            array[largestIndex] = temp;
        }

    }
}
