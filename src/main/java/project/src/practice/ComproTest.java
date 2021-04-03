package practice;

import java.util.ArrayList;
import java.util.HashMap;

public class ComproTest {

	public static void main(String[] args) {

		String str = "ABcdaulPsabAuUlbausarruJHuabBBaaslruCD";
		String findstr = "Bulbasaur";
		// String str="ABCdbalbasau";
		// String str="ABcdefgefg";
		// String findstr="BBeeggff";
	//	bulbasaur(str, findstr);

		int[][] arr = { { 0, 0, 0, 1, 5 }, { 5, 5, 1, 5, 5 }, { 0, 0, 1, 5, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		int x=twodmatrix(arr, 0, 0, 0);
		System.out.println(x);
	}

	public static void bulbasaur(String str, String findstr) {

		boolean flag = false;
		int cnt = 0;
		HashMap<Character, Integer> hmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);

			// if (ch == 'B' || ch == 'u' || ch == 'l' || ch == 'b' || ch == 'a'
			// || ch == 's' || ch == 'r') {
			hmap.put(ch, hmap.containsKey(ch) ? hmap.get(ch) + 1 : 1);
		}

		HashMap<Character, Integer> fmap = new HashMap<>();

		for (int i = 0; i < findstr.length(); i++) {
			Character c = findstr.charAt(i);
			fmap.put(c, fmap.containsKey(c) ? fmap.get(c) + 1 : 1);
		}

		ArrayList<Character> strkeys = new ArrayList<>(hmap.keySet());
		ArrayList<Character> findstrkeys = new ArrayList<>(fmap.keySet());

		while (true) {
			for (int i = 0; i < findstrkeys.size(); i++) {
				if (strkeys.contains(findstrkeys.get(i))
						&& hmap.get(findstrkeys.get(i)) >= fmap.get(findstrkeys.get(i))) {
					flag = true;
					hmap.put(findstrkeys.get(i), hmap.get(findstrkeys.get(i)) - fmap.get(findstrkeys.get(i)));
				} else {
					flag = false;
					break;
				}
			}

			if (flag == true) {
				cnt++;
			} else {
				break;
			}
		}

		System.out.println(cnt);

	}

	public static int twodmatrix(int[][] arr, int i, int j, int cnt) {

		if ( i > (arr.length - 1) || j > (arr[0].length - 1)||arr[i][j] == 5 ) {
			return cnt;
		}
		if (arr[i][j] == 1) {
			cnt++;
		}
				
		int lc = twodmatrix(arr, i, j + 1, cnt);
		int rc = twodmatrix(arr, i + 1, j, cnt);

		return Math.max(lc, rc);
	}

}
