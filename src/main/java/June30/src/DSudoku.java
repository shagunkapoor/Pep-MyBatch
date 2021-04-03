
public class DSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr={ 
				{3,0,6,5,0,8,4,0,0},
				{5,2,0,0,0,0,0,0,0},
				{0,8,7,0,0,0,0,3,1},
				{0,0,3,0,1,0,0,8,0},
				{9,0,0,8,6,3,0,0,5},
				{0,5,0,0,9,0,6,0,0},
				{1,3,0,0,0,0,2,5,0},
				{0,0,0,0,0,0,0,7,4},
				{0,0,5,2,0,6,3,0,0}
		};
		int[][] rowcol=new int[arr.length][arr.length];
		int[][] subm=new int[3][3];
		sudoku(arr,0,0);		
	}
	public static void sudoku(int[][] arr,int[][] rowcol, int[][] submatrix, boolean isnum ){
		//Setting rows & columns
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				int elt=arr[i][j];
				int mask=1<<elt-1;
				rowcol[i][j]=rowcol[i][j] | mask;
			}
			
			for(i=0;i<arr.length;i++){
				
			}
			for(int x=1;x<=9;x++){
				if(canPlaceNumber){
					addNumber(x,r,c);
				}
			}
	
		
	}
	public static boolean canPlaceNumber(int[][] arr, int[] row, int[] col,int r, int c, int n){
		
		for(int i=0;i<arr.length;i++){
				if(data==arr[i][c]){
					return false;
				}
			}
		}
	}

}
