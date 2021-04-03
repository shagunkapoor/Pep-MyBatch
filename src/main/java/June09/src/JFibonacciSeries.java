import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class JFibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the limit of Fibonacci Series:");
		int n = scn.nextInt();
		int a = 0;
		int b = 1;
		int cnt = 0;
		while (cnt <= n) {
			System.out.print(a + " ");
			int c = a + b;
			a = b;
			b = c;
			cnt++;

		}
	}

}
