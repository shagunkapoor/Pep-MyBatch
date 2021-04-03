
public class CPrintNKnights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = new boolean[3][3];
		printNknights(board, 0, 1, "");
	}

	static int cntr = 0;

	public static void printNknights(boolean[][] board, int kpsf, int bno, String csf) {

		if (kpsf == board.length) {
			cntr++;
			System.out.println(cntr + ". " + csf);
			return;
		}
		if (bno > board.length * board.length) {
			return;
		}
		printNknights(board, kpsf, bno + 1, csf);
		int r = (bno - 1) / board.length;
		int c = (bno - 1) % board.length;
		if (board[r][c] == false && isKnightSafe(board, r, c) == true) {
			board[r][c] = true;
			printNknights(board, kpsf + 1, bno + 1, csf + "#" + bno);
			board[r][c] = false;
		}

	}

	public static boolean isKnightSafe(boolean[][] board, int r, int c) {
		int[][] dirs = { { -2, 0 }, // n
				{ -2, +2 }, // ne
				{ 0, +2 }, // e
				{ +2, +2 }, // se
				{ +2, 0 }, // s
				{ +2, -2 }, // sw
				{ 0, -2 }, // w
				{ -2, -2 } // nw
		};
		for (int direction = 0; direction < dirs.length; direction++) {
			int renemy = r + (dirs[direction][0]);
			int cenemy = c + (dirs[direction][1]);
			if (renemy >= 0 && cenemy >= 0 && renemy < board.length && cenemy < board.length
					&& board[renemy][cenemy] == true) {
				return false;
			}
		}
		return true;
	}
}
