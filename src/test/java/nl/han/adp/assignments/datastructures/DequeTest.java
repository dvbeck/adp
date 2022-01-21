package nl.han.adp.assignments.datastructures;

import nl.han.adp.assignments.algorithms.searching.avl.BinaryTree;
import nl.han.adp.assignments.datastructures.queue.Deque;
import nl.han.adp.assignments.datastructures.queue.IDeque;
import nl.han.adp.assignments.datastructures.queue.IQueue;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.DataSetUtils;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.dataset.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {
    private final DataSetUtils utils = new DataSetUtils();

    @Test
    void shouldInsertLijstAflopend2() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstOplopend2() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }


    @Test
    void shouldInsertLijstFloat() {
        IQueue<Double> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_FLOAT).map(JsonUtils::toDoubleArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }


    @Test
    void shouldInsertLijstGesorteerdAflopend3() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_AFLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }


    @Test
    void shouldInsertLijstGesorteerdOplopend3() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_OPLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }


    @Test
    void shouldInsertLijstHerhaald() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_HERHAALD).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }


    @Test
    void shouldInsertLijstLeeg() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_LEEG).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }


    @Test
    void shouldInsertLijstNull1() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_1).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }


    @Test
    void shouldInsertLijstNull3() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }


    @Test
    void shouldNotInsertLijstOnsorteerbaar() {
        IQueue<Object> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_ONSORTEERBAAR).map(JsonUtils::toObjectArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }


    @Test
    void shouldInsertLijstOplopend10000() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig10000() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig3() {
        IQueue<Integer> structure = new Deque<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

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

    private <T> void insertValues(IQueue<T> structure, T[] data) {
        var totalElapsedTime = 0;
        for (T value : data) {
            totalElapsedTime += Measurement.measureElapsedTimeOfTargetCode(() -> structure.enqueue(value));
        }
        Measurement.outputDuration(totalElapsedTime, "Insertion");
    }

    private <T> void readValues(IQueue<T> structure, T[] data) {
        var totalElapsedTime = 0;
        for (T value : data) {
            long start = System.nanoTime();
            var val = structure.dequeue();
            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertEquals(value, val);

        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }
}
