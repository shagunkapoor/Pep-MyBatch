import java.util.ArrayList;

public class AGetSubSequence {

	public static void main(String[] args) {

		String s="abc";
		ArrayList<String> res=new ArrayList<>();
		res=getSS(s);
		System.out.println(res);
	}
	public static ArrayList<String> getSS(String str){
		
		if(str.equals("")){
			ArrayList<String> base=new ArrayList<>();
			base.add("");
			return base;
		}
		
		char ch=str.charAt(0);        //a
		String rem=str.substring(1);  //bc
		
		ArrayList<String> list=getSS(rem);
		ArrayList<String> result= new ArrayList<>();
		for(String s:list){
			result.add("_"+s);
			result.add(ch+s);
		}
		
		
		
		return result;
		
	}

}
