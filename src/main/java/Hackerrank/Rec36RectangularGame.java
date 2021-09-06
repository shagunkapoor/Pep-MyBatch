package Hackerrank;

import java.util.Arrays;
import java.util.Scanner;

//You are given an infinite 2-d grid with the bottom left cell referenced as
//(1,1). All the cells contain a value of zero initially. Let's play a game?
//
//The game consists of N steps wherein each step you are given two integers a and
//b. The value of each of the cells in the co-ordinate (u, v) satisfying
//1 ≤ u ≤ a and 1 ≤ v ≤ b, is increased by 1. After N such steps, if X is the
//largest number amongst all the cells in the rectangular board, can you print
//the number of X's in the board?
//
//Example(To be used only for expected output):
//Input:
//3
//2 3
//3 7
//4 1
//output
//2
//
//Explanation
//
//Assume that the following board corresponds to cells (i, j) where 1 ≤ i ≤ 4
//and 1 ≤ j ≤ 7.
//
//At the beginning board is in the following state:
//
//0 0 0 0 0 0 0
//0 0 0 0 0 0 0
//0 0 0 0 0 0 0
//0 0 0 0 0 0 0
//After the first step we will obtain:
//
//0 0 0 0 0 0 0
//0 0 0 0 0 0 0
//1 1 1 0 0 0 0
//1 1 1 0 0 0 0
//After the second step we will obtain:
//
//0 0 0 0 0 0 0
//1 1 1 1 1 1 1
//2 2 2 1 1 1 1
//2 2 2 1 1 1 1
//Finally, after the last step we will obtain:
//
//1 0 0 0 0 0 0
//2 1 1 1 1 1 1
//3 2 2 1 1 1 1
//3 2 2 1 1 1 1
//So, the maximum number is 3 and there are exactly two cells which correspond
//to 3. Hence 2.
public class Rec36RectangularGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of lines to be followed");
		int n = scn.nextInt();
		System.out.println("Enter the values of a & b");
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
			b[i] = scn.nextInt();
		}
		int rmax = a[0];
		int cmax = b[0];
		for (int i = 0; i < n; i++) {
			if (rmax < a[i]) {
				rmax = a[i];
			}
			if (cmax < b[i]) {
				cmax = b[i];
			}
		}

		int[][] arr = new int[rmax][cmax];
		Arrays.fill(arr, 0);
		rectgame(n, a, b, rmax, cmax, arr);
	}

	public static void rectgame(int n, int[] a, int[] b, int i, int j, int[][] arr) {

//		if(vidx==arr.length){
			
//		}
	}

}
