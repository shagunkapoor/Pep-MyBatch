import java.util.Scanner;

public class FPrintAllPrimeNoTillN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = scn.nextInt();
		int c = 2;
		while (c <= n) {
			// check if c is prime
			int div = 2;
			int prime = 1;
			while (div * div <= c) {
				// while(div<=c-1){
				if (c % div == 0) {
					prime = 0;
					break;
				}
				div++;
			}
			if (prime == 1) {
				System.out.println(c);
			}

			c++;

		}
	}
}

// int prime=1;
// int c=2;
// int d=1;
// while(c<=n){
// while(d*d<=c){
// if(c%d==0){
// prime=0;
// break;
// }
// d++;
// }
// if(prime==1){
// System.out.println(c);
// c++;
// }
// }
// }

// }
