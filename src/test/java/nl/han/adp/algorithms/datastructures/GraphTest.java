package nl.han.adp.algorithms.datastructures;

import nl.han.adp.datastructures.graph.Graph;
import nl.han.adp.datastructures.graph.GraphImpl;
import org.junit.jupiter.api.Test;

public class GraphTest {
    @Test
    void shouldUseGraphProperly() {
        Graph<Integer> graph = new GraphImpl<>();
        graph.init(500);

    }
}
