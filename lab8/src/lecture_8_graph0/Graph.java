package lecture_8_graph0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;



/** 
 * A basic Graph class. Provides a constructor for creating a graph
 * by loading up a list of Pairs. The toString() method displays the
 * vertices and edges of a graph.
 * @author paul_
 *
 */
public class Graph {
	private LinkedList<Vertex> vertices = new LinkedList<Vertex>();
	private LinkedList<Edge> edges = new LinkedList<Edge>();
	HashMap<Vertex,LinkedList<Vertex>> adjList = new HashMap<Vertex,LinkedList<Vertex>>();

	/**
	 * Constructs a graph from a list of pairs. A pair (A,B)
	 * is transformed into vertices A and B together with an edge A-B.
	 */
	public Graph(List<Pair> pairs){
		HashMap<Vertex,Vertex> dupverts = new HashMap<Vertex,Vertex>();
		HashMap<Edge,Edge> dupedges = new HashMap<Edge,Edge>();
		for(Pair e : pairs){
			//handle the vertices and edges simultaneously
			Vertex v1 = new Vertex(e.ob1);
			Vertex v2 = new Vertex(e.ob2);
			Edge edge = new Edge(v1,v2);
			if(!dupverts.containsKey(v1)){
				dupverts.put(v1,v1);
				vertices.add(v1);
			}
			if(!dupverts.containsKey(v2)){
				dupverts.put(v2,v2);
				vertices.add(v2);
			}

			if(!dupedges.containsKey(edge)){
				dupedges.put(edge,edge);
				edges.add(edge);
			}

			LinkedList<Vertex> l = adjList.get(v1);
			if(l == null) {
				l = new LinkedList<Vertex>();
			}
			l.add(v2);
			adjList.put(v1,l);

			LinkedList<Vertex> l2 = adjList.get(v2);
			if(l2 == null) {
				l2 = new LinkedList<Vertex>();
			}
			l2.add(v1);
			adjList.put(v2,l2);
		}

	}
	
	public boolean areAdjacent(Vertex v, Vertex w) {
		
		LinkedList<Vertex> adjVertList = adjList.get(v);
		
		System.out.println(adjVertList);
		
		for(Vertex vert: adjVertList) {
			if(vert.equals(w)) {
				return true;
			}
		}

		//implement
		return false;
	}
	
	//bfs implementation
	private void bfs(Vertex v, HashMap<Vertex, Vertex> visitedNode) {
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(v);
		while(!queue.isEmpty()) {
			Vertex currVertex = queue.poll();
			for(Vertex vertex : adjList.get(currVertex)) {
				if(!visitedNode.containsKey(vertex)) {
					visitedNode.put(vertex, vertex);
					queue.add(vertex);
				}
			}
		}
	}
	
	// check if there exist path from u to v
	public boolean pathExists(Vertex u, Vertex v) {
		if (u == null || v == null)
			return false;
		if (!adjList.containsKey(u) || !adjList.containsKey(v))
			return false;
		HashMap<Vertex, Vertex> uVisitedNodes = new HashMap<>();
		HashMap<Vertex, Vertex> vVisitedNodes = new HashMap<>();
		Queue<Vertex> uNext = new LinkedList<>();
		Queue<Vertex> vNext = new LinkedList<>();
		uNext.offer(u);
		vNext.offer(v);
		while (!uNext.isEmpty() || !vNext.isEmpty()) {
			if (!uNext.isEmpty() && check(v, uVisitedNodes, uNext, vVisitedNodes))
				return true;
			if (!vNext.isEmpty() && check(u, vVisitedNodes, vNext, uVisitedNodes))
				return true;
		}
		return false;
	}

	
	private boolean check(Vertex node, HashMap<Vertex, Vertex> visitedNodes, Queue<Vertex> next,
			HashMap<Vertex, Vertex> otherEndNodes) {
		Vertex current = next.remove();
		for (Vertex vertex : adjList.get(current)) {
			if (otherEndNodes.containsKey(vertex) || vertex.equals(node))
				return true;
			if (!visitedNodes.containsKey(vertex)) {
				visitedNodes.put(vertex, vertex);
				next.add(vertex);
			}
		}
		return false;
	}

	// compute number of connected component
	// 1 -> graph is connected
	// > 1 means not connected and has connected component
	public int getNumberOfConnectedComponents() {
		int connectedComponents = 0;
		HashMap<Vertex, Vertex> visitedNodes = new HashMap<>();
		ListIterator<Vertex> vertexIterator = vertices.listIterator();
		Vertex currentVertex = null;
		while ((currentVertex = nextUnivisitedNode(vertexIterator, visitedNodes)) != null) {
			connectedComponents++;
			bfs(currentVertex, visitedNodes);
		}
		return connectedComponents;
	}


	// helper to get the current unvisited node
	private Vertex nextUnivisitedNode(ListIterator<Vertex> currentVertexIterator,
			HashMap<Vertex, Vertex> visitedNodes) {
		Vertex currentVertex = null;
		while (currentVertexIterator.hasNext()) {
			currentVertex = currentVertexIterator.next();
			if (!visitedNodes.containsKey(currentVertex))
				return currentVertex;
		}
		return null;
	}

	public boolean containsCycle() {
		HashMap<Vertex, Vertex> visitedNodes = new HashMap<>();
		ListIterator<Vertex> vertexIterator = vertices.listIterator();
		Vertex currentVertex = null;
		while ((currentVertex = nextUnivisitedNode(vertexIterator, visitedNodes)) != null) {
			if (cycleExists(currentVertex, visitedNodes))
				return true;
		}
		return false;
	}

	
	// BFS with cycle checking
	private boolean cycleExists(Vertex v, HashMap<Vertex, Vertex> visitedNodes) {
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(v);
		while (!queue.isEmpty()) {
			Vertex currentVertex = queue.poll();
			for (Vertex adj : adjList.get(currentVertex)) {
				if (!visitedNodes.containsKey(adj)) {
					visitedNodes.put(adj, adj);
					queue.add(adj);
				} else
					return true;
			}
		}
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Vertices: \n"+" ");
		for(Vertex v : vertices) {
			sb.append(v+" ");
		}
		sb.append("\nEdges:\n"+" ");
		HashMap<String,String> dups = new HashMap<String,String>();
		for(Vertex v: vertices){
			LinkedList<Vertex> l  = adjList.get(v);

			for(Vertex w : l){
				String edge = v.toString()+"-"+w.toString();
				String edgeRev = reverse(edge);
				if(!dups.containsKey(edge) && !dups.containsKey(edgeRev)){
					sb.append(edge+" ");
					dups.put(edge,edge);
				}
			}
		}
		return sb.toString();
	}
	
	/* Support method for toString() */
	private String reverse(String edge) {
		String[] vals = edge.split("-");
		return vals[1]+"-"+vals[0];
	}
	
	public List<Vertex> vertices() {
		return vertices;
	}

	public List<Edge> edges() {
		return edges;
	}

	public static void main(String[] args) {
		List<Pair> l = new ArrayList<Pair>();
		l.add(new Pair("A", "B"));
		l.add(new Pair("B", "C"));
		l.add(new Pair("A", "C"));
		l.add(new Pair("C", "D"));
		l.add(new Pair("F", "E"));
		l.add(new Pair("E", "A"));
		l.add(new Pair("F", "G"));
		l.add(new Pair("G", "H"));
		l.add(new Pair("H", "F"));
		l.add(new Pair("K", "W"));
		l.add(new Pair("Z", "X"));
		l.add(new Pair("X", "Y"));
		l.add(new Pair("K", "I"));

		Graph g = new Graph(l);
		
		System.out.println(g);
		System.out.println("PATH EXISTS BETWEEN A and W " + g.pathExists(new Vertex("A"), new Vertex("W")));
		System.out.println("Connected Components : " + g.getNumberOfConnectedComponents());
		System.out.println("Contains Cycle: " + g.containsCycle());

		
	}
}
