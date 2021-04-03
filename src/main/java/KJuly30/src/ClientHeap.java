
public class ClientHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Heap hp=new Heap(true);
		// int[] arr={2,9,14,19,28,7,5,11,-1};
		// for(int val:arr){
		// hp.add(val);
		// }
		//
		// hp.display();
		// System.out.println("PEEK VALUE: "+hp.peek());
		//
		// if(hp.size()>0){
		// System.out.println(hp.remove());
		// }
		// hp.display();

		// int[] arr={2,9,14,19,28,7,5,11,-1};
		// Heap hp=new Heap(true,arr);
		// hp.display();

		// August 1

		int[] arr = { 10,8,5,3,2,1,7};//2, 9, 14, 19, 28, 7, 5, 11, -1 };
		heapSort(arr);
		for (int val : arr) {
			System.out.print(val+" ");
		}
	}

	public static void heapSort(int[] arr) {

		for (int i = arr.length - 1; i >= 0; i--) { // decreasing order
			downheapify(arr, i, arr.length);
		}

		for (int i = arr.length - 1; i >= 0; i--) { // swap first & last and
													// sort again
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			downheapify(arr, 0, i);

		}
	}

	public static void downheapify(int[] arr, int pi, int vep) {

		int maxi = pi;

		int lci = (2 * pi) + 1;
		if (lci < vep && arr[lci] > arr[maxi]) {
			maxi = lci;
		}

		int rci = (2 * pi) + 2;
		if (rci < vep && arr[rci] > arr[maxi]) {
			maxi = rci;
		}

		if (pi != maxi) {
			int temp = arr[pi];
			arr[pi] = arr[maxi];
			arr[maxi] = temp;

			downheapify(arr, maxi, vep);
		}

	}

}
