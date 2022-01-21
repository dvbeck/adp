package nl.han.adp.assignments.datastructures;

import nl.han.adp.assignments.datastructures.hashtable.Dictionary;
import nl.han.adp.assignments.datastructures.hashtable.HashTable;
import nl.han.adp.assignments.datastructures.list.DynamicArray;
import nl.han.adp.assignments.datastructures.list.IList;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.DataSetUtils;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.dataset.DataGenerator;
import nl.han.adp.utility.dataset.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HashTableTest {
    private final DataSetUtils utils = new DataSetUtils();

    @Test
    void sjoetPoetZeHashTableStufInZeStruksjur() {
        Dictionary<String, List<Integer>> structure = new HashTable<>(100);

        var data = utils.getHashingObject(Constants.Hashing.HASH_TABEL).map(JsonUtils::toStringIntegerListMap).orElseThrow(TestAbortedException::new);

        measureAndTest(structure, data);
    }

    private void measureAndTest(Dictionary<String, List<Integer>> structure, Map<String, List<Integer>> data) {
        var totalElapsedTime = 0;
        for (Map.Entry<String, List<Integer>> entry : data.entrySet()) {
            totalElapsedTime += Measurement.measureElapsedTimeOfTargetCode(() -> structure.put(entry.getKey(), entry.getValue()));
        }
        Measurement.outputDuration(totalElapsedTime, "Putting");


        totalElapsedTime = 0;
        Assertions.assertEquals(data.size(), structure.size());
        for (Map.Entry<String, List<Integer>> entry : data.entrySet()) {
            long start = System.nanoTime();
            var val = structure.get(entry.getKey());
            totalElapsedTime += System.nanoTime() - start;
            Assertions.assertEquals(entry.getValue(), val);
        }
        Measurement.outputDuration(totalElapsedTime, "Getting");
    }


    @Test
    void testHashTable() {
        var ht = new HashTable<Integer, Integer>(10);
        var data = DataGenerator.generateIntegerDataset(500);
        Arrays.stream(data).forEach(n -> ht.put(n, n * 10));
        Arrays.stream(data).forEach(n -> {
            Assertions.assertNotNull(ht.get(n));
            Assertions.assertEquals(n * 10, ht.get(n));
        });

    }

    @Test
    void testHashTable2() {
        var ht = new HashTable<Integer, Integer>(2);
        ht.put(1, 10);
        ht.put(2, 20);
        ht.put(3, 30);
        ht.put(4, 40);
        ht.put(5, 50);
        ht.clear();
        ht.size();

    }
}
