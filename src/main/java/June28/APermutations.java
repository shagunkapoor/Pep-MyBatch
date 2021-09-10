package June28;

public class APermutations {

	// Total no of ways to place 3 queens in  5 boxes
	public static void main(String[] args) {

		boolean[] boxes = new boolean[5];
		permutations(boxes, 3, 0, "");

	}

	static int counter = 0;

	public static void permutations(boolean[] boxes, int tnq, int qpsf, String csf) {
		if (qpsf == tnq) {
			counter++;
			System.out.println(counter + " " + csf);
			return;
		}

		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				permutations(boxes, tnq, qpsf + 1, csf + "q" + qpsf + "b" + i + " ");
				boxes[i] = false;
			}
		}

	}

}
