package nl.han.adp.assignments.datastructures.queue;

public interface IDeque<T> extends IQueue<T> {
    /***
     * Places an item and the head of the queue
     * @param item the item to place on the queue
     */
    void enqueueHead(T item);

    /***
     * Takes and removes an item from the head of the queue
     * @return the item at the head of the queue
     */
    T dequeueHead();

    /***
     * Takes the item from the head of the queue without removing it
     * @return the item at the head of the queue
     */
    T peekHead();

    /***
     * Places an item and the tail of the queue
     * @param item the item to place on the queue
     */
    void enqueueTail(T item);

    /***
     * Takes and removes an item from the tail of the queue
     * @return the item at the tail of the queue
     */
    T dequeueTail();

    /***
     * Takes the item from the tail of the queue without removing it
     * @return the item at the tail of the queue
     */
    T peekTail();


}
