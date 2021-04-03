import java.util.ArrayList;
import java.util.Scanner;

public class ISeparateDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = scn.nextLine();
		int indx = scn.nextInt();
		StringBuilder sb = new StringBuilder();
		String res = retsepduplicates(s, 0, sb);
		System.out.println(res.charAt(indx));
		printsepduplicates(s, 0);
	}

	public static String retsepduplicates(String str, int vidx, StringBuilder sb) {
		if (vidx == str.length() - 1) {
			sb.append(str.charAt(str.length() - 1));
			return "";
		}
		if (str.charAt(vidx) == str.charAt(vidx + 1)) {
			sb.append(str.charAt(vidx));
			sb.append("*");
			String result = retsepduplicates(str, vidx + 1, sb);
		} else {
			sb.append(str.charAt(vidx));
			String result = retsepduplicates(str, vidx + 1, sb);
		}
		return sb.toString();

	}

	public static void printsepduplicates(String str, int vidx) {

		if (vidx == str.length() - 1) {
			System.out.println(str.charAt(vidx));
			return;
		}
		if (str.charAt(vidx) == str.charAt(vidx + 1)) {
			System.out.print(str.charAt(vidx));
			System.out.print('*');
			printsepduplicates(str, vidx + 1);
		} else {
			System.out.print(str.charAt(vidx));
			printsepduplicates(str, vidx + 1);
		}
	}

}
