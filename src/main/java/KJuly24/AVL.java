package KJuly24;

public class AVL {

	private class Node {
		int data;
		Node left;
		Node right;
		int height;
		int balancedfactor;

	}

	Node root;

	public AVL(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node node = new Node();
		node.data = sa[mid];
		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);
		node.height = getHeight(node);
		node.balancedfactor = getBF(node);

		return node;
	}

	private int getHeight(Node node) {
		if (node == null) {
			return -1;
		}

		int lht = -1;
		int rht = -1;

		if (node.left != null) {
			lht = getHeight(node.left);
		}
		if (node.right != null) {
			rht = getHeight(node.right);
		}

		return Math.max(lht, rht) + 1;
	}

	private int getBF(Node node) {
		if (node == null) {
			return 0;
		}

		int lht = -1;
		int rht = -1;

		if (node.left != null) {
			lht = getHeight(node.left);
		}
		if (node.right != null) {
			rht = getHeight(node.right);
		}

		return lht - rht;
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
		str += "<-" + node.data+"["+node.height+","+node.balancedfactor+"]" + "->";
		str += node.right != null ? node.right.data : -1;
		System.out.println(str);

		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}

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

	public void add(int data) {
		add(root, data);
	}

	private Node add(Node node, int data) {
		if (node == null) {
			Node base = new Node();
			base.data = data;
			base.height = 0;
			base.balancedfactor = 0;
			return base;
		}
		if (node.data > data) {
			node.left = add(node.left, data);
		} else if (node.data < data) {
			node.right = add(node.right, data);
		} else {

		}

		node.height = getHeight(node);
		node.balancedfactor = getBF(node);
		if (getBF(node) > 1) { // ll or lr
			if (getBF(node) > 0) { // ll
				node = rightRotate(node);
			} else { // lr
				node.left = leftRotate(node.left);
				node = rightRotate(node);
			}
		} else if (getBF(node) < -1) { // rr or rl
			if (getBF(node)< 0) { // rr
				node = leftRotate(node);
			} else { // rl
				node.right = rightRotate(node.right);
				node = leftRotate(node);
			}
		}

		return node;

	}

	private Node rightRotate(Node z) {
		Node y = z.left;
		if (y.right != null) {
			z.left = y.right;
		}
		y.right = z;

		UpdateFactor(z);
		UpdateFactor(y);

		return y;
	}

	private Node leftRotate(Node z) {
		Node y = z.right;
		if (y.left != null) {
			z.right = y.left;
		}
		y.left = z;
		UpdateFactor(z);
		UpdateFactor(y);

		return y;
	}

	private void UpdateFactor(Node node) {
		node.height = getHeight(node);
		node.balancedfactor = getBF(node);
	}
	
	public void removeNode(int data){
		root=removeNode(root,data);
	}
	private Node removeNode(Node node, int data){
		if(node==null){
			return null;
		}
		if(node.data>data){
			node.left=removeNode(node.left,data);
		}else if(node.data<data){
			node.right=removeNode(node.right, data);
		}else{
			if(node.left==null && node.right==null){
				return null;
			}else if(node.left==null && node.right!=null){
				return node.right;
			}else if(node.left!=null && node.left==null){
				return node.left;
			}else{
				int max=max(node.left);
				node.data=max;
				node.left=removeNode(node.left, max);
			}
		}
		
		UpdateFactor(node);
		if (getBF(node) > 1) { // ll or lr
			if (getBF(node)> 0) { // ll
				node = rightRotate(node);
			} else { // lr
				node.left = leftRotate(node.left);
				node = rightRotate(node);
			}
		} else if (getBF(node) < -1) { // rr or rl
			if (getBF(node)< 0) { // rr
				node = leftRotate(node);
			} else { // rl
				node.right = rightRotate(node.right);
				node = leftRotate(node);
			}
		}
		return node;
	}
	

}