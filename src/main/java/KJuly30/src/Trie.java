import java.util.ArrayList;
import java.util.HashMap;

public class Trie {

	public class Node {
		char data;
		HashMap<Character, Node> children = new HashMap<>();
		boolean eow;
	}

	Node root;
	int words;
	int nodes;

	public Trie() {
		root = new Node();
		root.data = '$';
		nodes = 1;
	}

	public void addWord(String word) {
		if (searchWord(word)) {
			return;
		} else {
			addWord(root, word);
		}
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = true;
			return;
		}

		char ch = word.charAt(0);
		String sub = word.substring(1);

		if (node.children.containsKey(ch)) {
			Node child = node.children.get(ch);
			addWord(child, sub);
		} else {
			Node newnode = new Node();
			newnode.data = ch;
			node.children.put(ch, newnode);
			addWord(newnode, sub);
			words++;
		}
	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {
		if (word.length() == 0) {
			return node.eow;
		}
		char ch = word.charAt(0);
		String sub = word.substring(1);

		Node child = node.children.get(ch);
		if (child == null) {
			return false;
		} else {
			return searchWord(child, sub);
		}
	}

	public void removeWord(String word) {
		if (searchWord(word)) {
			removeWord(root, word);
		} else {
			return;
		}
	}

	private void removeWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = false;
			words--;
			return;
		}

		char ch = word.charAt(0);
		String sub = word.substring(1);
		Node child = node.children.get(ch);
		removeWord(child, sub);
		if (child.eow == false && child.children.size() == 0) {
			nodes--;
			node.children.remove(child);
		}
	}

	public void displayWords() {
		
		displayWords(root,"");
	}
	private void displayWords(Node node, String wsf){
		if(node.eow){
			System.out.println(wsf+" ");
		}
		
		ArrayList<Character> allkeynodes=new ArrayList<>(node.children.keySet());
		for(Character key: allkeynodes){
			Node child=node.children.get(key);
			displayWords(child,wsf+key);
		}
	}
	
	
	public void displayTrie(){
		displayTrie(root);
	}
	private void displayTrie(Node node){
		
		System.out.println(node.data+" -> "+ node.children.keySet());
		
		ArrayList<Character> allkeynodes=new ArrayList<>(node.children.keySet());
		for(Character key: allkeynodes){
			Node child=node.children.get(key);
			displayTrie(child);
		}
	}
}
