package Hackerrank;

import java.util.Scanner;

//Take as input N, a number. Write a recursive function which prints counting
//from 1 to N in lexicographical order. In lexicographical (dictionary) order 10,
//100 and 109 will be printed before 11.
//
//
//Example(To be used only for expected output):
//Input:
//20
//output
//1
//10
//11
//12
//13
//14
//15
//16
//17
//18
//19
//2
//3
//4
//5
//6
//7
//8
//9
public class Rec45Laxicographical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=scn.nextInt();
		laxicographicalorder(n,1);
	}
	static int i=0;
	public static void laxicographicalorder(int num, int nsf){
//		if(nsf>num){
//			return;
//		}
//		if(nsf==num){
//			nsf=1+i;
//		}
//	while(nsf<num){	
//		System.out.println(nsf);
//		if(digcount(nsf)<digcount(num)){
//			nsf*=10;
//			System.out.println(nsf);
//		}
//		nsf+=1;
//		laxicographicalorder(num, nsf);
//	}
//	}
//	public static int digcount(int n){
//	int dc=0;
//		while(n!=0){
//			int d=n%10;
//			n/=10;
//			dc++;
//		}
//		return dc;
//	}

		if(nsf>num){
			return;
		}
		if(nsf<num){
			System.out.println(nsf);
		}
		if(i==10){
			return;
		}
//		while(nsf<num || i!=10){
		laxicographicalorder(num, nsf*10+i);
		i++;
		laxicographicalorder(num, nsf+1);
//		}
	}
}
