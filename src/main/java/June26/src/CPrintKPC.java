
public class CPrintKPC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "254";
		KPC(s, "");
	}

	static String[] codes = { ".;", "abc", "def", "gh", "ijkl", "mn", "opq", "nstu", "v", "wxyz" };

	public static void KPC(String ques, String ans) {

		if (ques.length()== 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		String code = codes[ch - '0'];
		for (int i = 0; i < code.length(); i++) {
			KPC(roq, ans + code.charAt(i));
		}
	}
}
