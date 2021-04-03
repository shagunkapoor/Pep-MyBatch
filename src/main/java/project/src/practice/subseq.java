package practice;

import java.util.Arrays;
import java.util.Scanner;

public class subseq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String str="abc";
		// printsubseq(str,"");
		// System.out.println("***********************************");

		// String str="145";
		// nokiakeypad(str,"");
		// System.out.println("***********************************");

		// String str = "aab";
		// permutations(str, "");
		// System.out.println("***********************************");

//		Scanner scn = new Scanner(System.in);
//		System.out.println("Enter the number of disks");
//		int n = scn.nextInt();
//		towerofhanoi("A", "B", "C", n);
//		System.out.println("***********************************");
		
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the array size");
		int n=scn.nextInt();
		System.out.println("Enter the array elements");
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		splittingintwogroup(arr,0,"",0,"",0);
		
	}

	public static void printsubseq(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String rem = ques.substring(1);
		int ascii = (int) ch;
		printsubseq(rem, ans + "");
		printsubseq(rem, ans + ch);
		printsubseq(rem, ans + ascii);
	}

	static String[] words = { "abc", "def", "ghi", "jk", "lmn", "opq", "rst", "uvw", "xyz" };

	public static void nokiakeypad(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String rem = ques.substring(1);

		String word = words[ch - '0'];
		// nokiakeypad(rem, ans+word);

		for (int i = 0; i < word.length(); i++) {
			nokiakeypad(rem, ans + word.charAt(i));
		}
	}

	public static void permutations(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		int[] arr = new int[26];
		Arrays.fill(arr, 1);
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String rem = ques.substring(0, i) + ques.substring(i + 1);

			if (arr[ch - 'a'] == 1) {
				arr[ch - 'a'] = 0;
				permutations(rem, ans + ch);

			}
		}
	}

	public static void towerofhanoi(String src, String destination, String helper, int n) {
		if (n == 0) {
			return;
		}
		towerofhanoi(src, helper, destination, n - 1);
		System.out.println("Move disk [" + (n - 1) + "] from " + src + " to " + destination);
		towerofhanoi(helper, destination, src, n - 1);

	}
	public static void splittingintwogroup(int[] arr, int vidx, String s1, int so1, String s2, int so2){ // Printing Equisets
		if(vidx>=arr.length){
			if(so1==so2){
				System.out.println(s1+" --- "+s2);
			}
			return;
		}
		
		splittingintwogroup(arr, vidx+1, s1+" "+arr[vidx], so1+arr[vidx], s2, so2);
		splittingintwogroup(arr, vidx+1, s1, so1, s2+" "+arr[vidx], so2+arr[vidx]);
	}
}
