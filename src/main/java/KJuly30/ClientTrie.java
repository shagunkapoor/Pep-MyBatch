package KJuly30;

public class ClientTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie tr=new Trie();
		tr.addWord("are");
		tr.addWord("art");
		tr.addWord("an");
		tr.addWord("and");
		tr.addWord("ant");
		tr.addWord("as");
		tr.addWord("ask");
		tr.addWord("see");
		tr.addWord("seen");
		tr.addWord("sea");
		
		System.out.println(tr.searchWord("see"));
		System.out.println(tr.searchWord("an"));
		tr.displayWords();
		
		//July 31
		System.out.println("************************");
		tr.removeWord("ant");
		tr.removeWord("an");
		tr.displayWords();
		System.out.println("Trie display");
		tr.displayTrie();
		
	}

}
