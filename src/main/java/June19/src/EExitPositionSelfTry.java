
public class EExitPositionSelfTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 0, 0, 1, 0 }, 
						{ 0, 0, 0 , 0 }, 
						{ 1, 0, 0, 0 }, 
						{ 0, 0, 1, 0 } };
	
		int r = arr.length;
		int c = arr[0].length;
		
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		int rmin = 0;
		int rmax = r - 1;
		int cmin = 0;
		int cmax = c - 1;
		int x=rmin;
		int y=cmin;

		if(arr[rmin][cmin]==0){
			y++;
			while(x<rmax && y<cmax){
				if(arr[x][y]==1){
					x++;
					if(arr[x][y]==1)
						y--;
					else 
						x++;
				}else{
					y++;
				}
				if(x==rmax && y==cmax){
					System.out.println(x+","+y);
					return;
				}
			}
			System.out.println(x+","+y);
		}else{
			x++;
			while(x<=rmax && y<=cmax){
				if(arr[x][y]==1){
					System.out.println(x+","+y);
					return;
				}else{
					if(x==rmax){
						System.out.println(x+","+y);
						return;
					}
					x++;
				}
			}
		}
	}

}
