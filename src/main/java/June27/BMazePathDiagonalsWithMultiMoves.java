package June27;

public class BMazePathDiagonalsWithMultiMoves {

	public static void main(String[] args) {

		mazepathdiagwithmoves(0,0,2,2,"");

	}
	public static void mazepathdiagwithmoves(int sr,int sc,int dr,int dc,String ans){
		if(sr==dr && sc==dc){
			System.out.println(ans);
			return;
		}
		
		if(sr>dr || sc>dc){
			return;
		}
		
		for(int i=1;i<=dr;i++){
			int path=sr+i;
			if(path<=dr)
			mazepathdiagwithmoves(path, sc, dr, dc, ans+"V"+i);
		}
		for(int j=1;j<=dc;j++){
			int path=sc+j;
			if(path<=dc)
			mazepathdiagwithmoves(sr, path, dr, dc, ans+"H"+j);
		}
		for(int k=1;(k<=dr && k<=dc);k++){
			int rpath=sr+k;
			int cpath=sc+k;
			if(cpath<=dc && rpath<=dr)
		mazepathdiagwithmoves(rpath, cpath, dr, dc, ans+"D"+k);	
		}
		
	
//		mazepathdiagwithmoves(sr, sc+1, dr, dc, ans+"H1");
//		mazepathdiagwithmoves(sr, sc+2, dr, dc, ans+"H2");
//		mazepathdiagwithmoves(sr, sc+3, dr, dc, ans+"H3");
//		mazepathdiagwithmoves(sr+1, sc, dr, dc, ans+"V1");                Wrong
//		mazepathdiagwithmoves(sr+2, sc, dr, dc, ans+"V2");
//		mazepathdiagwithmoves(sr+3, sc, dr, dc, ans+"V3");
//		mazepathdiagwithmoves(sr+1, sc+1, dr, dc, ans+"D");	
		}

}
