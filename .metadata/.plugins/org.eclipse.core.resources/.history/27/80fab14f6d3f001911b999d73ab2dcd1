import java.util.HashSet;
import java.util.LinkedList;

public class TopologicalSort {

	public static void main(String[] args) {

		int[][] graph = new int[7][7];
		graph[0][1] = 10;
		graph[0][4] = 10;
		graph[1][2] = 10;
		graph[2][3] = 10;
		graph[5][4] = 10;
		graph[5][6] = 10;
		graph[6][3] = 10;

		topologicalsort(graph);
	}

	public static void topologicalsort(int[][] graph) {
		HashSet<Integer> visited = new HashSet<>();
		LinkedList<Integer> res = new LinkedList<>();
		for (int i = 0; i < graph.length; i++) {
			if (!visited.contains(i)) {
				topsort(graph, visited, i, res);
			}
		}
		System.out.println(res);
	}

	public static void topsort(int[][] graph, HashSet<Integer> visited, int src, LinkedList<Integer> stack) {
		visited.add(src);
		for (int nbr = 0; nbr < graph.length; nbr++) {
			if (graph[src][nbr] == 0 || visited.contains(nbr)) {
				continue;
			}
			topsort(graph, visited, nbr, stack);
		}
		stack.addFirst(src);
	}

}
