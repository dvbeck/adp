package nl.han.adp.assignments.algorithms.sorting;

import nl.han.adp.utility.sorting.CompareValues;

import java.util.Arrays;

public class TimSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    private static final int MAX_RUN_SIZE = 32;
    private final CompareValues<T> comparator;

    public TimSort(CompareValues<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(T[] array) {
        sortChunks(array);
        mergeChunks(array);
    }

    private void sortChunks(T[] array) {
        for (int i = 0; i < array.length; i+= MAX_RUN_SIZE) {
            int lastIndexOfRun = Math.min(i + MAX_RUN_SIZE - 1, array.length - 1);
            insertionSort(array, i, lastIndexOfRun);
        }
    }

    private void insertionSort(T[] array, int begin, int end) {
        for (int j = begin + 1; j <= end; j++) {
            T key = array[j];
            int i = j - 1;
            while (i >= begin && comparator.keyComesBeforeValue(key, array[i])) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
    }


    private void mergeChunks(T[] array) {
        int size = MAX_RUN_SIZE;
        while (size < array.length) {
            for(int start = 0; start < array.length; start += size * 2) {
                int mid = start + size - 1;
                int end = Math.min(start + (size * 2) - 1, array.length - 1);
                if(end > mid)
                    merge(array, start, mid, end);
            }
            size *= 2;
        }
    }

    //todo herzien want if leftNotEmpty(...) lijkt niet nodig
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
