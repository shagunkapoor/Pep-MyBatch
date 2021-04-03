import java.util.Scanner;

//Write a recursive function to find Nth triangle where 1st triangle is 1, 2nd
//triangle is 1 + 2 = 3, 3rd triangle is 1 + 2 + 3 = 6, so on and so forth.
public class HNthTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n=scn.nextInt();
		
		int res=nthtriangle(n);
		System.out.println(res);
	}
	public static int nthtriangle(int n){
		
		if(n==0){
			return 0;
		}
		int sum=nthtriangle(n-1);
		
		return n+sum;
	}

}
