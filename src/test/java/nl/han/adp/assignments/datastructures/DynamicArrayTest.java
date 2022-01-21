package nl.han.adp.assignments.datastructures;

import nl.han.adp.assignments.datastructures.list.DynamicArray;
import nl.han.adp.assignments.datastructures.list.IList;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.DataSetUtils;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.dataset.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicArrayTest {
    private final DataSetUtils utils = new DataSetUtils();

    @Test
    void shouldInsertLijstAflopend2() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstOplopend2() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstFloat() {
        IList<Double> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_FLOAT).map(JsonUtils::toDoubleArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstGesorteerdAflopend3() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_AFLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstGesorteerdOplopend3() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_OPLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstHerhaald() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_HERHAALD).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstLeeg() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_LEEG).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstNull1() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_1).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstNull3() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldNotInsertLijstOnsorteerbaar() {
        IList<Object> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_ONSORTEERBAAR).map(JsonUtils::toObjectArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstOplopend10000() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig10000() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig3() {
        IList<Integer> structure = new DynamicArray<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

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

    private <T> void insertValues(IList<T> structure, T[] data) {
        var totalElapsedTime = 0;
        for (T value : data) {
            totalElapsedTime += Measurement.measureElapsedTimeOfTargetCode(() -> structure.insert(value));
        }
        Measurement.outputDuration(totalElapsedTime, "Inserting");
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