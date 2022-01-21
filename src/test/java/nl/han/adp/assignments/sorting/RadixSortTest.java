package nl.han.adp.assignments.sorting;

import nl.han.adp.assignments.algorithms.sorting.RadixSort;
import nl.han.adp.assignments.algorithms.sorting.RadixSort;
import nl.han.adp.assignments.algorithms.sorting.SortingAlgorithm;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.DataSetUtils;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.dataset.JsonUtils;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.sorting.AscendingComparator;
import nl.han.adp.utility.sorting.DescendingComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadixSortTest {
    private final DataSetUtils utils = new DataSetUtils();


    @Test
    void shouldSortLijstAflopend2() {
        var algorithm = new RadixSort();

        utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstOplopend2() {
        var algorithm = new RadixSort();

        utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstFloat() {
        // Floats not implemented
    }

    @Test
    void shouldSortLijstGesorteerdAflopend3() {
        var algorithm = new RadixSort();

        utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_AFLOPEND3)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstGesorteerdOplopend3() {
        var algorithm = new RadixSort();

        utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_OPLOPEND3)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstHerhaald() {
        var algorithm = new RadixSort();

        utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_HERHAALD)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstLeeg() {
        var algorithm = new RadixSort();

        var optData = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_1).map(JsonUtils::toIntegerArray);
        if(optData.isPresent()) {
            try {
                algorithm.sort(optData.get());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    void shouldSortLijstNull1() {
        var algorithm = new RadixSort();

        var optData = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_1).map(JsonUtils::toIntegerArray);
        if(optData.isPresent()) {
            try {
                algorithm.sort(optData.get());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    void shouldSortLijstNull3() {
        var algorithm = new RadixSort();

        var optData = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_1).map(JsonUtils::toIntegerArray);
        if(optData.isPresent()) {
            try {
                algorithm.sort(optData.get());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    void shouldNotSortLijstOnsorteerbaar() {

        //Trying to map the JSON array to an array of type Double (or any other Comparable type for that matter)
        // will fail as at least one of the elements in the JSON array is of an incompatible type.
        // For that reason this test will not even try to sort the dataset as the JSON utility method will return an empty optional.
        // Shoehorning the dataset into the algorithm won't work, as the algorithm requires a generic type T extending Comparable<T>
        var optDataset = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_ONSORTEERBAAR).map(JsonUtils::toDoubleArray);
        Assertions.assertTrue(optDataset.isEmpty());
    }

    @Test
    void shouldSortLijstOplopend10000() {
        var algorithm = new RadixSort();

        utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND_10000)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstWillekeurig10000() {
        var algorithm = new RadixSort();

        utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_10000)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstWillekeurig3() {
        var algorithm = new RadixSort();

        utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_3)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortNegatives() {
        var algorithm = new RadixSort();
        Integer[] data = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        algorithm.sort(data);
        Assertions.assertArrayEquals(DataGenerator.sortCopyOfData(data), data);
    }

}
