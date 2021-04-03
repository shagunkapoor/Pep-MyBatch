import java.util.Scanner;

public class GMaxMinInOn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of test cases");
		int t = scn.nextInt();
		System.out.println("Enter array size");
		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			System.out.println("Enter the array elements:");
			for (int x = 0; x < n; x++) {
				arr[x] = scn.nextInt();
			}

			int max = 0;
			int min = arr[0];
			for (int indx = 0; indx < n; indx++) {
				if (arr[indx] > arr[max]) {
					max = indx;
				}
				if (arr[indx] < min) {
					min = arr[indx];
				}
			}
			System.out.println(arr[max] + ", " + min);
		}
	}

}
