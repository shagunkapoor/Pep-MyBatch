package project.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Board Path
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the board size");
		int n = scn.nextInt();
		System.out.println("Enter the number of faces of dice");
		int m = scn.nextInt();
		boardpath(n, m, 0);

	}

	// Take as input N, a number. N is the size of a snakes and ladder board
	// (without
	// any snakes and ladders).
	// 2.Take as input M, a number. M is the number of faces of the dice.

	public static void boardpath(int n, int dice, int src, int dest) {
		ArrayList<String> al = new ArrayList<>();
		for (int i = 1; i <= dice; i++) {
			int inter = src + dice;

		}
		String interdestpath = boardpath(n, dice, inter, n);

	}
}