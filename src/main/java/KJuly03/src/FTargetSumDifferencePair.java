import java.util.Arrays;

public class FTargetSumDifferencePair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = { 50, 12, 75, 25, 62, 37, 87, 10, 89 };
		int targetsum = 99;
		printsumpairs(arr1, 0, arr1.length - 1, targetsum);

		System.out.println("\n*******************************");

		int[] arr2 = { 5, 7, 9, 10, 11, 17, 15, 16, 17, 19, 21 };
		int targetdiff = 5;
		printdiffpairs(arr2, 0, 1, targetdiff);

	}

	public static void printsumpairs(int[] arr, int left, int right, int target) {

		Arrays.sort(arr);
		while (left < right) {
			if (arr[left] + arr[right] == target) {
				System.out.println(arr[left] + "," + arr[right]);
				left++;
				right--;
			} else if (arr[left] + arr[right] < target) {
				left++;
			} else if (arr[left] + arr[right] > target) {
				right--;
			}
		}
	}

	public static void printdiffpairs(int[] arr, int start, int end, int target) {

		Arrays.sort(arr);
		while (start < end && end < arr.length) {
			if (arr[end] - arr[start] == target) {
				System.out.println(arr[start] + "," + arr[end]);
				start++;
				end++;
			} else if (arr[end] - arr[start] > target) {
				start++;
			} else if (arr[end] - arr[start] < target) {
				end++;
			}
		}
	}
}
