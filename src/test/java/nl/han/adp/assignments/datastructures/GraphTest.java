package nl.han.adp.assignments.datastructures;

import nl.han.adp.assignments.algorithms.searching.DijkstraSearch;
import nl.han.adp.assignments.datastructures.graph.Graph;
import nl.han.adp.assignments.datastructures.graph.GraphImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GraphTest {
    @Test
    void shouldUseGraphProperly() {
        Graph<Integer> graph = new GraphImpl<>();
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 2, 9);
        graph.getValue(500);
        System.out.println(graph.getWeight(1, 2));
    }



}
