package Oct1_Subseq;

public class CRecursion_PlaceNQueens {

	public static void main(String[] args) {

//		 boolean[] boxes = new boolean[4];
//		 printCombinations(boxes, 2, 0, -1, "");
//		 printCombinations2(boxes, 2, 0, 0, "");
//
//		boolean[][] boxes2D = new boolean[4][4];
//		placeNQueens(boxes2D, 4, 0, 1, "");
		boolean[][] boxes2DK=new boolean[3][3];
		placeNKnights(boxes2DK, 4, 0, 1, "");
	}

	public static void printPermutations() {

	}

	public static void printCombinations(boolean[] boxes, int tq, int q, int pqb, String asf) {
		if (q == tq) {
			System.out.println(asf);
			return;
		}

		for (int i = pqb + 1; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				printCombinations(boxes, tq, q + 1, i, asf + "q" + q + "b" + i + " ");
				boxes[i] = false;
			}
		}

	}

	public static void printCombinations2(boolean[] boxes, int tq, int cq, int cb, String asf) {

		if (cq == tq) {
			System.out.println(asf);
			return;
		}

		if (cb == boxes.length) {
			return;
		}

		printCombinations2(boxes, tq, cq, cb + 1, asf);
		if (boxes[cb] == false) {
			boxes[cb] = true;
			printCombinations2(boxes, tq, cq + 1, cb + 1, asf + "q" + cq + "b" + cb + " ");
			boxes[cb] = false;
		}
	}

	public static void placeNQueens(boolean[][] boxes, int tq, int cq, int bno, String asf) {

		if (cq == tq) {
			if (isBoardValid(boxes)) {
				System.out.println(asf);
			}
			return;
		}

		if (bno == boxes.length * boxes.length + 1) {
			return;
		}

		placeNQueens(boxes, tq, cq, bno + 1, asf);
		int row = (bno - 1) / boxes.length;
		int col = (bno - 1) % boxes.length;
		if (boxes[row][col] == false) {
			boxes[row][col] = true;
			placeNQueens(boxes, tq, cq + 1, bno + 1, asf + bno + "-");
			boxes[row][col] = false;
		}

	}

	public static boolean isBoardValid(boolean[][] boxes) {

		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < boxes.length; j++) {
				if (boxes[i][j] == true) {
					if (isQueenSafe(boxes, i, j) == false) {
						return false;
					}
				}
			}
		}
		return true;
	}

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

	public static boolean isQueenSafe(boolean[][] boxes, int crow, int ccol) {
		for (int rad = 1; rad < boxes.length; rad++) {
			for (int d = 0; d < dir.length; d++) {
				int r = crow + rad * dir[d][0];
				int c = ccol + rad * dir[d][1];

				if (r >= 0 && r < boxes.length && c >= 0 && c < boxes.length && boxes[r][c] == true) {
					return false;
				}
			}
		}
		return true;
	}

	public static void placeNKnights(boolean[][] boxes, int tk, int ck, int bno, String asf) {
		if (ck == tk) {
			if (isBoardValidK(boxes))
				System.out.println(asf);
			return;
		}
		if (bno == boxes.length * boxes.length + 1) {
			return;
		}

		placeNKnights(boxes, tk, ck, bno + 1, asf);
		int row = (bno - 1) / boxes.length;
		int col = (bno - 1) % boxes.length;
		if (boxes[row][col] == false) {
			boxes[row][col] = true;
			placeNKnights(boxes, tk, ck + 1, bno + 1, asf + bno + "-");
			boxes[row][col] = false;
		}

	}

	public static boolean isBoardValidK(boolean[][] boxes) {
		for(int i=0;i<boxes.length;i++){
			for(int j=0;j<boxes.length;j++){
				if(boxes[i][j]==true && isKnightSafe(boxes,i,j)==false){
					return false;
				}
			}
		}
		
		return true;
	}

	public static boolean isKnightSafe(boolean[][] boxes, int i, int j) {
		int[][] dir={{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-1,-2}};
		
		for(int d=0;d<dir.length;d++){
			int r = i + dir[d][0];
			int c = j + dir[d][1];
			if(r>=0 && c>=0 && r<boxes.length && c<boxes.length && boxes[r][c]==true){
				return false;
			}
		}
		
		return true;
	}
	
	public static void Laxicographical(int n){
		for(int i=1;i<n  ;i++){
			
		}
	}

}
