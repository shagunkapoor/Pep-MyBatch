package June14;

import java.util.Scanner;

//LCM=Prod of 2 no./GCD
public class EFunction_LCMusingGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter two no. whose LCM is reqd.");
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		int result = LCM(n1, n2);
		System.out.println(result);
	}

	public static int LCM(int x, int y) {
		int prod = x * y;
		int hcf = GCD(x, y);
		int lcm = prod / hcf;
		return lcm;
	}

	public static int GCD(int a, int b) {
		int rem = a % b;
		while (rem != 0) {
			a = b;
			b = rem;
			
			rem = a % b;

		}
		return b;

	}

}
