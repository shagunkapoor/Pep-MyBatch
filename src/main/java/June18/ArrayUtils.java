package June18;

import java.util.Scanner;

public class ArrayUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = takeInput();
		display(arr);
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int[] takeInput() {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = scn.nextInt();
		int[] arr = new int[n];

		System.out.println("Enter the elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static void swap(int[] arr, int i, int j) {
		
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		
	}

}
