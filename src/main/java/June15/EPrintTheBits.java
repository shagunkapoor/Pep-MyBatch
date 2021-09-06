package June15;

public class EPrintTheBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = -128;
		int lim = 31;
		while (lim >= 0) {
			int mask = 1 << lim;
			int val = n & mask;

			if (val == mask) {
				System.out.print("1");
			} else
				System.out.print("0");
			lim--;
		}
	}

}
