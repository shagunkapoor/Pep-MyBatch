package June09;

import java.util.Scanner;

public class GSumOfPrimeNoTillN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=scn.nextInt();
		
		int c=2;
		int sum=0;
		while(c<=n){
			int d=2;
			int prime=1;
			while(d*d<=c){
				if(c%d==0){
					prime=0;
					break;
				}
				d++;
			}
			if(prime==1){
				sum+=c;	
			}
			c++;
		}
		System.out.println("Sum of all prime numbers till "+n+" is: " +sum);
		
	}

}
