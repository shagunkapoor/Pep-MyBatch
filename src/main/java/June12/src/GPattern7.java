import java.util.Scanner;

//  *
// ***
//*****
// ***
//  *

public class GPattern7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n = scn.nextInt();

		int r = 1;
		int sp = n / 2;
		int st = 1;

		while (r <= n) {
			int csp = 1;
			while (csp <= sp) {
				System.out.print(" ");
				csp++;
			}
			int cst = 1;
			while (cst <= st) {
				System.out.print("*");
				cst++;
			}

			if (r <= n / 2) {
				sp = sp - 1;
				st = st + 2;
			} else {
				sp = sp + 1;
				st = st - 2;
			}
			System.out.println();
			r++;
		}
	}

}
