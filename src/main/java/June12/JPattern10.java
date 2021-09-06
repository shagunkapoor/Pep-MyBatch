package June12;

import java.io.*;
import java.util.*;

//1           1
//1 2       2 1
//1 2 3   3 2 1
//1 2 3 4 3 2 1

public class JPattern10 {

	public static void main(String[] args) {
		System.out.println("Enter the no. of rows");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int r = 1;
		int st1 = 1;
		int sp = (2 * n) - 3;
		int st2 = 1;
		int val = 1;
		while (r <= n) {
			int cst1 = 1;
			val = 1;
			while (cst1 <= st1) {
				System.out.print(val + " ");
				val++;
				cst1++;
			}
			int csp = 1;
			while (csp <= sp) {
				System.out.print("  ");
				csp++;
			}
			int cst2 = 1;
			val = r;
			while (cst2 <= st2) {
				System.out.print(val + " ");
				cst2++;
				if (cst2 > 1)
					val--;
			}

			st1 += 1;
			sp -= 2;
			st2 += 1;

			System.out.println();
			r++;
			if (r == n)
				st1 -= 1;
		}

	}
}