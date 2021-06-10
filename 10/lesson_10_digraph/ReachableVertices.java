package lesson_10_digraph;

import java.util.ArrayList;
import java.util.List;

public class ReachableVertices extends DepthFirstSearch {
	private int numComponents = 0;
	List<Vertex> reachableVertices;
	public ReachableVertices(Digraph graph) {
		super(graph);
		reachableVertices = new ArrayList<>();
	}

	@Override
	public void processVertex(Vertex w) {
		// Change value of pathFound only if we are working in
		// the 0th component.
		if (numComponents == 0) {
			reachableVertices.add(w);
		}
	}

	@Override
	public void additionalProcessing() {
		numComponents++;
	}

	public List<Vertex> reachable(Vertex u) {
		start(u);
		return reachableVertices;
	}
}
