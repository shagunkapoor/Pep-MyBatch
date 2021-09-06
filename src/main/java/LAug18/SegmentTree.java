package LAug18;

public class SegmentTree {

	private class Node {
		int data;
		int segsi;
		int segei;
		Node left;
		Node right;
	}

	Node root;

	public SegmentTree(int[] arr) {
		construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		if (lo == hi) {
			Node node = new Node();
			node.data = arr[lo];
			node.segsi = lo;
			node.segei = hi;
			return node;
		}
		Node res = new Node();
		int mid = (lo + hi) / 2;
		res.left = construct(arr, lo, mid);
		res.right = construct(arr, mid + 1, hi);

		res.data = res.left.data + res.right.data;

		return res;

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null && node.right != null) {
			System.out.println(node.left + " <-" + node.data + "[" + node.segsi + "," + node.segei + "]->" + node.right);
		}
		display(node.left);
		display(node.right);
	}
	
	public void query(){
		
	}
}
