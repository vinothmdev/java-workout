package dev.vinothm.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class GraphALTest {

    @Test
    void testIndegree() {
	List<List<Integer>> graph = List
		.of(List.of(2, 4), List.of(5), List.of(6, 5), List.of(2), List.of(4), List.of(6));
	GraphAL graphAl = new GraphAL(graph);
	assertEquals(2, graphAl.getIndegreeOf(2));
	assertEquals(2, graphAl.getIndegreeOf(6));
	assertEquals(0, graphAl.getIndegreeOf(1));
    }

    @Test
    void testOutdegree() {
	List<List<Integer>> graph = List
		.of(List.of(2, 4), List.of(5), List.of(6, 5), List.of(2), List.of(4), List.of(6));
	GraphAL graphAl = new GraphAL(graph);
	assertEquals(1, graphAl.getOutdegree(2));
	assertEquals(1, graphAl.getOutdegree(6));
	assertEquals(2, graphAl.getOutdegree(1));
    }
    
    @Test
    void testTranspose() {
	List<List<Integer>> graph = List
		.of(List.of(2, 4), List.of(5), List.of(6, 5), List.of(2), List.of(4), List.of(6));
	GraphAL graphAl = new GraphAL(graph);
	GraphAL trAl = new GraphAL(graphAl.transpose());
	assertEquals(1, trAl.getIndegreeOf(2));
	assertEquals(1, trAl.getIndegreeOf(6));
	assertEquals(2, trAl.getIndegreeOf(1));
    }

}
