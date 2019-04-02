package smart_estate;

import java.io.*;
import java.util.*;

import edu.princeton.cs.algs4.Bag;

public class Graph {
	private static int V; // number of vertices
	private static int E; // number of edges
	private static Bag<String>[] adj; // adjacency lists
	public static ArrayList<String> states = new ArrayList<String>();

	public Graph(int V) {
		V = V;
		E = 0;
		adj = (Bag<String>[]) new Bag[V]; // Create array of lists.
		for (int v = 0; v < V; v++) // Initialize all lists
			adj[v] = new Bag<String>(); // to empty.
	}

	public static void readStates() throws IOException {

		try {
			
			BufferedReader reader = new BufferedReader (new FileReader("data/connectedStates.txt")); 
			String line = reader.readLine(); 
			while (line != null) {
				String[] info = line.split(", " );
				String state = info[0];
				states.add(state);
				line = reader.readLine(); 
				
				
			}
			


			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static Graph genGraph() throws IOException {
		readStates();
		Graph g = new Graph(50);
		try {
			
			BufferedReader reader = new BufferedReader (new FileReader("data/connectedStates.txt")); 
			String line = reader.readLine(); 
			while (line != null) {
				String[] info = line.split(", " );
				String state = info[0];
				for (int i = 1; i < info.length; i++ ) {
					g.addEdge(state, info[i]);
					
				}
			
				line = reader.readLine(); 
			}
			
			
		} catch (FileNotFoundException e) {
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
		adj[states.indexOf(w)].add(v); // Add v to w’s list.
		E++;
	}

	public Iterable<String> adj(int v) {
		return adj[v];
	}
	
	public static void main (String args[]) throws IOException {
		
		//The following code is just to print the graph, for debugging purposes
		Graph g = genGraph();
		int count = 1;
		for (int i = 0; i < adj.length; i++) {
			Iterator<String> curr = g.adj[i].iterator();
			System.out.println("current: " + count);
			
			while (curr.hasNext()) {
				
				System.out.println(curr.next());
				
			}
			count++;
			
		}
		System.out.println(count);
		
		
		
	}

}
