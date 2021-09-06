import java.util.Scanner;

public class DSumTillN {

	public static void main(String[] args) {

		//int n = 5;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n=scn.nextInt();
		int count = 1;
		int sum = 0;
		while (count <= n) {
			sum = sum + count;
			count++;
		}
		
		System.out.println("Sum is : " + sum);

	}

}