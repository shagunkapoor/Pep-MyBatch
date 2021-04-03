import java.util.Scanner;
//one duplicate parenthesis
//(((a+b)+(c+d)))  ->false
// ((a+b)+((c+d))) ->false
//(a+(b+(c+d))) ->true

public class BDuplicateParenthesis extends Stack {

	public BDuplicateParenthesis(int cap) {
		super(cap);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = scn.nextLine();
		boolean res = checkduplicates(s);
		System.out.println(res);
	}
	

	public static boolean checkduplicates(String s) {
		Stack obj = new BDuplicateParenthesis(s.length());
		int cntr = 0;
		boolean val = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				obj.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (obj.top() == '(') {
					val = true;
				} else {
					while (obj.top() != '(') {
						obj.pop();
					}
					obj.pop();
				}
			} else {
				obj.push(s.charAt(i));
			}
		}
		return val;
	}

}
