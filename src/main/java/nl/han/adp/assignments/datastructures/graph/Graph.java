package nl.han.adp.assignments.datastructures.graph;

import java.util.List;

public interface Graph<T> {

    int nodeCount();

    int edgeCount();

    T getValue(int v);

    void setValue(int v, T value);

    void addEdge(int fromNode, int toNode, int weight);

    int getWeight(int fromNode, int toNode);

    void removeEdge(int fromNode, int toNode);

    boolean hasEdge(int fromNode, int toNode);

    List<Integer> neighbors(int node);
}