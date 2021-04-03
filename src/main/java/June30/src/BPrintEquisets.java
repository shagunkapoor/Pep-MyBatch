import java.util.ArrayList;

public class BPrintEquisets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		printequisets(arr, 0, "", 0, "", 0);
		System.out.println("--------------------------");
		printequisetswothAL(arr, 0, new ArrayList<>(), 0, new ArrayList<>(), 0);
	}

	//Pair of all sets whose sum is equal
	public static void printequisets(int[] arr, int vidx, String s1, int sos1, String s2, int sos2) {

		if (vidx == arr.length) {
			if (sos1 == sos2) {
				System.out.println(s1 + "--" + s2);
			}
			return;
		}
		printequisets(arr, vidx + 1, s1 + " " + arr[vidx], sos1 + arr[vidx], s2, sos2);
		printequisets(arr, vidx + 1, s1, sos1, s2 + " " + arr[vidx], sos2 + arr[vidx]);

	}

	public static void printequisetswothAL(int[] arr, int vidx, ArrayList<Integer> s1, int sos1, ArrayList<Integer> s2,
			int sos2) {
		if (vidx == arr.length) {
			if (sos1 == sos2) {
				System.out.println(s1 + "--" + s2);
			}
			return;
		}
		s1.add(arr[vidx]);
		printequisetswothAL(arr, vidx + 1, s1, sos1 + arr[vidx], s2, sos2);
		s1.remove(s1.size() - 1);
		s2.add(arr[vidx]);
		printequisetswothAL(arr, vidx + 1, s1, sos1, s2, sos2 + arr[vidx]);
		s2.remove(s2.size() - 1);
	}

}
