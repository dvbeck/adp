package nl.han.adp.assignments.datastructures.queue;

import nl.han.adp.utility.sorting.CompareValues;
import nl.han.adp.utility.sorting.HeapUtils;

public class PriorityQueue<T extends Comparable<T>> implements IQueue<T>{
    private final CompareValues<T> comparator;
    private final int capacity;
    private int size;
    private final T[] queue;

    @SuppressWarnings("unchecked")
    public PriorityQueue(CompareValues<T> comparator, int capacity) {
        this.comparator = comparator;
        this.capacity = capacity;
        queue = (T[]) new Comparable[capacity];
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if(size + 1 == capacity) throw new ArrayIndexOutOfBoundsException();
        int i = size;
        size++;
        queue[i] = item;
        while(i > 0 && nodeShouldBeSwappedWithParent(i)) {
            T tmp = queue[i];
            queue[i] = queue[HeapUtils.calculateParentOfNode(i)];
            queue[HeapUtils.calculateParentOfNode(i)] = tmp;
            i = HeapUtils.calculateParentOfNode(i);
        }

    }

    private boolean nodeShouldBeSwappedWithParent(int i) {
        return comparator.keyComesBeforeValue(queue[i], queue[HeapUtils.calculateParentOfNode(i)]);
    }

    @Override
    public T dequeue() {
        if(size == 0) return null;
        T max = queue[0];
        queue[0] = queue[--size];
        queue[size] = null;
        HeapUtils.heapify(queue, 0, size, comparator);
        return max;
    }

    @Override
    public T peek() {
        return queue[0];
    }

    @Override
    public int size() {
        return size;
    }
}
