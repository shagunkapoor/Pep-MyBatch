package AugNewBatch.Oct1_Subseq;

import java.util.Arrays;

public class EDPGreedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		egyptianFraction(5, 12);
		int[] wt = { 10, 40, 20, 30 };
		int[] val = { 60, 40, 100, 120 };

		fractionalKnapSack(wt, val, 50);
	}

	public static void egyptianFraction(int n, int d) {

		if (d % n == 0) {
			int fn = 1;
			int fd = d / n;
			System.out.println(fn + "/" + fd);
			return;
		}

		int fn = 1;
		int fd = d / n + 1;
		System.out.print(fn + "/" + fd + " + ");
		int nn = n * fd - d;
		int nd = d * fd;

		egyptianFraction(nn, nd);

	}

	public static void fractionalKnapSack(int[] wt, int[] val, int bag) {

		Item[] items = new Item[wt.length];

		for (int i = 0; i < items.length; i++) {
			items[i] = new Item();
			items[i].wt = wt[0];
			items[i].val = val[0];
			items[i].valbywt = (double) (items[i].val / items[i].wt);
		}

		Arrays.sort(items);
		int x = items.length - 1;
		double valinbag = 0;
		int remcap = bag;
		while (x >= 0) {

			if (remcap > items[x].wt) {
				remcap -= items[x].wt;
				valinbag += items[x].val;
			} else {
				valinbag += items[x].valbywt * remcap;
				remcap = 0;
				break;
			}
			x--;
		}
		
		System.out.println(valinbag);
	}
	
	public static void minPlatformsRequired(){
		
	}

}
