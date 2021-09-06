package June26;

import java.util.Scanner;

//A �twin� is defined as two instances of a char separated by a char.
//
//Write a function which recursively counts number of �twins� in a string when
//overlap is not allowed and Print the value returned.
//
//Example(To be used only for expected output):
//
//Input:
//AxAxA
//
//output
//1
public class LTwinCountWithoutOverlap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = scn.nextLine();
		int res = counttwinswithoutoverlap(s, 0);
		System.out.println(res);
	}

	static int twincount = 0;

	public static int counttwinswithoutoverlap(String str, int vidx) {
		if (vidx >= str.length() - 2) {
			return 0;
		}
		if (str.charAt(vidx) == str.charAt(vidx + 2)) {
			twincount++;
			counttwinswithoutoverlap(str, vidx + 3);
		} else {
			counttwinswithoutoverlap(str, vidx + 1);
		}
		return twincount;
	}

}
