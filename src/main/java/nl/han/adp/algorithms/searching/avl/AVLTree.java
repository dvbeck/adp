package nl.han.adp.algorithms.searching.avl;

public class AVLTree<T extends Comparable<T>> {
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    private int getHeightOfNode(Node<T> node) {
        int height = -1;
        if (node != null) height = node.getHeight();
        return height;
    }

    private void updateHeeight(Node<T> node) {
        int leftChildHeight = getHeightOfNode(node.getLeft());
        int rightChildHeight = getHeightOfNode(node.getRight());
        int newHeight = Math.max(leftChildHeight, rightChildHeight) + 1;
        node.setHeight(newHeight);
    }

    private int balanceFactor(Node<T> node) {
        return getHeightOfNode(node.getRight()) - getHeightOfNode(node.getLeft());
    }

    private Node<T> rotateRight(Node<T> node) {
        var leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());
        leftChild.setRight(node);
        node.updateHeight();
        leftChild.updateHeight();
        return leftChild;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightChild = node.getRight();
        node.setRight(rightChild.getLeft());
        rightChild.setLeft(node);
        node.updateHeight();
        rightChild.updateHeight();
        return rightChild;
    }

    private Node<T> rebalance(Node<T> node) {
        int balanceFactor = balanceFactor(node);

        if (balanceFactor < -1) {
            node = rotateLeftHeavy(node);
        } else if (balanceFactor > 1) {
            node = rotateRightHeavy(node);
        }

        return node;
    }

    private Node<T> rotateRightHeavy(Node<T> node) {
        if (balanceFactor(node.getRight()) >= 0) {
            node = rotateLeft(node);
        } else {
            node.setRight(rotateRight(node.getRight()));
            node = rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateLeftHeavy(Node<T> node) {
        if (balanceFactor(node.getLeft()) <= 0) {
            node = rotateRight(node);
        } else {
            node.setLeft(rotateLeft(node.getLeft()));
            node = rotateRight(node);
        }
        return node;
    }

    public void insert(T key) {
        root = insertNode(key, root);
        var curNode = root;

    }

    private Node<T> insertNode(T key, Node<T> node) {
        if (node == null) {
            node = new Node<>(key);
        } else if (key.compareTo(node.getItem()) < 0) {
            node.setLeft(insertNode(key, node.getLeft()));
        } else {
            node.setRight(insertNode(key, node.getRight()));
        }
        node.updateHeight();
        return rebalance(node);
    }

    public boolean delete(T key) {
        root = deleteNode(key, root);
        return root != null;
    }

    private Node<T> deleteNode(T key, Node<T> node) {
        // No node at current position --> go up the recursion
        if (node == null) {
            return null;
        }

        // Traverse the tree to the left or right depending on the key
        if (key.compareTo(node.getItem()) < 0) {
            node.setLeft(deleteNode(key, node.getLeft()));
        } else if (key.compareTo(node.getItem()) > 0) {
            node.setRight(deleteNode(key, node.getRight()));
        } else if (node.getLeft() == null && node.getRight() == null) {
            node = null;
        }
        // Node has only one child --> replace node by its single child
        else if (node.getLeft() == null) {
            node = node.getRight();
        } else if (node.getRight() == null) {
            node = node.getLeft();
        }

        // Node has two children
        else {
            deleteNodeWithTwoChildren(node);
        }

        // Node is null if the tree doesn't contain the key
        if (node == null) {
            return null;
        }

        node.updateHeight();

        return rebalance(node);
    }

    private void deleteNodeWithTwoChildren(Node<T> node) {
        // Find minimum node of right subtree ("inorder successor" of current node)
        Node<T> inOrderSuccessor = findMinimum(node.getRight());

        // Copy inorder successor's data to current node
        node.setItem(inOrderSuccessor.getItem());

        // Delete inorder successor recursively
        node.setRight(deleteNode(inOrderSuccessor.getItem(), node.getRight()));
    }

    private Node<T> findMinimum(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public Node<T> find(T key) {
        var curNode = root;
        while(curNode != null && !curNode.hasKey(key)) {
            curNode = curNode.getChildForKey(key);
        }
        return curNode;
    }


}