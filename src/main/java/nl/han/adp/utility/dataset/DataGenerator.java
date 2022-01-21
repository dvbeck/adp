package nl.han.adp.utility.dataset;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

public class DataGenerator {
    public static Integer[] generateIntegerDataset(int size) {
        return IntStream.generate(() -> new Random().nextInt(size)).limit(size).boxed().toArray(Integer[]::new);
    }

    public static int[] generateIntegerDatasetUnboxed(int size) {
        return IntStream.generate(() -> new Random().nextInt(size)).limit(size).toArray();
    }

    public static int[] sortCopyOfIntArray(int[] data) {
        int[] ts = Arrays.copyOf(data, data.length);
        Arrays.sort(ts);
        return ts;
    }

    public static <T extends Comparable<T>> T[] sortCopyOfData(T[] data) {
        T[] ts = Arrays.copyOf(data, data.length);
        Arrays.sort(ts, Comparator.nullsLast(Comparator.naturalOrder()));
        return ts;
    }

    public static <T extends Comparable<T>> T[] sortCopyOfDataDesc(T[] data) {
        T[] ts = Arrays.copyOf(data, data.length);
        Arrays.sort(ts, Comparator.nullsLast(Comparator.reverseOrder()));
        return ts;
    }
}
