//Odd position --> reduce ASCII by 1
//Even Position --> increase ASCII by 1
public class GModify1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hEllo";
		System.out.println(s);
		String mod1 = modify1(s);
		System.out.println(mod1);

	}

	public static String modify1(String str) {
		StringBuilder sb = new StringBuilder(str);
		int n = sb.length();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				sb.setCharAt(i, (char) (sb.charAt(i) + 1));
			} else {
				sb.setCharAt(i, (char) (sb.charAt(i) - 1));

			}
		}

		return sb.toString();
	}

}
