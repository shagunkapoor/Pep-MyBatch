import java.io.*;
import java.util.*;

//Take as input
//1. Armstrong Number: arn
//2. Start Range: sr
//3. End Range: er
//
//Check whether arn is an Armstrong Number on not, and in next line
//print all Armstrong Number till er separated by space.
//
//All Armstrong numbers in the range of
//0 and 999.  An Armstrong number is a number such that the sum
//of its digits raised to the n power(where n is the number of digits in er)
//is equal to the number
//itself.  For example, 371 is an Armstrong number, since n =3 and er 999
//3**3 + 7**3 + 1**3 = 371.
//



public class FIsArmstrong {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scn = new Scanner(System.in);
		System.out.println("dvgdg");
		int arn = scn.nextInt();
		int sr = scn.nextInt();
		int er = scn.nextInt();
		boolean b = isarm(arn);
		System.out.println(b + " ");
	//	System.out.println(allarm(10, 999));
		while (sr <= er) {

		//	int valinrange = allarm(sr, er);
			//System.out.print(valinrange + " ");
			boolean c=isarm(sr);
			if(c==true)
			{
				System.out.println(sr);
			}
			sr++;
		}
	}

	public static boolean isarm(int a) {
		int val = a;
		int sum = 0;
		int rem = 0;
		while (a != 0) {
			rem = a % 10;
			a /= 10;
			sum += (rem * rem * rem);
		}
		if (sum == val)
			return true;
		else
			return false;
	}

//	public static int allarm(int start, int end) {
//		int sum = 0;
//		int num = 0;
//		int rem = 0;
//		int val = 0;
//		while (start <= end) {
//			
//			
//			num = start;
//			while (num != 0) {
//				rem = num % 10;
//				num /= 10;
//				sum += (rem * rem * rem);
//
//			}
//			if (sum == start) {
//				val = sum;
//				break;
//			} else
//				start++;
//		}
//		return val;
//
//	}
//
}