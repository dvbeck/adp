package nl.han.adp.algorithms.searching;

public class BSTNode<T extends Comparable<T>> {
    private T value;
    private BSTNode<T> left;
    private BSTNode<T> right;
    private int height;

    public BSTNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public boolean toLeft(T key) {
        return key.compareTo(value) < 0;
    }

    public boolean toRight(T key) {
        return key.compareTo(value) > 0;
    }

    public boolean hasKey(T key) {
        return key.compareTo(value) == 0;
    }

    public int numberOfChildren() {
        int cnt = 0;
        if(left != null) cnt++;
        if(right != null) cnt++;
        return cnt;
    }

    public void removeChild(BSTNode<T> child) {
        if(child == right)
            right = null;
        else if(child == left)
            left = null;
    }

    public void replaceChild(BSTNode<T> nodeToDelete, BSTNode<T> newChild) {
        if(nodeToDelete == right) right = newChild;
        else if(nodeToDelete == left) left = newChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
