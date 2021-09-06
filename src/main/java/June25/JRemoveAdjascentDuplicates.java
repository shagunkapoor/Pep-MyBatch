package June25;

import java.util.Scanner;

public class JRemoveAdjascentDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = scn.nextLine();
		int indx = scn.nextInt();

		StringBuilder sb = new StringBuilder();
		String res = retremovedduplicates(s, 0, sb);
		System.out.println(res.charAt(indx));
		printremovedduplicates(s, 0);

	}

	public static String retremovedduplicates(String str, int vidx, StringBuilder sb) {

		if (vidx == str.length() - 1) {
			sb.append(str.charAt(str.length() - 1));
			return "";
			//sb.toString();
		}
		if (str.charAt(vidx) == str.charAt(vidx + 1)) {
			String result = retremovedduplicates(str, vidx + 1, sb);

		} else {
			sb.append(str.charAt(vidx));
			String result = retremovedduplicates(str, vidx + 1, sb);
		}

		return sb.toString();

	}

	public static void printremovedduplicates(String str, int vidx) {
		if (vidx == str.length() - 1) {
			System.out.print(str.charAt(str.length() - 1));
			return;
		}

		if (str.charAt(vidx) == str.charAt(vidx + 1)) {
			printremovedduplicates(str, vidx + 1);
		} else {
			System.out.print(str.charAt(vidx));
			printremovedduplicates(str, vidx + 1);
		}
	}
}
