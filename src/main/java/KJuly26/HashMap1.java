package KJuly26;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMap1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabrakadabra";
		highestFreqCharacter(s);
		System.out.println("*************");
		int[] one = { 5, 1, 2, 3, 1, 1, 2 };
		int[] two = { 1, 2, 4, 2, 5, 2, 1 };
//		System.out.println("Common Elements 1");
//		getCommonElements1(one, two);
//		System.out.println();
		System.out.println("Common Elements 2");
		getCommonElements2(one, two);
//		System.out.println();
//		System.out.println("Longest Consecutive Element's Sequence");
//		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
//		longestConsecutiveElements(arr);
		String str = "aabbcaabdaacbbcdaac";
//		System.out.println();
		smallestSubstringWithUniqueChars(str);

	}

	public static void highestFreqCharacter(String s) {
		HashMap<Character, Integer> hmap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (hmap.containsKey(ch)) {
				hmap.put(ch, hmap.get(ch) + 1);

			} else {
				hmap.put(ch, 1);
			}
		}
		ArrayList<Character> allkeys = new ArrayList<>(hmap.keySet());
		char maxfc = allkeys.get(0);
		for (Character key : allkeys) {
			if (hmap.get(maxfc) < hmap.get(key)) {
				maxfc = key;
			}
		}
		System.out.println(hmap);
		System.out.println(maxfc + " " + hmap.get(maxfc));
	}

	public static void getCommonElements1(int[] one, int[] two) {
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0, j = 0; i < one.length || j < two.length; i++, j++) {
			hmap.put(one[i], hmap.containsKey(one[i]) ? hmap.get(one[i]) + 1 : 1);
			hmap.put(two[j], hmap.containsKey(two[j]) ? hmap.get(two[j]) + 1 : 1);
		}
		ArrayList<Integer> commonelts = new ArrayList<>(hmap.keySet());
		for (Integer key : commonelts) {
			if (hmap.get(key) > 1) {
				System.out.print(key + " ");
			}
		}
	}
	// public static void getCommonElements1(int[] one, int[] two){
	// LAug18.HashMap<Integer, Integer> hmap=new LAug18.HashMap<>();
	// for(int val:one){
	// hmap.put(val, hmap.containsKey(val)? hmap.get(val)+1:1);
	// }
	// for(int val:two){
	// if(hmap.containsKey(val)){
	// System.out.print(val+" ");
	// hmap.remove(val);
	// }
	// }
	// }

	public static void getCommonElements2(int[] one, int[] two) {
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int val : one) {
			hmap.put(val, hmap.containsKey(val) ? hmap.get(val) + 1 : 1);
		}
		for (int val : two) {
			if (hmap.containsKey(val) && hmap.get(val) > 0) {
				System.out.print(val + " ");
				hmap.put(val, hmap.get(val) - 1);
			}
		}

	}

	public static void longestConsecutiveElements(int[] arr) {
		HashMap<Integer, Boolean> hmap = new HashMap<>();

		for (int val : arr) {
			hmap.put(val, true);
		}
		for (int val : arr) {
			if (hmap.containsKey(val + 1)) {
				hmap.put(val + 1, false);
			}
		}
		int mseqsp = 0;
		int mseqlen = 0;
		for (int val : arr) {
			if (hmap.get(val) == true) {
				int cseqsp = val;
				int cseqlen = 1;

				while (hmap.containsKey(cseqsp + cseqlen)) {
					cseqlen++;
				}
				if (cseqlen > mseqlen) {
					mseqlen = cseqlen;
					mseqsp = cseqsp;
				}
			}

		}
		for (int i = mseqsp; i < mseqsp + mseqlen; i++) {
			System.out.print(i + " ");
		}
	}

	public static void smallestSubstringWithUniqueChars(String s) {
		HashMap<Character, Integer> hmap = new HashMap<>();
		HashMap<Character, Integer> temphmap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			hmap.put(ch, hmap.containsKey(ch) ? hmap.get(ch) + 1 : 1);
		}
		int csp = 0;
		int cep = 0;
		String shortest = s;

		while (csp < s.length() && cep < s.length()) {

			if (temphmap.size() < hmap.size()) {
				temphmap.put(s.charAt(cep), temphmap.containsKey(s.charAt(cep)) ? temphmap.get(s.charAt(cep)) + 1 : 1);
				cep++;
			} else {
				temphmap.put(s.charAt(csp), temphmap.get(s.charAt(csp)) - 1);
				
				if (temphmap.get(s.charAt(csp)) == 0) {
					temphmap.remove(s.charAt(csp));
				}
				csp++;
			}
			if (temphmap.size() == hmap.size()) {
				String ans = s.substring(csp, cep);
				if (shortest.length() > ans.length()) {
					shortest = ans;
				}
			}
		}

		System.out.println(shortest);

	}
}