import java.util.Scanner;

//{[(a+b)+(c+d)]} ->true
public class ABalancedParenthesis extends Stack {

	public ABalancedParenthesis(int cap) {
		super(cap);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = scn.nextLine();
		checkbalanced(s);
	}
 
	public static void checkbalanced(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
				res += 1;
			else if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')')
				res -= 1;
			else
				continue;
		}
		if (res == 0)
			System.out.println(true);
		else
			System.out.println(false);

		/*
		 * OR
		 * Stack obj = new Stack(s.length());
		 * 
		 * for (int i = 0; i < s.length(); i++) {
		 * 
		 * if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
		 * obj.push(s.charAt(i)); } if (s.charAt(i) == '}' || s.charAt(i) == ']'
		 * || s.charAt(i) == ')') { if (obj.size() == 0) {
		 * System.out.println(false); return; } else if (s.charAt(i) == '}' &&
		 * obj.top() == '{') { obj.pop(); } else if (s.charAt(i) == ']' &&
		 * obj.top() == '[') { obj.pop(); } else if (s.charAt(i) == ')' &&
		 * obj.top() == '(') { obj.pop(); } else { obj.push(s.charAt(i)); } } }
		 * if (obj.isEmpty()) { System.out.println(true); } else {
		 * System.out.println(false); }
		 */
	}

}
