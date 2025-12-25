package project.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Twitter {

	public class Node {
		int data;
		int value;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data, int value) {
			this.data = data;
			this.value = value;
		}
	}

	Node root;



	public static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values,
			List<Integer> queries) {

		HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();

		return queries;

	}

	public void constTree(int n, int m, List<Integer> first, List<Integer> second, List<Integer> values) {
		root = new Node(1, values.get(0));

		for (int i = 0; i < m; i++) {
			if (first.get(i) == root.data) {
				Node ch = new Node(second.get(i), values.get(second.get(i) - 1));
				root.children.add(ch);
			}
		}

		constTreeHelper(root, n, m, first, second, values);
		// correctTree();

	}

	private void constTreeHelper(Node node, int n, int m, List<Integer> first, List<Integer> second,
			List<Integer> values) {

		// for(Node child:node.children){
		//
		// for(int i=0;i<m;i++){
		// if(first.get(i)==child.data){
		// Node ch=new Node(second.get(i), values.get(second.get(i)-1));
		// child.children.add(ch);
		// }
		// }
		// }

	}

	public class treeConnections {

		HashMap<Node, ArrayList<Node>> hmap = new HashMap<>();

		public boolean containsEdge(Node n1, Node n2) {
			if (hmap.get(n1).contains(n2)) {
				return true;
			}

			return false;
		}

		public void addEdge(Node n1, Node n2) {
			if (containsEdge(n1, n2)) {
				return;
			}
			ArrayList<Node> a1 = hmap.get(n1);
			a1.add(n2);
			hmap.put(n1, a1);
			ArrayList<Node> a2 = hmap.get(n2);
			a2.add(n1);
			hmap.put(n2, a2);
		}

		public ArrayList<Node> nodeTorootPath(Node n, int data) {
			if (n == null) {
				return new ArrayList<>();
			}
			if (n.data == data) {
				ArrayList<Node> base = new ArrayList<>();
				base.add(n);
				return base;
			}

			ArrayList<Node> res;
			for (Node child : n.children) {
				res = nodeTorootPath(child, data);
				if (res.size() > 0) {
					res.add(n);
				}
				return res;
			}

			return new ArrayList<>();
		}

		public void correctTree() {

		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10, m=9;
		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();
		List<Integer> values = new ArrayList<>();
		List<Integer> queries = new ArrayList<>();
		
		first.add(6);
		first.add(8);
		first.add(3);
		first.add(6);
		first.add(4);
		first.add(1);
		first.add(8);
		first.add(5);
		first.add(1);
		
		second.add(9);
		second.add(9);
		second.add(5);
		second.add(7);
		second.add(8);
		second.add(8);
		second.add(10);
		second.add(8);
		second.add(2);
		
		values.add(17);
		values.add(29);
		values.add(3);
		values.add(20);
		values.add(11);
		values.add(8);
		values.add(3);
		values.add(23);
		values.add(5);
		values.add(15);
		

//		treeConnections t = new treeConnections();

		for (int i = 0; i < m; i++) {

		}
	}
}
