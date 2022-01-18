package nl.han.adp.algorithms.searching;

import nl.han.adp.utility.Measurement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class BinarySearchTest {
    private static final int N_ELEMENTS = 1_000_000;
    private Integer i;

    @Test
    void bigTest() {
        Integer[] dataset = IntStream.generate(() -> new Random().nextInt(N_ELEMENTS)).limit(N_ELEMENTS).boxed().toArray(Integer[]::new);
        Arrays.sort(dataset);
        int key = 86868;

        Arrays.sort(dataset);
        BinarySearch<Integer> search = new BinarySearch<>();

        Measurement.measureElapsedTimeOfTargetCode(() -> i = search.search(dataset, key));
        int j = Arrays.binarySearch(dataset, key);
        Assertions.assertEquals(i == -1, j < 0);
        Assertions.assertEquals(i, j < 0 ? -1 : j);
        System.out.println(i);

    }

    @Test
    void shouldFindIndex() {
        Integer[] dataset = {1, 3, 5, 7, 9, 10, 12, 18, 19, 20, 25};
        Arrays.sort(dataset);
        BinarySearch<Integer> search = new BinarySearch<>();

        int i = search.search(dataset, dataset[6]);
        System.out.println(i);

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
