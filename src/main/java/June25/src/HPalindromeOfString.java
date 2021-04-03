import java.util.Scanner;

public class HPalindromeOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = scn.nextLine();
		boolean res = checkpalindrome(s.toLowerCase(), 0, s.length() - 1);
		System.out.println(res);

	}

	static boolean result = true;

	public static boolean checkpalindrome(String str, int vidx, int n) {
		if (vidx == str.length()) {
			return true;
		}

		if (str.charAt(vidx) != str.charAt(n)) {
			result = false;
		} else
			result = checkpalindrome(str, vidx + 1, n - 1);

		return result;
	}

}
