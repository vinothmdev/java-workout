package dev.vinothm.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    public List<Vertex> bfs(List<Vertex> graph) {
	var root = graph.get(0);
	root.visited = true;
	root.predecessor = null;

	LinkedList<Vertex> queue = new LinkedList<>();
	queue.add(root);

	List<Vertex> result = new ArrayList<>();

	while (!/* NOT */queue.isEmpty()) {
	    var vertex = queue.poll();
	    result.add(vertex);
	    for (int i = 0; i < vertex.edges.size(); i++) {
		var curr = graph.get(vertex.edges.get(i) - 1);
		if (!curr.visited) {
		    visit(vertex, curr);
		    queue.add(curr);
		}
	    }
	}

	return result;
    }

    private void visit(Vertex s, Vertex t) {
	t.distance = s.distance + 1;
	t.predecessor = s;
	t.visited = true;
    }

    public void printPath(List<Vertex> graph, Vertex s, Vertex v) {
	if (s.equals(v)) {
	    System.out.println(s);
	} else if (v.predecessor == null) {
	    System.out.println("There is no path between " + s + " and " + v);
	} else {
	    printPath(graph, s, v.predecessor);
	    System.out.println(v);
	}
    }
}

class Vertex {
    boolean visited;
    int value;
    List<Integer> edges;
    int distance;
    Vertex predecessor;

    Vertex(int value, List<Integer> edges) {
	this.value = value;
	this.edges = edges;
    }

    @Override
    public boolean equals(Object o) {
	return o != null && ((Vertex) o).value == this.value;
    }

    @Override
    public String toString() {
	return String.format("{ v=%d, d=%d, p=%d }", this.value, this.distance,
		this.predecessor != null ? this.predecessor.value : 0);
    }
}
