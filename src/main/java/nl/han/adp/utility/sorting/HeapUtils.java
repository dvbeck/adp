package nl.han.adp.utility.sorting;

public class HeapUtils {
    public static <T extends Comparable<T>> void buildMaxHeap(T[] array) {
        int currentNode = (array.length - 1) / 2;

        while(currentNode >= 0)
            maxHeapifyNode(array, currentNode--, array.length);
    }

    public static <T extends Comparable<T>> void maxHeapifyNode(T[] array, int nodeIndex, int heapSize) {
        heapify(array, nodeIndex, heapSize, false);
    }

    public static <T extends Comparable<T>> void minHeapifyNode(T[] array, int nodeIndex, int heapSize) {
        heapify(array, nodeIndex, heapSize, true);
    }

    private static <T extends Comparable<T>> void heapify(T[] array, int nodeIndex, int heapSize, boolean reverse) {
        int leftChildNode = calculateLeftChildNodeIndex(nodeIndex);
        int rightChildNode = calculateRightChildNodeIndex(nodeIndex);
        int largestNode = nodeIndex;

        if(leftChildNode < heapSize && shouldSwitchNodes(array[leftChildNode], array[largestNode], reverse))
            largestNode = leftChildNode;
        if(rightChildNode < heapSize && shouldSwitchNodes(array[rightChildNode], array[largestNode], reverse))
            largestNode = rightChildNode;
        if(largestNode != nodeIndex) {
            T largestValue = array[largestNode];
            array[largestNode] = array[nodeIndex];
            array[nodeIndex] = largestValue;
            maxHeapifyNode(array, largestNode, heapSize);
        }
    }

    private static <T extends Comparable<T>> boolean shouldSwitchNodes(T candidate, T target, boolean invert) {
        return candidate == null || target != null && (candidate.compareTo(target) > 0 ^ invert);
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
}
