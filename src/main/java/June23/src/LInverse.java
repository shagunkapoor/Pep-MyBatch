import java.util.Scanner;

//Input:
//4
//1 2 3 0
//2
//Output:
//3 0 1 2
//1
public class LInverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the array size");
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int indx = scn.nextInt();
		int[] res = new int[n];
		res = inverse(arr, 0);
		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		System.out.print(res[indx]);
	}

	public static int[] inverse(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return new int[arr.length];
		}

		int[] inv = inverse(arr, vidx + 1);
		int temp = arr[vidx];
		inv[temp] = vidx;
		return inv;
	}

}
