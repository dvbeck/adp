package nl.han.adp.utility;

import nl.han.adp.algorithms.sorting.SortingAlgorithm;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.dataset.JsonUtils;
import nl.han.adp.utility.Measurement;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

public class SortingTestUtils {

    public Optional<JSONArray> getJsonArray(String array) {
        return JsonUtils.readFromResources(Constants.Files.DATASET_SORTEREN).map(json -> json.getJSONArray(array));
    }

    public <T extends Comparable<T>> void ascendingSortDatasetAndAssertSorted(SortingAlgorithm<T> sortingAlgorithm, T[] data) {
        long elapsedTimeOfTargetCode = Measurement.measureElapsedTimeOfTargetCode(() -> sortingAlgorithm.sort(data));
        System.out.println(String.format("Target code executed in %,d nanoseconds, or %,d microseconds, or %,d milliseconds", elapsedTimeOfTargetCode, elapsedTimeOfTargetCode / 1000, elapsedTimeOfTargetCode / 1000000));
        Assertions.assertArrayEquals(DataGenerator.sortCopyOfData(data), data);
    }

    public <T extends Comparable<T>> void descendingSortDatasetAndAssertSorted(SortingAlgorithm<T> sortingAlgorithm, T[] data) {
        long elapsedTimeOfTargetCode = Measurement.measureElapsedTimeOfTargetCode(() -> sortingAlgorithm.sort(data));
        System.out.println(String.format("Target code executed in %,d nanoseconds, or %,d microseconds, or %,d milliseconds", elapsedTimeOfTargetCode, elapsedTimeOfTargetCode / 1000, elapsedTimeOfTargetCode / 1000000));
        Assertions.assertArrayEquals(DataGenerator.sortCopyOfDataDesc(data), data);
    }
}

