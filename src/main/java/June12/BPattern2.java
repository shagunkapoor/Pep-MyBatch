package June12;

import java.util.Scanner;


//1
//2 3
//4 5 6
//7 8 9 10
//11 12 13 14 15


public class BPattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n = scn.nextInt();
		int r = 1;
		int val = 1;
		while (r <= n) {
			int c = 1;
			while (c <= r) {
				System.out.print(val + " "); // CORRECT
				val++;
				c++;
			}
			System.out.println();
			r++;
		}
	}
}
