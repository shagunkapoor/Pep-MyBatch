import java.util.Scanner;

public class BBinaryAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the binary numbers");
		int bin1 = scn.nextInt();
		int bin2 = scn.nextInt();
		int n1 = 0;
		int n2 = 0;
		int sum = 0;
		int c = 0;
		int pow = 1;
		while (bin1 != 0) {
			n1 = bin1 % 10;
			n2 = bin2 % 10;
			bin1 /= 10;
			bin2 /= 10; 
			int dig = (n1 + n2 + c);
			c = dig / 2;
			dig = dig % 2;
			sum += dig * pow;
			pow *= 10;
		}
		System.out.println(c*pow+sum);
	}

}
