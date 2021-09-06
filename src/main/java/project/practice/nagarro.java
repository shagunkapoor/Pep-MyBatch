package project.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class nagarro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter");
//		Scanner scn = new Scanner(System.in);
//
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = scn.nextInt();
//		}
//
//		int[] res = new int[n];
//		res = construct(n, arr);
//		for (int i = 0; i < n; i++) {
//			System.out.println(res[i]);
//		}
//		//System.out.println(res);
//	}

//	private static int[] construct(int n, int[] arr) {
//		int[] useful = new int[n];
//		Arrays.fill(useful, Integer.MAX_VALUE);
//		int resultcounter=0;
//		int[] result = new int[n];
////		for (int i = 0; i < n; i++) {
////			useful[i] = arr[i];
////		}
////		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
////		for (int i = 0; i < n; i++)
////			pq.add(arr[i]);
//		
////		result[resultcounter]=pq.peek();
//		int grp=1;
//		while (grp<=n) {
//			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//			for(int i=0;i<=n-grp;i++)
//			{
//				useful[i]=Math.min(useful[i],arr[i+grp-1]);
//				pq.add(useful[i]);
//			}
//			//System.out.println(pq.peek());
//			result[resultcounter]=pq.peek();
//			resultcounter++;
//			grp++;
//		}
//
//		return result;
//
//	}

	
//	import java.util.*;
//
//	public class Solution {

//	        static Scanner scn = new Scanner(System.in);
//
//	        public static void main(String[] args) {
	                Scanner scn = new Scanner(System.in);
	                String str = scn.next();
	                printAllPossibleCode(str, "");
	                System.out.println(count);
	                // Code(str, "");
	        }
					static int count=0;
	        public static void printAllPossibleCode(String ques, String ans) {

	                if (ques.length() == 0) {
	                        count++;
	                        return;
	                }

	                String s1 = ques.substring(0, 1);
	                int num1 = Integer.parseInt(s1);
	                String roq1 = ques.substring(1);

	                if (num1 >= 1) {
	                        char ch = (char) (num1 - 1 + 'a');
	                        printAllPossibleCode(roq1, ans + ch);
	                } else {
	                        printAllPossibleCode(roq1, ans);
	                }

	                if (ques.length() > 1) {
	                        String s2 = ques.substring(0, 2);
	                        int num2 = Integer.parseInt(s2);
	                        String roq2 = ques.substring(2);

	                        if (num2 >= 10 && num2 <= 26) {
	                                char ch = (char) (num2 - 1 + 'a');
	                                printAllPossibleCode(roq2, ans + ch);
	                        }
	                }
	        }
}
//	        private static void Code(String str, String ans) {
//	                if (str.length() == 0) {
//	                        System.out.println(ans + " ");
//	                        return;
//	                }
//
//	                char ch = str.charAt(0);
//	                int numOneLength = ch - '1';
//
//	                if (numOneLength >= 0) {
//	                        Code(str.substring(1), ans + (char) (numOneLength + 'a'));
//	                } else {
//	                        Code(str.substring(1), ans);
//	                }
//
//	                if (str.length() >= 2) {
//	                        String len2Str = str.substring(0, 2);
//	                        int numtwoleng = Integer.parseInt(len2Str);
//	                        if (numtwoleng > 9 && numtwoleng < 27) {
//	                                Code(str.substring(2), ans + (char) (numtwoleng - 1 + 'a'));
//	                        }
//	                }
//
//	        }
//
//	}

