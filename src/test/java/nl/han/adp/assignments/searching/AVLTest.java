package nl.han.adp.assignments.searching;


import nl.han.adp.assignments.algorithms.searching.avl.AVLTree;
import nl.han.adp.assignments.algorithms.searching.avl.BinaryTree;
import nl.han.adp.assignments.datastructures.list.DynamicArray;
import nl.han.adp.assignments.datastructures.list.IList;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.DataSetUtils;
import nl.han.adp.utility.Measurement;
import nl.han.adp.utility.dataset.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import java.util.Arrays;

public class AVLTest {
    private final DataSetUtils utils = new DataSetUtils();

    @Test
    void shouldInsertLijstAflopend2() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_AFLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }



    @Test
    void shouldInsertLijstOplopend2() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND2).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);
        
        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void shouldInsertLijstFloat() {
        BinaryTree<Double> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_FLOAT).map(JsonUtils::toDoubleArray).orElseThrow(TestAbortedException::new);
        
        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void shouldInsertLijstGesorteerdAflopend3() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_AFLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void shouldInsertLijstGesorteerdOplopend3() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_SORTED_OPLOPEND3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void shouldInsertLijstHerhaald() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_HERHAALD).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void shouldInsertLijstLeeg() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_LEEG).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void shouldInsertLijstNull1() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_1).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void shouldInsertLijstNull3() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_NULL_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void shouldNotInsertLijstOnsorteerbaar() {
        BinaryTree<Double> structure = new AVLTree<>();

        //Trying to map the JSON array to an array of type Double (or any other Comparable type for that matter)
        // will fail as at least one of the elements in the JSON array is of an incompatible type.
        // For that reason this test will not even try to sort the dataset as the JSON utility method will return an empty optional.
        // Shoehorning the dataset into the algorithm won't work, as the algorithm requires a generic type T extending Comparable<T>
        var optDataset = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_ONSORTEERBAAR).map(JsonUtils::toDoubleArray);
        Assertions.assertTrue(optDataset.isEmpty());

    }

    @Test
    void shouldInsertLijstOplopend10000() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_OPLOPEND_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig10000() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_10000).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void shouldInsertLijstWillekeurig3() {
        BinaryTree<Integer> structure = new AVLTree<>();

        var data = utils.getSortingArray(Constants.Sorteren.SORTEER_LIJST_WILLEKEURIG_3).map(JsonUtils::toIntegerArray).orElseThrow(TestAbortedException::new);

        insertValuesIntoTree(structure, data);
        readValuesFromTree(structure, data);
    }

    @Test
    void testAvl() {
        BinaryTree<Integer> tree = new AVLTree<>();
        Integer[] data = {10, 1, 2, 3, 4, 11, 3, 12, 2, 13, 6, 14, 5, 3};
        for (Integer integer : data) {
            tree.insert(integer);
        }


        tree.delete(11);
        tree.delete(6);
        System.out.println("test");
    }

    private <T extends Comparable<T>> void insertValuesIntoTree(BinaryTree<T> structure, T[] data) {
        var totalElapsedTime = 0;
        for (T value : data) {
            totalElapsedTime += Measurement.measureElapsedTimeOfTargetCode(() -> structure.insert(value));
        }
        Measurement.outputDuration(totalElapsedTime, "Insertion");
    }

    private <T extends Comparable<T>> void readValuesFromTree(BinaryTree<T> structure, T[] data) {
        var totalElapsedTime = 0;
        for (T value : data) {
            long start = System.nanoTime();
            var node = structure.search(value);
            totalElapsedTime += System.nanoTime() - start;

            if (node != null && value != null)
                Assertions.assertEquals(value, node.getValue());
            else if(value == null)
                Assertions.assertNull(node);
            else
                Assertions.fail("node not found");
        }
        Measurement.outputDuration(totalElapsedTime, "Searching");
    }


}
