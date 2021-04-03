
public class FToggleCase {

	public static void main(String[] args) {

		String s="hello";
		String res=toggleCase(s);
		System.out.println(res);
	}
	public static String toggleCase(String str){
		StringBuilder sb= new StringBuilder(str);
		int n=sb.length();
		for(int i=0;i<n;i++){
			if(sb.charAt(i)>='a' && sb.charAt(i)<='z'){
				sb.setCharAt(i, (char)(sb.charAt(i)-'a'+'A'));
			}else{
				sb.setCharAt(i, (char)(sb.charAt(i)-'A'+'a'));
			}
		}
		return sb.toString();
	}

}
