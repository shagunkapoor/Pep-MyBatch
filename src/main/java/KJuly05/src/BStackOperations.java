public class BStackOperations {
	int tos = -1;
	int[] arr;

	public BStackOperations(int cap) {
		arr = new int[cap];
	}

	public void push(int val) {
		if (tos == arr.length - 1) {
			System.out.println("Stack Overflow");
			return;
		}
		tos++;
		arr[tos] = val;
	}

	public int top() {
		if (tos == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return arr[tos];
	}

	public int pop() {
		if (tos == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		int rv = arr[tos];
		 arr[tos] = 0;
		tos--;
		return rv;
	}

	public int size() {
		if (tos == -1) {
			return 0;
		} else {
			return tos + 1;
		}
	}

	public boolean isEmpty() {
		if (tos == -1) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		if (tos == -1) {
			System.out.println("Stack Underflow");
			return;
		}
		for (int i = tos; i >= 0; i--) {
			System.out.print(arr[i] + "->");
		}
		System.out.println();
		
	}

}
