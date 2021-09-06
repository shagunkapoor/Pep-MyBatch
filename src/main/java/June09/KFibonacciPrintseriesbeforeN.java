package June09;//To series till the n'th element of fibonacci series

import java.util.Scanner;

public class KFibonacciPrintseriesbeforeN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the number whose preceding series is reqd.");
		int n=scn.nextInt();
		
		int a=0;
		int b=1;
		int cnt=0;
		if(n==1){
			System.out.println("0 1 1");
		}else{
		while(cnt<n){
			//System.out.print(a+"\t");
			if(a<=n){
				System.out.println(a);
			}else
				return;
			int c=a+b;
			a=b;
			b=c;
			cnt++;
		}
		
		
		
//	   	Scanner scn=new Scanner(System.in);
//        int n=scn.nextInt();
//        int a=0;
//        int b=1;
//        int cnt=0;
//        int sum=0;																//CORRECT
//        if(n>=0){
//            while(a<=n){
//            System.out.print(a+" ");
//            sum=a+b;
//            a=b;
//            b=sum;
//            }
//        }else
//            return;
//    }
//}
		
		
//	0	1	1	2	3	5	8	13	21	34	55
//		int sum=0;
//		int a=0;
//		int b=1;
//		int i=1;
//		while(i<=1000000000){
//			
//			sum=a+b;
//			a=b;
//			b=sum;
//			if(sum==n){
//				System.out.println(sum);
//				return;
//				}
//			i++;
//			}
	
		}
		
		
		
		
		
		
	}
}

