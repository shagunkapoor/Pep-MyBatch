package AugNewBatch.Oct1_Subseq;

import java.util.*;

import java.util.Collections;
import java.util.PriorityQueue;

public class Graphs {
	/*
	public static void main(String[] args) {

		spd = Integer.MAX_VALUE;
		sp = "";
		lpd = Integer.MIN_VALUE;
		lp = "";
		cpd = Integer.MAX_VALUE;
		cp = "";
		fpd = Integer.MIN_VALUE;
		fp = "";
		pq = new PriorityQueue<>();
		multisolver(0, 6, "", 0, 35, 40, 3);
		System.out.println();
		System.out.println(spd + "@" + sp);
		System.out.println(lpd + "@" + lp);
		System.out.println(cpd + "@" + cp);
		System.out.println(fpd + "@" + fp);
		System.out.println(pq.peek().wt + "@" + pq.peek().path);

	}

	static Integer[][] graph = new Integer[6][6];
	static boolean[] visited = new boolean[6];

	static int spd;
	static String sp;
	static int lpd;
	static String lp;
	static int cpd;
	static String cp;
	static int fpd;
	static String fp;
	static int kpd;
	static String kp;
	static PriorityQueue<Kthpair> pq;

	static class Kthpair implements Comparable<Kthpair> {
		int wt;
		String path;

		public Kthpair(int wt, String path) {
			this.wt = wt;
			this.path = path;
		}

		@Override
		public int compareTo(Kthpair o) {
			// TODO Auto-generated method stub
			return this.wt - o.wt;
		}

		public String toString() {
			return wt + "@" + path;
		}
	}

	private static void multisolver(int s, int d, String psf, int dsf, int cw, int fw, int k) {
		if (s == d) {
			psf += d;
			System.out.println("Path:" + psf);
			System.out.println("Distance" + dsf);

			if (spd > dsf) {
				spd = dsf;
				sp = psf;
			}
			if (lpd < dsf) {
				lpd = dsf;
				lp = psf;
			}
			if (dsf > cw && dsf < cpd) {
				cpd = dsf;
				cp = psf;
			}
			if (dsf < fw && dsf > fpd) {
				fpd = dsf;
				fp = psf;
			}
			if (pq.size() < k) {
				pq.add(new Kthpair(dsf, psf));
			} else {
				if (dsf < pq.peek().wt) {
					pq.remove();
					pq.add(new Kthpair(dsf, psf));
				}
			}
			return;
		}

		visited[s] = true;
		for (int n = 0; n < graph.length; n++) {
			if (graph[s][n] != 0 && visited[n] == false) {
				multisolver(n, d, psf + s, dsf + graph[s][n], cw, fw, k);
			}
		}
		visited[s] = false;

	}

	private static void hamiltonianPathandCycle(int s, int os, String path, int cnt) {
		if (cnt == visited.length - 1) {
			System.out.println(path);
			if (graph[s][os] != null) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
			return;
		}

		visited[s] = true;

		cnt++;
		for (int n = 0; n < graph.length; n++) {
			hamiltonianPathandCycle(n, path + s, cnt);
		}
		visited[s] = false;

	}

	static int[][] dir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

	static int[][] arr = new int[5][5];

	private static void KnightsTour(int n, int r, int c, int cnt) {
		if (cnt == n * n) {
			System.out.println("True");
			return;
		}

		visited[cnt] = true;
		cnt++;
		for (int i = 0; i < dir.length; i++) {
			sr = r;

		}
	}

	private static ArrayList<String> gcc() {
		ArrayList<String> res = new ArrayList<>();
		String s = "";
		for (int i = 0; i < graph.length; i++) {
			if (visited[i] == true) {
				s = bftgcc(i);
			}
			res.add(s);
		}
		return res;
	}

	private static String bftgcc(int src) {

		LinkedList<Integer> queue = new LinkedList<>();
		String res = "";
		queue.addLast(src);
		while (queue.size() != null) {
			int rem = queue.removeFirst();
			if (visited[rem] == true) {
				continue;
			} else {
				visited[rem] = false;
			}
			res += rem;
			for (int i = 0; i < graph.length; i++) {
				if (graph[rem][i] != null && visited[i] == false) {
					queue.addLast(i);
				}
			}

		}
		return res;

	}

	private static boolean isCyclic() {
		for (int i = 0; i < graph.length; i++) {
			if (visited[i] == false) {
				boolean res = isCyclichelper(i);
				if (res == true) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isCyclichelper(int src) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(src);
		while (queue.size() != 0) {
			int rem = queue.removeFirst();
			if (visited[rem] == true) {
				return true;
			} else {
				visited[rem] = true;
			}

			for (int i = 0; i < graph.length; i++) {
				if (graph[rem][i] != null && visited[i] == false) {
					queue.addLast(i);
				}
			}
		}
		return false;
	}

	private static boolean isConnected() {
		bftgcc(0);
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		return true;
	}

	private static class Pair implements Comparable<Pair> {
		int v;
		String p;
		int d;

		Pair(int v, String p, int d) {
			this.v = v;
			this.p = p;
			this.d = d;
		}

		public int compareTo(Pair o) {
			return this.d - o.d;
		}
	}

	private static void dijkstra(int src) { // Shortest Path

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, src + "", 0));

		while (pq.size() > 0) {
			// remove
			Pair rem = pq.remove();
			// mark *
			if (visited[rem.v] == true) {
				continue;
			} else {
				visited[rem.v] = true;
			}

			// work
			System.out.println(rem.v + " via " + rem.p + " @ " + rem.d);

			// add
			for (int n = 0; n < graph.length; n++) {
				if (graph[rem.v][n] != null && visited[n] == false) {
					pq.add(new Pair(n, rem.p + n, rem.d + graph[rem.v][n]));
				}
			}

		}
	}

	private static void Prims(int src) { // Min Spanning Tree

	}

	// Kruskals without Node Class
	private static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int wt;

		public Edge(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		public int compareTo(Edge o) {
			return this.wt - o.wt;
		}
	}

	private static Integer[][] Kruskals() {// graph as input //MST as output
		// intitalisation
		Integer[][] mst = new Integer[graph.length][graph.length];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int u = 0; u < graph.length; u++) {
			for (int v = u; v < graph.length; v++) {
				if (graph[u][v] != null) {
					pq.add(new Edge(u, v, graph[u][v]));
				}
			}
		}

		int[] djp = new int[graph.length];
		int[] djr = new int[graph.length];

		for (int i = 0; i < djp.length; i++) {
			djp[i] = i;
			djr[i] = 1;
		}

		// start
		while (pq.size() > 0) {
			Edge rem = pq.remove();

			int usetroot = find(djp, rem.u);
			int vsetroot = find(djp, rem.v);

			if (usetroot != vsetroot) {
				addEdge(mst, rem.u, rem.v, rem.wt);
				union(djp, djr, usetroot, vsetroot);
			}
		}

		return mst;

	}

	private static int find(int[] djp, int vtx) {
		if (djp[vtx] == vtx) {
			return vtx;
		} else {
			int root = find(djp, djp[vtx]);
			return root;
		}
	}

	private static void union(int[] djp, int[] djr, int uroot, int vroot) {
		if (djr[uroot] < djr[vroot]) {
			djp[uroot] = vroot;
		} else if (djr[uroot] > djr[vroot]) {
			djp[vroot] = uroot;
		} else {
			djp[uroot] = vroot;
			djr[vroot]++;
		}

	}

	private static void addEdge(Integer[][] graph, int u, int v, int wt) {
		graph[u][v] = wt;
		graph[v][u] = wt;
	}

	// Kruskals with Node Class

	private class NodeEdge implements Comparable<Edge> {
		int u;
		int v;
		int wt;

		public NodeEdge(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		public int compareTo(Edge o) {
			return this.wt - o.wt;
		}
	}

	private class Node {
		int vtx;
		int par;
		int rank;

		public Node(int vtx, int par, int rank) {
			this.vtx = vtx;
			this.par = par;
			this.rank = rank;
		}
	}

	private static Integer[][] NodeKruskals() {// graph as input //MST as output
		// intitalisation
		Integer[][] mst = new Integer[graph.length][graph.length];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int u = 0; u < graph.length; u++) {
			for (int v = u; v < graph.length; v++) {
				if (graph[u][v] != null) {
					pq.add(new Edge(u, v, graph[u][v]));
				}
			}
		}

		int[] djp = new int[graph.length];
		int[] djr = new int[graph.length];

		for (int i = 0; i < djp.length; i++) {
			djp[i] = i;
			djr[i] = 1;
		}

		// start
		while (pq.size() > 0) {
			Edge rem = pq.remove();

			int usetroot = find(djp, rem.u);
			int vsetroot = find(djp, rem.v);

			if (usetroot != vsetroot) {
				addEdge(mst, rem.u, rem.v, rem.wt);
				union(djp, djr, usetroot, vsetroot);
			}
		}

		return mst;

	}

	private static int Nodefind(int[] djp, int vtx) {
		if (djp[vtx] == vtx) {
			return vtx;
		} else {
			int root = find(djp, djp[vtx]);
			return root;
		}
	}

	private static void Nodeunion(int[] djp, int[] djr, int uroot, int vroot) {
		if (djr[uroot] < djr[vroot]) {
			djp[uroot] = vroot;
		} else if (djr[uroot] > djr[vroot]) {
			djp[vroot] = uroot;
		} else {
			djp[uroot] = vroot;
			djr[vroot]++;
		}

	}

	private static ArrayList<Integer> TopologicalSort() {  //Incorrect
		for(int i=0;i<graph.length;i++){
			if(visited[i]==false){
				LinkedList<Integer> res=new LinkedList<>();
				res=TS(i);
			}
		}
	}

	private static LinkedList<Integer> TS(int s){
		LinkedList<Integer> stack = new LinkedList<>();

//		if (visited[s] == true) {
//			continue;
//		} else
			visited[s] = true;
		for (int n = 0; n < graph.length; n++) {
			if (graph[s][n] != null && visited[n] == false) {
				TS(n);
				stack.addFirst(n);
			}
		}
		
		return stack;
	}


 */
}
