import java.util.ArrayList;
import java.util.Scanner;

public class ESumOfDigitInString {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = scn.nextLine();
		int res=sumofdig(s);
		System.out.println(res);
}
	
	public static int sumofdig(String str){
		
		if(str.length()==0){
			return 0;
		}
//		System.out.println((int)'0');
		char ch=str.charAt(0);
		int n1=ch-'0';
		System.out.println(n1);
		String sub=str.substring(1);

		int sum=sumofdig(sub);
		int result=n1+sum;
		
		return result;
	}
}
