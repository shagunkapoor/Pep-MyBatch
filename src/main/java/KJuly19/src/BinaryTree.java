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

	public BinaryTree(int[] preo, int[] ino) {

		// root=constructprein(preo, ino, 0, preo.length-1, 0, ino.length-1);
		root = constructpostin(preo, ino, 0, preo.length - 1, 0, ino.length - 1);
	}

	private Node constructprein(int[] preo, int[] ino, int prelo, int prehi, int inlo, int inhi) {
		if (prelo > prehi || inlo > inhi) {
			return null;
		}
		Node node = new Node(preo[prelo]);
		int indx = -1;
		for (int i = 0; i < ino.length; i++) {
			if (ino[i] == node.data) {
				indx = i;
			}
		}

		int lhs = indx - inlo;
		node.left = constructprein(preo, ino, prelo + 1, prelo + lhs, inlo, indx - 1);
		node.right = constructprein(preo, ino, prelo + lhs + 1, prehi, indx + 1, inhi);

		return node;
	}

	private Node constructpostin(int[] posto, int[] ino, int postlo, int posthi, int inlo, int inhi) {
		if (postlo > posthi || inlo > inhi) {
			return null;
		}

		Node node = new Node(posto[posthi]);
		int indx = -1;
		for (int i = 0; i < ino.length; i++) {
			if (ino[i] == node.data) {
				indx = i;
			}
		}
		int rhs = inhi - indx;
		node.right = constructpostin(posto, ino, posthi - rhs, posthi - 1, indx + 1, inhi);
		node.left = constructpostin(posto, ino, postlo, posthi - rhs - 1, inlo, indx - 1);
		return node;
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

	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int res = Math.min(min(node.left), min(node.right));
		return Math.min(node.data, res);
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
		if (node.left != null && node.right == null) {
			System.out.print(node.right.data + " ");
		}

		printSingleChild(node.left);
		printSingleChild(node.right);
	}

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

	//BFS
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

	//DFS
	public void preorder() {
		preorder(root);
		System.out.println(".");
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder() {
		postorder(root);
		System.out.println(".");
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}

	public void inorder() {
		inorder(root);
		System.out.println(".");
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int ld = diameter(node.left);
		int rd = diameter(node.right);

		int leftheight = height(node.left);
		int rightheight = height(node.right);

		int childheight = Math.max(ld, rd);
		return Math.max(leftheight + rightheight + 2, childheight); // for edges

		// leftheight+rightheight+1 for node
	}

	public class DiaPair {
		int diameter;
		int height;
	}

	public int diameter2() {
		DiaPair dp = diameter2(root);
		return dp.diameter;
	}

	private DiaPair diameter2(Node node) {
		DiaPair resdp = new DiaPair();
		if (node == null) {
			DiaPair base = new DiaPair();
			base.diameter = 0;
			base.height = -1;
			return base;
		}

		DiaPair lp = diameter2(node.left);
		DiaPair rp = diameter2(node.right);
		resdp.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));
		resdp.height = Math.max(lp.height, rp.height) + 1;

		return resdp;

	}

	public class BalancedTree {
		int height;
		boolean isbalanced;
	}

	public boolean iBalanced() {
		BalancedTree bal = isBalanced(root);
		return bal.isbalanced;
	}

	private BalancedTree isBalanced(Node node) {
		BalancedTree res = new BalancedTree();
		if (node == null) {
			BalancedTree base = new BalancedTree();
			base.height = -1;
			base.isbalanced = true;
			return base;
		}

		BalancedTree lb = isBalanced(node.left);
		if (lb.isbalanced == false) {
			return lb;
		}
		BalancedTree rb = isBalanced(node.right);
		if (lb.isbalanced == false) {
			return rb;
		}
		res.height = Math.max(lb.height, rb.height) + 1;
		int delta = Math.abs(lb.height - rb.height);
		res.isbalanced = delta > 1 ? false : true;

		return res;
	}

	// public boolean BST() {
	// return BST(root);
	// }
	//
	// private boolean BST(Node node) {
	// if (node == null) {
	// return true;
	// }
	// if (node.left != null && max(node.left) > node.data) {
	// return false;
	// }
	// if (node.right != null && node.data > min(node.right)) {
	// return false;
	// }
	// boolean lbst = BST(node.left);
	// if (lbst == false) {
	// return lbst;
	// }
	// boolean rbst = BST(node.right);
	// if (rbst == false) {
	// return rbst;
	// }
	//
	// return true;
	//
	// }

	
	//To check whether the BT is a BST or not
	public class classBST {
		boolean isBST;
		int max;
		int min;
	}

	public boolean BST() {
		classBST b = new classBST();
		b = BST(root);
		return b.isBST;
	}

	private classBST BST(Node node) {
		if (node == null) {
			classBST base = new classBST();
			base.isBST = true;
			base.max = Integer.MIN_VALUE;
			base.min = Integer.MAX_VALUE;
			return base;
		}

		classBST lbst = BST(node.left);
		if (lbst.isBST == false) {
			return lbst;
		}

		classBST rbst = BST(node.right);
		if (rbst.isBST == false) {
			return rbst;
		}
		classBST res = new classBST();
		res.max = Math.max(node.data, Math.max(lbst.max, rbst.max));
		res.min = Math.min(node.data, Math.min(lbst.min, rbst.min));
		if (node.data > lbst.max && node.data < rbst.min) {
			res.isBST = true;
		}
		return res;

	}

	public class TraversalPair {
		Node node;
		boolean myprocess;
		boolean leftprocessed;
		boolean rightprocessed;
	}

	public void preorderIterative() {
		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair tp = new TraversalPair();
		tp.node = root;
		stack.addFirst(tp);

		while (stack.size() > 0) {

			TraversalPair tos = stack.getFirst();
			if (!tos.myprocess) {
				tos.myprocess = true;
				System.out.print(tos.node.data + " ");
			} else if (!tos.leftprocessed) {
				tos.leftprocessed = true;
				if (tos.node.left != null) {
					TraversalPair tl = new TraversalPair();
					tl.node = tos.node.left;
					stack.addFirst(tl);
				}
			} else if (!tos.rightprocessed) {
				tos.rightprocessed = true;
				if (tos.node.right != null) {
					TraversalPair tr = new TraversalPair();
					tr.node = tos.node.right;
					stack.addFirst(tr);
				}
			} else {
				stack.removeFirst();
			}

		}

	}

	public void inorderIterative() {
		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair tp = new TraversalPair();
		tp.node = root;
		stack.addFirst(tp);

		while (stack.size() > 0) {

			TraversalPair tos = stack.getFirst();
			if (!tos.leftprocessed) {
				tos.leftprocessed = true;
				if (tos.node.left != null) {
					TraversalPair tl = new TraversalPair();
					tl.node = tos.node.left;
					stack.addFirst(tl);
				}
			} else if (!tos.myprocess) {
				tos.myprocess = true;
				System.out.print(tos.node.data + " ");
			} else if (!tos.rightprocessed) {
				tos.rightprocessed = true;
				if (tos.node.right != null) {
					TraversalPair tr = new TraversalPair();
					tr.node = tos.node.right;
					stack.addFirst(tr);
				}
			} else {
				stack.removeFirst();
			}
		}
	}

	public void postorderIterative() {
		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair tp = new TraversalPair();
		tp.node = root;
		stack.addFirst(tp);

		while (stack.size() > 0) {

			TraversalPair tos = stack.getFirst();

			if (!tos.leftprocessed) {
				tos.leftprocessed = true;
				if (tos.node.left != null) {
					TraversalPair tl = new TraversalPair();
					tl.node = tos.node.left;
					stack.addFirst(tl);
				}
			} else if (!tos.rightprocessed) {
				tos.rightprocessed = true;
				if (tos.node.right != null) {
					TraversalPair tr = new TraversalPair();
					tr.node = tos.node.right;
					stack.addFirst(tr);
				}
			} else if (!tos.myprocess) {
				tos.myprocess = true;
				System.out.print(tos.node.data + " ");
			} else {
				stack.removeFirst();
			}

		}

	}

	public void LCA(int d1, int d2) {
		LCA(root, d1, d2);
	}

	private int LCA(Node node, int d1, int d2) {  //O(n)

		ArrayList<Integer> d1toroot = nodetorootpath(d1);
		ArrayList<Integer> d2toroot = nodetorootpath(d2);
		int lca = 0;
		for (int i = d1toroot.size() - 1; i >= 0; i--) {
			if (d1toroot.get(i) == d2toroot.get(i)) {
				lca = d1toroot.get(i);
			} else {
				break;
			}
		}
		return lca;

	}

	public void LCA2(int d1, int d2) {
		Node reslca = LCA2(root, d1, d2);
		if(reslca==null){
			System.out.println("Not found");
		}else{
			System.out.println(reslca.data);
		}
	}

	static Node lca = null;

	private Node LCA2(Node node, int d1, int d2) {
		if (node == null) {
			return null;
		}
		Node selflca = null;
		if (node.data == d1 || node.data == d2) {
			selflca = node;
		}
		Node leftlca = null;
		Node rightlca = null;

		if (lca == null) {
			leftlca = LCA2(node.left, d1, d2);
		}
		if (lca == null) {
			rightlca = LCA2(node.right, d1, d2);
		}

		if (selflca != null) {
			if (rightlca != null) {
				lca = node;
				return node;
			} else if (leftlca != null) {
				lca = node;
				return node;
			} else {
				return node;
			}
		} else if (rightlca != null) {
			if (leftlca != null) {
				lca = node;
				return node;
			} else {
				return rightlca;
			}
		} else if (leftlca != null) {
			return leftlca;
		} else {
			return null;
		}

	}
}
