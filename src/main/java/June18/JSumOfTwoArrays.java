package June18;

import java.io.*;
import java.util.*;

public class JSumOfTwoArrays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("l1");
		int n1 = scn.nextInt();
		int[] one = new int[n1];
		for (int i = 0; i < n1; i++) {
			one[i] = scn.nextInt();
		}
		int n2 = scn.nextInt();
		int[] two = new int[n2];
		for (int i = 0; i < n2; i++) {
			two[i] = scn.nextInt();
		}
		int n3 = n1 > n2 ? n1 + 1 : n2 + 1;
		int[] sum = new int[n3];
		int i = n1 - 1;
		int j = n2 - 1;
		int k = n3 - 1;
		int carry = 0;
		while (k > 0) {
			int res = carry;
			if (i >= 0)
				res += one[i];
			if (j >= 0)
				res += two[j];
			
			sum[k] = res % 10;
			carry = res / 10;
			i--;
			j--;
			k--;
		}
		for (int a = 0; a < n3; a++) {
			System.out.print(sum[a] + " ");
		}

	}
}

// int l3 = 0;
// if (l1 >= l2)// arr2 is small
// l3 = l1;
// else
// l3 = l2;// arr1 is small
// int[] arr3 = new int[l3];
// int c = 0;
// int sum = 0;
//
// if (l3 == l1) {
// int j = 0, i = 0;
// for (i = l2 - 1,j = l1-1; i >= 0; i-- , j--) {
// sum = arr1[j] + arr2[i] + c;
// arr3[j] = sum % 10;
// c = sum / 10;
// }
// for (int rem = j; rem >= 0; rem--) {
// sum = arr1[rem] + c;
// arr3[j] = sum % 10;
// c = sum / 10;
// }
// } else {
// for (int i = l1 - 1, j = l3 - 1; j > 0; i--, j--) {
// sum = arr1[i] + arr2[i] + c;
// arr3[j] = sum % 10;
// c = sum / 10;
// }
// }
// for (int i = 0; i < l3; i++) {
// System.out.print(arr3[i] + " ");
// }
//
// }
// }