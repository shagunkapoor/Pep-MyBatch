package June09;

import java.util.Scanner;

public class HGCD {

	public static void main(String[] args) {  //HCF
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the dividend and divisor: ");
		int dvdnd = scn.nextInt();
		int div = scn.nextInt();
//		int rem = dvdnd % div;

		while (true) {
			int rem = dvdnd % div;
			dvdnd = div;
			div = rem;
			
		if (rem == 0) {
			System.out.println(dvdnd);
			return;
		}

	}
}
}
