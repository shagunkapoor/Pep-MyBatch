import java.util.Scanner;

public class GStringOneTwoAreReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter String 1");
		String s1 = scn.nextLine();
		System.out.println("Enter String 2");
		String s2 = scn.nextLine();
		boolean res = checkreverse(s1, s2, 0,s1.length()-1,false);
		System.out.println(res);
	}

	public static boolean checkreverse(String s1, String s2, int vidx,int n,boolean val) {
		if (vidx == s1.length()) {
			return true;
		}
			if (s1.charAt(vidx) == s2.charAt(n)) {
				val=true;
				val = checkreverse(s1, s2, vidx + 1,n-1,val);
			} else {
				val = false;
			}
			return val;

	}

}
