package June30;

public class Sudoku2 { //O(n^n^2)

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
		
		int[] rows=new int[9];
		int[] cols=new int[9];
		int[][] sms=new int[3][3];
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr.length;col++){
				rows[row] |=(1<<arr[row][col]);
				cols[col] |=(1<<arr[row][col]);
				sms[row/3][col/3] |=(1<<arr[row][col]);
			}
		}
		sudoku(arr, 1, rows, cols, sms);
	}
	public static void sudoku(int[][] arr, int cellno, int[] rows, int[] cols, int[][]sms){
		if(cellno>arr.length*arr.length){
			for(int row=0;row<arr.length;row++){
				for(int col=0;col<arr.length;col++){
					System.out.print(arr[row][col]+" ");
				}
				System.out.println();
			}
			
			
			return;
		}
		
		int row=(cellno-1)/arr.length;
		int col=(cellno-1)%arr.length;
		
		if(arr[row][col]!=0){
			sudoku(arr, cellno+1, rows, cols, sms);
		}else{
			for(int choice=1;choice<=9;choice++){
				if(isAvailable(arr, rows, cols, sms, choice, row, col)){
					reserveNumber(arr, rows, cols, sms, choice, row, col);
					sudoku(arr, cellno+1, rows, cols, sms);
					releaseNumber(arr, rows, cols, sms, choice, row, col);
				}
			}
		}
	}
	private static boolean isAvailable(int[][] arr, int[] rows, int[] cols, int[][]sms, int num, int row, int col){
		
		int mask=1<<num;
		if((rows[row]& mask) !=0){
			return false;
		}else if((cols[col] &mask)!=0){
			return false;
		}else if((sms[row/3][col/3]&mask)!=0){
			return false;
		}else{
			return true;
		}
	}
	
	private static void reserveNumber(int[][] arr, int[] rows, int[] cols, int[][] sms, int choice, int row, int col){
		
		arr[row][col]=choice;
		int mask=1<<choice;
		rows[row] |= mask;
		cols[col] |=mask;
		sms[row/3][col/3] |=mask;
		
	}
	private static void releaseNumber(int[][] arr, int[] rows, int[] cols, int[][] sms, int choice, int row, int col){
		
		arr[row][col]=0;
		int mask= ~(1<<choice);
		rows[row] &= mask;
		cols[col] &=mask;
		sms[row/3][col/3] &=mask;
	}

}
