package nl.han.adp.assignments.datastructures;

import nl.han.adp.assignments.datastructures.list.DoublyLinkedList;
import nl.han.adp.assignments.datastructures.list.IList;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.DataSetUtils;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

public class DoublyLinkedListTest {

    private final DataSetUtils utils = new DataSetUtils();

    @Test
    void shouldInsertLijstAflopend2() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstOplopend2() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstFloat() {
        IList<Double> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_FLOAT).map(JsonUtils::toDoubleArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstGesorteerdAflopend3() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_AFLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstGesorteerdOplopend3() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_OPLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstHerhaald() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_HERHAALD).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstLeeg() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_LEEG).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstNull1() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_1).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstNull3() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldNotInsertLijstOnsorteerbaar() {
        IList<Object> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_ONSORTEERBAAR).map(JsonUtils::toObjectArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstOplopend10000() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig10000() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig3() {
        IList<Integer> structure = new DoublyLinkedList<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertInEmptyList() {
        DoublyLinkedList<Integer> llist = new DoublyLinkedList<>();
        Integer[] elements = {10, 30, 50, 80};
        for (Integer n : elements) {
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
        for (Integer n : elements) {
            llist.append(n);
            llist.printDebug();
        }
        System.out.println(llist.currPos());
    }

    private <T> void insertValues(IList<T> structure, T[] data) {
        var totalElapsedTime = 0;
        for (T value : data) {
            totalElapsedTime += Measurement.measureElapsedTimeOfTargetCode(() -> structure.append(value));
        }
        Measurement.outputDuration(totalElapsedTime, "Appending");
    }

    private <T> void readValues(IList<T> structure, T[] data) {
        var totalElapsedTime = 0;
        for (int i = 0; i < data.length; i++) {
            long start = System.nanoTime();
            var val = structure.getValue(i);
            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertEquals(data[i], val);

        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }
}
