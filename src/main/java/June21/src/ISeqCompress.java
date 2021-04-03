
public class ISeqCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabbbccdaafffgg";
		System.out.println(s);
		String c1 = compress1(s);
		System.out.println(c1);
		// abcdafg
		String c2 = compress2(s);
		System.out.println(c2);
		// a3b2c2da2f3g2
	}

	public static String compress1(String str) {
		StringBuilder sb = new StringBuilder();
		int flag = 1;
		int x = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(x) == str.charAt(i)) {
				flag = 0;
			} else {
				sb.append(str.charAt(x));
				x = i;
			}
		}
		sb.append(str.charAt(x));

		return sb.toString();

		// OR
		// StringBuilder sb=new StringBuilder();
		//
		//
		// int x=0;
		// int i=0;
		// while(i<str.length()-1){
		// while(str.charAt(x)==str.charAt(i)){
		// if(i==str.length()-1){
		// break;
		// }
		// i++;
		// }
		// sb.append(str.charAt(x));
		// x=i;
		//
		// }
		// return sb.toString();
		// }
	}

	public static String compress2(String str) {
		StringBuilder sb = new StringBuilder();

		int x = 0;
		int i = 0;
		while (i < str.length() - 1) {
			int cnt = 0;
			while (str.charAt(x) == str.charAt(i)) {
				cnt++;
				if (i == str.length() - 1) {
					break;
				}
				i++;
			}
			// i=3
			// cnt=3
			sb.append(str.charAt(x));
			sb.append(cnt);
			x = i;

		}
		return sb.toString();
	}
}
