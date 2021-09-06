package June25;

import java.util.ArrayList;
import java.util.Scanner;

public class FStringtoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = scn.nextLine();
		System.out.println("Enter the divisor");
		//String str = scn.nextLine();
		//int div = Integer.parseInt(scn.next());
		int div = Integer.parseInt(scn.nextLine());
		//int div = scn.nextInt();
		int n = str.length();
		long res = strtoint(str, n - 1, div);
		System.out.println(res / div);

	}

	public static long strtoint(String s, int power, int div) {
		if (s.length() == 0) {
			return 0;
		}
		char c = s.charAt(0);
		int ctoi = c - '0';
		String rem = s.substring(1);
		long num = strtoint(rem, power - 1, div);
		num = num + ((long) (ctoi * Math.pow(10, power)));
		return num;

	}
}