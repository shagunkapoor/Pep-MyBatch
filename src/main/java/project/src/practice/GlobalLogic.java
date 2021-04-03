package practice;

import java.util.HashSet;
import java.util.PriorityQueue;

public class GlobalLogic {

	public static void main(String[] args) {
		// Q1
		// Number System - Given n&k, find the lexicographically shortest string
		// of size n that sum up to k ( a=1,b=2..)
		// String ns=numberSystem(5,42); //n,k
		String ns = numberSystem(3, 25);
		System.out.println(ns);
		// Ways to Print Character Array as a String
		// char[] arr=ns.toCharArray();
		// System.out.println(String.valueOf(arr));
		// System.out.println(arr);

		// Q2
		// Shortest Distance - Travel from 1 to all vertices and after that go
		// back to kth position and then to 1
		int[][] distance = { { 0, 1, 15, 6 }, { 2, 0, 7, 3 }, { 9, 6, 0, 12 }, { 10, 4, 8, 0 } };
		int sd = shortestDistance(4, 2, distance); // n=total destinations,
													// k=place at which some
													// work is missed
		System.out.println(sd);
		// 1->2->4->3->2->1

		// Q3
		// Division - Given 3 no. a,b,c, find the max. no.<=c, such that the
		// remainder on dividing num by a is equal to b
		int d = division(3, 2, 9);
		// int d=division(1,2,4);
		System.out.println(d);

	}

	public static String numberSystem(int n, int k) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append('a');
		}
		return nsHelper(n, k, n, sb, n - 1);

	}

	private static String nsHelper(int n, int k, int sum, StringBuilder sb, int i) {
		if (sum == k) {
			return sb.toString();
		}

		if (sum < k) {
			char rem = sb.charAt(i);
			sb.deleteCharAt(i);
			sum -= (rem - 'a' + 1);
			int diff = k - sum;
			if (diff >= 26) {
				sb.insert(i, 'z');
				sum += 26;
			} else {
				sb.insert(i, (char) (diff + 'a' - 1));
				sum += diff;
			}
		}
		return nsHelper(n, k, sum, sb, i - 1);

	}

	static HashSet<Integer> visited = new HashSet<>();

	public static int shortestDistance(int n, int k, int[][] distance) {
		int res = 0;
		int src = 1;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, src + "", 0));
		int last = 0;
		while (pq.size() > 0) {
			Pair rem = pq.remove();

			if (visited.contains(rem.v)) {
				continue;
			} else {
				visited.add(rem.v);
				if (visited.size() == n) {
					last = rem.v;
				}
			}
			res += rem.d;

			int min = Integer.MAX_VALUE, indx = 0;
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (distance[rem.v - 1][i] != 0 && visited.contains(i + 1) == false) {
					if (distance[rem.v - 1][i] < min) {
						min = distance[rem.v - 1][i];
						indx = i;
						flag = true;
					}
				}

			}
			if (flag == true) {
				pq.add(new Pair(indx + 1, rem.p + (indx + 1), min));
			}

		}

		res += distance[last - 1][k - 1] + distance[k - 1][0];

		return res;
	}

	public static class Pair implements Comparable<Pair> {
		int v;
		String p;
		int d;

		public Pair(int v, String p, int d) {
			this.v = v;
			this.p = p;
			this.d = d;
		}

		public int compareTo(Pair o) {
			return this.d - o.d;
		}
	}

	public static int division(int a, int b, int c) {
		int res = c;
		if (b >= a) {
			return -1;
		}

		for (int i = 0; i < a; i++) {
			if (res % a == b) {
				return res;
			} else {
				res--;
			}

		}

		return res;
	}
}
