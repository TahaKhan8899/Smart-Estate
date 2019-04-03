package smart_estate;

import java.io.IOException;
import java.util.ArrayList;

import edu.princeton.cs.algs4.*;

public class BreadthFirstSearch {
	private static boolean[] marked; // Is a shortest path to this vertex known?
	private static String[] edgeTo; // last vertex on known path to this vertex
	private static String s; // source
	public static ArrayList<String> path = new ArrayList<String>();

	public static ArrayList<String> BreadthFirstSearch(Graph G, String s){
		marked = new boolean[G.V()];
		edgeTo = new String[G.V()];
		s = s;
		return bfs(G, s);
	}

	private static ArrayList<String> bfs(Graph G, String s) {
		Queue<String> queue = new Queue<String>();
		
		marked[Graph.states.indexOf(s)] = true; // Mark the source
		queue.enqueue(s); // and put it on the queue.
		while (!queue.isEmpty()) {
			String v = queue.dequeue(); // Remove next vertex from the queue.
			for (String w : G.adj(Graph.states.indexOf(v)))
				if (!marked[Graph.states.indexOf(w)]) { // For every unmarked adjacent vertex,
				
					edgeTo[Graph.states.indexOf(w)] = v; // save last edge on a shortest path,
					marked[Graph.states.indexOf(w)] = true; // mark it because path is known,
					path.add(w);
				}
		}
		return path;
		
	}

	public static StateInfo[] getStateInfo(ArrayList<String> neighbours) {
		StateInfo[] statesInfo = new StateInfo[50];
		statesInfo = PopulateStateInfo.populateStateInfo();
		StateInfo[] stateFeatures = new StateInfo[neighbours.size()];
		for (int i = 0; i < neighbours.size(); i++) {
			StateInfo info = binSearch.binSearch(statesInfo, neighbours.get(i));
			stateFeatures[i] = info;
			
		}
		return stateFeatures;
		
		
	}

	public static void main(String[] args) throws IOException {
		
		Graph g = Graph.genGraph();
		ArrayList<String> p = new ArrayList<String>();
		p = BreadthFirstSearch(g, "Alabama");
		StateInfo[] info = getStateInfo(p);
		for (int i = 0; i < info.length; i++) {
			System.out.println(info[i].toString());
		}

		

	}

}
