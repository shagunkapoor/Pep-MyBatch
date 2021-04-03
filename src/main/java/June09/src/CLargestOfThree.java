public class CLargestOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10; // 30 20 10
		int b = 20; // 20 30 10
		int c = 30; // 10 10 5

		if (a >= b && a >= c) {
			System.out.println(a);
			return;
			//return in main is used to simply terminate the program
		}
		if (b >= a && b >= c) {
			System.out.println(b);
			return;
		}
		System.out.println(c);
	}

}
