package nl.han.adp.algorithms.datastructures;

import nl.han.adp.datastructures.list.DoublyLinkedList;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {
    @Test
    void shouldInsertInEmptyList() {
        DoublyLinkedList<Integer> llist = new DoublyLinkedList<>();
        Integer[] elements = {10, 30, 50, 80};
        for(Integer n : elements) {
            llist.insert(n);
            llist.printDebug();
        }
        llist.next();
        llist.next();
        System.out.println(llist.currPos());
    }

    @Test
    void shouldAppendItemsToList() {
        DoublyLinkedList<Integer> llist = new DoublyLinkedList<>();
        llist.printDebug();
        Integer[] elements = {10, 30, 50, 80};
        for(Integer n : elements) {
            llist.append(n);
            llist.printDebug();
        }
        System.out.println(llist.currPos());
    }
}
