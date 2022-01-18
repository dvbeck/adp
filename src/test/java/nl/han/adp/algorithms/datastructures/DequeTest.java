package nl.han.adp.algorithms.datastructures;

import nl.han.adp.datastructures.queue.Deque;
import nl.han.adp.datastructures.queue.IDeque;
import nl.han.adp.datastructures.queue.IQueue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {
    @Test
    void shouldDequeueFromBothEnds() {
        IDeque<Integer> deque = new Deque<>();

        deque.enqueue(1);
        deque.enqueue(2);
        deque.enqueue(3);

        var tailVal = deque.dequeueTail();
        var headVal = deque.dequeueHead();

        assertEquals(3, tailVal);
        assertEquals(1, headVal);
        assertEquals(1, deque.size());
    }

    @Test
    void shouldBehaveAsQueue() {
        IQueue<Integer> deque = new Deque<>();

        deque.enqueue(1);
        deque.enqueue(2);
        deque.enqueue(3);

        var val1 = deque.dequeue();
        var val2 = deque.dequeue();

        assertEquals(1, val1);
        assertEquals(2, val2);
        assertEquals(1, deque.size());
    }
}
