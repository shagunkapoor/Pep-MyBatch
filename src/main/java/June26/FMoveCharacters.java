package June26;

import java.util.ArrayList;
import java.util.Scanner;

//1.Take as input String.
//2.Take as input charcter ch.
//3.Take as input Integer "i" which I used to verify your return type String.
//
//A. Write a recursive function which moves all �ch� from the string to its end
//   and Return String
//B. Write a recursive function return type void which moves all �ch� from the
//  string to its end and Print Output string.
//
//Example(To be used only for expected output):
//
//Input:
//abeedeedxxx x 2
//
//output
//e
//abeedeedxxx

public class FMoveCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter str, ch,int");
		String s = scn.nextLine();
		char c = scn.nextLine().charAt(0);
		int indx = scn.nextInt();
		StringBuilder sb = new StringBuilder();
		String res = movechartoend(s, c, 0, sb);
		System.out.println(res.charAt(indx));
		printcharatend(s, c, 0);
	}

	static int count = 0, cntch = 0;

	public static String movechartoend(String str, char ch, int vidx, StringBuilder sb) {

		if (vidx == str.length()) {
			for (int i = 1; i <= count; i++) {
				sb.append(ch);
			}
			return sb.toString();
		}
		if (ch == str.charAt(vidx)) {
			count++;
			movechartoend(str, ch, vidx + 1, sb);

		} else {
			sb.append(str.charAt(vidx));
			movechartoend(str, ch, vidx + 1, sb);
		}

		return sb.toString();
	}

	public static void printcharatend(String str, char ch, int vidx) {
		if (vidx == str.length()) {
			for (int i = 0; i < cntch; i++) {
				System.out.print(ch);
			}
			return;
		}
		if (ch == str.charAt(vidx)) {
			cntch++;
			printcharatend(str, ch, vidx + 1);
		} else {
			System.out.print(str.charAt(vidx));
			printcharatend(str, ch, vidx + 1);
		}
	}
}