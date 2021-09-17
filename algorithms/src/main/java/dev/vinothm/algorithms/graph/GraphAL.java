package dev.vinothm.algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphAL {

    List<List<Integer>> graph;

    public GraphAL(List<List<Integer>> graph) {
	this.graph = graph;
    }

    public int getIndegreeOf(int v) {
	var count = new AtomicInteger();
	graph.stream().forEach(l -> l.stream().forEach(e -> {
	    if (e == v)
		count.incrementAndGet();
	}));
	return count.get();
    }

    public int getOutdegree(int v) {
	return this.graph.get(v - 1).size();
    }

    public List<List<Integer>> transpose() {
	List<List<Integer>> tr = new ArrayList<List<Integer>>();
	for (int i = 1; i <= graph.size(); i++) {
	    tr.add(new ArrayList<Integer>());
	}
	for (int i = 1; i <= graph.size(); i++) {
	    for (int e : graph.get(i - 1)) {
		tr.get(e - 1).add(i);
	    }

	}
	return tr;
    }

}
