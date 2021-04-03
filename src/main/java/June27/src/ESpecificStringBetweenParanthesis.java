import java.util.Scanner;

public class ESpecificStringBetweenParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = scn.nextLine();
		StringBuilder sb = new StringBuilder();
		strbtwparenthesis(str, false, sb);

	}

	public static void strbtwparenthesis(String str, boolean val, StringBuilder sb) {

		if (str.length() == 0) {
			System.out.println(sb);
			return;
		}

		char ch = str.charAt(0);
		String rem = str.substring(1);
		if (ch == '(') {
			val = true;
		} else if (ch == ')') {
			val = false;
			if (sb.lastIndexOf("(") > sb.lastIndexOf(")")) {
				sb.append(ch);
			}
		}
		if (val == true) {
			sb.append(ch);
		}
		strbtwparenthesis(rem, val, sb);

	}
}
