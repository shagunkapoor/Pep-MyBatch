package June27;

import java.util.Scanner;

public class IPointOnLine {

	private static final float NaN = 0;
	private static final float Infinity = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of points");
		int n = scn.nextInt();
		float[] x = new float[n];
		float[] y = new float[n];
		System.out.println("Enter the xi & yi coordinates");
		for (int i = 0; i < n; i++) {
			x[i] = scn.nextInt();
			y[i] = scn.nextInt();
		}
		float slope = (y[1] - y[0]) / (x[1] - x[0]);
		checkonline(x, y, 0, slope);
	}

	// static float m;

	public static void checkonline(float[] x, float[] y, int vidx, float slope) {

		if (vidx == x.length) {
			System.out.println("YES");
		}
		// System.out.println((y[vidx + 1] - y[vidx]));
		// System.out.println((x[vidx + 1] - x[vidx]));
		// System.out.println(5.0/0.0);
//		System.out.println((2.0 - 2.0) / (1.0 - 1.0));
//		float m = (y[vidx + 1] - y[vidx]) / (x[vidx + 1] - x[vidx]);
//		if (m == NaN) {
//			checkonline(x, y, vidx + 1, slope);
//		} else
			if ((y[vidx + 1] - y[vidx]) / (x[vidx + 1] - x[vidx]) == slope) {
			checkonline(x, y, vidx + 1, slope);
		} else {
			System.out.println("NO");
			return;
		}

	}

}
