package nl.han.adp.assignments.datastructures.stack;

public interface IStack<T> {
    /***
     * Pushes an item on the stack
     * @param item item to push on the stack
     * @return true if the item was pushed on the stack or false if the stack is full
     */
    boolean push(T item);

    /***
     * Pops an item from the stack
     * @return an item of type T if the stack was not empty, or null if the stack was empty
     */
    T pop();

    /***
     * @return true if the stack is empty or false if the stack contains items
     */
    boolean isEmpty();

    /***
     * @return the number of elements on the stack
     */
    int size();

    /***
     * Empties the stack by removing all elements
     */
    void clear();
}
