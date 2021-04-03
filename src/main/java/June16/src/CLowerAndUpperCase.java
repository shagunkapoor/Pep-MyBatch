import java.util.Scanner;

public class CLowerAndUpperCase {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the character");
		char ch=scn.nextLine().charAt(0);
		
		if((ch>='a')&&(ch<='z')){
			System.out.println("Lowercase");
		}else if((ch>='A') &&(ch<='Z')){
			System.out.println("Uppercase");
		}else
			System.out.println("Invalid");
		
//		//ASCII VALUES
//		System.out.println((int)'0'); //48
//		System.out.println((int)'9'); //57
//		System.out.println((int)'a'); //97
//		System.out.println((int)'z'); //122
//		System.out.println((int)'A'); //65
//		System.out.println((int)'Z'); //90
	}

}
