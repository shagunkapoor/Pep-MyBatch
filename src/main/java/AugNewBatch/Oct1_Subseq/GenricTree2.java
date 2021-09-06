package AugNewBatch.Oct1_Subseq;

import java.util.ArrayList;
import java.util.LinkedList;



public class GenricTree2 {
	public class Node {

		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}
	}
	
	Node root;
	public GenricTree2(int[] arr) {
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
	
	public void removeLeaves(){
		removeLeaves(root);
	}
	private void removeLeaves(Node node){
		
	}
	
	public void Linearize(){
		linearize(root);
	}
	private void linearize(Node node){
		
	}
	private Node getTail(Node node){
		return null;
	}

	
	
	public void Linearize2(){ //On
		linearize2(root);
	}
	
	private Node linearize2(Node node){
		
		if(node.children.size()==0){
			return node;
		}
		
		Node last=node.children.get(node.children.size()-1);
		Node lt=linearize2(last);
		
		for(int i=node.children.size()-2;i>=0;i--){
			last=node.children.remove(i+1);
			Node im1th=node.children.get(i);
			Node im1thkitail=linearize2(im1th);
			im1thkitail.children.add(last);
		}
		
		return lt;
	}
	
	public static boolean haveSimilarStructure(GenricTree2 gt1, GenricTree2 gt2){
		
		boolean res=haveSimilarStructure(gt1.root, gt2.root);
		return res;
	}
	
	private static boolean haveSimilarStructure(Node node1, Node node2){
		if(node1.children.size()!=node2.children.size()){
			return false;
		}
		
		for(int i=node1.children.size()-1;i>=0;i--){
			Node child1=node1.children.get(i);
			Node child2=node2.children.get(i);
			
			boolean result=haveSimilarStructure(child1, child2);
			if(result==false){
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean haveMirrorStructure(GenricTree2 gt1, GenricTree2 gt2){
		
		return haveMirrorStructure(gt1.root, gt2.root);
	}
	
	private static boolean haveMirrorStructure(Node node1, Node node2){
		
		if(node1.children.size()!=node2.children.size()){
			return false;
		}
		
		for(int i=0, j=node2.children.size()-1;i<node1.children.size() && j>=0;i++ , j--){
			Node child1=node1.children.get(i);
			Node child2=node2.children.get(j);
			
			boolean res=haveMirrorStructure(child1, child2);
			if(res==false){
				return false;
			}
		}
		return true;
	}

	
	
}
