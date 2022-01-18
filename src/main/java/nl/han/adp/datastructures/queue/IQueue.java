package nl.han.adp.datastructures.queue;

public interface IQueue<T> {
    /***
     * Places an item and the tail of the queue
     * @param item the item to place on the queue
     */
    void enqueue(T item);

    /***
     * Takes and removes the item from the head of the queue;
     * @return the item at the head of the queue
     */
    T dequeue();

    /***
     * Takes an item from the head of the queue without removing it
     * @return the item at the head of the queue
     */
    T peek();

    /***
     * @return the amount of items on the queue
     */
    int size();

}
