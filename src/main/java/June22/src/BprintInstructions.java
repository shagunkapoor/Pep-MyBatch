//Tower of Hanoi
public class BprintInstructions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int res = printInstructions("A", "B", "C", 3);
		System.out.println(res);
	}

	public static int printInstructions(String src, String dest, String helper, int n) {

		if (n == 0) {
			return 0;
		}
		int c1 = printInstructions(src, helper, dest, n - 1);
		System.out.println("Move " + n + " from " + src + " to " + dest);
		int c2 = printInstructions(helper, dest, src, n - 1);

		return c1 + c2 + 1;
	}
}
