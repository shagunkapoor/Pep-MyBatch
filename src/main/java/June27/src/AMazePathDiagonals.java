
public class AMazePathDiagonals {

	public static void main(String[] args) {

		mazepathdiag(0,0,2,2,"");
	}
	public static void mazepathdiag(int sr, int sc, int dr, int dc, String ans){
		
		if(sr==dr && sc==dc){
			System.out.println(ans);
			return;
		}
		if(sr>dr || sc>dc){
			return;
		}
		
		mazepathdiag(sr,sc+1,dr,dr,ans+"H");
		mazepathdiag(sr+1, sc, dr, dc, ans+"V");
		mazepathdiag(sr+1, sc+1, dr, dc, ans+"D");
	}

}
