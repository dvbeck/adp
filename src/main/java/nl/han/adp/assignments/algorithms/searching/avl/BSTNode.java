package nl.han.adp.assignments.algorithms.searching.avl;

public class BSTNode<T extends Comparable<T>> {
    private T value;
    private BSTNode<T> left;
    private BSTNode<T> right;
    private int height;

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BSTNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public int getHeight() {
        return height;
    }

    public boolean hasKey(T key) {
        return key.compareTo(value) == 0;
    }
}
