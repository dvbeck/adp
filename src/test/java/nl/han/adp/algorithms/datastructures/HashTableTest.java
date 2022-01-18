package nl.han.adp.algorithms.datastructures;

import nl.han.adp.datastructures.HashTable;
import nl.han.adp.utility.dataset.DataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HashTableTest {
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
