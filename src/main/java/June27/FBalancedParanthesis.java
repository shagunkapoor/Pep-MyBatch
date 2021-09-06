package June27;

import java.util.Scanner;

//Write a recursive function which tests if the brackets in expression are
//balanced or not and returns a Boolean value. Print the value returned.
//
//Example(To be used only for expected output):
//Input:
//[a+{b+(c+d)+e}+f]
//
//output
//true
public class FBalancedParanthesis {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = scn.nextLine();
		StringBuilder sb = new StringBuilder("");
		checkbalanced(s, 0, sb);
		if (sb.length() == 0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	public static void checkbalanced(String str, int vidx, StringBuilder sb) {

		if (str.length() == 0) {
			return;
		}

		char ch = str.charAt(0);
		String rem = str.substring(1);
		if (ch == '[' || ch == '(' || ch == '{' || ch == ']' || ch == ')' || ch == '}') {
			sb.append(ch);
			if ((sb.charAt(sb.length() - 1) == ')' && sb.charAt(sb.length() - 2) == '(')
					|| (sb.charAt(sb.length() - 1) == '}' && sb.charAt(sb.length() - 2) == '{')
					|| (sb.charAt(sb.length() - 1) == ']' && sb.charAt(sb.length() - 2) == '[')) {
				sb.deleteCharAt(sb.length() - 1);
				sb.deleteCharAt(sb.length() - 1);
			}

			checkbalanced(rem, vidx + 1, sb);
		} else {

			checkbalanced(rem, vidx + 1, sb);
		}

	}

}
