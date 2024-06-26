package project.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Amazonques {

	// public static void main(String[] args) {
	// Scanner scn = new Scanner(System.in);
	//
	// PriorityQueue pq = new PriorityQueue<>();
	// PriorityQueue temp = new PriorityQueue<>();
	//
	// int n = 10;
	// int q = 10;
	// for (int i = 0; i < q; i++) {
	// int m = scn.nextInt();
	// temp.add(m);
	// pq.addAll(temp);
	// System.out.println(solve(m, 1, 10, pq));
	// }
	// }
	//
	// public static int solve(int m, int ll, int ul, PriorityQueue pq) {
	// int sum = ll;
	// while (pq.size() > 0) {
	// int rem = (int) pq.remove();
	//
	// if (pq.size() != 0) {
	// int top = (int) pq.peek();
	// sum += (top - 1) + (rem + 1);
	// }
	// }
	//
	// sum += ul;
	//
	// return sum;
	// }

	public static void main(String[] args) {
		int N = 6;

		int[][] tree = new int[N][N];
		int[] A = { 1, 5, 7, 8, 6, 10 };
		int[] X = { 6, 7, 2 };
		int[] L = { 1, 2, 6 };
		int[] u = { 1, 1, 2, 2, 3 };
		int[] v = { 2, 3, 4, 5, 6 };

		for (int i = 0; i < 3; i++) {
			System.out.println(solve2(N, 3, A, X[i], L[i], u, v));
		}

	}

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}
	}

	static Node root;

	public static int solve2(int N, int q, int[] A, int X, int L, int[] u, int[] v) {
		int res = Integer.MAX_VALUE;
//		root = new Node(A[0]);

		HashSet<Integer> visited=new HashSet<>();
		for (int i = 0; i < N - 1; i++) {
			constructTree(A[u[i] - 1], A[v[i] - 1], visited);
		}

		int maxdep = maxdepth(root);

		HashMap<Integer, ArrayList<Integer>> hlevels = new HashMap<>();
		addLevels(hlevels, root, 0);

		// for (int i = 0; i < q; i++) {
		int level = (L % (maxdep + 1));
		if (hlevels.containsKey(level)) {
			ArrayList<Integer> resal = hlevels.get(level);
			for (int r : resal) {
				if (r >= X) {
					res = Math.min(res, r);
				}
			}
			return res;
		} else {
			return -1;
		}

	}

	private static void constructTree(int val1, int val2, HashSet<Integer> visited) {
//		if(visited.contains(val1)==false)
		Node n1 = new Node(val1);
		
		Node n2 = new Node(val2);
		if(root==null){
			root=n1;
		}
		n1.children.add(n2);

	}

	private static int maxdepth(Node root) {
//		if (root == null) {
//			return -1;
//		}
		int level = 0;

		for (Node child : root.children) {
			int h = maxdepth(child);
			level = Math.max(level, h);
		}

		level += 1;
		return level;
	}

	private static void addLevels(HashMap<Integer, ArrayList<Integer>> hlevels, Node root, int l) {
		if (root == null) {
			return;
		}

		ArrayList<Integer> al = new ArrayList<>();
		if (hlevels.containsKey(l)) {
			al = hlevels.get(l);
			al.add(root.data);
			hlevels.put(l, al);
		} else {
			// al = new ArrayList<>();
			al.add(root.data);
			hlevels.put(l, al);
		}
		for (Node child : root.children) {
			addLevels(hlevels, child, l + 1);
		}

	}
}
