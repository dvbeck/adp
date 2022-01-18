package nl.han.adp.algorithms.datastructures;

import nl.han.adp.datastructures.queue.IQueue;
import nl.han.adp.datastructures.queue.PriorityQueue;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.Measurement;
import org.junit.jupiter.api.Test;

public class PriorityQueueTest {
    @Test
    void priorityQueueTest() {
        IQueue<Integer> queue = new PriorityQueue<>(2_000_000_000);
        for(Integer i : DataGenerator.generateIntegerDataset(2_000_000)) queue.enqueue(i);

        System.out.println(Measurement.measureElapsedTimeOfTargetCode(() -> queue.enqueue(2_000_001)));

        System.out.println(Measurement.measureElapsedTimeOfTargetCode(queue::dequeue));
    }
}
