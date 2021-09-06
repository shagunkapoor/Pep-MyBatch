package June12;

import java.util.Scanner;

//1
//1	1
//1	2	1
//1	3	3	1
//1	4	6	4	1
//1	5	10	10	5	1



//IMPORTANT (nCr)
public class DPattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n = scn.nextInt();
		int r=0;
		int nv;
		
		while(r<n){
			int c=0;
			int val=1;
			while(c<=r){
				System.out.print(val+" ");
				nv=(val*(r-c))/(c+1);
				val = nv;
				c++;
			}
			System.out.println();
		r++;
		}

	}

}


