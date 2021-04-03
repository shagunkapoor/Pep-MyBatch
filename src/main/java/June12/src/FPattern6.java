 import java.util.Scanner;

 
//*** ***
//**   **
//*     *
//**   **
//*** ***
public class FPattern6 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n = scn.nextInt();
		int r = 1;
		int st1 = (n / 2) + 1, sp = 1, st2 = (n / 2) + 1;
		while (r <= n) {
			int cst1 = 1;
			while (cst1 <= st1) {
				System.out.print("*");
				cst1++;
			}
			int csp = 1;
			while (csp <= sp) {
				System.out.print(" ");
				csp++;
			}
			int cst2 = 1;
			while (cst2 <= st2) {
				System.out.print("*");
				cst2++;
			}
			if (r <= n / 2) {
				st1 -= 1;
				sp += 2;
				st2 -= 1;
			} else {
				st1 += 1;
				sp -= 2;
				st2 += 1;
			}
			System.out.println();
			r++;
		}
	}
}