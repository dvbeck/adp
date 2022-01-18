package nl.han.adp.algorithms.searching.avl;

// Create node
public class Node<T extends Comparable<T>> {
    private T item;
    private int height;
    private Node<T> left;
    private Node<T> right;

    Node(T item) {
        this.item = item;
        height = 1;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void updateHeight() {
        int leftChildHeight = AVLTreeUtils.getHeightOfNode(left);
        int rightChildHeight = AVLTreeUtils.getHeightOfNode(right);
        height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    public boolean hasKey(T key) {
        return key.compareTo(item) == 0;
    }

    public Node<T> getChildForKey(T key) {
        if(hasKey(key)) return null;

        if (key.compareTo(item) < 0) {
            return left;
        } else {
            return right;
        }
    }
}
