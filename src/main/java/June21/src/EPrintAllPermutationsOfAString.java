
public class EPrintAllPermutationsOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		int n = s.length();
		int totalpermut = fact(n);
		// System.out.println(totalpermut);
		printpermutations(s, totalpermut);

	}

	public static int fact(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static void printpermutations(String str, int n) {
	StringBuilder sb=new StringBuilder();
	
	for(int i=0;i<str.length();i++){
		String s=str+3;
	}
	}

}
