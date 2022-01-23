package nl.han.adp.utility;

import nl.han.adp.assignments.algorithms.sorting.SortingAlgorithm;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.dataset.JsonUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

public class DataSetUtils {

    public Optional<JSONArray> getSortingArray(String array) {
        return JsonUtils.readFromResources(Constants.Files.DATASET_SORTEREN).map(json -> json.getJSONArray(array));
    }

    public Optional<JSONObject> getHashingObject(String array) {
        return JsonUtils.readFromResources(Constants.Files.DATASET_HASHING).map(json -> json.getJSONObject(array));
    }

    public Optional<JSONArray> getGraphArray(String array) {
        return JsonUtils.readFromResources(Constants.Files.DATASET_GRAPH).map(json -> json.getJSONArray(array));
    }

    public <T extends Comparable<T>> void ascendingSortDatasetAndAssertSorted(SortingAlgorithm<T> sortingAlgorithm, T[] data) {
        long elapsedTimeOfTargetCode = Measurement.measureElapsedTimeOfTargetCode(() -> sortingAlgorithm.sort(data));
        Measurement.outputDuration(elapsedTimeOfTargetCode);
        Assertions.assertArrayEquals(DataGenerator.sortCopyOfData(data), data);
    }



    public <T extends Comparable<T>> void descendingSortDatasetAndAssertSorted(SortingAlgorithm<T> sortingAlgorithm, T[] data) {
        long elapsedTimeOfTargetCode = Measurement.measureElapsedTimeOfTargetCode(() -> sortingAlgorithm.sort(data));
        Measurement.outputDuration(elapsedTimeOfTargetCode);
        Assertions.assertArrayEquals(DataGenerator.sortCopyOfDataDesc(data), data);
    }
}

