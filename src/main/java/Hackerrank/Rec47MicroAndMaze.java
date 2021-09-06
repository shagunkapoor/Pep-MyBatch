import java.util.Scanner;

//Micro just bought a maze, that can be represented as a matrix A of size N×M, 
//where rows are numbered from 1 to N and columns are numbered from 1 to M. Each
//cell of the matrix can be either 0 or 1. If a cell is 0 that means it cannot 
//be visited and if it is 1, then it can be visited. Allowed moves are up, down,
//left and right. Help Micro to find out if he can reach from the cell (1,1) to 
//the cell (N,M), it is guaranteed that the cells (1,1) and (N,M) have value 1.
//
//input:
//3 3
//1 0 1
//1 0 0
//1 1 1
//
//Output
//Yes
public class Rec47MicroAndMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of maze");
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		System.out.println("Enter maze elements");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		checkpath(arr, n, 1, 1, "");
	}

	public static void checkpath(int[][] arr, int n, int row, int col, String path) {
		if (row < 1 || row > n || col < 1 || col > n) {
			return;
		}
		if (row == n && col == n) {
			if (path.isEmpty()) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		}
		if (arr[row][col] == 0) {
			return;
		}else{
		checkpath(arr, n, row + 1, col, path + 'D');
		checkpath(arr, n, row, col + 1, path + 'R');
		checkpath(arr, n, row - 1, col, path + 'T');
		checkpath(arr, n, row, col - 1, path + 'L');
		}
	}

}
