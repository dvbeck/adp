package nl.han.adp.assignments.datastructures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GraphImpl<T> implements Graph<T> {
    private Edge[] nodeArray;
    private T[] nodeValues;
    private int numEdge;

    public GraphImpl() {
        this(100);
    }


    @SuppressWarnings("unchecked")
    public GraphImpl(int n) {
        nodeArray = new Edge[n];
        for (int i = 0; i < n; i++) {
            nodeArray[i] = new Edge(-1, -1, null, null);
        }
        nodeValues = (T[]) new Object[n];
        numEdge = 0;
    }

    @Override
    public int nodeCount() {
        return nodeArray.length;
    }

    @Override
    public int edgeCount() {
        return numEdge;
    }

    @Override
    public T getValue(int vertex) {
        if (vertex >= nodeValues.length) return null;

        return nodeValues[vertex];
    }

    @Override
    public void setValue(int vertex, T value) {
        if (vertex >= nodeArray.length) throw new IllegalArgumentException("Node index out of bounds");
        nodeValues[vertex] = value;
    }

    @Override
    public void addEdge(int fromNode, int toNode, int weight) {
        if (weight < 1) throw new IllegalArgumentException("Weight does not satisfy conditions (weight > 1)");
        if (fromNode >= nodeArray.length) throw new IllegalArgumentException("Node index out of bounds");

        find(fromNode, toNode).ifPresentOrElse(currentEdge -> currentEdge.weight = weight, () -> addNewEdge(fromNode, toNode, weight));
    }

    private void addNewEdge(int fromNode, int toNode, int weight) {
        Edge currentEdge = nodeArray[fromNode];
        currentEdge.next = new Edge(toNode, weight, currentEdge, currentEdge.next);
        if (currentEdge.next.next != null) {
            currentEdge.next.next.prev = currentEdge.next;
        }
        numEdge++;
    }


    private Optional<Edge> find(int fromNode, int toNode) {
        Optional<Edge> optionalEdge = Optional.empty();
        if (fromNode >= nodeArray.length) return optionalEdge;

        Edge currentEdge = nodeArray[fromNode];
        while (currentEdge.next != null) {
            currentEdge = currentEdge.next;
            if (currentEdge.vertex == toNode) {
                optionalEdge = Optional.of(currentEdge);
                break;
            }
        }
        return optionalEdge;
    }

    @Override
    public int getWeight(int fromNode, int toNode) {
        return find(fromNode, toNode).map(edge -> edge.weight).orElse(0);
    }

    @Override
    public void removeEdge(int fromNode, int toNode) {
        find(fromNode, toNode).ifPresent(curr -> {
            curr.next = curr.next.next;
            if (curr.next != null) {
                curr.next.prev = curr;
            }
            numEdge--;
        });

    }


    @Override
    public boolean hasEdge(int fromNode, int toNode) {
        return getWeight(fromNode, toNode) != 0;
    }

    @Override
    public List<Integer> neighbors(int node) {
        List<Integer> neighbors = new ArrayList<>();
        if (node >= nodeArray.length) return neighbors;

        for (Edge currentNode = nodeArray[node].next; currentNode != null; currentNode = currentNode.next) {
            neighbors.add(currentNode.vertex);
        }

        return neighbors;
    }

    private static class Edge { // Doubly linked list node
        int vertex;
        int weight;
        Edge prev;
        Edge next;

        Edge(int vertex, int weight, Edge previous, Edge next) {
            this.vertex = vertex;
            this.weight = weight;
            prev = previous;
            this.next = next;
        }
    }
}
