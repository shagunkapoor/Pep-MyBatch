public class B2DMatrixMultiplication {

	public static void main(String[] args) {

		int[][] one = { { 1, 0, 5, 0 }, { 2, 0, 0, 2 } };
		int[][] two = { { 10, 1, 1 }, { 1, 10, 1 }, { 1, 1, 10 }, { 0, 0, 0 } };
		multiply(one, two);
	}

	private static void multiply(int[][]one, int[][]two){
		int m=one.length;
		int n=one[0].length;
		int x=two.length;
		int y=two[0].length;
		int[][]arr=new int[m][y];
		if(n!=x){
			System.out.println("Not Possible");
			return;
		}else{
			for(int r=0;r<m;r++){
				for(int c=0;c<y;c++){
					for(int i=0;i<n;i++){
							arr[r][c]+=(one[r][i]*two[i][c]);
							}
					}
			}
			for(int i=0;i<m;i++){
				for(int j=0;j<y;j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
			
			
		}
	}

}
