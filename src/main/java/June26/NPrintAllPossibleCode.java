package June26;

import java.util.Scanner;

//Take as input str, a string. Assume that value of a=1, b=2, c=3, d=4, .... z=26.
//Write a recursive function (return type void) to print all possible codes for
//the string.
//
//Example(To be used only for expected output):
//
//Input:
//1123
//
//output
//aabc
//aaw
//alc
//kbc
//kw

public class NPrintAllPossibleCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		String s = "1023";
		papc(s, "");

	}

	public static void papc(String str, String codes) {
		if (str.length() == 0) {
			System.out.println(codes);
			return;
		}
		char cc = str.charAt(0);
		int ci = cc - '0';
		String ros = str.substring(1);

		if (ci == 0) {
			papc(ros, codes);
		} else {
			char c1 = (char) (ci + 'a' - 1);
			papc(ros, codes + c1);
		}

		if (str.length() > 1) {
			String c2 = str.substring(0, 2);
			String ros2 = str.substring(2);

			if (Integer.parseInt(c2) <= 26) {
				papc(ros2, codes + (char) (Integer.parseInt(c2) + 'a' - 1));
			}
		}
	}

}
