package nl.han.adp.algorithms.searching;

import nl.han.adp.algorithms.searching.avl.AVLTree;
import nl.han.adp.algorithms.searching.avl.AVLTreeUtils;
import nl.han.adp.algorithms.searching.avl.Node;
import nl.han.adp.utility.dataset.DataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AVLTest {
    @Test
    void testAvl() {
        AVLTree<Integer> tree = new AVLTree<>();
        var data = Arrays.stream(DataGenerator.generateIntegerDataset(30000)).distinct().collect(Collectors.toList());
        for (Integer integer : data) {
            tree.insert(integer);
        }

        for(Integer searchKey : data) {
//            long count = Arrays.stream(data).filter(i -> i.equals(searchKey)).count();
//            System.out.println(count);
            Node<Integer> integerNode = tree.find(searchKey);
            Assertions.assertNotNull(integerNode);
        }

    }

}
