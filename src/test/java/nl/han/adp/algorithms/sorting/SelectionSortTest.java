package nl.han.adp.algorithms.sorting;

import nl.han.adp.utility.Constants;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.SortingTestUtils;
import nl.han.adp.utility.dataset.JsonUtils;
import nl.han.adp.utility.sorting.AscendingComparator;
import nl.han.adp.utility.sorting.DescendingComparator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SelectionSortTest {

    @Test
    void shouldSortLijstAflopend2() {
        var algorithm = new SelectionSort<Integer>(new AscendingComparator<>());
        var utils = new SortingTestUtils();

        utils.getJsonArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstOplopend2() {
        var algorithm = new SelectionSort<Integer>(new DescendingComparator<>());
        var utils = new SortingTestUtils();

        utils.getJsonArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.descendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstFloat() {
        var algorithm = new SelectionSort<Double>(new AscendingComparator<>());
        var utils = new SortingTestUtils();

        utils.getJsonArray(Constants.Sorteren.SORTEER_LIJST_FLOAT)
                .map(JsonUtils::toDoubleArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }
    @Test
    void shouldPlaceNullsAtEnd() {
        Integer[] datasetWithNulls = {null, 5, 3, null, 1, null, 8, 8, 8, null, 8, 8, 9, 8, null, null, 10, 11, null};
        var algorithm = new SelectionSort<Integer>(new AscendingComparator<>());

        Measurement.measureElapsedTimeOfTargetCode(() -> algorithm.sort(datasetWithNulls));

        System.out.println(Arrays.toString(datasetWithNulls));
    }


}
