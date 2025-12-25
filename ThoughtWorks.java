package project.practice;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ThoughtWorks {

	public static void main(String[] args) {

		int n = scn.nextInt();
		while (n-- > 0) {
			solve();
		}

	}

	private static Scanner scn = new Scanner(System.in);

	private static void solve() {

		int n = scn.nextInt();

		PriorityQueue<pair> que = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(scn.next());
			String s = scn.next();

			pair p = new pair();
			p.num = x;
			p.str = s;
			
			que.add(p);

		}

		System.out.println(ans(que));

	}

	private static class pair implements Comparable<pair> {
		int num;
		String str;

		@Override
		public int compareTo(pair o) {

			if (this.num != o.num) {
				return this.num - o.num;
			} else {
				for (int i = 0; i < this.str.length() && i < o.str.length(); i++) {
					int num = this.str.charAt(i) - o.str.charAt(i);
					if (num < 0) {
						return -1;
					} else if (num > 0) {
						return 1;
					}
				}
			}

			return this.str.length() - o.str.length();
		}
	}

	private static String ans(PriorityQueue<pair> que) {

		while (que.size() != 1) {
			pair p1 = que.remove();
			pair p2 = que.remove();

			pair p = new pair();
			p.num = p1.num + p2.num;
			p.str = p1.str + " " + p2.str;

			que.add(p);
		}

		return que.remove().str;

	}



public static int solve2(int[] arr, int indx, int val) {
	int[] temp = new int[arr.length];
	for (int i = 0; i < arr.length; i++) {
		temp[i] = arr[i];
	}

	temp[indx - 1] = val;

	int[] lis = new int[temp.length];
	// lis[0]=1;
	for (int i = 0; i < temp.length; i++) {
		lis[i] = 1;
		for (int j = i - 1; j >= 0; j--) {
			if (temp[i] > temp[j]) {
				lis[i] = Math.max(lis[i], lis[j] + 1);
			}
		}
	}

	int liscnt = Integer.MIN_VALUE;
	for (int i = 0; i < lis.length; i++) {
		liscnt = Math.max(liscnt, lis[i]);
	}

	return liscnt;
}
}

