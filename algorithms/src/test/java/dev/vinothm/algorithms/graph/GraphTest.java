package dev.vinothm.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    void testBSF() {
	List<Vertex> graph = List.of(new Vertex(1, List.of(2, 4)), new Vertex(2, List.of(5)),
		new Vertex(3, List.of(6, 5)), new Vertex(4, List.of(2)), new Vertex(5, List.of(4)),
		new Vertex(6, List.of(4)));
	assertArrayEquals(new Integer[] { 1, 2, 4, 5 }, new Graph().bfs(graph).toArray());
    }

}
