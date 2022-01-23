package nl.han.adp.assignments.searching;

import nl.han.adp.assignments.algorithms.searching.BinarySearch;
import nl.han.adp.assignments.datastructures.queue.Deque;
import nl.han.adp.assignments.datastructures.queue.IQueue;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.DataSetUtils;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.dataset.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import java.util.Arrays;

public class BinarySearchTest {
    private final DataSetUtils utils = new DataSetUtils();

    @Test
    void shouldFindInLijstAflopend2() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");

    }

    @Test
    void shouldFindInLijstOplopend2() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }


    @Test
    void shouldFindInLijstFloat() {
        BinarySearch<Double> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_FLOAT).map(JsonUtils::toDoubleArray).orElseThrow(TestAbortedException::new);
        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Double value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }


    @Test
    void shouldFindInLijstGesorteerdAflopend3() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_AFLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }


    @Test
    void shouldFindInLijstGesorteerdOplopend3() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_OPLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }


    @Test
    void shouldFindInLijstHerhaald() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_HERHAALD).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }


    @Test
    void shouldFindInLijstLeeg() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_LEEG).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);


        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }


    @Test
    void shouldFindInLijstNull1() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_1).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);


        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            if (value == null)
                Assertions.assertEquals(-1, foundIndex);
            else
                Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }


    @Test
    void shouldFindInLijstNull3() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;
            if (value == null)
                Assertions.assertEquals(-1, foundIndex);
            else
                Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }


    @Test
    void shouldNotInsertLijstOnsorteerbaar() {

        //Trying to map the JSON array to an array of type Double (or any other Comparable type for that matter)
        // will fail as at least one of the elements in the JSON array is of an incompatible type.
        // For that reason this test will not even try to sort the dataset as the JSON utility method will return an empty optional.
        // Shoehorning the dataset into the algorithm won't work, as the algorithm requires a generic type T extending Comparable<T>
        var optDataset = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_ONSORTEERBAAR).map(JsonUtils::toDoubleArray);
        Assertions.assertTrue(optDataset.isEmpty());

    }


    @Test
    void shouldFindInLijstOplopend10000() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);


        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }

    @Test
    void shouldFindInLijstWillekeurig10000() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");

    }

    @Test
    void shouldFindInLijstWillekeurig3() {
        BinarySearch<Integer> search = new BinarySearch<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        var sortedData = DataGenerator.sortCopyOfData(data);
        var totalElapsedTime = 0;
        for (Integer value : sortedData) {
            long start = System.nanoTime();

            int foundIndex = search.search(sortedData, value);

            totalElapsedTime += System.nanoTime() - start;

            Assertions.assertNotEquals(-1, foundIndex);
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }

    @Test
    void shouldFindIndexStrubg() {
        String[] dataset = {"aa", "ab", "bb", "bc", "cc"};
        Arrays.sort(dataset);
        BinarySearch<String> search = new BinarySearch<>();

        for (int i = 0; i < dataset.length; i++) {
            int index = search.search(dataset, dataset[i]);
            Assertions.assertEquals(i, index);

        }
    }
}
