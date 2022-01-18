package nl.han.adp.datastructures.queue;

import nl.han.adp.datastructures.list.DoublyLinkedList;
import nl.han.adp.datastructures.list.IList;

public class Deque<T> implements IDeque<T> {
    private final IList<T> list = new DoublyLinkedList<>();

    @Override
    public void enqueueHead(T item) {
        list.insert(item);
    }

    @Override
    public T dequeueHead() {
        list.moveToStart();
        return list.remove();
    }

    @Override
    public T peekHead() {
        list.moveToStart();
        return list.getValue();
    }

    @Override
    public void enqueueTail(T item) {
        list.append(item);
    }

    @Override
    public T dequeueTail() {
        list.moveToEnd();
        return list.remove();
    }

    @Override
    public T peekTail() {
        list.moveToEnd();
        return list.getValue();
    }

    @Override
    public void enqueue(T item) {
        enqueueTail(item);
    }

    @Override
    public T dequeue() {
        return dequeueHead();
    }

    @Override
    public T peek() {
        return peekHead();
    }

    @Override
    public int size() {
        return list.length();
    }
}
