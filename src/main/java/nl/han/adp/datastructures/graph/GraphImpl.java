package nl.han.adp.datastructures.graph;

public class GraphImpl<T> implements Graph<T> {
    private Edge[] nodeArray;
    private T[] nodeValues;
    private int numEdge;

    @Override
    @SuppressWarnings("unchecked")
    public void init(int n) {
        nodeArray = new Edge[n];
        for (int i=0; i<n; i++) { nodeArray[i] = new Edge(-1, -1, null, null); }
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
        return nodeValues[vertex];
    }

    @Override
    public void setValue(int vertex, T value) {
        nodeValues[vertex] = value;
    }

    @Override
    public void addEdge(int fromNode, int toNode, int weight) {
        if (weight < 1) throw new IllegalArgumentException("Weight does not satisfy conditions (weight > 1)");

        Edge currentEdge = find(fromNode, toNode);
        if ((currentEdge.next != null) && (currentEdge.next.vertex == toNode)) {
            currentEdge.next.weight = weight;
        }
        else {
            currentEdge.next = new Edge(toNode, weight, currentEdge, currentEdge.next);
            if (currentEdge.next.next != null) { currentEdge.next.next.prev = currentEdge.next; }
        }
        numEdge++;
    }

    private Edge find(int fromNode, int toNode) {
        Edge currentEdge = nodeArray[fromNode];
        while (currentEdge.next != null && currentEdge.next.vertex < toNode) {
            currentEdge = currentEdge.next;
        }
        return currentEdge;
    }

    @Override
    public int getWeight(int fromNode, int toNode) {
        Edge curr = find(fromNode, toNode);
        if ((curr.next == null) || (curr.next.vertex != toNode)) { return 0; }
        else { return curr.next.weight; }
    }

    @Override
    public void removeEdge(int fromNode, int toNode) {
        Edge curr = find(fromNode, toNode);
        if ((curr.next == null) || curr.next.vertex != toNode) { return; }
        else {
            curr.next = curr.next.next;
            if (curr.next != null) { curr.next.prev = curr; }
        }
        numEdge--;
    }


    @Override
    public boolean hasEdge(int fromNode, int toNode) {
        return getWeight(fromNode, toNode) != 0;
    }

    @Override
    public int[] neighbors(int node) {
        int cnt = 0;
        Edge curr;
        for (curr = nodeArray[node].next; curr != null; curr = curr.next) {
            cnt++;
        }
        int[] temp = new int[cnt];
        cnt = 0;
        for (curr = nodeArray[node].next; curr != null; curr = curr.next) {
            temp[cnt++] = curr.vertex;
        }
        return temp;
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
