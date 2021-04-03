import java.util.Scanner;

//XRaiseToPowerN
public class HPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of test cases");
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println("Enter X and N");
			int x = scn.nextInt();
			int n = scn.nextInt();
			int res = power(x, n);
			System.out.println(res);
		}
	}

	public static int power(int x, int n) {
		if(x==0){
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		int result;
		if (n % 2 == 0) {
			result = power(x, n / 2) * power(x, n / 2);
		} else {
			result = x * power(x, n / 2) * power(x, n / 2);
		}
		
		return result;
	}

}
