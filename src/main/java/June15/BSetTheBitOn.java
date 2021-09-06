package June15;

public class BSetTheBitOn {

	public static void main(String[] args) {

		int n=57;
		int k=2;
		
		int mask=1<<k;
		int val=(n|mask);
		
		System.out.println(Integer.toBinaryString(val));
		
	}
}