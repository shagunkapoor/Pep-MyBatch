package Hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class Rec37Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = scn.nextLine();
		int cnt = countsubseq(s, "");
		System.out.println(cnt);
		ArrayList<String> list = new ArrayList<>();
		list = returnsubseq(s);
		System.out.println(list);
		printsubseq(s, "");

	}

	static int count = 0;

	public static int countsubseq(String ques, String ans) {
		if (ques.length() == 0) {
			count++;
			// System.out.println(ans);
			return 0;
		}
		char ch = ques.charAt(0);
		String rem = ques.substring(1);

		countsubseq(rem, ans + ch);
		countsubseq(rem, ans + "");

		return count;
	}

	public static ArrayList<String> returnsubseq(String str) {
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		char ch = str.charAt(0);
		String rem = str.substring(1);
		ArrayList<String> list = returnsubseq(rem);
		ArrayList<String> result = new ArrayList<>();
		for (String val : list) {
			result.add("" + val);
			result.add(ch + val);
		}

		return result;

	}

	public static void printsubseq(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String rem = ques.substring(1);

		printsubseq(rem, ans + "");
		printsubseq(rem, ans + ch);
	}

}
