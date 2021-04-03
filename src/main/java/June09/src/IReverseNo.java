import java.util.Scanner;

public class IReverseNo {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the number");
		int num=scn.nextInt();
		int rem;
		int sum=0;
		while(num!=0){
			rem=num%10;
			num=num/10;
			sum=sum*10+rem;
			
		}
		System.out.println("The reverse of the given number is: "+sum );
	}

}
