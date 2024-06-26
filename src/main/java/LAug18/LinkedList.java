package LAug18;

public class LinkedList<T> {

	public class Node {
		T data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public void addLast(T val) {
		if (size == 0) {
			handleAddwhensize0(val);
			return;
		}

		Node node = new Node();
		node.data = val;
		tail.next = node;
		tail = node;
		size++;

	}

	public void handleAddwhensize0(T val) {
		Node node = new Node();
		node.data = val;
		tail = head = node;
		size++;
	}

	public void display() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " -> ");
		}
		System.out.println();
	}

	public T getFirst() {
		if (size == 0) {
			System.out.println("List empty");
			return null;
		}
		return head.data;
	}

	public T getLast() {
		if (size == 0) {
			System.out.println("List Empty");
			return null;
		}
		return tail.data;
	}

	public T getAt(int indx) {

		if (size == 0) {
			System.out.println("List empty");
			return null;
		} else if (indx < 0 || indx >= size) {
			System.out.println("Index out of bounds");
		}
		Node node = head;
		for (int i = 0; i < indx; i++) {
			node = node.next;
		}
		return node.data;
	}

	public Node getNodeAt(int indx) {
		if (indx < 0 || indx >= size) {
			System.out.println("Invalid index");
			return new Node();
		}
		Node node = head;
		for (int i = 0; i < indx; i++) {
			node = node.next;
		}
		return node;

	}

	public void addFirst(T val) {
		if (size == 0) {
			handleAddwhensize0(val);
			return;
		}
		Node node = new Node();
		node.data = val;
		node.next = head;
		head = node;
		size++;
	}

	public void addAt(int indx, T val) {
		if (indx < 0 || indx > size) {
			System.out.println("Invalid index");
			return;
		}
		if (indx == 0) {
			addFirst(val);
			return;
		}
		if (indx == size) {
			addLast(val);
			return;
		}
		Node node = new Node();
		node.data = val;

		Node nm1 = getNodeAt(indx - 1);
		Node np1 = nm1.next;
		nm1.next = node;
		node.next = np1;
		size++;

	}

	public T removeFirst() {
		if (size == 0) {
			System.out.println("List Empty");
			return null;
		}
		T data = head.data;
		head = head.next;
		size--;
		return data;
	}

	public T removeLast() {
		if (size == 0) {
			System.out.println("List Empty");
			return null;
		}
		T data = tail.data;
		Node nm1 = getNodeAt(size - 2);
		nm1.next = null;
		tail = nm1;
		size--;
		return data;
	}

	public T removeAt(int indx) {
		if (size == 0) {
			System.out.println("List Empty");
			return null;
		}
		if (indx == 0) {
			return removeFirst();
		}
		if (indx == size - 1) {
			return removeLast();

		}
		if (indx < 0 || indx >= size) {
			System.out.println("Invalid index");
			return null;
		}

		Node nm1 = getNodeAt(indx - 1);
		Node n = nm1.next;
		Node np1 = n.next;
		nm1.next = np1;
		size--;
		return n.data;
	}

	// July 10

	public void reverseDataIterative() {
		if (size == 0) {
			System.out.println("List Empty");
			return;
		}
		//
		// int li=0;
		// int ri=size-1;
		// while(li<ri){
		// Node left=getNodeAt(li);
		// Node right=getNodeAt(ri);
		// int temp=left.data;
		// left.data=right.data;
		// right.data=temp;
		// li++;
		// ri-;
		// }
		Node node1 = head;
		Node node2 = tail;
		int sizevar = size - 1;
		T t;
		for (int indx = 0; indx < size / 2; indx++) {
			t = node1.data;
			node1.data = node2.data;
			node2.data = t;
			node1 = node1.next;
			sizevar -= 1;
			node2 = getNodeAt(sizevar);

		}
	}

	public void reversePointerIterative() {
		if (size == 0) {
			System.out.println("List Empty");
			return;
		}
		Node prev = head;
		Node curr = prev.next;
		while (curr != null) {
			Node ocn = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ocn;
		}
		tail = head;
		tail.next = null;
		head = prev;

	}

	public void displayReverse() {
		if (size == 0) {
			System.out.println("List Empty");
			return;
		}
		Node node = head;
		reversedisplayhelper(node);
	}

	private void reversedisplayhelper(Node node) {
		if (node == null) {
			return;
		}

		reversedisplayhelper(node.next);
		System.out.print(" <- " + node.data);
	}

	public void reversePointerRecursive() {
		Node res = reversePointerRecursiveHelper(head);
		head = tail;
		tail = res;
		tail.next = null;
	}

	private Node reversePointerRecursiveHelper(Node node) {
		if (node.next == null) {
			return node;
		}
		Node p = reversePointerRecursiveHelper(node.next);
		p.next = node;

		return node;
	}

	public class HeapMover {
		Node node;
	}

	public void reverseDataRecursive() {
		HeapMover left = new HeapMover();
		left.node = head;
		reverseDataRecursiveHelper(left, head, 0);
	}

	private void reverseDataRecursiveHelper(HeapMover left, Node right, int floor) {

		if (right == null) {
			return;
		}
		reverseDataRecursiveHelper(left, right.next, floor + 1);
		if (floor <= size / 2) { // swap
			T temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
		}

		left.node = left.node.next;
	}

	public boolean isPalindrome() {
		HeapMover left = new HeapMover();
		left.node = head;
		boolean res = isPalindromeHelper(left, head);
		return res;
	}

	private boolean isPalindromeHelper(HeapMover left, Node right) {
		if (right == null) {
			return true;
		}
		boolean val;

		val = isPalindromeHelper(left, right.next);
		if (val == false) {
			return false;
		} else {
			if (left.node.data != right.data) {
				return false;
			} else {
				left.node = left.node.next;
			}
		}
		return val;
	}

	public void foldList() {
		HeapMover left = new HeapMover();
		left.node = head;
		foldListHelper(left, head, 0);
		tail = left.node.next;
		tail.next = null;
	}

	private void foldListHelper(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		foldListHelper(left, right.next, floor + 1);
		if (floor >= size / 2) {
			Node node = left.node.next;
			left.node.next = right;
			right.next = node;
			left.node = node;
		}
	}

	public void unfoldList() {
		HeapMover left = new HeapMover();
		left.node = head;
		unfoldListHelper(left, head, 0);
	}

	private void unfoldListHelper(HeapMover left, Node right, int floor) {
		
	}

	public T kthfromLast(int k) {
		Node fast = head;
		Node slow = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;

		}
		return slow.data;

	}

	public T midPointOfList() {
		Node fast = head;
		Node slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}

	// public void kreverse(int k) {
	//
	// Node front = head;
	// Node prev = head;
	// Node curr = prev.next;
	// int floor = 0;
	// while (front != null) {
	// for (int i = 0; i < k; i++) {
	//
	// Node ocn = curr.next;
	// curr.next = prev;
	// prev = curr;
	// curr = ocn;
	// floor++;
	//
	// }
	// if (floor / k == 0) {
	// head = prev;
	// } else if (floor / k == (k - 1)) {
	// tail = prev;
	// tail.next = null;
	// }
	// front = curr;
	//
	// }
	// }

	private Node removeFirstNode() {
		if (size == 0) {
			System.out.println("List Empty");
			return null;
		}
		if (size == 1) {
			return handleRemovalOfNodeWhenSizeis1();

		}
		Node rv = head;
		head = head.next;
		rv.next = null;
		size--;

		return rv;

	}

	private Node handleRemovalOfNodeWhenSizeis1() {
		Node rv = head;
		tail = head = null;
		rv.next = null;
		size--;
		return rv;

	}

	private void addFirstNode(Node node) {
		if (size == 0) {
			handleAddNodeWhenSize0(node);
			return;
		}
		node.next = head;
		head = node;
		size++;

	}

	private void handleAddNodeWhenSize0(Node node) {

		head = tail = node;
		size++;
	}

	private void addLastNode(Node node) {
		if (size == 0) {
			handleAddNodeWhenSize0(node);
		}
		tail.next = node;
		tail = node;
		size++;
	}

}
