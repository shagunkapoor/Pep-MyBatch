import java.util.Scanner;

public class HBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = { 1, 26, 13, 94, 5, 6 };
		// bubbleSort(arr, 0, arr.length - 1);
		// disp(arr);
		// }
		//
		// public static void disp(int[] arr) {
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }
		//
		// }
		//
		// public static void bubbleSort(int[] arr, int start, int end) {
		//
		// if (end == arr.length) {
		//
		// return;
		// }
		// if (start < end) {
		// if (arr[start] > arr[start + 1]) {
		// int temp = arr[start];
		// arr[start] = arr[start + 1];
		// arr[start + 1] = temp;
		// }
		// bubbleSort(arr, start + 1, end);
		// }
		// if (start == end) {
		// bubbleSort(arr, 0, end - 1);
		// }
		// }
		// }
		
		//Hackerrank

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		bubble(arr, 0, n-1);
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}

	public static void bubble(int[] arr, int start, int end) {
		if (end == arr.length) {
			return;
		}
		if (start < end) {

			if (arr[start] > arr[start + 1]) {
				int temp = arr[start];
				arr[start] = arr[start + 1];
				arr[start + 1] = temp;
			}
			bubble(arr, start + 1, end);
		}
		if (start == end) {
			bubble(arr, 0, end - 1);
		}
	}
}
