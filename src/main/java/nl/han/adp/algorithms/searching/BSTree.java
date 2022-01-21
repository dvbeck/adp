package nl.han.adp.algorithms.searching;

public class BSTree<T extends Comparable<T>> implements BinaryTree<T> {
    protected BSTNode<T> root;

    @Override
    public BSTNode<T> getRoot() {
        return root;
    }

    @Override
    public BSTNode<T> search(T key) {
        var searchResult = findNodeWithParent(key);
        if(searchResult.node == null || !searchResult.node.hasKey(key)) return null;
        return searchResult.node;
    }

    @Override
    public void insert(T key) {
        BSTNode<T> newNode = new BSTNode<>(key);
        var searchResult = findNodeWithParent(key);
        if(searchResult.noParentFound())
            root = newNode;
        else if(searchResult.nodeFound())
            return;
        else if(searchResult.parent.toLeft(key))
            searchResult.parent.setLeft(newNode);
        else if(searchResult.parent.toRight(key))
            searchResult.parent.setRight(newNode);

    }

    @Override
    public void delete(T key) {
        var searchResult = findNodeWithParent(key);
        if(!searchResult.nodeFound())
            return;

        var nodeToDelete = searchResult.node;
        var parent = searchResult.parent;

        if(nodeToDelete.numberOfChildren() == 0) {
            parent.removeChild(nodeToDelete);
        }
        else if (nodeToDelete.numberOfChildren() == 1) {
            if(nodeToDelete.getRight() != null) parent.replaceChild(nodeToDelete, nodeToDelete.getRight());
            else parent.replaceChild(nodeToDelete, nodeToDelete.getLeft());
        }
        else {
            removeNodeWithTwoChildren(nodeToDelete);
        }
    }

    private void removeNodeWithTwoChildren(BSTNode<T> nodeToDelete) {
        BSTNode<T> ancestor = nodeToDelete;
        var biggest = nodeToDelete.getLeft();
        while(biggest.getRight() != null) {
            ancestor = biggest;
            biggest = biggest.getRight();
        }
        nodeToDelete.setValue(biggest.getValue());
        ancestor.removeChild(biggest);
    }

    private NodeWithParent<T> findNodeWithParent(T key) {
        var currentNode = root;
        var parent = currentNode;

        while (currentNode != null && !currentNode.hasKey(key)) {
            parent = currentNode;
            if (currentNode.toLeft(key))
                currentNode = currentNode.getLeft();
            else if(currentNode.toRight(key))
                currentNode = currentNode.getRight();
        }
        return new NodeWithParent<>(currentNode, parent);
    }

    private static class NodeWithParent<T extends Comparable<T>> {
        BSTNode<T> node;
        BSTNode<T> parent;

        public NodeWithParent(BSTNode<T> node, BSTNode<T> parent) {
            this.node = node;
            this.parent = parent;
        }

        public boolean noParentFound() {
            return parent == null;
        }

        public boolean nodeFound() {
            return node != null;
        }
    }
}
