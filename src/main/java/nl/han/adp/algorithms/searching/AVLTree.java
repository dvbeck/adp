package nl.han.adp.algorithms.searching;

public class AVLTree<T extends Comparable<T>> extends BSTree<T> {


    @Override
    public void insert(T key) {
        super.insert(key);
        System.out.println("test");
        findImbalance(root);
    }

    @Override
    public void delete(T key) {

    }

    @Override
    public BSTNode<T> search(T key) {
        return null;
    }

    private int getHeight(BSTNode<T> node) {
        return node != null ? node.getHeight() : -1;
    }

    private BSTNode<T> rebalance(BSTNode<T> node) {
        int bf = calculateBalanceFactor(node);
        if (bf < -1)
            node = resolveLeftHeavy(node);
        if (bf > 1)
            node = resolveRightHeavy(node);

        return node;
    }

    private BSTNode<T> resolveLeftHeavy(BSTNode<T> node) {
        if (calculateBalanceFactor(node.getLeft()) <= 0) {
            node = rotateRight(node);
        } else {
            node.setLeft(rotateLeft(node.getLeft()));
            node = rotateRight(node);
        }
        return node;
    }

    private BSTNode<T> resolveRightHeavy(BSTNode<T> node) {
        if (calculateBalanceFactor(node.getRight()) >= 0) {
            node = rotateLeft(node);
        } else {
            node.setRight(rotateRight(node.getRight()));
            node = rotateLeft(node);
        }
        return node;
    }

    private BSTNode<T> findImbalance(BSTNode<T> root) {
        int bf;
        do {
            bf = calculateBalanceFactor(root);
            if (bf < -1) root = root.getLeft();
            else root = root.getRight();
        } while (Math.abs(bf) > 1);
        return null;
    }

    private int calculateBalanceFactor(BSTNode<T> node) {
        var leftChildHeight = getHeight(node.getLeft());
        var rightChildHeight = getHeight(node.getRight());
        return rightChildHeight - leftChildHeight;
    }

    private BSTNode<T> rotateRight(BSTNode<T> node) {
        BSTNode<T> leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());
        leftChild.setRight(node);

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    private BSTNode<T> rotateLeft(BSTNode<T> node) {
        BSTNode<T> rightChild = node.getRight();
        node.setRight(rightChild.getLeft());
        rightChild.setLeft(node);

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    private void updateHeight(BSTNode<T> node) {
        int leftChildHeight = getHeight(node.getLeft());
        int rightChildHeight = getHeight(node.getRight());
        var height = Math.max(leftChildHeight, rightChildHeight) + 1;
        node.setHeight(height);
    }
}
