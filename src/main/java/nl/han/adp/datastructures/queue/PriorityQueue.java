package nl.han.adp.datastructures.queue;

import nl.han.adp.utility.sorting.HeapUtils;

public class PriorityQueue<T extends Comparable<T>> implements IQueue<T>{
    private final int capacity;
    private int size;
    private final T[] queue;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity) {
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
        return queue[HeapUtils.calculateParentOfNode(i)].compareTo(queue[i]) < 0;
    }

    @Override
    public T dequeue() {
        if(size == 0) return null;
        T max = queue[0];
        queue[0] = queue[--size];
        queue[size] = null;
        HeapUtils.maxHeapifyNode(queue, 0, size);
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
