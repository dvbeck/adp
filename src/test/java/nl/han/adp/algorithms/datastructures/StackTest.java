package nl.han.adp.algorithms.datastructures;

import nl.han.adp.datastructures.stack.IStack;
import nl.han.adp.datastructures.stack.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    @Test
    void shouldPushPopEmpty() {
        IStack<Integer> stack = new Stack<>();

        stack.push(1);
        Integer val = stack.pop();

        assertEquals(1, val);
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    void shouldPushTwiceAndCheckSize() {
        IStack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldPushThreeTimesAndPopAndCheckSize() {
        IStack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        var val = stack.pop();

        assertEquals(3, val);
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldEmptyStack() {
        IStack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        stack.clear();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }
}
