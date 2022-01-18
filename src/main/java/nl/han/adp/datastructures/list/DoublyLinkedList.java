package nl.han.adp.datastructures.list;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements IList<T> {
    private DoublyLinkedNode baseNode;
    private DoublyLinkedNode currentNode;
    private int sizeOfList;

    public DoublyLinkedList() {
        clear();
    }

    @Override
    public void clear() {
        currentNode = new DoublyLinkedNode(null, null);
        currentNode.setNextNode(currentNode);
        currentNode.setPreviousNode(currentNode);
        baseNode = currentNode;
        sizeOfList = 0;
    }

    @Override
    public void insert(T item) {
        var newNode = new DoublyLinkedNode(item, currentNode.getPreviousNode(), currentNode);
        currentNode.setNextOfPrevious(newNode);
        currentNode.setPreviousNode(newNode);
        currentNode = newNode;
        sizeOfList++;
    }

    public void printDebug() {
        String string = "baseNode";
        var node = baseNode.getNextNode();
        while (node != baseNode) {
            string = string.concat(" <-> " + node.getElement());
            if (node == currentNode)
                string = string.concat(" X");
            node = node.getNextNode();
        }

        string = string.concat(" -> baseNode");
        System.out.println(string);
    }

    @Override
    public void append(T item) {
        var oldTail = baseNode.getPreviousNode();
        var newTail = new DoublyLinkedNode(item, oldTail, baseNode);
        baseNode.setPreviousNode(newTail);
        oldTail.setNextNode(newTail);
        sizeOfList++;
        if(currentNode == baseNode) currentNode = newTail;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();

        T value = currentNode.getElement();
        currentNode.setPreviousOfNext(currentNode.getPreviousNode());
        currentNode.setNextOfPrevious(currentNode.getNextNode());
        currentNode = currentNode.getNextNode();
        sizeOfList--;
        return value;
    }

    @Override
    public T remove(int i) throws NoSuchElementException {
        moveToPos(i);
        return remove();
    }

    @Override
    public void moveToStart() {
        if (isEmpty()) throw new NoSuchElementException();
        currentNode = baseNode.getNextNode();
    }

    @Override
    public void moveToEnd() {
        if (isEmpty()) throw new NoSuchElementException();
        currentNode = baseNode.getPreviousNode();
    }

    @Override
    public void prev() {
        var prev = currentNode.getPreviousNode();
        if (prev == baseNode) throw new NoSuchElementException();
        currentNode = prev;
    }

    @Override
    public void next() {
        var next = currentNode.getNextNode();
        if (next == baseNode) throw new NoSuchElementException();
        currentNode = next;
    }

    @Override
    public int length() {
        return sizeOfList;
    }

    @Override
    public int currPos() {
        if (isEmpty()) throw new NoSuchElementException();

        int i = 0;
        var node = baseNode.getNextNode();
        while (node != currentNode) {
            i++;
            node = node.getNextNode();
        }
        return i;
    }

    @Override
    public void moveToPos(int pos) throws NoSuchElementException {
        if (isEmpty() || pos > sizeOfList - 1) throw new NoSuchElementException();

        int curPos = 0;
        var node = baseNode.getNextNode();
        while (curPos != pos) {
            node = node.getNextNode();
            curPos++;
        }

        currentNode = node;
    }

    @Override
    public boolean isAtEnd() {
        return currentNode == baseNode.getPreviousNode();
    }

    @Override
    public T getValue() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException();
        return currentNode.getElement();
    }

    @Override
    public T getValue(int i) throws NoSuchElementException {
        moveToPos(i);
        return getValue();
    }

    @Override
    public boolean isEmpty() {
        return sizeOfList == 0;
    }

    private class DoublyLinkedNode {
        private T element;
        private DoublyLinkedNode nextNode;
        private DoublyLinkedNode previousNode;

        public DoublyLinkedNode(DoublyLinkedNode previousNode, DoublyLinkedNode nextNode) {
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }

        public DoublyLinkedNode(T element, DoublyLinkedNode previousNode, DoublyLinkedNode nextNode) {
            this.element = element;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public DoublyLinkedNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(DoublyLinkedNode nextNode) {
            this.nextNode = nextNode;
        }

        public DoublyLinkedNode getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(DoublyLinkedNode previousNode) {
            this.previousNode = previousNode;
        }

        public void setPreviousOfNext(DoublyLinkedNode link) {
            nextNode.setPreviousNode(link);
        }

        public void setNextOfPrevious(DoublyLinkedNode link) {
            previousNode.setNextNode(link);
        }
    }
}
