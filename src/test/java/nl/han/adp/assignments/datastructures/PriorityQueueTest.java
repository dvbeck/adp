package nl.han.adp.assignments.datastructures;

import nl.han.adp.assignments.datastructures.queue.IQueue;
import nl.han.adp.assignments.datastructures.queue.PriorityQueue;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.DataSetUtils;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.dataset.JsonUtils;
import nl.han.adp.utility.sorting.AscendingComparator;
import nl.han.adp.utility.sorting.DescendingComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import java.util.Arrays;

public class PriorityQueueTest {
    private final DataSetUtils utils = new DataSetUtils();

    @Test
    void shouldInsertLijstAflopend2() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new DescendingComparator<>(), 10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstOplopend2() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new AscendingComparator<>(), 10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstFloat() {
        IQueue<Double> structure = new PriorityQueue<Double>(new AscendingComparator<>(), 10000);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_FLOAT).map(JsonUtils::toDoubleArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        insertValues(structure, sortedData);
        readValues(structure, sortedData);
    }

    @Test
    void shouldInsertLijstGesorteerdAflopend3() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new DescendingComparator<>(), 10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_AFLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstGesorteerdOplopend3() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new AscendingComparator<>(), 10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_OPLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstHerhaald() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new AscendingComparator<>(), 10001);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_HERHAALD).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        insertValues(structure, sortedData);
        readValues(structure, sortedData);
    }

    @Test
    void shouldInsertLijstLeeg() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new AscendingComparator<>(), 10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_LEEG).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstNull1() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new AscendingComparator<>(), 10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_1).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstNull3() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new AscendingComparator<>(), 10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        insertValues(structure, sortedData);
        readValues(structure, sortedData);
    }

    @Test
    void shouldNotInsertLijstOnsorteerbaar() {
        IQueue<Double> structure = new PriorityQueue<Double>(new AscendingComparator<>(), 10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_ONSORTEERBAAR).map(JsonUtils::toDoubleArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstOplopend10000() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new AscendingComparator<>(), 100001);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig10000() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new AscendingComparator<>(), 10001);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        insertValues(structure, sortedData);
        readValues(structure, sortedData);
    }

    @Test
    void shouldInsertLijstWillekeurig3() {
        IQueue<Integer> structure = new PriorityQueue<Integer>(new AscendingComparator<>(), 10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        insertValues(structure, sortedData);
        readValues(structure, sortedData);
    }

    @Test
    void priorityQueueTest() {
        IQueue<Integer> queue = new PriorityQueue<Integer>(new AscendingComparator<>(), 2_000_000_000);
        for (Integer i : DataGenerator.generateIntegerDataset(2_000_000)) queue.enqueue(i);

        System.out.println(Measurement.measureElapsedTimeOfTargetCode(() -> queue.enqueue(2_000_001)));

        System.out.println(Measurement.measureElapsedTimeOfTargetCode(queue::dequeue));
    }

    private <T extends Comparable<T>> void insertValues(IQueue<T> structure, T[] data) {
        var totalElapsedTime = 0;
        for (T value : data) {
            totalElapsedTime += Measurement.measureElapsedTimeOfTargetCode(() -> structure.enqueue(value));
        }
        Measurement.outputDuration(totalElapsedTime, "Insertion");
    }

    private <T extends Comparable<T>> void readValues(IQueue<T> structure, T[] data) {
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
