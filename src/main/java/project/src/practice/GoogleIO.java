package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class GoogleIO {
	static Scanner scn=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

		GridEscape();
	}
	
	public static void GridEscape(){
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int r=scn.nextInt();
			int c=scn.nextInt();
			int k=scn.nextInt();
			
			ArrayList<ArrayList<Character>> res=find(r,c,k);
			if(res.size()==0){
				System.out.println("IMPOSSIBLE");
			}else{
				System.out.println("POSSIBLE");
				System.out.println(res);
			}
		}
	}
	
	private static ArrayList<ArrayList<Character>> find(int r, int c, int k){
		
		ArrayList<ArrayList<Character>> res=new ArrayList<>();
		
		if(k==0 || r<k || c<k){
			return new ArrayList<>();
		}
		
		char[][] arr=new char[r][c];
		
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				while(i==0 && j!=k){
					
				}
			}
		}
		
		return res;
	}

}
