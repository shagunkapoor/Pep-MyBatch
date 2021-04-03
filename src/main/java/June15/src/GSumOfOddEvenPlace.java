import java.io.*;
import java.util.*;

public class GSumOfOddEvenPlace {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number");
		long n = scn.nextInt();

		long temp = n, len = 0, rem = 0;
		while (temp != 0) {
			// rem=temp%10;
			temp /= 10;
			len++;
		}
		int ES = 0;
		int OS = 0;
		int cnt = 0;
		long num = 0;

		while (cnt < len) {
			num = n % 10;
			n /= 10;
			if (cnt % 2 == 0) {
				ES += num;
			} else
				OS += num;
			cnt++;
		}
		System.out.println(ES + " " + OS);
	}
}