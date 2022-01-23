package nl.han.adp.assignments.algorithms.sorting;

import nl.han.adp.utility.CompareValues;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    private final CompareValues<T> comparator;

    public MergeSort(CompareValues<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(T[] array, int begin, int end) {
        if (begin < end) {
            int mid = (end + begin) / 2;
            mergeSort(array, begin, mid);
            mergeSort(array, mid + 1, end);
            merge(array, begin, mid, end);
        }
    }

    private void merge(T[] array, int begin, int mid, int end) {
        T[] leftArray = Arrays.copyOfRange(array, begin, mid + 1);
        T[] rightArray = Arrays.copyOfRange(array, mid + 1, end + 1);
        
        int leftArrayCurrentIndex = 0;
        int rightArrayCurrentIndex = 0;
        for (int i = begin; i < end + 1; i++) {
            boolean leftNotEmpty = leftArrayCurrentIndex < leftArray.length;
            boolean rightNotEmpty = rightArrayCurrentIndex < rightArray.length;

            if (leftNotEmpty && (!rightNotEmpty || comparator.keyComesBeforeValueOrTie(leftArray[leftArrayCurrentIndex], rightArray[rightArrayCurrentIndex]))) {
                array[i] = leftArray[leftArrayCurrentIndex];
                leftArrayCurrentIndex++;
            } else if (rightNotEmpty) {
                array[i] = rightArray[rightArrayCurrentIndex];
                rightArrayCurrentIndex++;
            }
        }
    }
}

