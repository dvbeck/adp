package nl.han.adp.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface IList<T>   {
    /***
     * Remove all contents from the list, so it is once again empty
     */
    void clear();

    /***
     * Inserts an item at the current position
     * The client must ensure that the list's capacity is not exceeded
     * @param item the item to insert at current location
     */
    void insert(T item);

    /***
     * Append an item at the end of the list
     * The client must ensure that the list's capacity is not exceeded
     * @param item the item to append to the list
     */
    void append(T item);

    /***
     * Removes the current item from the list
     * @return the item which was removed from the list
     * @throws NoSuchElementException if there is no element at the current position in the list
     */
    T remove() throws NoSuchElementException;

    /***
     * Removes an item from the list specified by its index
     * @return the item which was removed from the list
     * @throws NoSuchElementException if there is no element at the specified position in the list
     */
    T remove(int i) throws NoSuchElementException;

    /***
     * Set the current position to the start of the list
     */
    void moveToStart();

    /***
     * Set the current position to the end of the list
     */
    void moveToEnd();

    /***
     * Move the current position one step left, no change if already at beginning
     */
    void prev();

    /***
     * Move the current position one step right, no change if already at end
     */
    void next();

    /***
     * Return the number of elements in the list
     * @return the number of elements in the list
     */
    int length();

    /***
     * Return the position of the current element
     * @return the position of the current element in the list
     */
    int currPos();


    /***
     * Moves current position to specified position
     * @param pos position to move to
     * @throws NoSuchElementException if list is empty or position is out of bounds
     */
    void moveToPos(int pos) throws NoSuchElementException;

    /***
     * Checks whether the list is currently at the last element
     * @return true only if the current element is the last element in the list
     */
    boolean isAtEnd();

    /***
     * Return the current element
     * @return the current element in the list
     * @throws NoSuchElementException if no element exists at the current position
     */
    T getValue() throws NoSuchElementException;

    /***
     * Return the element at the specified position
     * @return the element in the list at the specified position
     * @throws NoSuchElementException if no element exists at the specified position
     */
    T getValue(int i) throws NoSuchElementException;


    /***
     * Checks if the list is empty
     * @return true only if the list is empty
     */
    boolean isEmpty();
}
