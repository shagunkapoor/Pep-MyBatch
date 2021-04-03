import java.util.Scanner;

//Kadane's Algorithm
public class ASubarrayWithLargestSumORKadanes {

	public static void main(String[] args) {
		// Scanner scn=new Scanner(System.in);
		// int[] arr= ArrayUtils.takeInput();

//		int[] arr = { -5, 2, -1, 3, 6, -11, 8, 9, -10, 5, 6, -4, -5 };
		int[] arr={-2, -3, 4, -1, -2, 1, 5,5, -3 }; 
		kadane(arr);
	}

	public static void kadane(int[] a) {
		// current end point
		int cep = 0;
		int csp = 0;
		int csum = a[0];

		// overall end point
		int oep = 0;
		int osp = 0;
		int osum = a[0];

		for (int i = 1; i < a.length; i++) {
			if (csum > 0) {
				csum += a[i];
				cep++;
			} else {
				csum = a[i];
				csp = cep = i;
			}
			if (osum < csum) {
				osum = csum;
				osp = csp;
				oep = cep;
			}
		}

		System.out.println(osum);
		for (int i = osp; i <= oep; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
