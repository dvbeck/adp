package nl.han.adp.algorithms.searching;


import org.junit.jupiter.api.Test;

public class AVLTest {
    @Test
    void testAvl() {
        BinaryTree<Integer> tree = new AVLTree<>();
        Integer[] data = {10, 1, 2, 3, 4, 11, 3, 12, 2, 13, 6, 14, 5, 3};
        for (Integer integer : data) {
            tree.insert(integer);
        }


        tree.delete(3);
        tree.delete(6);
        System.out.println("dsa");

    }

}
