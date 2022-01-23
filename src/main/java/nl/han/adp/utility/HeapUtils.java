package nl.han.adp.utility;

public class HeapUtils {
    public static <T extends Comparable<T>> void heapify(T[] array, int nodeIndex, int heapSize, CompareValues<T> comparator) {
        int leftChildNode = calculateLeftChildNodeIndex(nodeIndex);
        int rightChildNode = calculateRightChildNodeIndex(nodeIndex);
        int largestNode = nodeIndex;

        if(leftChildNode < heapSize && comparator.keyComesBeforeValue(array[leftChildNode], array[largestNode]))
            largestNode = leftChildNode;
        if(rightChildNode < heapSize && comparator.keyComesBeforeValue(array[rightChildNode], array[largestNode]))
            largestNode = rightChildNode;
        if(largestNode != nodeIndex) {
            T largestValue = array[largestNode];
            array[largestNode] = array[nodeIndex];
            array[nodeIndex] = largestValue;
            heapify(array, largestNode, heapSize, comparator);
        }
    }

    public static int calculateLeftChildNodeIndex(int i) {
        return ((i+1)*2)-1;
    }

    public static int calculateRightChildNodeIndex(int i) {
        return ((i+1)*2);
    }

    public static int calculateParentOfNode(int i) {
        return (i-1)/2;
    }

    public static <T extends Comparable<T>> void buildHeap(T[] array, CompareValues<T> comparator) {
        int currentNode = (array.length - 1) / 2;

        while(currentNode >= 0)
            heapify(array, currentNode--, array.length, comparator);
    }
}
