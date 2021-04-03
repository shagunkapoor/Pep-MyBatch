import java.util.Scanner;

public class EMinSwapsToBringElmntsLessThanKTogether {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the dividing element");
		double div = scn.nextDouble();
		int k=(int)div;
		// int[] arr = ArrayUtils.takeInput();
		int[] arr = { 10,9,2,3,8,5,6};//2, 8,7, 5, 6, 5, 11, 15 };
		int cnt = 0;
		int arrlessthank = 0;
		int arrmorethank = 0;
		while (arrmorethank < arr.length) {
			if (arr[arrmorethank] < k) {
				ArrayUtils.swap(arr, arrlessthank, arrmorethank);
				arrlessthank++;
				arrmorethank++;
				cnt++;
			} else {
				arrmorethank++;
			}
		}

		System.out.println("Min swaps=" + (cnt-1));

	}

}
