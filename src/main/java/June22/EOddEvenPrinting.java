package June22;

import java.util.Scanner;

public class EOddEvenPrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no.");
		int n = scn.nextInt();
		oep(n);
		ep(n);
	}

	public static void oep(int n) {
		if (n < 1) {
			return;
		}

		if (n % 2 == 0) {
			oep(n - 1);
		} else {
			System.out.println(n);
			oep(n - 2);
		}
	}
	public static void ep(int n){
		if(n==0){
			return;
		}
		
		if(n%2==0){
			ep(n-2);
			System.out.println(n);
		}else{
			ep(n-1);
		}
	}
	
}