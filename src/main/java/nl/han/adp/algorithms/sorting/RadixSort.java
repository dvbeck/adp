package nl.han.adp.algorithms.sorting;

public class RadixSort implements SortingAlgorithm<Integer> {

    private void countingSortByDigit(Integer[] array, int digitPosition) {
        int size = array.length;
        Integer[] output = new Integer[size + 1];
        int[] buckets = calculateTargetIndicesPerDigit(array, digitPosition);

        for (int i = size - 1; i >= 0; i--) {
            int digitAtPosition = calculateBucketPosition(digitPosition, array[i]);

            int targetIndex = buckets[digitAtPosition] - 1;
            output[targetIndex] = array[i];
            buckets[digitAtPosition]--;
        }

        System.arraycopy(output, 0, array, 0, size);
    }

    private int[] calculateTargetIndicesPerDigit(Integer[] array, int digitPosition) {
        int[] buckets = new int[20];

        for (int value : array) {
            int bucket = calculateBucketPosition(digitPosition, value);
            buckets[bucket]++;
        }

        for (int i = 1; i < buckets.length; i++)
            buckets[i] += buckets[i - 1];

        return buckets;
    }

    private int calculateBucketPosition(int digitPosition, int value) {
        int bucketPosition = (value / digitPosition) % 10;
        if (bucketPosition < 0) bucketPosition = 10 - Math.abs(bucketPosition);
        else bucketPosition = bucketPosition + 10;
        return bucketPosition;
    }

    private int getLargestElementFromArray(Integer[] array) {
        int n = array.length;

        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }


    @Override
    public void sort(Integer[] array) {
        int max = getLargestElementFromArray(array);

        for (int digitPosition = 1; max / digitPosition > 0; digitPosition *= 10)
            countingSortByDigit(array, digitPosition);
    }
}
