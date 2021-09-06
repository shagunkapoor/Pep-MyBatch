package June26;

public class DPrintBoardPaths {

	public static void main(String[] args) {
		int src=0;
		int dest=10;
		String ans="";
		printboard(src,dest,ans);
	}
	
	public static void printboard(int s, int d, String ans){
	if(s==d){
		System.out.println(ans);
		return;
	}
	if(s>d){
		return;
	}
		
		for(int dice=1;dice<=6;dice++){
			int inter=s+dice;
			//ans=ans+dice;
			printboard(inter,d,ans+dice);
			
		}
	}

}
