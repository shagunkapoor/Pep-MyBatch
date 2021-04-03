
import java.util.*;
import java.lang.*;
import java.io.*;

//n=4
//Output :
// 4444444
// 4333334
// 4322234
// 4321234
// 4322234
// 4333334
// 4444444
//
//n=3
//  Output :
//   33333
//   32223
//   32123
//   32223
//   33333

public class KPattern11 {

	public static void main(String[] args) {
		// code
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			solve(n);

		}
	}

	private static void solve(int max) {
		int n = (2 * max) - 1;
		int r = 1, c = 1;
		int sp1 = 0, sp2 = n, sp3 = 0;
		int v2 = max, v1, v3 = 0;

		while (r <= n) {
			v1 = max;
			int csp1 = 1;
			while (csp1 <= sp1) {
				System.out.print(v1);
				v1--;
				csp1++;
			}

			int csp2 = 1;
			while (csp2 <= sp2) {
				System.out.print(v2);
				csp2++;
			}

			int csp3 = 1;
			while (csp3 <= sp3) {
				System.out.print(v3);
				v3++;
				csp3++;
			}

			if (r <= n / 2) {
				sp1++;
				sp2 -= 2;
				sp3++;
				v2--;
				v3 = v2 + 1;
			} else {
				sp1--;
				sp2 += 2;
				sp3--;
				v2++;
				v3 = v2 + 1;
			}
			r++;

			System.out.println();
		}
	}

}
