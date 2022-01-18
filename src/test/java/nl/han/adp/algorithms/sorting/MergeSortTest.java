package nl.han.adp.algorithms.sorting;

import nl.han.adp.utility.*;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.dataset.JsonUtils;
import nl.han.adp.utility.sorting.AscendingComparator;
import nl.han.adp.utility.sorting.DescendingComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    void shouldSortLijstAflopend2() {
        var algorithm = new MergeSort<Integer>(new AscendingComparator<>());
        var utils = new SortingTestUtils();

        utils.getJsonArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstOplopend2() {
        var algorithm = new MergeSort<Integer>(new DescendingComparator<>());
        var utils = new SortingTestUtils();

        utils.getJsonArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.descendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstFloat() {
        var algorithm = new MergeSort<Double>(new AscendingComparator<>());
        var utils = new SortingTestUtils();

        utils.getJsonArray(Constants.Sorteren.SORTEER_LIJST_FLOAT)
                .map(JsonUtils::toDoubleArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }
    @Test
    void runOften() {
        var algorithm = new MergeSort<Integer>(new AscendingComparator<>());
        Integer[] sizes = {100_000, 500_000, 1_000_000, 5_000_000};

        for(Integer size : sizes) {
            long sum = 0;
            int runs = 1;
            long min = Integer.MAX_VALUE;
            long max = 0;
            for (int run = 0; run < runs; run++) {
                Integer[] dataset = DataGenerator.generateIntegerDataset(size);
                long time = Measurement.measureElapsedTimeOfTargetCode(() -> algorithm.sort(dataset));
                System.out.println(String.format("- Target code executed in %,d nanoseconds, or %,d microseconds, or %,d milliseconds", time, time / 1000, time / 1000000));
                Assertions.assertArrayEquals(DataGenerator.sortCopyOfData(dataset), dataset);
                sum += time;
                if (time > max) max = time;
                if (time < min) min = time;
            }
            System.out.println(String.format("Executed %d runs for %d elements with an average elapsed time of %dms per run (min: %d, max: %d)", runs, size, sum / runs, min, max));
        }
    }

    @Test
    void shouldPlaceNullsAtEnd() {
        Integer[] datasetWithNulls = {null, 5, 3, null, 1, null, 8, 8, 8, null, 8, 8, 9, 8, null, null, 10, 11, null};
        var algorithm = new MergeSort<Integer>(new AscendingComparator<>());

        Measurement.measureElapsedTimeOfTargetCode(() -> algorithm.sort(datasetWithNulls));

        System.out.println(Arrays.toString(datasetWithNulls));
    }
}
