
public class EPrintMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		maze(0, 0, 2, 2, "");
	}

	public static void maze(int sr, int sc, int dr, int dc, String ans) {

		if (sr == dr && sc == dc) {
			System.out.println(ans);
			return;
		}
		if(sr>dr || sc>dc){
			return;
		}
		
		maze(sr,sc+1,dr,dc,ans+"H");
		maze(sr+1,sc,dr,dc,ans+"V");
		
	}
}
