package June19;

import java.time.chrono.IsoChronology;

public class CWaveDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = { { 11, 12, 13, 14 }, 
				{ 21, 22, 23, 24 }, 
				{ 31, 32, 33, 34 }, 
				{ 41, 42, 43, 44 } };
		int r = arr.length;
		int c = arr[0].length;
		for (int i = 0; i < c; i++) {
			boolean gngdown = (i % 2 == 0);
			if (gngdown) {
				for (int j = 0; j < r; j++) {
					System.out.print(arr[j][i] + " ");
				}
			} else {
				for (int j = r - 1; j >= 0; j--) {
					System.out.print(arr[j][i] + " ");
				}
			}
			// System.out.println();
		}
		
	}

}
