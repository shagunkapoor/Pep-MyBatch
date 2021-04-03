import java.util.Scanner;

//Write a recursive function which returns true if the array is sorted and false
//otherwise
public class JCheckSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = scn.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the array elements");
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		chcksorted(arr, 0);
	}

	public static void chcksorted(int[] arr, int vidx) {
		if (vidx == arr.length - 1) {
			System.out.println(true);
			return;
		}
		int firstelt = arr[vidx];
		if (firstelt > arr[vidx + 1]) {
			System.out.println(false);
			return;
		} 
		if(firstelt<arr[vidx+1]){
			chcksorted(arr, vidx + 1);
			
		}


	}

}
