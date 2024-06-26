package project.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MobStacTest {

	public static void main(String[] args) {
		// Matrix colouring
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String s = scn.next();
		int c = colouringspossible(s, n);
		int m = Integer.parseInt(scn.next());
		for (int i = 0; i < m; i++) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			int res = matrixcolourings(c, s, n, x - 1, y - 1);
			System.out.println(res);
		}
	}

	private static int colouringspossible(String s, int n) {
		HashMap<Character, Integer> hmap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			hmap.put(ch, hmap.containsKey(ch) ? hmap.get(ch) + 1 : 1);
		}

		ArrayList<Character> allkeys = new ArrayList<>(hmap.keySet());

		return allkeys.size();
	}

	private static int matrixcolourings(int c, String str, int n, int x, int y) {
		int m = 1000000007;

		String substrindexedwithx = str.substring(x);
		String substrindextedwithy = str.substring(y);

		int A = lcp(substrindexedwithx, str);
		int B = lcp(substrindextedwithy, str);

		int row = A;
		int col = ((int) Math.pow(A, B))%m;

		int rowcol = row * col;

		int maxcoloringspossible = ((int) Math.pow(c, rowcol))%m;
		return maxcoloringspossible;

	}

	private static int lcp(String str1, String str2) { // longest common prefix
		String small = str1.length() > str2.length() ? str2 : str1;
		String large = str1.length() > str2.length() ? str1 : str2;

		int indx = 0;
		for (char c : large.toCharArray()) {

			if (indx == small.length()) {
				break;
			}
			if (c != small.charAt(indx)) {
				break;
			}
			indx++;
		}

		return indx;
/*
		// if we want to return lcp string then,
		if (indx == 0) {
			return 0;
		} else {
			System.out.println("lcp"+large.substring(0,indx));
			return large.substring(0, indx).length();
		}
*/
	}

}
