public class FExitPosition2 {

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 1, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 1, 0, 0, 0 }, 
				{ 0, 0, 1, 0 } };

		int r = arr.length;
		int c = arr[0].length;

		// Display Array
		for (int a = 0; a < r; a++) {
			for (int b = 0; b < c; b++) {
				System.out.print(arr[a][b] + " ");
			}
			System.out.println();
		}

		int i = 0;
		int j = 0;
		int dir = 0;

		while (true) {
			dir = (dir + arr[i][j]) % 4;

			if (dir == 0) { // east
				j++;
			} else if (dir == 1) { // south
				i++;
			} else if (dir == 2) { // west
				j--;
			} else if (dir == 3) { // north
				i--;
			}

			if (i < 0) {// top wall break
				i++;
				System.out.println(i + "," + j);
				break;
			} else if (j < 0) { // left wall break
				j++;
				System.out.println(i + "," + j);
				break;
			} else if (i >= arr.length) { // bottom wall break
				i--;
				System.out.println(i + "," + j);
				break;
			} else if (j >= arr[0].length) { // right wall break
				j--;
				System.out.println(i + "," + j);
				break;
			}
		}
//		if(flag==false)
//		System.out.println("No exit point");

	}

}
