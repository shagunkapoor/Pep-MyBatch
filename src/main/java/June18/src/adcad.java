
import java.io.*;
import java.util.*;

public class adcad {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		//min in row
		//max in col
		Scanner scn = new Scanner(System.in);
		System.out.println("r");
		int r = scn.nextInt();
		int c = scn.nextInt();
		int[][] A = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				A[i][j] = scn.nextInt();
			}
		}
		int res=sadal(A,r,c);
		if(res==-1)
			System.out.println("No Such Point Exist");
		else
			System.out.println(res);
	}
	
	public static int sadal(int[][] arr, int r, int c){
		int val=-1;
		int row = 0;
		int rmin = 0;
		int cmax = 0;
		for (int j = 0; j < c; j++) {
			cmax=arr[0][j];
			for (int i = 0; i < r; i++) {
				if(arr[i][j]>cmax){
					cmax=arr[i][j];
					row=i;
				}
			}
				rmin=cmax;
				for(int x=0;x<c;x++){
					if(arr[row][x]<rmin){
						val=-1;
					}
				}	
		}		
				if(cmax==rmin){
					val=cmax;
				}
				return val;
			
	}
}