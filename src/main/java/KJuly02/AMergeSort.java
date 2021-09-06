package KJuly02;

import java.util.Scanner;

public class AMergeSort {

	public static void main(String[] args) {
		int[] array = { 2, 8, 5, 7, 11, 0, 3, 15 };
		int[] res = new int[array.length];
		res = mergesort(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int[] mergesort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] base = new int[1];
			base[0] = arr[lo];
			return base;
		}
		

		int mid = (lo + hi) / 2;
		int[] one = mergesort(arr, lo, mid);
		int[] two = mergesort(arr, mid + 1, hi);
		int[] sorted = merging(one, two);
		return sorted;
	}

	public static int[] merging(int[] one, int[] two) {
		int i = 0, j = 0, k = 0;
		int[] sortedarr = new int[one.length + two.length];
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				sortedarr[k] = one[i];
				i++;
				k++;
			} else {
				sortedarr[k] = two[j];
				j++;
				k++;
			}
		}
		while (i < one.length) {
			sortedarr[k] = one[i];
			i++;
			k++;
		}
		while (j < two.length) {
			sortedarr[k] = two[j];
			j++;
			k++;
		}
		return sortedarr;
	}

}
