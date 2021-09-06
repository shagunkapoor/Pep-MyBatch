package June14;

import java.util.Scanner;

public class COctalSubtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no.");
		int oct1 = scn.nextInt();
		int oct2 = scn.nextInt();
		int n1 = 0;
		int n2 = 0;
		int diff = 0;
		int borrow = 0;
		int octdiff = 0;
		int pow = 1;
		while ((oct1 != 0) || (oct2 != 0)) {

			n1 = oct1 % 10;
			n2 = oct2 % 10;
			oct1 /= 10;
			oct2 /= 10;
			if (borrow != 0) {
				n1 -= 1;
			}
			if (n1 >= n2) {
				diff = n1 - n2;
				borrow = 0;
			} else {
				n1 += 8;
				diff = n1 - n2;
				borrow = -1;
			}
			octdiff += (diff * pow);
			pow *= 10;
		}
		System.out.println(octdiff);
	}

}
