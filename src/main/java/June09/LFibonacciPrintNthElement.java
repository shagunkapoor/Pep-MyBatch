package June09;

import java.util.Scanner;

public class LFibonacciPrintNthElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the element position");
		int n=scn.nextInt();
		
		int a=0;
		int b=1;
		int cnt=0;
		int sum=0;
		while(cnt<=n){
			if(cnt==n){
				System.out.println(a);
			}
			sum=a+b;
			a=b;
			b=sum;
			cnt++;
		}
	}

}
