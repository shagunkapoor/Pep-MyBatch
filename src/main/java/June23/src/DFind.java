import java.util.Scanner;

public class DFind {

	public static void main(String[] args) {
		int[] arr = { 1, 26, 13, 94, 5, 6 };
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number to be searched");
		int n = scn.nextInt();
		boolean res = find(arr, 0, n);
		System.out.println(res); // CORRECT
	}

	public static boolean find(int[] arr, int vidx, int data) {
		if (vidx == arr.length)
			return false;

		if (data == arr[vidx])
			return true;
		boolean val = find(arr, vidx + 1, data);

		return val;

	}
}

// Scanner scn = new Scanner(System.in);
// System.out.println("Enter the size of array");
// int n = scn.nextInt();
// System.out.println("Enter the array");
// int[] arr = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = scn.nextInt();
// }
// int data = scn.nextInt();
// findnum(arr, data, 0);
// }
//
// public static void findnum(int[] arr, int data, int vidx) {
// if (vidx == arr.length - 1) {
// System.out.println(false);
// return;
// }
//
// if (data == arr[vidx]) {
// System.out.println(true);
// return;
// }
// findnum(arr, data, vidx + 1);
// }}
