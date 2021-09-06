package June26;

import java.util.Scanner;

//1.Take as input String.
//2.Take as input Integer "i" which I used to verify your return type String.
//
//a. Write a recursive function which counts the number of times �hi� appears in
//   the string. Print the value returned.
//b. Write a recursive function which removes all �hi� in the string. Print the
//   i'th index character.
//c. Write a recursive function which removes all �hi� in the string. Print the
//   output (return type void).
//
//
//Example(To be used only for expected output):
//
//Input:
//hihihijjhihi 1
//
//output
//5
//j
//jj
public class GCountOrRemoveHi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter");
		String s = scn.nextLine();
		int index = scn.nextInt();
		int count = countshi(s, 0);
		System.out.println(count);
		StringBuilder sb = new StringBuilder();
		String res = removeallhi(s, 0, sb);
		System.out.println(res.charAt(index));
		StringBuilder sb1 = new StringBuilder();
		sb1.append(s);
		printremovedhi(s,0);
	}

	static int cnt = 0;

	public static int countshi(String str, int vidx) {

		// If i use cnt as an argument, then its value changes and while
		// returning it retains the old value again, so we use static int so
		// that its value would change finally in the last step and not while
		// backtracking
		if (vidx == str.length() - 1) {
			return cnt;
		}
		if (str.charAt(vidx) == 'h' && str.charAt(vidx + 1) == 'i') {
			cnt++;
			countshi(str, vidx + 1);
		} else {
			countshi(str, vidx + 1);
		}
		return cnt;
	}

	public static String removeallhi(String str, int vidx, StringBuilder sb) {
		if(vidx>=str.length()-1){
			return "";
		}
		if (str.charAt(vidx) == 'h' && str.charAt(vidx + 1) == 'i') {
			removeallhi(str, vidx + 2, sb);
		} else {
			sb.append(str.charAt(vidx));
			removeallhi(str, vidx + 1, sb);
		}
		return sb.toString();
	}
	public static void printremovedhi(String str, int vidx){
		if(vidx>=str.length()-1){
			if(vidx==str.length()-1)
				System.out.println(str.charAt(str.length()-1));
			return;
		}
		if(str.charAt(vidx)=='h' && str.charAt(vidx+1)=='i'){
			printremovedhi(str,vidx+2);
		}else{
			System.out.print(str.charAt(vidx));
			printremovedhi(str,vidx+1);
		}
	}

}
