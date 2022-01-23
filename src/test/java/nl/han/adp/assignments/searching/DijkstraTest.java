package nl.han.adp.assignments.searching;


import nl.han.adp.assignments.algorithms.searching.DijkstraSearch;
import nl.han.adp.assignments.datastructures.graph.Graph;
import nl.han.adp.assignments.datastructures.graph.GraphImpl;
import nl.han.adp.utility.Constants;
import nl.han.adp.utility.DataSetUtils;
import nl.han.adp.utility.JsonUtils;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import java.util.List;

public class DijkstraTest {
    private final DataSetUtils utils = new DataSetUtils();

    @Test
    void dijkstraTest() {
        Graph<Integer> graph = new GraphImpl<>();
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 5, 1);

        graph.addEdge(2, 5, 1);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 1);


        DijkstraSearch<Integer> dijkstraSearch = new DijkstraSearch<>(graph);

        Integer[] pathsFromNode = dijkstraSearch.findPathsFrom(0);
        var shortestPath = DijkstraSearch.getShortestPathTo(0, 5, pathsFromNode);

        shortestPath.ifPresent(path -> DijkstraSearch.printPathToNode(0, path));

    }

    @Test
    void testLijnLijst() {
        Graph<Integer> graph = utils.getGraphArray(Constants.Graphs.LIJN_LIJST)
                .map(JsonUtils::toIntegerListList)
                .map(this::graphFromLijnLijst)
                .orElseThrow(TestAbortedException::new);


        DijkstraSearch<Integer> dijkstraSearch = new DijkstraSearch<>(graph);

        Integer[] pathsFromNode = dijkstraSearch.findPathsFrom(0);
        var shortestPath = DijkstraSearch.getShortestPathTo(0, 5, pathsFromNode);

        shortestPath.ifPresent(path -> DijkstraSearch.printPathToNode(0, path));

    }

    @Test
    void testLijnLijstGewogen() {
        Graph<Integer> graph = utils.getGraphArray(Constants.Graphs.LIJN_LIJST_GEWOGEN)
                .map(JsonUtils::toIntegerListList)
                .map(this::graphFromLijnLijst)
                .orElseThrow(TestAbortedException::new);


        DijkstraSearch<Integer> dijkstraSearch = new DijkstraSearch<>(graph);

        Integer[] pathsFromNode = dijkstraSearch.findPathsFrom(0);
        var shortestPath = DijkstraSearch.getShortestPathTo(0, 4, pathsFromNode);

        shortestPath.ifPresent(path -> DijkstraSearch.printPathToNode(0, path));

    }

    @Test
    void testVerbindingsLijst() {
        Graph<Integer> graph = utils.getGraphArray(Constants.Graphs.VERBINDINGS_LIJST)
                .map(JsonUtils::toIntegerListList)
                .map(this::graphFromVerbindingsLijst)
                .orElseThrow(TestAbortedException::new);


        DijkstraSearch<Integer> dijkstraSearch = new DijkstraSearch<>(graph);

        Integer[] pathsFromNode = dijkstraSearch.findPathsFrom(0);
        var shortestPath = DijkstraSearch.getShortestPathTo(0, 4, pathsFromNode);

        shortestPath.ifPresent(path -> DijkstraSearch.printPathToNode(0, path));

    }

    private Graph<Integer> graphFromVerbindingsLijst(List<List<Integer>> lists) {
        Graph<Integer> graph = new GraphImpl<>();
        for (int i = 0; i < lists.size(); i++) {
            for (Integer edge : lists.get(i)) {
                graph.addEdge(i, edge, 1);
            }
        }
        return graph;
    }


    private Graph<Integer> graphFromLijnLijst(List<List<Integer>> lists) {
        Graph<Integer> graph = new GraphImpl<>();
        for (List<Integer> edge : lists) {
            if (edge.size() == 2)
                graph.addEdge(edge.get(0), edge.get(1), 1);
            else if (edge.size() == 3)
                graph.addEdge(edge.get(0), edge.get(1), edge.get(2));
        }
        return graph;
    }
}
