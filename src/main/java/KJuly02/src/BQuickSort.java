public class BQuickSort {

	public static void main(String[] args) {

		int[] arr = { 2, 7, 0, 3, 15, 1, 8, 5 };
		quicksort(arr, 0, arr.length - 1);

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int pivot = arr[hi];
		int pivotindx = partitioning(arr, pivot, lo, hi);
		quicksort(arr, lo, pivotindx - 1);
		quicksort(arr, pivotindx + 1, hi);

	}

	public static int partitioning(int[] arr, int pivot, int lo, int hi) {

		int itr = lo;
		int partidx = lo;

		while (itr <= hi) {
			if (arr[itr] <= pivot) {
				int temp = arr[itr];
				arr[itr] = arr[partidx];
				arr[partidx] = temp;

				itr++;
				partidx++;
			} else {
				itr++;
			}
		}
		return partidx - 1;
	}

}
