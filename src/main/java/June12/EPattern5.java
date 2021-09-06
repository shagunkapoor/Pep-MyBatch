package June12;

import java.util.Scanner;

//*				*
//	*		*	
//		*
//	*		*
//*				*	
public class EPattern5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n=scn.nextInt();
		
//		int r=1;
//		while(r<=n){
//			int c=1;
//			while(c<=n){
//				if(r==c || (r+c)==n+1){
//					System.out.print("*");
//				}else
//					System.out.print(" ");
//			c++;
//			}
//			System.out.println();
//		r++;
//		}
		
		
		for(int r=1;r<=n;r++){
			for(int c=1;c<=n;c++){
				if(r==c || (r+c)==(n+1)){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}

