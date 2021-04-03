import java.util.Scanner;

public class GAllIndices {

	public static void main(String[] args) {
		// Scanner scn = new Scanner(System.in);
		// System.out.println("Enter");
		// int n = scn.nextInt();
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// arr[i] = scn.nextInt();
		// }
		// int data = scn.nextInt();
		// int indx = scn.nextInt();

		int[] arr = { 3, 26, 3, 94, 3, 6, 0, 3, 51 };
		int data = 3;
		// int indx=;
		int[] res = allindices(arr, data, 0, 0);
		// System.out.println(res[indx]);
	}

	public static int[] allindices(int[] arr, int data, int vidx, int cnt) {
		if (vidx == arr.length) {
			return new int[cnt];
		}
		if (data == arr[vidx]) {
			cnt++;
		}
		int[] result = allindices(arr, data, vidx + 1, cnt);
		if (data == arr[vidx]) {
			result[cnt - 1] = vidx;
		}

		return result;

	}
}
