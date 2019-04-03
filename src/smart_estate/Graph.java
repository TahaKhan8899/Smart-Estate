package smart_estate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import edu.princeton.cs.algs4.Bag;

public class Graph {
	public static int V; // number of vertices
	private static int E; // number of edges
	private static Bag<String>[] adj; // adjacency lists
	public static ArrayList<String> states = new ArrayList<String>(Arrays.asList(StateGen.readStates()));

	public Graph(int V) {
		this.V = V;
		this.E = 0;

		adj = (Bag<String>[]) new Bag[V]; // Create array of lists.
		for (int v = 0; v < V; v++) // Initialize all lists
			adj[v] = new Bag<String>(); // to empty.
	}

	public static Graph genGraph() {
		Graph g = new Graph(50);

		try {

			BufferedReader reader = new BufferedReader(new FileReader("data/connectedStates.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] info = line.split(", ");
				String state = info[0];
				for (int i = 1; i < info.length; i++) {
					g.addEdge(state, info[i]);

				}

				line = reader.readLine();
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;

	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public static void addEdge(String v, String w) {
		adj[states.indexOf(v)].add(w); // Add w to v’s list.
		E++;
	}

	public Iterable<String> adj(int v) {
		return adj[v];
	}

	public static void main(String args[]) {

		// The following code is just to print the graph, for debugging purposes
		Graph g = genGraph();
		int count = 0;

		for (int i = 0; i < adj.length; i++) {
			Iterator<String> curr = g.adj[i].iterator();
			System.out.println("Current: " + states.get(count));
			count++;

			while (curr.hasNext()) {

				System.out.print(curr.next() + ", ");

			}
			System.out.println("");

		}

	}

}
