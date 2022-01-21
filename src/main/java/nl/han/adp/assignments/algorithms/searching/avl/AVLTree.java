package nl.han.adp.assignments.algorithms.searching.avl;

public class AVLTree<T extends Comparable<T>> implements BinaryTree<T> {
    private BSTNode<T> root;

    @Override
    public BSTNode<T> getRoot() {
        return root;
    }

    @Override
    public void insert(T key) {
        if(key == null) return;
        root = insert(key, root);
    }

    @Override
    public void delete(T key) {
        root = delete(key, root);
    }

    @Override
    public BSTNode<T> search(T key) {
        if(key == null) return null;
        return search(key, root);
    }

    public BSTNode<T> search(T key, BSTNode<T> node) {
        if (node == null)
            return null;

        var nodeValue = node.getValue();
        if (key.compareTo(nodeValue) == 0)
            return node;
        else if (key.compareTo(nodeValue) < 0)
            return search(key, node.getLeft());
        else
            return search(key, node.getRight());
    }

    public BSTNode<T> insert(T key, BSTNode<T> node) {
        if (node == null)
            node = new BSTNode<>(key);
        else if (key.compareTo(node.getValue()) < 0) {
            node.setLeft(insert(key, node.getLeft()));
        } else if (key.compareTo(node.getValue()) > 0) {
            node.setRight(insert(key, node.getRight()));
        }

        updateHeight(node);
        return rebalance(node);
    }

    public BSTNode<T> delete(T key, BSTNode<T> node) {
        if (node == null)
            return null;

        if (key.compareTo(node.getValue()) < 0) {
            node.setLeft(delete(key, node.getLeft()));
        } else if (key.compareTo(node.getValue()) > 0) {
            node.setRight(delete(key, node.getRight()));
        } else if (node.getLeft() == null && node.getRight() == null) {
            node = null;
        } else if (node.getLeft() == null) {
            node = node.getRight();
        } else if (node.getRight() == null) {
            node = node.getLeft();
        } else {
            deleteNodeWithTwoChildren(node);
        }
        if(node != null) {
            updateHeight(node);
            node = rebalance(node);
        }
        return node;
    }

    private void deleteNodeWithTwoChildren(BSTNode<T> node) {
        BSTNode<T> inOrderSuccessor = findMinimum(node.getRight());
        node.setValue(inOrderSuccessor.getValue());
        node.setRight(delete(inOrderSuccessor.getValue(), node.getRight()));
    }

    private BSTNode<T> findMinimum(BSTNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public void updateHeight(BSTNode<T> node) {
        int leftChildHeight = height(node.getLeft());
        int rightChildHeight = height(node.getRight());
        var newHeight = Math.max(leftChildHeight, rightChildHeight) + 1;
        node.setHeight(newHeight);
    }

    public BSTNode<T> rebalance(BSTNode<T> node) {
        int balanceFactor = balanceFactor(node);

        if (balanceFactor < -1) {
            if (balanceFactor(node.getLeft()) <= 0) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }

        if (balanceFactor > 1) {
            if (balanceFactor(node.getRight()) >= 0) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }

        return node;
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

    private int balanceFactor(BSTNode<T> node) {
        return height(node.getRight()) - height(node.getLeft());
    }

    private int height(BSTNode<T> node) {
        return node != null ? node.getHeight() : -1;
    }


}