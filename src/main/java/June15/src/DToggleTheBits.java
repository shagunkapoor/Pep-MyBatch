public class DToggleTheBits {

	public static void main(String[] args) {

		int n=57;
		int k=3;
		int mask=1<<k;
		int val=n^mask;
		System.out.println(Integer.toBinaryString(val));
	}

}
