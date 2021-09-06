package June27;

public class DShortestFloodFillPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze=new int[5][6];
		maze[0][1]=1;
		maze[0][5]=1;
		maze[1][3]=1;
		maze[1][5]=1;
		maze[2][1]=1;
		maze[3][1]=1;
		maze[3][4]=1;
		maze[4][3]=1;
		int[][] visited=new int[maze.length][maze[0].length];
		floodfill(0,0,maze,visited,"");
		System.out.println("Shortest Path "+ shortest);

	}
	static String shortest=null;

	public static void floodfill(int sr,int sc, int[][]maze, int[][] visited, String path){
		if(sr==maze.length-1 && sc==maze[0].length-1){
			System.out.println(path);
			if(shortest==null){
				shortest=path;
			}else{
				if(path.length()<shortest.length()){
				shortest=path;
			}
			}
			
			return;
		}
		if (sr >= maze.length || sc >= maze[0].length || sr < 0 || sc < 0) {
			return;
		}

		if (maze[sr][sc] == 1) {
			return;
		}

		if (visited[sr][sc] == 1) {
			return;
		}
		
	
		visited[sr][sc]=1;
		floodfill(sr, sc + 1, maze, visited, path + "R");
		floodfill(sr + 1, sc, maze, visited, path + "D");
		floodfill(sr, sc - 1, maze, visited, path + "L");
		floodfill(sr - 1, sc, maze, visited, path + "T");
		visited[sr][sc] = 0;

	}
}
