
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class GenricTree {

	public class Node {

		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}
	}

	Node root;

	// HardCoded Tree
	// public GenricTree() {
	//
	// root = new Node(10);
	// Node l1c1 = new Node(20);
	// Node l1c2 = new Node(30);
	// Node l1c3 = new Node(40);
	//
	// root.children.add(l1c1);
	// root.children.add(l1c2);
	// root.children.add(l1c3);
	//
	// Node l2c1 = new Node(50);
	// Node l2c2 = new Node(60);
	// l1c1.children.add(l2c1);
	// l1c1.children.add(l2c2);
	//
	// Node l2c3 = new Node(70);
	// Node l2c4 = new Node(80);
	// Node l2c5 = new Node(90);
	// l1c2.children.add(l2c3);
	// l1c2.children.add(l2c4);
	// l1c2.children.add(l2c5);
	//
	// Node l2c6 = new Node(100);
	// l1c3.children.add(l2c6);
	//
	// Node l3c1 = new Node(110);
	// Node l3c2 = new Node(120);
	// l2c4.children.add(l3c1);
	// l2c4.children.add(l3c2);
	// }

	// Generalized Tree
	public GenricTree(int[] arr) {
		LinkedList<Node> stack = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			Node n = new Node(arr[i]);
			if (arr[i] != -1) {
				stack.addFirst(n);
			} else {
				if (stack.size() == 1) {
					root = stack.getFirst();
				} else {
					Node removed = stack.removeFirst();
					stack.getFirst().children.add(removed);
				}
			}
		}
	}

	public void display() {
		displayHelper(root);
	}

	private void displayHelper(Node node) {
		String str = node.data + " -> ";
		for (Node child : node.children) {
			str += child.data + ",";
		}
		System.out.print(str);
		System.out.println(".");
		for (Node child : node.children) {
			displayHelper(child);
		}
	}

	public int size() {
		return sizeHelper(root);
	}

	private int sizeHelper(Node node) {
		int ps = 0;

		for (Node child : node.children) {
			int cs = sizeHelper(child);
			ps += cs;

		}
		ps += 1;
		return ps;
	}

	public int max() {
		return maxHelper(root);
	}

	private int maxHelper(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int m = maxHelper(child);
			if (m > max) {
				max = m;
			}
		}
		return max;
	}

	// July 13
	public int height() {
		return height(root);
	}

	private int height(Node node) {

		int level = 0;
		for (Node child : node.children) {
			int l = height(child);
			if (l > level) {
				level = l;
			}
		}
		level += 1;
		return level;
	}

	public boolean find(int data) {
		return (find(root, data));
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		for (Node child : node.children) {
			boolean res = find(child, data);
			if (res == true) {
				return true;
			}

		}
		return false;

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}
		// for (int i = 0; i < node.children.size() / 2; i++) {
		// Node temp1 = node.children.get(i);
		// Node temp2 = node.children.get(node.children.size() - 1-i);
		// node.children.set(i, temp2);
		// node.children.set(node.children.size()-1, temp1);
		//
		// }

		// OR

		// int left=0;
		// int right=node.children.size()-1;
		// while(left<=right){
		// Node leftn=node.children.get(left);
		// Node rightn=node.children.get(right);
		// node.children.set(left, rightn);
		// node.children.set(right, leftn);
		// left++;
		// right--;
		// }
		//
		// OR
		Collections.reverse(node.children);

	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(i);
			} else {
				removeLeaves(child);
			}
		}
	}

	public void linearize() {
		linearize(root);
	}

	private Node linearize(Node node) {
		if (node.children.size() == 0) {
			return node;
		}
		Node last = node.children.get(node.children.size() - 1);
		Node lastkitail = linearize(last);

		for (int i = node.children.size() - 1; i > 0; i--) {
			Node im1th = node.children.get(i - 1);
			Node ith = node.children.remove(i);
			Node im1thkitail = linearize(im1th);
			im1thkitail.children.add(ith);

		}
		return lastkitail;
	}

	// BFS
	public void levelorder() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		while (queue.size() > 0) {
			// remove
			Node rem = queue.removeFirst();

			// print
			System.out.print(rem.data + " ");

			// add child
			for (Node child : rem.children) {
				queue.addLast(child);
			}
		}

		System.out.println();
	}

	public void levelorderLineWise() {
		LinkedList<Node> clqueue = new LinkedList<>();
		LinkedList<Node> nlqueue = new LinkedList<>();
		clqueue.addLast(root);

		while (clqueue.size() > 0) {
			// remove
			Node rem = clqueue.removeFirst();

			// print
			System.out.print(rem.data + " ");

			// add child
			for (Node child : rem.children) {
				nlqueue.addLast(child);
			}
			
			if (clqueue.size() == 0) {
				System.out.println();
				clqueue = nlqueue;
				nlqueue = new LinkedList<>();
			}
		}

	}

	public void levelorderLeftWise() { // Zig Zag
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		boolean l2r = true;
		queue.addLast(root);

		while (queue.size() > 0) {

			Node rem = queue.removeFirst();
			System.out.print(rem.data + " ");
			if (l2r) {
				for (int i = 0; i < rem.children.size(); i++) {
					Node child = rem.children.get(i);
					stack.addFirst(child);

				}
			} else {
				for (int i = rem.children.size() - 1; i >= 0; i--) {

					Node child = rem.children.get(i);
					stack.addFirst(child);
				}
			}
			if (queue.size() == 0) {
				System.out.println();
				queue = stack;
				stack = new LinkedList<>();
				l2r = !l2r;
			}

		}
	}

	//DFS
	public void preOrder() {
		preOrder(root);

	}

	private void preOrder(Node node) {
		System.out.println(node.data);
		for (Node child : node.children)
			preOrder(child);
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		for (Node child : node.children)
			postOrder(child);
		System.out.println(node.data);
	}

	public class HeapMover {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int size = 0;
		int height = -1;
		boolean find = false;
		int pred = 0;
		Integer succ = null;
		int justLarger = Integer.MAX_VALUE;
		int justSmaller = Integer.MIN_VALUE;
	}

	public void multisolver(int data) {
		HeapMover mover = new HeapMover();
		multisolver(root, mover, 0, data, 61);
		System.out.println("MAX=" + mover.max);
		System.out.println("MIN=" + mover.min);
		System.out.println("SIZE=" + mover.size);
		System.out.println("HEIGHT=" + mover.height);
		System.out.println("FIND=" + mover.find);
		System.out.println("Pred=" + mover.pred);
		System.out.println("Succ=" + mover.succ);
		System.out.println("Just Larger=" + mover.justLarger);
		System.out.println("Just Smaller=" + mover.justSmaller);

	}

	private void multisolver(Node node, HeapMover results, int depth, int data, int jl) {

		results.size++;
		results.max = Math.max(results.max, node.data);
		results.min = Math.min(results.min, node.data);
		results.height = Math.max(results.height, depth);

		if (node.data > jl) {
			results.justLarger = Math.min(results.justLarger, node.data);
		}
		if (node.data < jl) {
			results.justSmaller = Math.max(results.justSmaller, node.data);
		}
		if (results.find == true && results.succ == null) { //the next elt of the data found
			results.succ = node.data;
		}
		results.find = results.find || node.data == data;
		
		if (results.find == false) {
			results.pred = node.data;
		}

		for (Node child : node.children) {
			multisolver(child, results, depth + 1, data, jl);

		}

	}

	public void justLarger(int val) {
		System.out.println(justLarger(root, val));
	}

	private int justLarger(Node node, int val) {
		int res = Integer.MAX_VALUE;

		if (node.data > val && node.data < res) {
			res = node.data;
		}

		for (Node child : node.children) {
			int v = justLarger(child, val);
			res = Math.min(res, v);

		}
		return res;
	}

	public int kthLargest(int data, int k) {

		if (k == 0) {
			return data;
		}
		int res = kthLargest(justLarger(root, data), k - 1);

		return res;

	}
	// public int kthLargest(int k) {
	// HeapMover mover = new HeapMover();
	// int data = Integer.MAX_VALUE;
	// for (int i = 0; i < k; i++) {
	// multisolver(root, results, 0, data);
	// }
	// }

	public ArrayList<Integer> serialize() {
		return serialize(root);
	}

	// private ArrayList<Integer> serialize(Node node) {
	//// if (node.children.size() == 0) {
	//// ArrayList<Integer> list = new ArrayList<>();
	//// list.add(node.data);
	//// list.add(-1);
	//// }

	// ArrayList<Integer> reslist = new ArrayList<>();
	// reslist.add(node.data);
	// for (int i = 0; i < node.children.size(); i++) {
	// Node child = node.children.get(i);
	// if (child.children.size() == 0) {
	// reslist.add(child.data);
	// reslist.add(-1);
	// } else {
	// ArrayList<Integer> partialres = serialize(child);
	// for (int x = 0; x < partialres.size(); x++) {
	// reslist.add(partialres.get(x));
	// }
	// }
	// }
	// reslist.add(-1); // part 2
	// return reslist;
	// }

	// OR

	private ArrayList<Integer> serialize(Node node) {
		if (node.children.size() == 0) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			list.add(-1);
		}

		ArrayList<Integer> reslist = new ArrayList<>();
		reslist.add(node.data);
		for (int i = 0; i < node.children.size(); i++) {
			Node child = node.children.get(i);
			ArrayList<Integer> partialres = serialize(child);
			reslist.addAll(partialres);
		}
		reslist.add(-1);
		return reslist;
	}

	public boolean isIsomorphic(GenricTree other) {
		return isIsomorphic(this.root, other.root);
	}

	private boolean isIsomorphic(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size()) {
			return false;
		}
		for (int i = 0; i < node1.children.size(); i++) {
			Node child1 = node1.children.get(i);
			Node child2 = node2.children.get(i);
			boolean res = isIsomorphic(child1, child2);
			if (res == false) {
				return false;
			}
		}
		return true;
	}

	public boolean isMirrorImage(GenricTree other) {
		return isMirrorImage(this.root, other.root);
	}

	private boolean isMirrorImage(Node node1, Node node2) {

		if (node1.children.size() != node2.children.size()) {
			return false;
		}
		// For checking data values
		// if(node1.data!=node2.data){
		// return false;
		// }
		for (int i = 0, j = node2.children.size() - 1; i < node1.children.size() && j >= 0; i++, j--) {
			Node child1 = node1.children.get(i);
			Node child2 = node2.children.get(j);
			boolean res = isMirrorImage(child1, child2);
			if (res == false) {
				return false;
			}
		}
		return true;
	}

	public boolean isFoldable() {
		return isMirrorImage(this.root, this.root);
	}

}
