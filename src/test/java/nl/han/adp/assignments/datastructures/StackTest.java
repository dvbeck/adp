package nl.han.adp.assignments.datastructures;

import nl.han.adp.assignments.datastructures.stack.IStack;
import nl.han.adp.assignments.datastructures.stack.Stack;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.DataSetUtils;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private final DataSetUtils utils = new DataSetUtils();

    @Test
    void shouldInsertLijstAflopend2() {
        IStack<Integer> structure = new Stack<>(10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstOplopend2() {
        IStack<Integer> structure = new Stack<>(10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstFloat() {
        IStack<Double> structure = new Stack<>(10000);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_FLOAT).map(JsonUtils::toDoubleArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstGesorteerdAflopend3() {
        IStack<Integer> structure = new Stack<>(10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_AFLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstGesorteerdOplopend3() {
        IStack<Integer> structure = new Stack<>(10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_OPLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstHerhaald() {
        IStack<Integer> structure = new Stack<>(10001);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_HERHAALD).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstLeeg() {
        IStack<Integer> structure = new Stack<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_LEEG).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstNull1() {
        IStack<Integer> structure = new Stack<>(10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_1).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstNull3() {
        IStack<Integer> structure = new Stack<>(10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldNotInsertLijstOnsorteerbaar() {
        IStack<Object> structure = new Stack<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_ONSORTEERBAAR).map(JsonUtils::toObjectArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstOplopend10000() {
        IStack<Integer> structure = new Stack<>(10001);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig10000() {
        IStack<Integer> structure = new Stack<>(10001);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig3() {
        IStack<Integer> structure = new Stack<>(10);

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValues(structure, data);
        readValues(structure, data);
    }
    
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

    private <T> void insertValues(IStack<T> structure, T[] data) {
        var totalElapsedTime = 0;
        for (T value : data) {
            totalElapsedTime += Measurement.measureElapsedTimeOfTargetCode(() -> structure.push(value));
        }
        Measurement.outputDuration(totalElapsedTime, "Pushing");
    }

    private <T> void readValues(IStack<T> structure, T[] data) {
        var totalElapsedTime = 0;

        for(int i = data.length -1; i > 0; i--) {
            long start = System.nanoTime();
            var val = structure.pop();
            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertEquals(data[i], val);

        }
        Measurement.outputDuration(totalElapsedTime, "Popping");
    }
}
