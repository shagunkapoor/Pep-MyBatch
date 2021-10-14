package KJuly23;

import java.util.LinkedList;

public class BinarySearchTree {

	private class Node {
		int data;
		Node left;
		Node right;

		private Node(int data) {
			this.data = data;
		}
	}

	Node root;

	public BinarySearchTree(int[] arr) {

		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] sortedArr, int lo, int hi) {

		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node node = new Node(sortedArr[mid]);
		node.left = construct(sortedArr, lo, mid - 1);
		node.right = construct(sortedArr, mid + 1, hi);
		return node;

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";

		str += node.left != null ? node.left.data : -1;
		str += "<-" + node.data + "->";
		str += node.right != null ? node.right.data : -1;
		System.out.println(str);

		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}

	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		boolean res;
		if (node.data == data) {
			return true;
		} else if (data < node.data) {
			res = find(node.left, data);
			if (res == true) {
				return true;
			}
		} else if (data > node.data) {
			res = find(node.right, data);
			if (res == true) {
				return true;
			}
		}
		return false;
	}

	public int max() {
		return max(root);

	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		}

		int res = max(node.right);
		return res;

	}

	public void printInRange(int lo, int hi) {
		printInRange(root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}

		if (node.data < hi && node.data > lo) {
			System.out.println(node.data);
			printInRange(node.left, lo, hi);
			printInRange(node.right, lo, hi);
		} else if (node.data > lo) {
			printInRange(node.left, lo, hi);
		} else if (node.data < hi) {
			printInRange(node.right, lo, hi);
		}
	}

	public void replaceNodesWithSum() {
		replaceNodesWithSum(root);
	}

	static int sum = 0;

	private void replaceNodesWithSum(Node node) {
		if (node == null) {
			return;
		}
		replaceNodesWithSum(node.right);
		int var = node.data;
		node.data = sum;
		sum += var;
		replaceNodesWithSum(node.left);
	}

	public void addNode(int data) {
		addNode(root, data);
	}

	private void addNode(Node node, int data) {
		Node newnode = new Node(data);

		if (node.left == null && node.data > data) {
			node.left = newnode;
		}
		if (node.right == null && node.data < data) {
			node.right = newnode;
		}
		if (data < node.data) {
			addNode(node.left, data);
		}
		if (data > node.data) {
			addNode(node.right, data);
		}
	}

	public void add2(int data) {
		root = add2(root, data);
	}

	private Node add2(Node node, int data) {
		if (node == null) {
			Node newnode = new Node(data);
			return newnode;
		}
		if (node.data > data) {
			node.left = add2(node.left, data);
		} else if (node.data < data) {
			node.right = add2(node.right, data);
		}
		return node;
	}

	public void removeLeaves(int data) {
		removeLeaves(root, data);
	}

	private Node removeLeaves(Node node, int data) {
		if (node == null) {
			return null;
		}
		if (data < node.data) {
			node.left = removeLeaves(node.left, data);
		} else if (data > node.data) {
			node.right = removeLeaves(node.right, data);
		} else {
			return null;
		}
		return node;
	}

	public void removeANode(int data) {
		removeANode(root, data);
	}

	private Node removeANode(Node node, int data) {
		if (node == null) {
			return null;
		}

		if (node.data > data) {
			node.left = removeANode(node.left, data);
		} else if (node.data < data) {
			node.right = removeANode(node.right, data);
		} else { // node.data=data
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left != null && node.right == null) {
				return node.left;
			} else if (node.right != null && node.left == null) {
				return node.right;
			} else {
				int max = max(node.left);
				node.data = max;
				node.left = removeANode(node.left, max);
			}
		}
		return node;

	}

	public int LCA(int d1, int d2) {
		return LCA(root, d1, d2);
	}

	private int LCA(Node node, int d1, int d2) {
		if (d1 < node.data && d2 < node.data) {
			return LCA(node.left, d1, d2);
		} else if (d1 > node.data && d2 > node.data) {
			return LCA(node.right, d1, d2);
		} else {
			return node.data;
		}
	}

}
