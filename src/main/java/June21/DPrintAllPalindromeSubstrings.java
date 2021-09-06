package June21;

public class DPrintAllPalindromeSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="nitin";
		//System.out.println(s);
		int n=s.length();
		
		for(int i=0;i<n;i++){
			for(int j=i+1;j<=n;j++){
				String check=s.substring(i,j);
				int checklen=check.length();
				boolean res=true;
				for(int a=0,b=checklen-1;a<checklen/2 &&b>=checklen/2;a++,b--){
					if(check.charAt(a)!=check.charAt(b)){
						res=false;
					}
				}
				if(res==true){
					System.out.println(check);
				}
			}
		}
	}

}
