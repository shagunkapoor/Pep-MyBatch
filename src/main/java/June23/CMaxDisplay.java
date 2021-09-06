package June23;

public class CMaxDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { -1, 26, 13, 94, 5, 6 };
		int res = maxDisplay(arr, 0);
		System.out.println(res);
	}

	public static int maxDisplay(int[] arr, int vidx) {
		// if (vidx == arr.length) {
		// return Integer.MIN_VALUE;
		// }

		if (vidx == arr.length - 1) {
			return arr[vidx];
		}

		int val = maxDisplay(arr, vidx + 1);
		if (val > arr[vidx]) {
			return val;
		} else {
			return arr[vidx];
		}
	}
}