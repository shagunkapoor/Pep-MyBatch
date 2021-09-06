package KJuly17;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;

		private Node(int data) {
			this.data = data;
		}
	}

	Node root;                   

	public BinaryTree(int[] arr) {

		LinkedList<Node> stack = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			Node n = new Node(arr[i]);
			if (arr[i] == -1) {
				Node top = stack.removeFirst();
				if (stack.size() == 0) {
					root = top;
				} else {
					if (stack.getFirst().left == null) {
						stack.getFirst().left = top;
					} else {
						stack.getFirst().right = top;
					}
				}
			} else {
				stack.addFirst(n);
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		String str = "";
		str += node.left != null ? node.left.data + "" : "-1";
		str += " <- " + node.data + " -> ";
		str += node.right != null ? node.right.data : "-1";

		System.out.print(str);
		System.out.println();
		if (node.left != null) {
			display(node.left);

		}
		if (node.right != null) {
			display(node.right);

		}
	}

	// public class HeapMover {
	// int treesize = 0;
	// int treemax = Integer.MIN_VALUE;
	// int treeheight = 0;
	// boolean eltfound = false;
	// }

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		int lsize = size(node.left);
		int rsize = size(node.right);
		return lsize + rsize + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int res = Math.max(max(node.left), max(node.right));
		return Math.max(node.data, res);
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		return Math.max(height(node.left), height(node.right)) + 1;

	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}
		boolean findleft = find(node.left, data);
		if (findleft == true) {
			return true;
		}

		boolean findright = find(node.right, data);
		if (findright == true) {
			return true;
		}
		return false;
	}

	public ArrayList<Integer> nodetorootpath(int data) {
		return nodetorootpath(root, data);
	}

	private ArrayList<Integer> nodetorootpath(Node node, int data) {
		if (node == null) {
			return new ArrayList<>();
		}
		if (node.data == data) {
			ArrayList<Integer> paths = new ArrayList<>();
			paths.add(node.data);
			return paths;
		}
		ArrayList<Integer> lpath = nodetorootpath(node.left, data);
		if (lpath.size() > 0) {
			lpath.add(node.data);
			return lpath;
		}
		ArrayList<Integer> rpath = nodetorootpath(node.right, data);
		if (rpath.size() > 0) {
			rpath.add(node.data);
			return rpath;
		}

		return new ArrayList<>();
	}

	public void printRootToLeafPathsInRange(int lo, int hi) {
		printRootToLeafPathsInRange(root, "", 0, lo, hi);
	}

	private void printRootToLeafPathsInRange(Node node, String psf, int ssf, int lo, int hi) {
		if (node.left == null && node.right == null) {
			if (ssf + node.data >= lo && ssf + node.data <= hi) {
				System.out.print(psf + " " + node.data);
				System.out.println();
			}

		}
		if (node.left != null)
			printRootToLeafPathsInRange(node.left, psf + " " + node.data, ssf + node.data, lo, hi);

		if (node.right != null)
			printRootToLeafPathsInRange(node.right, psf + " " + node.data, ssf + node.data, lo, hi);

	}

	public void removeLeaves() {
		// removeLeaves(root);
		root = removeLeaves2(root);
	}

	private void removeLeaves(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null && node.left.left == null && node.left.right == null) {
			node.left = null;
		}
		if (node.right != null && node.right.left == null && node.right.right == null) {
			node.right = null;
		}
		removeLeaves(node.left);
		removeLeaves(node.right);
	}

	// OR
	private Node removeLeaves2(Node node) {
		if (node == null) {
			return null;
		}
		if (node.left == null && node.right == null) {
			return null;
		}

		node.left = removeLeaves2(node.left);
		node.right = removeLeaves2(node.right);
		return node;
	}

	public void printSingleChild() {
		printSingleChild(root);
	}

	private void printSingleChild(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null && node.right == null) {
			System.out.print(node.left.data + " ");
		}
		if (node.right != null && node.left == null) {
			System.out.print(node.right.data + " ");
		}

		printSingleChild(node.left);
		printSingleChild(node.right);
	}

	//Print All the nodes that are 'k' steps far from the given node
	public void printStepsFar(int data, int steps) {
		ArrayList<Node> paths = nodetorootpath2(root, data);
		for (int i = 0; i < paths.size(); i++) {
			printStepsDown(i == 0 ? null : paths.get(i - 1), paths.get(i), steps - i);
		}
	}

	private ArrayList<Node> nodetorootpath2(Node node, int data) {
		if (node == null) {
			return new ArrayList<>();
		}
		if (node.data == data) {
			ArrayList<Node> paths = new ArrayList<>();
			paths.add(node);
			return paths;
		}
		ArrayList<Node> lpath = nodetorootpath2(node.left, data);
		if (lpath.size() > 0) {
			lpath.add(node);
			return lpath;
		}
		ArrayList<Node> rpath = nodetorootpath2(node.right, data);
		if (rpath.size() > 0) {
			rpath.add(node);
			return rpath;
		}

		return new ArrayList<>();
	}

	private void printStepsDown(Node obstacle, Node node, int steps) {
		if (node == null || node == obstacle) {
			return;
		}
		if (steps == 0) {
			System.out.println(node.data);
			return;
		}

		if (node.left != null) {
			printStepsDown(obstacle, node.left, steps - 1);
		}
		if (node.right != null) {
			printStepsDown(obstacle, node.right, steps - 1);
		}

	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		while (queue.size() != 0) {
			Node rem = queue.removeFirst();
			
			System.out.print(rem.data + " ");

			if (rem.left != null) {
				queue.addLast(rem.left);
			}
			if (rem.right != null) {
				queue.addLast(rem.right);
			}
		}
		System.out.println();
	}
}