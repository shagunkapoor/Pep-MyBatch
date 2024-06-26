package June29;

import java.util.Scanner;

public class APrintNQueens {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = scn.nextInt();
		int tnq = n;
		boolean[][] board = new boolean[n][n];
		printNqueens(board, tnq, 0, 0, 0, "");
	}

	public static void printNqueens(boolean[][] board, int tnq, int i, int j, int qpsf, String csf) {

		if (qpsf == tnq) {
			System.out.println(csf);
			return;
		}

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] == false) {
					if (canPlaceQueen(board, r, c, false)) {
						printNqueens(board, tnq, r, c + 1, qpsf + 1, csf + "[" + r + "," + c + "]");
					}

				} else {
					printNqueens(board, tnq, r + 1, c, qpsf, csf);

				}
			}
		}

	}

	public static boolean canPlaceQueen(boolean[][] board, int r, int c, boolean result) {

		if (r > board.length || c > board[0].length || r < 0 || c < 0) {
			return false;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i][c] == false && (board[r][i] == false)) {
				result = true;
			}
			if ((r - i) >= 0 && (r + i) <= board.length && (c - i) >= 0 && (c + i) <= board.length) {
				if ((board[r - i][c - i] == false) && (board[r + i][c + i] == false)) {
					result = true;
				}
			}
			if ((r - i) >= 0 && (r + i) <= board.length && (c + i) >= 0 && (c - i) <= board.length) {
				if ((board[r - i][c + i] == false) && (board[r + i][c - i] == false)) {
					result = true;
				}
			}

		}
		return result;

	}
}
