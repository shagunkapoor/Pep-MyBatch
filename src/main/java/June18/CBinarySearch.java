package June18;

import java.util.Arrays;
import java.util.Scanner;

public class CBinarySearch {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the element to be searched");
		int num = scn.nextInt();
		int[] arr = ArrayUtils.takeInput();
		// int[] arr={10,20,50,30,40};

		Arrays.sort(arr);
		int low = 0;
		int pos = 0;
		int high = (arr.length) - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (num < arr[mid]) {
				high = mid - 1;
			} else if (num > arr[mid]) {
				low = mid + 1;
			} else if (num == arr[mid]) {
				pos = mid + 1;
				break;
			}
		}
		if (pos != 0)
			System.out.println("Element is present at position: " + pos);
		else
			System.out.println("Not present");
	}

}
