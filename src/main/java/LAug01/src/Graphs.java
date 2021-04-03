import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graphs {

	private HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int countVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (vces.containsKey(vname)) {
			return;
		} else {
			vces.put(vname, new HashMap<>());
		}
	}

	public void removevertex(String vname) {
		if (!vces.containsKey(vname)) {
			return;
		}
		ArrayList<String> allkeys = new ArrayList<>(vces.get(vname).keySet());
		for (String str : allkeys) {
			vces.get(str).remove(vname);
		}
		vces.remove(vname);
	}

	public int countEdges() {
		int edges = 0;

		for (String ename : vces.keySet()) {
			edges += vces.get(ename).size();
		}
		return edges / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {

		if (vces.containsKey(v1name) && vces.get(v1name).containsKey(v2name)) {
			return true;
		} else {
			return false;
		}
	}

	public void addEdge(String v1name, String v2name, int weight) {
		if (containsEdge(v1name, v2name)) {
			return;
		}

		vces.get(v1name).put(v2name, weight);
		vces.get(v2name).put(v1name, weight);
	}

	public void removeEdge(String v1name, String v2name) {
		if (!containsEdge(v1name, v2name)) {
			return;
		}
		vces.get(v1name).remove(v2name);
		vces.get(v2name).remove(v1name);
	}

	public void display() {
		for (String str : vces.keySet()) {
			System.out.println(str + " -> " + vces.get(str));
		}
	}

	//DFS
	public boolean hasPath(String src, String dest) {
		return hasPathHelper(src, dest, new HashSet<>());
	}

	private boolean hasPathHelper(String src, String dest, HashSet<String> visited) {

		if (containsEdge(src, dest)) {
			return true;
		}

		visited.add(src);

		for (String nghbr : vces.get(src).keySet()) {
			if (visited.contains(nghbr) == false) {
				boolean hpfromntod = hasPathHelper(nghbr, dest, visited);
				if (hpfromntod)
					return true;
			}
		}

		return false;
	}

	public void printAllPaths(String src, String dest) {
		printAllPathsHelper(src, dest, new HashSet<>(), src);
	}

	private void printAllPathsHelper(String src, String dest, HashSet<String> visited, String psf) {
		if (src.equals(dest)) {
			System.out.println(psf);
			return;
		}
		visited.add(src);

		for (String nghbr : vces.get(src).keySet()) {
			if (visited.contains(nghbr) == false) {
				printAllPathsHelper(nghbr, dest, visited, psf + nghbr);
			}
		}
		visited.remove(src);

	}

	//DFS (in terms of weight)
	public void printShortestPath(String src, String dest) {
		printShortestPathHelper(src, dest, new HashSet<>(), 0, src);
		System.out.println(shortest + "@" + spancount);
	}

	static int spancount = Integer.MAX_VALUE;
	static String shortest = "";

	private void printShortestPathHelper(String src, String dest, HashSet<String> visited, int csf, String psf) {
		if (src.equals(dest)) {
			if (csf < spancount) {
				spancount = csf;
				shortest = psf;
			}
			return;
		}

		visited.add(src);
		for (String nghbr : vces.get(src).keySet()) {
			if (visited.contains(nghbr) == false) {
				printShortestPathHelper(nghbr, dest, visited, csf + vces.get(src).get(nghbr), psf + nghbr);
			}
		}
		visited.remove(src);

	}

	public void printShortestPath2(String src, String dest) {
		Pair res = printShortestPath2Helper(src, dest, new HashSet<>());
		System.out.println(res.shortestpath + "@" + res.count);
	}

	class Pair implements Comparable<Pair> {
		int count = Integer.MAX_VALUE;
		String shortestpath = "";

		@Override
		public int compareTo(Pair o) {
			return this.count - o.count;
		}
	}

	private Pair printShortestPath2Helper(String src, String dest, HashSet<String> visited) {
		if (src.equals(dest)) {
			Pair base = new Pair();
			base.count = 0;
			base.shortestpath = dest;
			return base;
		}
		visited.add(src);
		Pair mp = new Pair();
		for (String nbr : vces.get(src).keySet()) {
			if (!visited.contains(nbr)) {
				Pair np = printShortestPath2Helper(nbr, dest, visited);
				if (np.shortestpath.length() > 0 && vces.get(src).get(nbr) + np.count < mp.count) {
					mp.count = vces.get(src).get(nbr) + np.count;
					mp.shortestpath = src + np.shortestpath;
				}
			}
		}
		visited.remove(src);
		return mp;
	}

	class HeapMover {
		String shortestp = null;
		int shortestpc = Integer.MAX_VALUE;
		String largestp = null;
		int largestpc = Integer.MIN_VALUE;
		String justLargerp = null;
		int justLargerpc = Integer.MAX_VALUE;
		PriorityQueue<Pair> pq = new PriorityQueue<>(); // for kth largest
	}

	public void multiSolver(String src, String dest, int k, int jlw) {
		HeapMover mover = new HeapMover();
		multiSolverHelper(src, dest, k, jlw, new HashSet<>(), src, 0, mover);

		System.out.println(mover.shortestp + "@" + mover.shortestpc);
		System.out.println(mover.largestp + "@" + mover.largestpc);
		System.out.println(mover.justLargerp + "@" + mover.justLargerpc);
		System.out.println(mover.pq.peek().shortestpath + "@" + mover.pq.peek().count);
	}

	private void multiSolverHelper(String src, String dest, int k, int jlw, HashSet<String> visited, String psf,
			int csf, HeapMover mover) {
		if (src.equals(dest)) {
			if (csf < mover.shortestpc) { // shortest path
				mover.shortestp = psf;
				mover.shortestpc = csf;
			}
			if (csf > mover.largestpc) { // largest path
				mover.largestp = psf;
				mover.largestpc = csf;
			}
			if (csf > jlw) {
				if (csf < mover.justLargerpc) { // just larger
					mover.justLargerp = psf;
					mover.justLargerpc = csf;
				}
			}

			if (mover.pq.size() < k) {
				Pair p = new Pair();
				p.count = csf;
				p.shortestpath = psf;
				mover.pq.add(p);
			} else if (csf > mover.pq.peek().count) {
				mover.pq.remove();
				Pair p = new Pair();
				p.count = csf;
				p.shortestpath = psf;
				mover.pq.add(p);
			}

		}

		visited.add(src);
		for (String nghbr : vces.get(src).keySet()) {
			if (visited.contains(nghbr) == false) {
				multiSolverHelper(nghbr, dest, k, jlw, visited, psf + nghbr, csf + vces.get(src).get(nghbr), mover);
			}
		}
		visited.remove(src);
	}

	private class TPair {
		String vname;
		String psf;
		String color;

		TPair(String vname, String psf) {
			this.vname = vname;
			this.psf = psf;
		}

		TPair(String vname, String psf, String color) {
			this(vname, psf);
			this.color = color;
		}
	}
	// public boolean bfs(String src, String dest){
	//
	// }
	// public boolean dfs(String src, String dest){
	//
	// }

	public void bft() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> allkeys = new ArrayList<>(vces.keySet());
		System.out.println("BFT:");
		for (String nbr : allkeys) {
			if (visited.contains(nbr) == false) {
				bftComponent(nbr, visited);
			}
		}
	}

	public void bftComponent(String src, HashSet<String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();
		TPair tp = new TPair(src, src);
		queue.addLast(tp);
		while (queue.size() > 0) {
			TPair rp = queue.removeFirst();

			if (visited.contains(rp.vname)) { // best Spot For cycle detection.
				continue;
			}

			visited.add(rp.vname);

			System.out.println(rp.vname + " " + rp.psf);
			for (String nbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(nbr)) {
					continue;
				}

				queue.addLast(new TPair(nbr, rp.psf + nbr));
			}
		}
	}

	public void dft() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> allkeys = new ArrayList<>(vces.keySet());
		System.out.println("DFT:");
		for (String nbr : allkeys) {
			if (visited.contains(nbr) == false) {
				dftComponent(nbr, nbr, visited);
			}
		}
	}

	private void dftComponent(String src, String psf, HashSet<String> visited) {
		visited.add(src);

		System.out.println(src + " " + psf);
		ArrayList<String> allkeys = new ArrayList<>(vces.get(src).keySet());
		for (String child : allkeys) {
			if (visited.contains(child) == false)
				dftComponent(child, psf + child, visited);
		}
	}

	public boolean isConnected() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> allkeys = new ArrayList<>(vces.keySet());
		bftComponent(allkeys.get(0), visited);
		return visited.size() == allkeys.size();
	}
	// OR
	// public boolean isConnected() {
	// counter
	// }
	// private boolean isConnected(){
	//
	// }

	public boolean isCyclic() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> allkeys = new ArrayList<>(vces.keySet());
		for (String nbr : allkeys) {
			if (visited.contains(nbr) == false) {
				boolean res = isCyclicComponents(nbr, visited);
				if (res == true) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isCyclicComponents(String src, HashSet<String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();
		TPair tp = new TPair(src, src);
		queue.addLast(tp);
		while (queue.size() > 0) {
			TPair rp = queue.removeFirst();

			if (visited.contains(rp.vname)) { // best Spot For cycle detection.
				return true;
			}

			visited.add(rp.vname);

			// System.out.println(rp.vname + " " + rp.psf);

			for (String nbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(nbr)) {
					continue;
				}

				queue.addLast(new TPair(nbr, rp.psf + nbr));
			}
		}
		return false;
	}

	public ArrayList<String> getConnectedComponents() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> components = new ArrayList<>();
		ArrayList<String> allkeys = new ArrayList<>(vces.keySet());
		for (String nbr : allkeys) {
			if (visited.contains(nbr) == false) {
				String res = getConnectedComponents(nbr, visited);
				components.add(res);
			}
		}
		return components;
	}

	private String getConnectedComponents(String src, HashSet<String> visited) {
		String comp = "";
		LinkedList<TPair> queue = new LinkedList<>();
		TPair tp = new TPair(src, src);
		queue.addLast(tp);
		while (queue.size() > 0) {
			TPair rp = queue.removeFirst();

			if (visited.contains(rp.vname)) { // best Spot For cycle detection.
				continue;
			}

			visited.add(rp.vname);

			// System.out.println(rp.vname + " " + rp.psf);
			comp += rp.vname;
			for (String nbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(nbr)) {
					continue;
				}

				queue.addLast(new TPair(nbr, rp.psf + nbr));
			}
		}
		return comp;
	}

	public boolean IsBipartite() {
		HashMap<String, String> visited = new HashMap<>();
		ArrayList<String> allkeys = new ArrayList<>(vces.keySet());
		for (String nbr : allkeys) {
			if (visited.containsKey(nbr) == false) {
				boolean res = BipartiteHelper(nbr, visited);
				if (res == false) {
					return false;
				}
			}
		}
		return true;

	}

	private boolean BipartiteHelper(String src, HashMap<String, String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();
		queue.addLast(new TPair(src, src, "*"));

		while (queue.size() > 0) {
			TPair rp=queue.remove();
			if (visited.containsKey(rp.vname)) {
				String oldcolor=visited.get(rp.vname);
				String newcolor=rp.color;
				
				if(!oldcolor.equals(newcolor)){
					return false;
				}
			}
			visited.put(rp.vname, rp.color);
			
			for(String nbr:vces.get(rp.vname).keySet()){
				if(visited.containsKey(nbr)==false){
					queue.addLast(new TPair(nbr, rp.psf+nbr, rp.color.equals("*")?"@": "*"));
				}
			}
		}
		return true;

	}

}
