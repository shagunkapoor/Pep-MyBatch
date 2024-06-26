package KJuly27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueue1 {

	public static void main(String[] args) {

		int[] arr = { 10, 44, 2, 15, 9, 63, 8 };
//		System.out.println("MIN PQ");
//		minPQ(arr);
		/*
		System.out.println();
		// System.out.println("MAX PQ");
		// maxPQ(arr);
		// System.out.println();
		System.out.println("Print K largest");
		printKLargestItems(arr, 3);
		// System.out.println("Print K smallest");
		// printKSmallestItems(arr, 3);
		//
		*/
		 ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		 lists.add(new ArrayList<>(Arrays.asList(11, 15, 20, 25)));
		 lists.add(new ArrayList<>(Arrays.asList(5, 7, 14)));
		 lists.add(new ArrayList<>(Arrays.asList(8, 12, 16, 24, 32)));
		 lists.add(new ArrayList<>(Arrays.asList(30, 40)));
		 System.out.println("Merge K Sorted Lists");
		 mergeKSortedLists(lists);
		 /*
		//
		// System.out.println();
		// int[] arr2 = { 30, 22, 10, 40, 55, 60, 50, 70 };
		// sortNearlySortedArray(arr2, 2);
		//
		MedianPQ mp = new MedianPQ();
		mp.add(10);
		mp.add(50);
		mp.add(5);
		mp.add(-1);
		mp.add(80);
		System.out.println(mp.peek());
*/
	}

	public static void minPQ(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int val : arr) {
			pq.add(val);
		}
		// Trial for extra functions
		 if(pq.contains(2))
		 System.out.println("2 is present");

//		 System.out.println(pq);
//		 pq.poll();
//		 pq.clear();
//		 pq.remove();
//		 pq.remove(63);
//
//		 Object[] parr=pq.toArray();
//		 for(int i=0;i<parr.length;i++){
//		 System.out.print(parr[i]+" ");
//		 }

		 System.out.println(pq);
		while (pq.size() > 0) {
			System.out.print(pq.remove() + " ");
		}
//		 System.out.println(pq);
	}

	public static void maxPQ(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int val : arr) {
			pq.add(val);
		}
		while (pq.size() > 0) {
			System.out.print(pq.remove() + " ");
		}
	}

	public static void printKLargestItems(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				pq.add(arr[i]);
			} else {
				if (arr[i] > pq.peek()) {
					pq.remove();
					pq.add(arr[i]);
				}
			}
		}
		System.out.println(pq);
	}

	public static void printKSmallestItems(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				pq.add(arr[i]);
			} else {
				if (arr[i] < pq.peek()) {
					pq.remove();
					pq.add(arr[i]);
				}
			}
		}
		System.out.println(pq);
	}

	public static class priorityClass implements Comparable<priorityClass> {
		int list_index;
		int arr_index;
		int data_value;

		public priorityClass(int list_index, int arr_index, int data_value) {
			this.list_index = list_index;
			this.arr_index = arr_index;
			this.data_value = data_value;
		}

		@Override
		public int compareTo(priorityClass o) {
			return this.data_value - o.data_value;
		}
	}

	public static void mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		PriorityQueue<priorityClass> pq = new PriorityQueue<>();
		for (int i = 0; i < lists.size(); i++) {
			pq.add(new priorityClass(i, 0, lists.get(i).get(0)));
		}
		while (pq.size() > 0) {
			priorityClass rp = pq.remove();
			System.out.print(rp.data_value + " ");
			rp.arr_index++;
			if (rp.arr_index < lists.get(rp.list_index).size()) {
				rp.data_value = lists.get(rp.list_index).get(rp.arr_index);
				pq.add(rp);
			}
		}
	}

	//int[] arr2 = { 30, 22, 10, 40, 55, 60, 50, 70 };
	public static void sortNearlySortedArray(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i <= k; i++) {
			pq.add(arr[i]);
		}

		for (int i = k + 1; i < arr.length; i++) {
			System.out.println(pq.remove());
			pq.add(arr[i]);
		}
		while (pq.size() > 0) {
			System.out.println(pq.remove());
		}
	}

	public static class MedianPQ {

		//Larger half
		PriorityQueue<Integer> lhminPQ = new PriorityQueue<>();
		//Shorter half
		PriorityQueue<Integer> shmaxPQ = new PriorityQueue<>(Collections.reverseOrder());
		int size = 0;

		public void add(int data) {
			if (shmaxPQ.size() != 0 && data < shmaxPQ.peek()) {
				shmaxPQ.add(data);
			} else if (lhminPQ.size() != 0 && data > lhminPQ.peek()) {
				lhminPQ.add(data);
			} else {
				shmaxPQ.add(data);
			}
			if (shmaxPQ.size() - lhminPQ.size() > 1) {
				lhminPQ.add(shmaxPQ.remove());
			} else if (lhminPQ.size() - shmaxPQ.size() > 1) {
				shmaxPQ.add(lhminPQ.remove());
			}

			size++;
		}

		public int peek() {
			if (size == 0) {
				return -1;
			}
			return shmaxPQ.size() >= lhminPQ.size() ? shmaxPQ.peek() : lhminPQ.peek();
		}

		public int remove() {
			if (size == 0) {
				return -1;
			}
			size--;
			return shmaxPQ.size() >= lhminPQ.size() ? shmaxPQ.remove() : lhminPQ.remove();

		}
	}

}
