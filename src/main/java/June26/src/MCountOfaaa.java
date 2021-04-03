import java.util.Scanner;

//a. Write a recursive function which counts, the number of times “aaa”
//appears in the string. Print the value returned.
//
//b. Write a recursive function which counts, the number of times “aaa”
//appears in the string, but only such instances of “aaa” should be
//considered which do not overlap. Print the value returned.
//
//Example(To be used only for expected output):
//
//Input:
//aaaaaa
//
//output
//4
//2
public class MCountOfaaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = scn.nextLine();
		int co = countwithoverlap(s, 0);
		System.out.println(co);
		int cwo = countwithoutoverlap(s, 0);
		System.out.println(cwo);
	}

	static int cnto = 0, cntwo = 0;

	public static int countwithoverlap(String str, int vidx) {
		if (vidx == str.length() - 2) {
			return 0;
		}
		if (str.charAt(vidx) == 'a' && str.charAt(vidx + 1) == 'a' && str.charAt(vidx + 2) == 'a') {
			cnto++;
			countwithoverlap(str, vidx + 1);
		} else {
			countwithoverlap(str, vidx + 1);
		}
		return cnto;
	}

	public static int countwithoutoverlap(String str, int vidx) {
		if (vidx >= str.length() - 2) {
			return 0;
		}
		if (str.charAt(vidx) == 'a' && str.charAt(vidx + 1) == 'a' && str.charAt(vidx + 2) == 'a') {
			cntwo++;
			countwithoutoverlap(str, vidx + 3);
		} else {
			countwithoutoverlap(str, vidx + 1);
		}
		return cntwo;
	}

}
