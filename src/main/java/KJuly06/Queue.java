package KJuly06;

public class Queue {

	int[] arr;
	int front = 0;
	int size = 0;

	public Queue(int cap) {
		arr = new int[cap];
	}

	public void enqueue(int val) {
		if (size == arr.length) {
			System.out.println("Stack Overflow");
			return;
		}
		int rear = (front + size) % arr.length;
		arr[rear] = val;

		size++;
	}

	public int deque() {
		if (size == 0) {
			System.out.println("Stack Underflow");
			return -1;
		}
		int rv = arr[front];
		front = (front + 1) % arr.length;
		size--;
		return rv;
	}

	public int front() {
		if (size == 0) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return arr[front];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		if (size == 0) {
			System.out.println("Stack Underflow");
			return;
		}
		for (int i = 0; i < this.size; i++) {
			System.out.print(arr[(i + front) % arr.length] + "->");
		}
		System.out.println();
	}
}
