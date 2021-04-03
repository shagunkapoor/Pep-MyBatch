import java.util.Scanner;

public class BBinarytoDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no.");
		int bin = scn.nextInt();
		int pow=1;
		int val=0;
		int dec=0;
		while(bin!=0){
			val=bin%10;
			bin=bin/10;
			dec=dec+val*pow;
			pow*=2;
			
		}
		System.out.println(dec);
	}

}
