package June23;

import java.util.Scanner;

public class FLastIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 5, 1, 94, 5, 1, 6 };
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the element");
		int n = scn.nextInt();
		int res = lastIndex(arr, 0, n);
		System.out.println(res);

	}

	public static int lastIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length)
			return -1;

		int val = lastIndex(arr, vidx + 1, data);
		if (val == -1)
			if (data == arr[vidx])
				return vidx;
			else
				return -1;

		return val;
	}
}
