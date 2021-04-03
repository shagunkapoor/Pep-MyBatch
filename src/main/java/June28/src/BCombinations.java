
public class BCombinations {

	public static void main(String[] args) {
		boolean[] boxes = new boolean[5];
		combinations(boxes, 3, 0, "",-1);

	}

	static int counter = 0;

	public static void combinations(boolean[] boxes, int tnq, int qpsf, String csf,int lqpb) {
		if (qpsf == tnq) {
			counter++;
			System.out.println(counter + " " + csf);
			return;
		}

		for (int i = lqpb+1; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				combinations(boxes, tnq, qpsf + 1, csf + "q" + qpsf + "b" + i + " ",i);
				boxes[i] = false;
			}
			
		}

	}

}
