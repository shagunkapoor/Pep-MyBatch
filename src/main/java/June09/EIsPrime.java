package June09;

import java.util.Scanner;

public class EIsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = scn.nextInt();

		// int count = 2;
		// int flag=1;
		// while (count <= n - 1) {
		// if (n % count == 0) {
		// flag=0;
		// } else //CORRECT
		// flag=1;
		// count++;
		// }0
		// if(flag==0)
		// System.out.println("Not Prime");
		// else
		// System.out.println("Prime");

		int div = 2;
		// while(div<=n-1){  //O(n)
		// if (n%div==0){
		// System.out.println("Not prime"); //CORRECT
		// return;
		// }
		// div++;
		// }
		// System.out.println("Prime");

		while (div * div <= n) {  //O(sqrt(n))
			if (n % div == 0) {
				System.out.println("Not Prime"); // CORRECT
				return;
			}
			div++;
		}
		System.out.println("Prime");
	}

}
