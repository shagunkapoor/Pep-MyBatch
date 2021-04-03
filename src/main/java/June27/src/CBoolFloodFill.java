
public class CBoolFloodFill {
	// Cannot traverse from positions having 1

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = { { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0 }, { 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0 } };
		int[][] v = new int[a.length][a[0].length];
		// v=a;
		floodfill(0, 0, a, v, "");
	}

	public static void floodfill(int sr, int sc, int[][] maze, int[][] visited, String path) {

		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			System.out.println(path);
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

		visited[sr][sc] = 1;
		floodfill(sr, sc + 1, maze, visited, path + "R");
		floodfill(sr + 1, sc, maze, visited, path + "D");
		floodfill(sr, sc - 1, maze, visited, path + "L");
		floodfill(sr - 1, sc, maze, visited, path + "T");
		visited[sr][sc] = 0;

	}
}
