
import java.io.*;
import java.util.*;

public class GSquareRootIntegralAndPrecision {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter no. & precision");
		double N = scn.nextDouble();
		int P = scn.nextInt();
		// int InSR = sqroot(N);
		// double PrSR = sqrootwithprec(N, P);
		// }
		//
		// public static int sqroot(int num) {
		// for (int val = 1; val <= num / 2; val++) {
		// if (val * val <= num) {
		// System.out.print(val + " ");
		// }
		// }
		// return val;
		// }
		//
		// public static double sqrootwithprec(int num, int p) {

		double val = 1;
		int sqrt = 0;
		while (val <= N / 2) {
			if (val * val <= N) {
				// System.out.println(val);
				sqrt = (int) val;
				// break;
			}
			if (val * val > N)
				break;

			val++;
		}
		System.out.println(sqrt);

		double x = Math.sqrt(N);
		System.out.println(x);
		if (P <= 10) {

			double power = Math.pow(10, P);
			int pow = (int) Math.pow(10, P);
			System.out.println(pow);
			System.out.println(power);
			double db = (int) (x * pow) / power;
			System.out.println(db);

			// double sqrtwithprec = Math.round(db);
			System.out.println(sqrt + " " + db);
		}
	}
}
