
public class BPrintSubSeqWithASCII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		int ascii=ch;
		ssASCII(roq,ans+ch);
		ssASCII(roq, ans+"");
		ssASCII(roq,ans+ascii);
		//System.out.print(ascii);
		//System.out.println();
	}

}
