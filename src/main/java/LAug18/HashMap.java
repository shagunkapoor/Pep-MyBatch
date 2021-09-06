package LAug18;

import java.util.ArrayList;

public class HashMap<K, V> {

	private class HMNode {
		K key;
		V value;

		private HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	private LinkedList<HMNode>[] buckets;
	private int size = 0;

	public HashMap() {
		buckets = new LinkedList[4];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	public boolean containsKey(K key) {
		int bi = key.hashCode();
		int di = foundInBucket(key, buckets[bi]);
		if (di == -1) {
			return false;
		} else {
			return true;
		}
	}

	public V get(K key) {
		int bi = key.hashCode();
		int di = foundInBucket(key, buckets[bi]);
		if (di != -1) {
			return buckets[bi].getAt(di).value;
		}

		return null;
	}

	public V remove(K key) {
		int bi = key.hashCode();
		int di = foundInBucket(key, buckets[bi]);
		if (di != -1) {
			return buckets[bi].removeAt(di).value;
		}

		return null;
	}

	public void put(K key, V value) {

		int bi = hashFunc(key);
		LinkedList<HMNode> internalbucket = buckets[bi];
		int di = foundInBucket(key, internalbucket);

		if (di == -1) { // key not present
			HMNode node = new HMNode(key, value);
			buckets[bi].addLast(node);
			this.size++;
		} else { // update value
			buckets[bi].getAt(di).value = value;
		}

		// Rehashing
		double lambda = this.size * 1.0 / buckets.length;

		if (lambda > 2) {
			rehash();
		}
	}

	private void rehash() {

		LinkedList<HMNode>[] oldbucket = buckets;

		buckets = new LinkedList[oldbucket.length * 2];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
		this.size = 0;

		for (int bi = 0; bi < oldbucket.length; bi++) {
			for (int di = 0; di < oldbucket[bi].size; di++) {
				HMNode node = oldbucket[bi].getAt(di);
				put(node.key, node.value);
			}
		}
	}

	private int hashFunc(K key) {
		int hc = key.hashCode();
		int bi = Math.abs(hc) % buckets.length; // Compression Function

		return bi;
	}

	private int foundInBucket(K key, LinkedList<HMNode> bucket) {

		for (int i = 0; i < bucket.size; i++) {
			HMNode node = bucket.getAt(i);
			if (node.key.equals(key)) {
				return i;
			}
		}
		return -1;
	}

	public ArrayList<K> keySet() {

		ArrayList<K> list = new ArrayList<>();
		for (int bi = 0; bi < buckets.length; bi++) {
			for (int di = 0; di < buckets[bi].size; di++) {
				HMNode node = buckets[bi].getAt(di);
				list.add((K) buckets[bi].getAt(di).key);
			}
		}
		return list;
	}

	public void display() {
		for (int bi = 0; bi < buckets.length; bi++) {
			System.out.print("B:" + bi + " ->");
			for (int di = 0; di < buckets[bi].size; di++) {
				HMNode node = buckets[bi].getAt(di);
				System.out.print(node.key + " @ " + node.value + ", ");
			}

			System.out.println();
		}
	}

}
