package June27;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//RJ is a very curious observer. On the first day of every month, he tries to
//figure out, for each of the seven days of the week, how many times that day
//occurs in the current month.
//
//RJ got confused so badly doing this that he asks for your help! He asks several
//queries; in each query, he gives you the number of days in the current month and
//which day of the week is on the 1st of the current month.
//
//For each query, you should tell him how many times each day of the week occurs.
//
//Example
//Input:
//
//2
//28 mon
//31 wed
//
//Output:
//
//4 4 4 4 4 4 4
//4 4 5 5 5 4 4
public class GDaysInMonth {

	static String[] days = { "mon", "tue", "wed", "thurs", "fri", "sat", "sun" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of test cases");
		int test = scn.nextInt();
		System.out.println("Enter the no. of days in a month & day on 1st of that month");

		for (int i = 1; i <= test; i++) {
			int D = scn.nextInt();
			String S = scn.next();
			int idx = -1;
			for (int x = 0; x < 7; x++) {
				if (days[x].equals(S)) {
					idx = x;
					break;
				}
			}
			int[] res = new int[7];
			Arrays.fill(res, D / 7);
			incdays(D % 7, res, idx);

			for (int x : res) {
				System.out.print(x + " ");
			}
		}

	}

	private static int[] incdays(int d, int[] res, int idx) {
		if (d == 0) {
			return res;
		}

		res[idx]++;
		return incdays(d - 1, res, (idx + 1) % 7);
	}

}