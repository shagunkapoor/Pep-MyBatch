import java.util.Scanner;

public class DOctalMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no.");
		int oct1 = scn.nextInt();
		int oct2 = scn.nextInt();
		int n1 = 0;
		int n2 = 0;
		int pow = 1;
		int x = 1;
		while (oct2 != 0) {
			int i = oct2 % 10;
			int carry = 0;
			int temp = oct1;							//INCOMPLETE
			int sum = 0;
			while (temp != 0) {
				n1 = temp % 10;
				temp /= 10;
				int dig = (n1 * i) + carry;
				carry = dig / 8;
				dig = dig % 8;
				sum += (dig * pow);
				pow *= 10;
			}
			int sum1 = sum + (carry * pow);
//			octaladdition(sum1, sum2);
			System.out.println(sum1);
			pow = 10 * x;
			x *= 10;
			oct2 /= 10;
		}
	}
}