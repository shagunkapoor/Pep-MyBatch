package AugNewBatch.Oct1_Subseq;


public class LinkedList {

	public class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public void addLast(int val) {

		if (size == 0) {
			handleAddwhensize0(val);
			return;
		}

		Node n = new Node();
		n.data = val;
		n.next = null;

		Node node = head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = n;
		size++;
	}

	public void handleAddwhensize0(int val) {
		Node n=new Node();
		n.data=val;
		head=n;
		tail=n;
		size++;
	}
	
	public void display(){
		if(size==0){
			System.out.println("List Empty");
			return;
		}
		
		display(head);
	}
	
	private void display(Node node){
		if(node==null){
			return;
		}
		
		System.out.println(node.data+"->");
		display(node.next);
	}
	
	public int getFirst(){
		return head.data;
	}
	
	public int getLast(){
		return tail.data;
	}
	
	public int getAt(int indx){
		
		Node node=head;
		
		for(int i=0;i<indx;i++){
			node=node.next;
		}
		
		return node.data;
	}
	
	public Node getNodeAt(int indx){
		
		Node node=head;
		for(int i=0;i<indx;i++){
			node=node.next;
		}
		
		return node;
	}
	
	public void addFirst(int val){
		if(size==0){
			handleAddwhensize0(val);
			return;
		}
		
		Node node=new Node();
		node.data=val;
		node.next=head;
		head=node;
	}
	
	public void addAt(int indx, int val){
		if(indx==0){
			addFirst(val);
			return;
		}else if(indx==size){
			addLast(val);
		}
		
		Node node=new Node();
		node.data=val;
		
		Node nm1=getNodeAt(indx-1);
		Node np1=nm1.next;
		nm1.next=node;
		node.next=np1;
		size++;
		
	}
	
	public void removeFirst(){
		Node temp=head;
		head=head.next;
		temp.next=null;
	}
	
	public void removeLast(){
		Node temp=tail;
		
	}
	
	//Node 

public void reversePointerIterative(){ //Incomplete
	if(size==0){
		System.out.println("List Empty");
		return;
	}
	Node prev=head;
	Node curr=prev.next;
	Node ocn=curr.next;
	//while()
	
}

	public void reverseDataIterative() throws Exception { // On2

		if (size == 0) {
			System.out.println("List Empty");
			return;
		}

		int left = 0;
		int right = size - 1;

		while (left < right) {
			Node l = getNodeAt(left);
			Node r = getNodeAt(right);
			int temp = l.data;
			l.data = r.data;
			r.data = temp;

			left++;
			right--;
		}
	}

	public void displayReverse() { // On
		if (size == 0) {
			System.out.println("List Empty");
			return;
		}

		displayReverse(head);
	}

	private void displayReverse(Node node) {
		if (node == null) {
			return;
		}

		displayReverse(node.next);
		System.out.print("<-" + node.data);
	}

	public void reversePointerRecursive() {
		if (size == 0) {
			System.out.println("List Empty");
			return;
		}
		Node last = reversePointerRecursive(head);
		head = tail;
		tail = last;
		tail.next = null;

	}

	private Node reversePointerRecursive(Node node) {
		if (node.next == null) {
			return node;
		}

		Node n = reversePointerRecursive(node.next);
		n.next = node;

		return node;
	}

	public void reverseDataRecursive() {

		if (size == 0) {
			System.out.println("List Empty");
			return;
		}

		reverseDataRecursive(head,0);
	}

	Node rdrleft;

	private void reverseDataRecursive(Node right, int floor) {
		rdrleft=head;
		if (right == null) {
			return;
		}

		reverseDataRecursive(right.next, floor+1);
		if (floor>=size/2) {
			int temp = right.data;
			right.data = rdrleft.data;
			rdrleft.data = temp; 

			rdrleft = rdrleft.next;
		}
	}
	
	
	public void isPalindrome(){
		if(size==0){
			System.out.println("List Empty");
			return;
		}
		
		isPalindrome(head,0);
	}
	Node palleft;
	private boolean isPalindrome(Node right, int floor){
		palleft=head;
		if(right!=null){
			return true;
		}
		
		boolean res=isPalindrome(right.next, floor+1);
		if(res==false){
			return false;
		}else {
		if(floor>=size/2){
			if(palleft.data!=right.data){
				return false;
			}
		}
		}
		return true;
	}
	Node foldleft;
	public void foldList(){
		foldList(head,0);
		tail = foldleft.next;
		tail.next = null;
	
	}
	
	private void foldList(Node right, int floor){
		
		if (right == null) {
			return;
		}
		foldList(right.next, floor + 1);
		if (floor >= size / 2) {
			Node node = foldleft.next;
			foldleft.next = right;
			right.next = node;
			foldleft = node;
		}

	}

}
