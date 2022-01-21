package nl.han.adp.assignments.algorithms.searching;

import nl.han.adp.assignments.datastructures.graph.Graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DijkstraSearch<T extends Comparable<T>> {
    private static final int INFINITY = Integer.MAX_VALUE;
    private final Graph<T> graph;

    private Integer[] distancesFromSource;
    private Integer[] previousNode;
    private List<Integer> unvisitedNodes;

    public DijkstraSearch(Graph<T> graph) {
        this.graph = graph;
    }

    public Integer[] findPathsFrom(int source) {
        resetPathFindResult();
        distancesFromSource[source] = 0;

        while (!unvisitedNodes.isEmpty()) {
            Integer nodeWithSmallestDistance = findNodeWithSmallestDistance(unvisitedNodes);
            unvisitedNodes.remove(nodeWithSmallestDistance);
            if (nodeIsReachable(nodeWithSmallestDistance))
                updateNeighborsOfNode(nodeWithSmallestDistance);

        }
        return previousNode;
    }

    private Integer findNodeWithSmallestDistance(List<Integer> nodes) {
        if (nodes.isEmpty()) return null;

        Integer smallestDistanceNode = nodes.get(0);
        Integer smallestDistance = distancesFromSource[smallestDistanceNode];
        for (Integer node : nodes) {
            if (distancesFromSource[node] < smallestDistance) {
                smallestDistanceNode = node;
                smallestDistance = distancesFromSource[node];
            }
        }
        return smallestDistanceNode;
    }


    private boolean nodeIsReachable(Integer node) {
        return node != null && distancesFromSource[node] != INFINITY;
    }

    private void resetPathFindResult() {
        unvisitedNodes = IntStream.iterate(0, n -> n + 1).limit(graph.nodeCount()).boxed().collect(Collectors.toList());
        distancesFromSource = new Integer[graph.nodeCount()];
        previousNode = new Integer[graph.nodeCount()];
        Arrays.fill(distancesFromSource, INFINITY);
        Arrays.fill(previousNode, null);
    }

    private void updateNeighborsOfNode(Integer node) {
        var neighbors = graph.neighbors(node);
        for (int neighbor : neighbors) {
            var weight = graph.getWeight(node, neighbor);
            if (weight == 0) continue;
            int distanceToNeighbor = distancesFromSource[node] + weight;
            if (distanceToNeighbor < distancesFromSource[neighbor]) {
                distancesFromSource[neighbor] = distanceToNeighbor;
                previousNode[neighbor] = node;
            }
        }
    }


    public static void printPathToNode(int from, List<Integer> path) {
        System.out.println("Shortest path from node " + from + " to " + path.get(path.size() - 1));
        System.out.print(from);
        for (Integer node : path) {
            System.out.print(" -> ");
            System.out.print(node);
        }
    }

    public static Optional<List<Integer>> getShortestPathTo(int from, int to, Integer[] pathsFromNode) {
        List<Integer> path = new ArrayList<>();

        while (to != from) {
            var prev = pathsFromNode[to];
            if (prev == null) return Optional.empty();
            path.add(to);
            to = prev;
        }
        Collections.reverse(path);
        return Optional.of(path);
    }
}
