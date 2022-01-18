package nl.han.adp.algorithms.sorting;

import nl.han.adp.utility.Constants;
import nl.han.adp.utility.SortingTestUtils;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.dataset.JsonUtils;
import nl.han.adp.utility.Measurement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadixSortTest {

    @Test
    void shouldSortLijstAflopend2() {
        var algorithm = new RadixSort();
        var utils = new SortingTestUtils();

        utils.getJsonArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortNegatives() {
        var algorithm = new RadixSort();
        Integer[] data = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1,2,3,4,5,6,7,8,9};
        algorithm.sort(data);
        Assertions.assertArrayEquals(DataGenerator.sortCopyOfData(data), data);
    }

    @Test
    void runOften() {
        SortingAlgorithm<Integer> algorithm = new RadixSort();
        Integer[] sizes = {100_000, 500_000, 1_000_000, 5_000_000};
        int runs = 1;

        for(Integer size : sizes) {
            long sum = 0;
            long min = Integer.MAX_VALUE;
            long max = 0;
            for (int run = 0; run < runs; run++) {
                Integer[] dataset = DataGenerator.generateIntegerDataset(size);
                long time = Measurement.measureElapsedTimeOfTargetCode(() -> algorithm.sort(dataset));
                System.out.println(String.format("- Target code executed in %,d nanoseconds, or %,d microseconds, or %,d milliseconds", time, time / 1000, time / 1000000));

                sum += time;
                if (time > max) max = time;
                if (time < min) min = time;
            }
            System.out.println(String.format("Executed %d runs for %,d elements with an average elapsed time of %,d nanoseconds per run (min: %,d, max: %,d)", runs, size, sum / runs, min, max));

        }
    }
}
