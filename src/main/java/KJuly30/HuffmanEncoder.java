package KJuly30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanEncoder {

	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	class Node implements Comparable<Node> {
		char data;
		int freq;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.freq - o.freq;
		}
	}

	public HuffmanEncoder(String feeder) {

		// Step 1: feeder to fmap
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			char ch = feeder.charAt(i);
			fmap.put(ch, fmap.containsKey(ch) ? fmap.get(ch) + 1 : 1);
		}

		// Step 2: fmap to PQ
		PriorityQueue<Node> pq = new PriorityQueue<>();
		ArrayList<Character> allkeys = new ArrayList<>(fmap.keySet());
		for (Character key : allkeys) {
			Node pqvalues = new Node();
			pqvalues.data = key;
			pqvalues.freq = fmap.get(key);
			pq.add(pqvalues);
		}

		// Step 3: While PQ.size >1, remove 2, merge, put back
		while (pq.size() > 1) {
			Node one = pq.remove();
			Node two = pq.remove();

			Node merged = new Node();
			merged.freq = one.freq + two.freq;
			merged.left = one;
			merged.right = two;

			pq.add(merged);
		}

		// Step 4: retrieve last node and traverse PQ to fill encoder & decoder
		Node lastnode = pq.remove();
		traverse(lastnode, "");

	}

	private void traverse(Node node, String psf) {
		if (node.left == null && node.right == null) {
			encoder.put(node.data, psf);
			decoder.put(psf, node.data);
			return;
		}

		traverse(node.left, psf + "0");
		traverse(node.right, psf + "1");
	}

	// abcd->11010
	public String encode(String str) {
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			res += encoder.get(ch);
		}
		return res;
	}
	
	// 11010->abcd
	public String decode(String str) {
		String decoded = "";
		String prefix = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			prefix += ch;
			if (decoder.containsKey(prefix)) {
				decoded += decoder.get(prefix);
				prefix = "";
			}
		}
		return decoded;
	}
}
