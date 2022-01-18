package nl.han.adp.algorithms.sorting;

import nl.han.adp.utility.*;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.dataset.JsonUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HeapSortTest {

    @Test
    void heapSortTest() {
        Integer[] dataset = DataGenerator.generateIntegerDataset(10_000_000);
        Integer[] controlData = DataGenerator.sortCopyOfData(dataset);

        SortingAlgorithm<Integer> algorithm = new HeapSort<>();

        long time = Measurement.measureElapsedTimeOfTargetCode(() -> algorithm.sort(dataset));

        assertArrayEquals(controlData, dataset);
        System.out.println(time);
    }

    @Test
    void heapSortTestString() {
        String[] dataset = {"cc", "ba", "ab", "cd", "aa", "bb"};
        SortingAlgorithm<String> algorithm = new HeapSort<>();
        algorithm.sort(dataset);
        System.out.println(Arrays.toString(dataset));
    }

    @Test
    void heapSortTestWithNull() {
        Integer[] datasetWithNulls = {null, 5, 3, null, 1, null, 8, 8, 8, null, 8, 8, 9, 8, null, null, 10, 11, null};
        SortingAlgorithm<Integer> algorithm = new HeapSort<>();

        Measurement.measureElapsedTimeOfTargetCode(() -> algorithm.sort(datasetWithNulls));

        System.out.println(Arrays.toString(datasetWithNulls));
    }


    @Test
    void shouldSortLijstAflopend2() {
        var algorithm = new HeapSort<Integer>();
        var utils = new SortingTestUtils();

        utils.getJsonArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }


}
