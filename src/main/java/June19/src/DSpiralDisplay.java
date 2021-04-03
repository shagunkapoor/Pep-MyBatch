public class DSpiralDisplay {
	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14 }, 
				{ 21, 22, 23, 24 },
				{ 31, 32, 33, 34 },
				{ 41, 42, 43, 44 } };
		
		int r = arr.length;
		int c = arr[0].length;

		int rmin = 0;
		int rmax = r - 1;
		int cmin = 0;
		int cmax = c - 1;
		int total = r * c;
		int cnt = 1;
		while (cnt <= total) {
			for (int i = rmin; i <= rmax && cnt <= total; i++) {
				System.out.println(arr[i][cmin]);
				cnt++;
			}

			cmin++;

			for (int j = cmin; j <= cmax && cnt <= total; j++) {
				System.out.println(arr[rmax][j]);
				cnt++;
			}
			rmax--;

			for (int i = rmax; i >= rmin && cnt <= total; i--) {
				System.out.println(arr[i][cmax]);
				cnt++;
			}
			cmax--;

			for (int j = cmax; j >= cmin && cnt <= total; j--) {
				System.out.println(arr[rmin][j]);
				cnt++;
			}
			rmin++;

		}
	}
}
