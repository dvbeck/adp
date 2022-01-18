package nl.han.adp.datastructures.graph;

public interface Graph<T> {
    void init(int n);

    int nodeCount();

    int edgeCount();

    T getValue(int v);

    void setValue(int v, T value);

    // Adds a new edge from node fromNode to node toNode with weight weight
    void addEdge(int fromNode, int toNode, int weight);

    int getWeight(int fromNode, int toNode);

    void removeEdge(int fromNode, int toNode);

    boolean hasEdge(int fromNode, int toNode);

    int[] neighbors(int node);
}