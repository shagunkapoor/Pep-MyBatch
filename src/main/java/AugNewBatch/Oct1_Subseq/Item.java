package AugNewBatch.Oct1_Subseq;

public class Item implements Comparable<Item>{

	int wt;
	int val;
	Double valbywt;
	@Override
	
	
	public int compareTo(Item o){
		return (int) (this.valbywt-o.valbywt);
	}
}
