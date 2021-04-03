import java.util.Scanner;
//1
//11
//121
//1331

public class GBinomialPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.err.println("Enter the no. of rows");
		int n = scn.nextInt();
		printbinomial(n, 0, 0);
	}

	static int val = 1;

	public static void printbinomial(int n, int i, int j) {
		if (i > n) {
			return;
		}
		if (j <= i) {
			System.out.print(val);
			int nv=(val*(i-j))/(j+1);
			val = nv;
			printbinomial(n, i, j + 1);
		} else {
			val=1;
			System.out.println();
			printbinomial(n, i + 1, 0);
		}
	}

}
