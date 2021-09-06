import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Rec46_BoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the board length and faces of dice");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[n][n];
		int count = countways(0, 0, n - 1, n - 1, "", m, arr);
		boardpath(n, m);

	}

	static int cnt = 0;

	public static int countways(int sr, int sc, int dr, int dc,String path,int m, int[][] arr){
		
		if(sr==dr && sc==dc){
			cnt++;
			return cnt;
		}
		
		countways(sr+dice, sc+dice, dr, dc, path+"arr[i", m, arr)
		
		for(int dice=1;dice<=m;dice++){
			
		}
	}

	public static ArrayList<String> returnpaths(int src, int dest, int[][] arr, int m) {
		if (src == dest) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}

		ArrayList<String> totalpaths = new ArrayList<>();
		for (int dice = 1; dice <= m; dice++) {
			int inter = src + dice;
			ArrayList<String> intertodestpath = new ArrayList<>();
			intertodestpath = returnpaths(inter, dest, arr, m);

			for (String interpath : intertodestpath) {
				String srcpath = dice + interpath;
				totalpaths.add(srcpath);

			}
		}
	}
}
