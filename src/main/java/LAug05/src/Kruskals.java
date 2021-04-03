import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;

public class Kruskals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		ArrayList<Edge> graph = new ArrayList<>();
		
		graph.add(new Edge("A", "B", 10));
		graph.add(new Edge("A", "D", 40));
		graph.add(new Edge("B", "C", 10));
		graph.add(new Edge("C", "D", 10));
		graph.add(new Edge("D", "E", 2));
		graph.add(new Edge("E", "F", 3));
		graph.add(new Edge("E", "G", 8));
		graph.add(new Edge("F", "G", 3));

		ArrayList<Edge> mst = kruskals(graph);
		for (Edge mste : mst) {
			System.out.println(mste.v1name + " " + mste.v2name + " " + mste.weight);
		}
	}

	public class Edge implements Comparable<Edge> {
		String v1name;
		String v2name;
		int weight;

		public Edge(String v1name, String v2name, int weight) {
			this.v1name = v1name;
			this.v2name = v2name;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return o.weight - this.weight;
		}
	}

	public class Pair {
		String parent;
		int size;

		public Pair(String parent, int size) {
			this.parent = parent;
			this.size = size;
		}
	}

	public static ArrayList<Edge> kruskals(ArrayList<Edge> graph) {
		ArrayList<Edge> mstgraph = new ArrayList<>();
		HashMap<String, Pair> disjoint = new HashMap<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (Edge edge : graph) { //add all edges in PQ
			pq.add(edge);
		}

		
		for(Edge edge:graph){
			disjoint.put(edge.v1name, new Pair(edge.v1name,1));
			disjoint.put(edge.v2name, new Pair(edge.v2name, 1));
		}
		
		while (pq.size() > 0) {
			// remove
			Edge rp = pq.remove();

			// find parent
			String v1parent = find(rp.v1name, disjoint);
			String v2parent = find(rp.v2name, disjoint);


			if (!v1parent.equals(v2parent)) {
				mstgraph.add(rp);
				merge(v1parent, v2parent, disjoint);
			}
		}
		return mstgraph;
	}

	public static String find(String vtx, HashMap<String, Pair> disjoint) {
		if (vtx.equals(disjoint.get(vtx))) {
			return vtx;
		}else{
		String v1set = disjoint.get(vtx).parent;
		return find(v1set, disjoint);
		}
	}

	public static void merge(String v1name, String v2name, HashMap<String, Pair> disjoint) {

		Pair v1setp = disjoint.get(v1name);
		Pair v2setp = disjoint.get(v2name);

		if (v1setp.size > v2setp.size) {
			v1setp.size += v2setp.size;
			v2setp.size = -1;
			v2setp.parent = v1setp.parent;
		} else {
			v2setp.size += v1setp.size;
			v1setp.size = -1;
			v1setp.parent = v2setp.parent;
		}
	}

}
*/
		
		
		
		int[][] graph = new int[7][7];
		graph[0][1] = 10;
		graph[0][4] = 10;
		graph[1][2] = 10;
		graph[2][3] = 10;
		graph[5][4] = 10;
		graph[5][6] = 10;
		graph[6][3] = 10;
	}
	
	public class EdgePair{
		int u;
		int v;
		int wt;
		
		EdgePair(int u, int v, int wt){
			this.u=u;
			this.v=v;
			this.wt=wt;
		}
	}
	
	private static void Krus(int[][] graph){  //MST
		
		int[] djp=new int[graph.length];
		int[] djr=new int[graph.length];
		
		PriorityQueue<EdgePair> pq=new PriorityQueue<>();
		
		for(int i=0;i<graph.length;i++){
			djr[i]=1;
			djp[i]=i;
		}
		
		for(int u=0;u<graph.length;u++){
			for(int v=u;v<graph.length;v++){
				if(graph[u][v]!=0){
					EdgePair e=new EdgePair(u,v,graph[u][v]);
				
				}
			}
		}
		
		while(pq.size()>0){
			
		}
		
		
	}
}
