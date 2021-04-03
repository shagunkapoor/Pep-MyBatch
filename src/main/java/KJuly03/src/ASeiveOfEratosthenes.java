import java.util.Arrays;
import java.util.Scanner;

public class ASeiveOfEratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = scn.nextInt();
		printPrimesSOE(n);

	}

	public static void printPrimesSOE(int n) {
		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i * i <= n; i++) {
			if (primes[i] == true) {
				for (int x = i; x * i <= n; x++) {
					primes[i * x] = false;
				}
			}
		}

		for (int i = 0; i <= n; i++) {
			if (primes[i])
				System.out.println(i);
		}

	}
}
