package June30;

public class CPrintPermutationsUsingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abc";
		permutationsusingstr(s, "");
		System.out.println("*****************************");
		permutationsusingsb(new StringBuilder("abc"), new StringBuilder());
		System.out.println("*****************************");
		allpermutationsusingsb(new StringBuilder("abc"), new StringBuilder());
	}

	//Time -> O(n!)

	public static void permutationsusingstr(String ques, String ans) {
		if (ques.length() == 0) {

			System.out.println(ans);
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String left = ques.substring(0, i);
			String right = ques.substring(i + 1);
			String roq = left + right;
			permutationsusingstr(roq, ans + ch);

		}
	}

	public static void permutationsusingsb(StringBuilder ques, StringBuilder ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			ques.deleteCharAt(i);
			ans.append(ch);
			permutationsusingsb(ques, ans);
			ans.deleteCharAt(ans.length() - 1);
			ques.insert(i, ch);
		}
	}

	public static void allpermutationsusingsb(StringBuilder ques, StringBuilder ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		ques.deleteCharAt(0);
		for (int x = 0; x <= ans.length(); x++) {
			ans.insert(x, ch);
			allpermutationsusingsb(ques, ans);
			ans.deleteCharAt(x);
		}
		ques.insert(0, ch);

	}
}
