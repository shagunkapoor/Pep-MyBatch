package KJuly30;

import java.util.ArrayList;

public class Heap {
	
	// priorityflag - true : max priority
	// priorityflag - false : min priority
	boolean priorityflag;
	ArrayList<Integer> aldata = new ArrayList<>();

	public Heap(boolean priorityflag) {
		this.priorityflag = priorityflag;
	}

	public Heap(boolean priorityflag, int[] arr) { // Heap Construction
		this.priorityflag = priorityflag;
		for (int val : arr) {
			aldata.add(val);
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			downheapify(i);
		}
	}

	// i>j => +ve
	// i==j => 0
	// i<j => -ve
	public int compareTo(int i, int j) {
		int ith = aldata.get(i);
		int jth = aldata.get(j);

		if (priorityflag) {
			return ith - jth;
		} else {
			return jth - ith;
		}
	}

	public int size() {
		return aldata.size();
	}

	public boolean isEmpty() {
		if (aldata.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void swap(int i, int j) {

		int ith = aldata.get(i);
		int jth = aldata.get(j);

		aldata.set(i, jth);
		aldata.set(j, ith);
	}

	public void upheapify(int ci) {
		if (ci == 0) {
			return;
		}
		int pi = (ci - 1) / 2;
		if (compareTo(ci, pi) > 0) { // ci>pi
			swap(ci, pi);
			upheapify(pi);
		}
	}

	public void downheapify(int pi) {

		int maxi = pi;
		int lci = (2 * pi) + 1;
		if (lci < aldata.size() && compareTo(lci, maxi) > 0) {
			maxi = lci;
		}
		int rci = (2 * pi) + 2;
		if (rci < aldata.size() && compareTo(rci, maxi) > 0) {
			maxi = rci;
		}

		if (pi != maxi) {
			swap(pi, maxi);
			downheapify(maxi);
		}
	}

	public void display() {
		System.out.println(aldata);
	}

	public void add(int val) {
		aldata.add(val);
		upheapify(aldata.size() - 1);
	}

	public int peek() {
		if (aldata.size() == 0) {
			return -1;
		} else
			return aldata.get(0);
	}

	public int remove() {

		swap(0, aldata.size() - 1);
		int rv = aldata.remove(aldata.size() - 1);
		downheapify(0);
		return rv;

	}

}
