package June29;

//Proactive Approach --->directly print the safe solutions
// //Reactive Approach --->will work for all combinations and then print the safe ones (Uses BoardSafe)
public class APrintNQueens2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = new boolean[4][4];
		printNqueensProactive(board, 0, "", 1);

		//printNqueensReactive(board, 0, "", 1);

	}

	public static void printNqueensProactive(boolean[][] board, int qpsf, String csf, int lqpb) {
		if (qpsf == board.length) {
			// if (isBoardSafe(board)) {
			System.out.println(csf);

			return;
		}
		for (int cno = lqpb + 1; cno <= board.length * board.length; cno++) {
			int ir = (cno - 1) / board.length;
			int ic = (cno - 1) % board.length;

			if (board[ir][ic] == false) {//no queen present
				if (isQueenSafe(board, ir, ic)) {
					board[ir][ic] = true;
					printNqueensProactive(board, qpsf + 1, csf + "#" + cno, cno);
					board[ir][ic] = false;
				}
			}
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
//REACTIVE
//
//public static void printNqueensReactive(boolean[][] board, int qpsf, String csf, int lqpb) {
//	if (qpsf == board.length) {
//		if (isBoardSafe(board)) {
//		System.out.println(csf);
//		}
//		return;
//	}
//	for (int cno = lqpb + 1; cno <= board.length * board.length; cno++) {
//		int ir = (cno - 1) / board.length;
//		int ic = (cno - 1) % board.length;
//
//		if (board[ir][ic] == false) {
//				board[ir][ic] = true;
//				printNqueensReactive(board, qpsf + 1, csf + "#" + cno, cno);
//				board[ir][ic] = false;
//			}
//		}
//	}
//
//
// public static boolean isBoardSafe(boolean[][] board) {
//
// for (int i = 0; i < board.length; i++) {
// for (int j = 0; j < board.length; j++) {
// if (board[i][j] == true) {
// if (isQueenSafe(board, i, j) == false) {
// return false;
// }
// }
// }
// }
// return true;
// }
//
//public static boolean isQueenSafe(boolean[][] board, int r, int c) {
//	int[][] dirs = { { -1, 0 }, // n
//			{ -1, +1 }, // ne
//			{ 0, +1 }, // e
//			{ +1, +1 }, // se
//			{ +1, 0 }, // s
//			{ +1, -1 }, // sw
//			{ 0, -1 }, // w
//			{ -1, -1 } // nw
//	};
//	for (int rad = 1; rad < board.length; rad++) {
//		for (int direction = 0; direction < dirs.length; direction++) {
//			int renemy = r + rad * (dirs[direction][0]);
//			int cenemy = c + rad * (dirs[direction][1]);
//			if (renemy >= 0 && cenemy >= 0 && renemy < board.length && cenemy < board.length
//					&& board[renemy][cenemy] == true) {
//				return false;
//			}
//		}
//	}
//	return true;
//}
//
//}