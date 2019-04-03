package smart_estate;

import edu.princeton.cs.algs4.*;

public class BreadthFirstSearch {
	private static boolean[] marked; // Is a shortest path to this vertex known?
	private static String[] edgeTo; // last vertex on known path to this vertex
	private static int s; // source

	public static void BreadthFirstSearch(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new String[G.V()];
		s = s;
		bfs(G, s);
	}

	private static void bfs(Graph G, int s) {
		Queue<String> queue = new Queue<String>();
		marked[s] = true; // Mark the source
		queue.enqueue(Graph.states.get(s)); // and put it on the queue.
		while (!queue.isEmpty()) {
			String v = queue.dequeue(); // Remove next vertex from the queue.
			for (String w : G.adj(Graph.states.indexOf(v)))
				if (!marked[Graph.states.indexOf(w)]) // For every unmarked adjacent vertex,
				{
					edgeTo[Graph.states.indexOf(w)] = v; // save last edge on a shortest path,
					marked[Graph.states.indexOf(w)] = true; // mark it because path is known,
					queue.enqueue(w); // and add it to the queue.
				}
		}
	}



	// Same as for DFS (see page 536).
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
