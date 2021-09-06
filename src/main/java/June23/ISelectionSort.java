package June23;

import java.util.Scanner;

public class ISelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 26, 13, 94, 5, 6 };
		selectionSort(arr, 0, 1);
		disp(arr);
	}

	public static void disp(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void selectionSort(int[] arr, int start, int end) {

		if (end < arr.length) {
			if (arr[start] > arr[end]) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
			selectionSort(arr, start, end + 1);
		}
		if (end == arr.length - 1) {
			end = start + 2;
			selectionSort(arr, start + 1, end);
		}
	}
}
