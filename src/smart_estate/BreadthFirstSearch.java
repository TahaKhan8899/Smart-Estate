package smart_estate;

import edu.princeton.cs.algs4.*;

public class BreadthFirstSearch {
	private boolean[] marked; // Is a shortest path to this vertex known?
	private int[] edgeTo; // last vertex on known path to this vertex
	private final int s; // source

	public BreadthFirstSearch(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		Queue<String> queue = new Queue<String>();
		marked[s] = true; // Mark the source
		queue.enqueue(s); // and put it on the queue.
		while (!q.isEmpty()) {
			int v = queue.dequeue(); // Remove next vertex from the queue.
			for (int w : G.adj(v))
				if (!marked[w]) // For every unmarked adjacent vertex,
				{
					edgeTo[w] = v; // save last edge on a shortest path,
					marked[w] = true; // mark it because path is known,
					queue.enqueue(w); // and add it to the queue.
				}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}

	// Same as for DFS (see page 536).
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
