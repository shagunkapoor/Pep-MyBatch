import java.util.Scanner;
//T is Number Of Test Cases.
//Take as input N, a number. Take N more inputs to form an array.
//The array was expected to be sorted. Accidentally, it got k items forward rotated.
// E.g. 3, 4, 5, 6, 1, 2 has been forward rotated 4 times. Find K. Target complexity is O(N).
//
//Example
//
//Input:
//1
//6
//3 4 5 6 1 2
//
//Output:
//4

public class JFindKOfRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of test cases");
		int t = scn.nextInt();
		System.out.println("Enter size of array");
		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			System.out.println("Enter the array elements");
			for (int x = 0; x < n; x++) {
				arr[x] = scn.nextInt();
			}

			int cntr = 0;
			if(arr[0]==1){
				System.out.println(0);
				return;
			}
			
			for (int indx = 0; indx < arr.length; indx++) {
				if (arr[indx] != n) {
					cntr++;
				} else {
					break;
				}
			}
			System.out.println(cntr+1);
		}
	}

}
