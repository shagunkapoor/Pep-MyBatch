import java.util.Scanner;

public class KPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		boolean res = palindrome(arr, 0, n - 1);
		System.out.println(res);

	}

	static boolean result = true;

	public static boolean palindrome(int[] arr, int vidx, int n) {
		if (vidx > arr.length - 1 - vidx) {
			return true;
		}

		if (arr[vidx] != arr[n]) {
			return false;
		} else {
			result = palindrome(arr, vidx + 1, n - 1);
		}

		return result;
	}

}
