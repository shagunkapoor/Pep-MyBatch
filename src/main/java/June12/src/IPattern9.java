import java.io.*;
import java.util.*;

//      1
//    2 3 2
//  3 4 5 4 3
//4 5 6 7 6 5 4

public class IPattern9 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n = scn.nextInt();
		int r = 1;
		int sp = n-1; //(n/2)+1
		int st = 1;
		int val = 1;
		while (r <= n) {
			int csp = 1;
			while (csp <= sp) {
				System.out.print("  ");
				csp++;
			}

			int cst = 1;

			val = r;

			while (cst <= st) {
				System.out.print(val + " ");
				// cst++;
				// }
				if (cst < (st / 2)+1)
					val++;
				else
					val--;
				cst++;
			}
			sp -= 1;
			st += 2;
			System.out.println();
			r++;

		}
	}
}