import java.util.Scanner;

public class ADecimaltoBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no.");
		int dec = scn.nextInt();
		int bin = 0;
		int rem = 0;
		int pow = 1;
		while (dec != 0) {

			rem = dec % 2;
			dec = dec / 2;
			bin = bin + rem * pow;
			pow *= 10;
		}
		System.out.println(bin);

	}

}
