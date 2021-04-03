import java.util.ArrayList;
import java.util.Scanner;

public class HReplaceHiWithpep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter");
		String s = scn.nextLine();
		int index = scn.nextInt();
		StringBuilder sb=new StringBuilder();
		String res=replacehiwithpep(s,0,sb);
		System.out.println(res.charAt(index));
		printtring(s,0);
		
	}
	static int cnt=0;
	public static String replacehiwithpep(String str, int vidx, StringBuilder sb){
		if(vidx>=str.length()-1){
			return "";
		}
		if(str.charAt(vidx)=='h' && str.charAt(vidx+1)=='i'){
			sb.insert(cnt, "pep");
			cnt+=3;
			replacehiwithpep(str,vidx+2,sb);
		}else{
			sb.append(str.charAt(vidx));
			cnt++;
			replacehiwithpep(str,vidx+1,sb);
		}
		
		return sb.toString();
	}
	public static void printtring(String str, int vidx){
		if(vidx>=str.length()-1){
			if(vidx==str.length()-1)
				System.out.println(str.charAt(vidx));
			return;
		}
		if(str.charAt(vidx)=='h' && str.charAt(vidx+1)=='i'){
			System.out.print("pep");
			printtring(str,vidx+2);
		}else{
			System.out.print(str.charAt(vidx));
			printtring(str,vidx+1);
		}
	}

}
