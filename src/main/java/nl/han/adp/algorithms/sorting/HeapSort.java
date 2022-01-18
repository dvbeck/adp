package nl.han.adp.algorithms.sorting;

import nl.han.adp.utility.sorting.HeapUtils;

public class HeapSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        HeapUtils.buildMaxHeap(array);

        for(int i = array.length - 1; i > 0; i--) {
            T k = array[i];
            array[i] = array[0];
            array[0] = k;
            HeapUtils.maxHeapifyNode(array, 0, i);
        }

    }


}
