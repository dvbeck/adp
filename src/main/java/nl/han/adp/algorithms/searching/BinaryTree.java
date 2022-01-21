package nl.han.adp.algorithms.searching;

public interface BinaryTree<T extends Comparable<T>> {
    BSTNode<T> getRoot();
    void insert(T key);
    void delete(T key);
    BSTNode<T> search(T key);
}
