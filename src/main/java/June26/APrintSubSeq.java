package June26;

public class APrintSubSeq {

	public static void main(String[] args) {
		String s = "abc";
		ssASCII(s,"");
	}
	public static void ssASCII(String ques, String ans){
		if(ques.length()==0){
			System.out.println(ans);
			return;
		}
		
		char ch=ques.charAt(0);
		String roq=ques.substring(1);
//		int ascii=ch;

		ssASCII(roq, ans+"");	
		ssASCII(roq,ans+ch);
	}

}
































