import java.util.Scanner;

public class DChangeCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the character");
		char ch=scn.nextLine().charAt(0);
		char conv=0;
		if((ch>='a')&&(ch<='z')){
			conv=(char)(ch-'a'+'A');
			//ch-=32;
			
		}else if((ch>='A') &&(ch<='Z')){
			conv=(char)(ch+'a'-'A');
			//ch+=32;
		}
		System.out.println(conv);
	}

}
