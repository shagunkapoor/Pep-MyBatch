package June20;

import java.util.Scanner;

public class D90DegreeClkwiseRotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner scn=new Scanner(System.in);
		// System.out.println("Enter the array size");
		// int n=scn.nextInt();
		// int[] arr=new int[n];
		// System.out.println("Enter the array elements");
		// for(int i=0;i<n;i++){
		// arr[i]=scn.nextInt();
		// }

		// Only Printing
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int n = arr.length;

		// Transpose
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
				// System.out.println();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		// Swapping Columns
		int x = 0;
		while (x < n / 2) {
			for (int i = 0; i < n; i++) {
				int temp = arr[i][n- x - 1];
				arr[i][n - x - 1] = arr[i][x];
				arr[i][x] = temp;
			}
			x++;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
