package June21;

import java.util.Scanner;

public class erfsf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the string");
		String s=scn.nextLine();

		boolean res=palindrome(s);
		System.out.println(res);
		}
	public static boolean palindrome(String str){
		StringBuilder sb=new StringBuilder();
		
		int n=str.length();
		boolean result=true;
		for(int i=0,j=n-1;i<n/2 && j>=n/2;i++,j--){
			if(str.charAt(i)!=str.charAt(j))
				result=false;
		}
		return result;
	}

}
