package dev.vinothm.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    void testBSF() {
	var graphSearch = new Graph();
	List<Vertex> graph = List.of(new Vertex(1, List.of(2, 4)), new Vertex(2, List.of(5)),
		new Vertex(3, List.of(6, 5)), new Vertex(4, List.of(2)), new Vertex(5, List.of(4)),
		new Vertex(6, List.of(4)));
	List<Vertex> bsfResult = graphSearch.bfs(graph);
	int[] visits = new int[bsfResult.size()];
	int i = 0;
	for (Vertex v : bsfResult) {
	    System.out.println(v);
	    visits[i++] = v.value;
	}
	graphSearch.printPath(graph, graph.get(4), graph.get(0));
	assertArrayEquals(new int[] { 1, 2, 4, 5 }, visits);
    }

}
