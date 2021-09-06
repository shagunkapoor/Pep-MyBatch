package KJuly30;

public class ClientHuffman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuffmanEncoder he=new HuffmanEncoder("aaaaaaaaaaaaabbbbbbbbbbbbbbbccccccccccddd");
		System.out.println(he.encode("abcd"));
		System.out.println(he.decode("100111110"));
	}

}
