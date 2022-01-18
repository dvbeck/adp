package nl.han.adp.algorithms.datastructures;

import nl.han.adp.datastructures.list.DynamicArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {
    @Test
    void shouldGrowArray() {
        DynamicArray<Integer> list = new DynamicArray<>();
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (Integer v : data) {
            list.append(v);
        }
        int capacityAfterTenthElement = list.getCapacity();
        list.append(11);
        int capacityAfterEleventhElement = list.getCapacity();

        assertTrue(capacityAfterEleventhElement > capacityAfterTenthElement);
    }

    @Test
    void shouldHaveProperLength() {
        DynamicArray<Integer> list = new DynamicArray<>();
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (Integer v : data) {
            list.append(v);
            System.out.println(list.length());
        }

    }

    @Test
    void shouldRemoveElementAndShrink() {
        DynamicArray<Integer> list = new DynamicArray<>();

        for (int i = 22; i > 0; i--) {
            list.append(i);
        }
        list.moveToPos(21);
        for (int i = 21; i >= 0; i--) {
            list.remove(i);
        }
        System.out.println(list.getCapacity());
    }

    @Test
    void shouldIterate() {
        DynamicArray<Integer> list = new DynamicArray<>();

        for (int i = 0; i < 20; i++) {
            list.append(i);
        }

        list.moveToStart();
        while(!list.isAtEnd()) {
            System.out.println(list.getValue());
            list.next();
        }
    }
}