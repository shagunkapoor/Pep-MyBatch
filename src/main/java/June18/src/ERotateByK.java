import java.util.Scanner;

public class ERotateByK {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of rotations");
		int r = scn.nextInt();
		int[] arr = ArrayUtils.takeInput();
		ArrayUtils.display(arr);
		int n = arr.length;
		int left1 = 0;
		int right1 = n - 1 - r;
		int left2 = n - r;
		int right2 = n - 1;

		reverse(arr, left1, right1);
		reverse(arr, left2, right2);
		reverse(arr, 0, n - 1);
		ArrayUtils.display(arr);
	}

	public static void reverse(int[] array, int left, int right) {
		while (left < right) {
			ArrayUtils.swap(array, left, right);
			left++;
			right--;
		}
	}

}
