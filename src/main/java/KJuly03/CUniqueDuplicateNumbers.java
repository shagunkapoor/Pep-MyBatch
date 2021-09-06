package KJuly03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CUniqueDuplicateNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = { 5, 9, 8, 7, 5, 7, 8 };
		System.out.println(uniquenumber(arr1));

		int[] arr2 = { 3, 1, 2, 4, 4, 6, 5 };
		System.out.println(duplicatenumber(arr2));

		int[] arr3 = { 1, 2, 1, 5, 6, 3 };
		System.out.println(checkduplicate(arr3));

		int[] arr4 = { 1, 5, 3, 4, 5, 6 };
		System.out.println(suspectedelt(arr4));
		
//		System.out.print(highest("abcbbbbaaa"));
	}

	public static int uniquenumber(int[] arr) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			num = num ^ arr[i];
		}
		return num;
	}

	public static int duplicatenumber(int[] arr) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			num = num ^ i ^ arr[i];
		}
		return num;
	}

	public static boolean checkduplicate(int[] arr) {
		Arrays.sort(arr);
		boolean val = false;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				val = true;
			}
		}

		return val;
	}

	public static int suspectedelt(int[] arr) {

		int[] fmap = new int[arr.length+1];
		Arrays.fill(fmap, 0);

		for (int i = 0; i < arr.length; i++) {
			int indx = arr[i];
			fmap[indx]++;
		}
		int max = 0;
		for (int x = 0; x < fmap.length; x++) {
			if (fmap[x] > fmap[max]) {
				max = x;
			}
		}
		return max;
	}
	
	
//	public static Character highest(String str){
//		LAug18.HashMap<Character, Integer> hmap=new LAug18.HashMap<>();
//		for(int i=0;i<str.length();i++){
//			char ch=str.charAt(i);
//			hmap.put(ch, hmap.containsKey(ch)?hmap.get(ch)+1:1);
//		}
//		
//		
//		ArrayList<Character> al=new ArrayList<>(hmap.keySet());
//		char res=al.get(0);
//		int max=hmap.get(al.get(0));
//		for(char key:al){
//			if(max<hmap.get(key)){
//				res=key;
//			}
//		}
//		return res;
//	}
}
