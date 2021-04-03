import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class BHighestFreqChar {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// String s = "aabrakakdaabra";
		// char highest = highestfreq(s);
		// System.out.println(highest);
		// }
		//
		// public static char highestfreq(String str) {
		// int[] arr = new int[26];
		//
		// for (int i = 0; i < str.length(); i++) {
		// int index = str.charAt(i) - 'a';
		// arr[index]++;
		// }
		// int max = 0;
		//
		// for (int i = 0; i < arr.length; i++) {
		// if (arr[max] < arr[i]) {
		// max = i;
		// }
		// }
		// return (char) (max + 'a');
		// }
		// }

		// Scanner scn = new Scanner(System.in);
		// System.out.println("Enter the no. of test cases");
		// int t = scn.nextInt();
		// for (int i = 0; i < t; i++) {
		// System.out.println("Enter the string");
		// String s=scn.nextLine();
		// char highest = highestfreq(s);
		// System.out.println(highest);
		// }
		// }
		//
		// public static char highestfreq(String str) {
		// int[] arr = new int[26];
		//
		// for (int i = 0; i < str.length(); i++) {
		// int index = str.charAt(i) - 'a';
		// arr[index]++;
		// }
		// int max = 0;
		//
		// for (int i = 0; i < arr.length; i++) {
		// if (arr[max] < arr[i]) {
		// max = i;
		// }
		// }
		// return (char) (max + 'a');
		// }
		// }
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of test cases");
		int t = br.read();
		for (int i = 0; i < t; i++) {

			System.out.println("Enter the string");
			String s = br.readLine();

			int[] alph = new int[256];

			for (int x = 0; x < s.length(); x++) {
				alph[(int) s.charAt(x)]++;
			}
			int max = 0;
			for (int index = 0; index < alph.length; index++) {
				if (alph[index] > alph[max]) {
					max = index;
				}
			}
			System.out.println((char) (max));
		}
	}
}
