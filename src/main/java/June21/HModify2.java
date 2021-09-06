package June21;

//Between 2 no. , add the difference of their ASCII
public class HModify2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "adbgj";
		System.out.println(s);
		String res = modify2(s);
		System.out.println(res);
	}

	public static String modify2(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length()-1; i++) {
			int diff = str.charAt(i+1) - str.charAt(i);
			 //System.out.println(diff);
			 sb.append(str.charAt(i));
			 sb.append(diff);
			}
		sb.append(str.charAt(str.length()-1));
		
		return sb.toString();
	}

}
