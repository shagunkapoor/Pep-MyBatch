
public class BPrintNQueensSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = new boolean[4][4];
		printNqueensSS(board, 1, 0, "");

	}

	public static void printNqueensSS(boolean[][] board, int bno, int qpsf, String csf) {
		if (qpsf == board.length) {
			System.out.println(csf);
			return;
		}
		if (bno > board.length * board.length) {
			return;
		}

		printNqueensSS(board, bno + 1, qpsf, csf);

		int r = (bno - 1) / board.length;
		int c = (bno - 1) % board.length;

		if (board[r][c] == false && isQueenSafe(board, r, c) == true) {
			board[r][c] = true;
			printNqueensSS(board, bno + 1, qpsf + 1, csf + "#" + bno);
			board[r][c] = false;
		}

	}

	public static boolean isQueenSafe(boolean[][] board, int r, int c) {
		int[][] dirs = { { -1, 0 }, // n
				{ -1, +1 }, // ne
				{ 0, +1 }, // e
				{ +1, +1 }, // se
				{ +1, 0 }, // s
				{ +1, -1 }, // sw
				{ 0, -1 }, // w
				{ -1, -1 } // nw
		};
		for (int rad = 1; rad < board.length; rad++) {
			for (int direction = 0; direction < dirs.length; direction++) {
				int renemy = r + rad * (dirs[direction][0]);
				int cenemy = c + rad * (dirs[direction][1]);
				if (renemy >= 0 && cenemy >= 0 && renemy < board.length && cenemy < board.length
						&& board[renemy][cenemy] == true) {
					return false;
				}
			}
		}
		return true;
	}

}
