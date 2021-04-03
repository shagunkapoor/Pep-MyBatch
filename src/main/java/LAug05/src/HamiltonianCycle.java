import java.util.HashSet;

public class HamiltonianCycle {

	public static void main(String[] args) {
		int[][] graph = new int[7][7];
		addEdge(graph, 0, 1, 10);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 5, 6, 3);
		addEdge(graph, 4, 6, 8);

		printAllPaths(0, 6, graph, new HashSet<>(), "0");
		hamiltonian(2, 2, graph, new HashSet<>(), "2");

	}

	public static void addEdge(int[][] graph, int i, int j, int wt) {
		graph[i][j] = wt;
		graph[j][i] = wt;
	}

	public static void printAllPaths(int src, int dest, int[][] graph, HashSet<Integer> visited, String psf) {
		if (src == dest) {
			System.out.println(psf);
			return;
		}

		visited.add(src);
		for (int nbr = 0; nbr < graph.length; nbr++) {
			if (graph[src][nbr] != 0) {
				if (visited.contains(nbr) == false) {
					printAllPaths(nbr, dest, graph, visited, psf + "" + nbr);
				}
			}
		}

		visited.remove(src);

	}

	public static void hamiltonian(int originalsrc, int src, int[][] graph, HashSet<Integer> visited, String hampath) {
		if (visited.size() == graph.length - 1) { // Hamiltonian Path exists
			if (graph[originalsrc][src] != 0) { // Hamiltonian Cycle exists
				System.out.println("Path:" + hampath + " Hamiltonian Cycle exists");
			} else {
				System.out.println("Path:"+ hampath+" Hamiltonian Cycle does not exist");
			}
		}
		visited.add(src);
		for (int nbr = 0; nbr < graph.length; nbr++) {
			if (graph[src][nbr] != 0 && !visited.contains(nbr)) {
				hamiltonian(originalsrc, nbr, graph, visited, hampath + "" + nbr);
			}
		}
		visited.remove(src);

	}
	
//	public static void KnightsTour(int sr, int sc, int[][] graph, int[][]){
//		
//	}
	
	
}
