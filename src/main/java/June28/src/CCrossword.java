import java.util.Scanner;

public class CCrossword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[][] box = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
//				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
//				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
//				{ '+', '-', '-', '-', '-', '-', '+', '+', '+', '+' },
//				{ '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
//				{ '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
//				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
//				{ '+', '+', '-', '-', '-', '-', '-', '-', '+', '+' },
//				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
//				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' } };
//
//		String[] words = { "DELHI", "ICELAND", "ANKARA", "LONDON" };
	//	 DELHI;ICELAND;ANKARA;LONDON
		
		
		//OR
		Scanner scn=new Scanner(System.in);
		char[][] box=new char[10][];
		for(int i=0;i<10;i++){
			box[i]=scn.nextLine().toCharArray();
		}
		String[] words=scn.nextLine().split(";");
				crossword(box, words, 0);

	}

	public static void crossword(char[][] box, String[] words, int vidx) {

		if (vidx == words.length) {
			for (int r = 0; r < box.length; r++) {
				for (int c = 0; c < box.length; c++) {
					System.out.print(box[r][c]);
				}
				System.out.println();
			}
			return;
		}
		boolean vert, horiz;
		// String word=words[vidx];
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if (box[i][j] == '-' || box[i][j] == words[vidx].charAt(0)) {
					if (canPlaceTheWordVertically(box, words[vidx], i, j)) {
						boolean[] reset = PlaceTheWordVertically(box, words[vidx], i, j);
						crossword(box, words, vidx + 1);
						UnplaceTheWordVertically(box, reset, i, j);
					}
					if (canPlaceTheWordHorizontally(box, words[vidx], i, j)) {
						boolean[] reset = PlaceTheWordHorizontally(box, words[vidx], i, j);
						crossword(box, words, vidx + 1);
						UnplaceTheWordHorizontally(box, reset, i, j);
					}
				}
			}
		}

	}

	public static boolean canPlaceTheWordVertically(char[][] box, String word, int r, int c) {
		for (int i = 0; i < word.length() ; i++) {
			if ((r + i) >=box.length) {
				return false;
			} else if (box[r + i][c] != '-' && box[r + i][c] != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean canPlaceTheWordHorizontally(char[][] box, String word, int r, int c) {
		for (int i = 0; i < word.length() ; i++) {
			if ((c + i) >= box.length) {
				return false;
			} else if (box[r][c + i] != '-' && box[r][c + i] != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean[] PlaceTheWordVertically(char[][] box, String word, int r, int c) {
		boolean[] res = new boolean[word.length()];
		for (int i = 0; i < word.length(); i++) {
			if (box[r + i][c] == word.charAt(i)) {
				res[i] = false;
			} else {
				box[r + i][c] = word.charAt(i);
				res[i] = true;
			}
		}
		return res;

	}

	public static boolean[] PlaceTheWordHorizontally(char[][] box, String word, int r, int c) {
		boolean[] res = new boolean[word.length()];
		for (int i = 0; i < word.length(); i++) {
			if (box[r][c + i] == word.charAt(i)) {
				res[i] = false;
			} else {
				box[r][c + i] = word.charAt(i);
				res[i] = true;
			}
		}
		return res;
	}

	public static void UnplaceTheWordVertically(char[][] box, boolean[] reset, int r, int c) {
		for (int i = 0; i < reset.length; i++) {
			if (reset[i] == true) {
				box[r + i][c] = '-';
			}
		}
	}

	public static void UnplaceTheWordHorizontally(char[][] box, boolean[] reset, int r, int c) {
		for (int i = 0; i < reset.length; i++) {
			if (reset[i] == true) {
				box[r][c + i] = '-';
			}
		}
	}

}
