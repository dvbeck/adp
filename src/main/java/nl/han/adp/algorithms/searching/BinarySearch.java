package nl.han.adp.algorithms.searching;

public class BinarySearch<T extends Comparable<T>> {
    public int search(T[] array, T key) {
        int low = 0;
        int high = array.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(key.compareTo(array[mid]) < 0)
                high = mid - 1;
            else if(key.compareTo(array[mid]) > 0)
                low = mid + 1;
            else
                return mid;
        }


        return -1;
    }
}
