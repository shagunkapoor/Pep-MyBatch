
import java.io.*;
import java.util.*;


//A rotation (or circular shift) is an operation similar to shift except that
//the digits that fall off at one end are put back to the other end.
//
//In left rotation, the digits that fall off at left end are put back at right end.
//
//In right rotation, the digits that fall off at right end are put back at left end.
//
//For Example,
//r=2 (Left Rotation)
//n=12345
//result=34512
//
//r=-2 (Right Rotation)
//n=12345
//result=45123
//
//
//Take as input
//1. Number of rotation: r
//2. A Number: n
//
//Let us assume result is desired answer after all operation.
//
//Print result in next line.



public class INumberRotationsByr {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of rotations and number");
		int r = scn.nextInt();
		int n = scn.nextInt();

		int temp = n;
		int numcount = 0;
		while (temp != 0) {
			temp /= 10;
			numcount++;
		}

		int rem = 0;
		int revnum1 = 0;
		int revnum2 = 0;

		int res = 0;
		if (r < 0) {
			int pow = 1;
			int cnt = 1;
			while (cnt <= r) {
				rem = n % 10;
				n /= 10;
				revnum2 = revnum2 + rem * pow;
				pow *= 10;
			}
			revnum1 = n;

			int val = (int) Math.pow(10, (numcount - r));
			res = (revnum2 * val) + revnum1;
		} else if (r > 0) {
			int pow = 1;
			int cnt = 1;
			while (cnt <= n - r) {
				rem = n % 10;
				n /= 10;
				revnum2 = revnum2 + rem * pow;
				pow *= 10;
			}
			revnum1 = n;

			int val = (int) Math.pow(10, (r));
			res = (revnum2 * val) + revnum1;
		} else {
			res = n;
		}

		System.out.println(res);

	}
}
