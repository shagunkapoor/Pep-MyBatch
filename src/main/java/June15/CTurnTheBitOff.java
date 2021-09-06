package June15;

public class CTurnTheBitOff {

	public static void main(String[] args) {

		int n=57;
		int k=3;
		int mask=1<<k;
		int revmask= ~mask;
		
		int val=n&revmask;
		System.out.println(Integer.toBinaryString(val));
	}

}
