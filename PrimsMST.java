package MST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class PrimsMST<T> {

	ArrayList<Node> nodes;

	public PrimsMST() {
		nodes = new ArrayList<Node>();
	}

	public class Edge implements Comparable<Edge> {
		Node one;
		Node two;
		int value;

		public Edge(Node o, Node t, int v) {
			one = o;
			two = t;
			value = v;
		}

		public int compareTo(Edge o) {

			return this.value - o.value;
		}
	}

	public class Node<T> {
		T element;
		ArrayList<Edge> edges;

		public Node(T e) {
			element = e;
			edges = new ArrayList<Edge>();
		}

		public void addEdge(Node t, int v) {
			this.edges.add(new Edge(this, t, v));
			t.edges.add(new Edge(t, this, v));
		}

		public String toString() {
			return element.toString();

		}
	}

	public ArrayList<Node> primAlg() {
		ArrayList<Node> result = new ArrayList<>();
		Node<T> current = nodes.get(0);
		PriorityQueue<Edge> PQ = new PriorityQueue<>();
		HashSet<Node> visitedNodes = new HashSet<>();
		
		result.add(current);
		visitedNodes.add(current);
		PQ.addAll(current.edges);

		while (result.size() < nodes.size()) {
			Edge val = PQ.poll();

			if (!visitedNodes.contains(val.two)) {
				result.add(val.two);
				visitedNodes.add(val.two);
				current = val.two;
				for(Edge edge : current.edges) {
					if(!visitedNodes.contains(edge.two)) {
						PQ.add(edge);
					}
				}
			}

			
		}
		return result;
	}

	public Node add(T a) {
		Node r;
		nodes.add(r = new Node(a));
		return r;
	}

	public Node getNode(int i) {
		return nodes.get(i - 1);
	}

}
