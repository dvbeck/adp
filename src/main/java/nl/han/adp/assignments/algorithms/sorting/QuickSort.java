package nl.han.adp.assignments.algorithms.sorting;

import nl.han.adp.utility.CompareValues;

public class QuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    private final CompareValues<T> comparator;

    public QuickSort(CompareValues<T> comparator) {
        this.comparator = comparator;
    }


    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length -1);
    }

    private void quickSort(T[] array, int start, int end) {
        if(start < end) {
            int q = partition(array, start, end);
            quickSort(array, start, q - 1);
            quickSort(array, q + 1, end);
        }
    }

    private int partition(T[] array, int start, int end) {
        T pivotValue = array[end];
        int lastSwappedPos = start - 1;

        for(int currentElement = start; currentElement < end; currentElement++) {
            if(comparator.keyComesBeforeValueOrTie(array[currentElement], pivotValue))
                swapValues(array, ++lastSwappedPos, currentElement);
        }

        swapValues(array, end, ++lastSwappedPos);
        return lastSwappedPos;
    }


    private void swapValues(T[] array, int source, int target) {
        T tmp = array[target];
        array[target] = array[source];
        array[source] = tmp;
    }
}
