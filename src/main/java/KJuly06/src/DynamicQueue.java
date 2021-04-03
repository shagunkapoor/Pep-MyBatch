
public class DynamicQueue extends Queue {

	public DynamicQueue(int cap) {
		super(cap);
	}

	public void enqueue(int val) {
		if (size == arr.length) {
			int[] oa = arr;
			arr = new int[2 * oa.length];

			for (int j = 0; j < size; j++) {
				arr[j] = oa[(front + j) % oa.length];
			}
			front = 0;
		}
		int rear = (front + size) % arr.length;
		arr[rear] = val;

		size++;

		// OR
		// super(enqueue(val);
	}
}
