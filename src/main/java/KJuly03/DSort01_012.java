package KJuly03;

import java.util.Scanner;

public class DSort01_012 {

	//O(n)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = { 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1 };
		sort01(arr1);
		System.out.println();
		System.out.println("*********************");
		int[] arr2 = { 0, 0, 2, 1, 1, 0, 1, 1, 0, 2, 0, 1, 0, 1, 2, 1 };
		sort012(arr2);
	}

	public static void sort01(int[] arr) {
		int i = 0;
		int z = 0;
		while (i < arr.length) {
			if (arr[i] == 1) {
				i++;
			} else {
				swap(arr, i, z);
				i++;
				z++;
			}
		}
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + " ");
		}
	}

	public static void sort012(int[] arr) {
		int i = 0;
		int z = 0;
		int t = arr.length - 1;
		while (i <= t) {
			if (arr[i] == 1) {
				i++;
			} else if (arr[i] == 0) {
				swap(arr, i, z);
				i++;
				z++;
			} else if (arr[i] == 2) {
				swap(arr, i, t);
				t--;
			}
		}
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + " ");
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

// OR
// 0101010101010101
// Scanner scn = new Scanner(System.in);
// System.out.println("Enter the no. of test cases");
// int t = scn.nextInt();
// for (int i = 0; i < t; i++) {
// System.out.println("Enter the array size");
// int n = scn.nextInt();
// int[] arr = new int[n];
// System.out.println("Enter the array elements");
// for (int x = 0; x < n; x++) {
// arr[x] = scn.nextInt();
// }
// int itr = 0;
// int z = 0;
//
// while (itr < arr.length) {
// if (arr[itr] == 1) {
// itr++;
// } else {
// int temp = arr[itr];
// arr[itr] = arr[z];
// arr[z] = temp;
// itr++;
// z++;
// }
// }
//
// for (int a = 0; a < arr.length; a++) {
// System.out.print(arr[a] + " ");
// }
// }
// }
// }

// 012012012012
// Scanner scn=new Scanner(System.in);
// System.out.println("Enter the no. of test cases");
// int t=scn.nextInt();
// for(int i=0;i<t;i++){
// System.out.println("Enter the size of array");
// int n=scn.nextInt();
// int[] arr=new int[n];
// System.out.println("Enter the array elements");
// for(int x=0;x<n;x++){
// arr[x]=scn.nextInt();
// }
// int itr=0; int z=0;
// int tw=n-1;
//
// while(itr<=tw){
//
// if(arr[itr]==0){
// int temp=arr[itr];
// arr[itr]=arr[z];
// arr[z]=temp;
// z++;
// itr++;
// }else if(arr[itr]==1){
// itr++;
// }else if(arr[itr]==2){
// int temp2=arr[itr];
// arr[itr]=arr[tw];
// arr[tw]=temp2;
// tw--;
// }
// }
// for(int a=0;a<n;a++){
// System.out.print(arr[a]+" ");
// }
// System.out.println();
// }
// }
// }
//
