package KJuly03;//import java.util.Scanner;
//
//public class IFibonacciNumbers {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Scanner scn = new Scanner(System.in);
//		System.out.println("Enter the no. of test cases");
//		int t = scn.nextInt();
//		System.out.println("Enter the position whose fibonacci no. is to be printed");
//		for (int i = 0; i < t; i++) {
//			int n = scn.nextInt();
//			long a = 0;
//			long b = 1;
//			for (int cnt = 0; cnt < n; cnt++) {
//				long c = a + b;
//				a = b;
//				b = c;
//			}
//			System.out.println(a);
//		}
//	}
//
//}
import java.io.*;
import java.util.*;

public class IFibonacciNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int fib=f(n-1)+f(n-2);
				
			
			int res=f(n/2)+f(n/2);
			System.out.println(res);
		}
	}
	public static int f(int n){
	int a=0;
	int b=1;
	int c=a+b;
	int fib=0;
	for(int i=n/2;i>=0;i--){
		//fib
	}
		return fib;
		
    }
}
