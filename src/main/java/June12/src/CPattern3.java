
import java.util.Scanner;


//0	
//1	1	
//2	3	5	
//8	13	21	34	
//55 89	144	233	377	


public class CPattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n=scn.nextInt();
		int r=1;
		int a=0;
		int b=1;
		while(r<=n){
			int i=1;
			while(i<=r){
				System.out.print(a+" ");
				int sum=a+b;
				a=b;
				b=sum;
				i++;
			}
		System.out.print("\n");
			r++;
	}
  }
}

