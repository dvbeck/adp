package nl.han.adp.algorithms.sorting;

import nl.han.adp.utility.Constants;
import nl.han.adp.utility.SortingTestUtils;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.dataset.JsonUtils;
import nl.han.adp.utility.sorting.AscendingComparator;
import nl.han.adp.utility.sorting.DescendingComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TimSortTest {

    @Test
    void shouldSortLijstAflopend2() {
        var algorithm = new TimSort<Integer>(new AscendingComparator<>());
        var utils = new SortingTestUtils();

        utils.getJsonArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.ascendingSortDatasetAndAssertSorted(algorithm, dataset));
    }

    @Test
    void shouldSortLijstOplopend2() {
        var algorithm = new TimSort<Integer>(new DescendingComparator<>());
        var utils = new SortingTestUtils();

        utils.getJsonArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2)
                .map(JsonUtils::toIntegerArray)
                .ifPresent(dataset -> utils.descendingSortDatasetAndAssertSorted(algorithm, dataset));
    }
}
