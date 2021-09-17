package dev.vinothm.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    public List<Integer> bfs(List<Vertex> graph) {
	var root = graph.get(0);
	root.visited = true;

	LinkedList<Vertex> queue = new LinkedList<>();
	queue.add(root);

	List<Integer> result = new ArrayList<>();

	while (!/* NOT */queue.isEmpty()) {
	    var vertex = queue.poll();
	    result.add(vertex.value);
	    for (int i = 0; i < vertex.edges.size(); i++) {
		var curr = graph.get(vertex.edges.get(i) - 1);
		if (!curr.visited) {
		    curr.d = vertex.d + 1;
		    queue.add(curr);
		}
		curr.visited = true;
	    }
	}

	return result;
    }

}

class Vertex {
    boolean visited;
    int value;
    List<Integer> edges;
    int d;

    Vertex(int value, List<Integer> edges) {
	this.value = value;
	this.edges = edges;
    }

    @Override
    public boolean equals(Object o) {
	return ((Vertex) o).value == this.value;
    }
}
