import java.util.Scanner;

public class CFactorial {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the no.");
		int n=scn.nextInt();
		int res=fact(n);
		System.out.println(res);
	}
	
	public static int fact(int num){
		if(num==0)
			return 1;
		int f=fact(num-1);
	
		return f*num;
	}

}
