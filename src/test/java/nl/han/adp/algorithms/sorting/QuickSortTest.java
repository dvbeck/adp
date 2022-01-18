package nl.han.adp.algorithms.sorting;

import nl.han.adp.utility.sorting.AscendingComparator;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.Measurement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortTest {
    @Test
    void testQuickSort() {
//        Integer[] dataset = DataGenerator.generateIntegerDataset(10_000_000);
        Integer[] dataset = {1,10,4,6,3,7,5};
        Integer[] controlData = DataGenerator.sortCopyOfData(dataset);


        SortingAlgorithm<Integer> algorithm = new QuickSort<>(new AscendingComparator<Integer>());

        long time = Measurement.measureElapsedTimeOfTargetCode(() -> algorithm.sort(dataset));

        Assertions.assertArrayEquals(controlData, dataset);
        System.out.println(time);
    }

    @Test
    void runOften() {
        SortingAlgorithm<Integer> algorithm = new QuickSort<>(new AscendingComparator<Integer>());
        Integer[] sizes = {100_000, 500_000, 1_000_000, 5_000_000, 10_000_000};

        for(Integer size : sizes) {
            long sum = 0;
            int runs = 20;
            long min = Integer.MAX_VALUE;
            long max = 0;
            for (int run = 0; run < runs; run++) {
                Integer[] dataset = DataGenerator.generateIntegerDataset(size);
                long time = Measurement.measureElapsedTimeOfTargetCode(() -> algorithm.sort(dataset));
                sum += time;
                if (time > max) max = time;
                if (time < min) min = time;
            }
            System.out.println(String.format("Executed %d runs for %d elements with an average elapsed time of %dms per run (min: %d, max: %d)", runs, size, sum / runs, min, max));
        }
    }
}
