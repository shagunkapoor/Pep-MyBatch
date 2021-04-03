
public class AArrayDisplay {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		disp(arr,0);
	}

	public static void disp(int[] arr, int vidx){
		if(vidx==arr.length){
			return;
		}
		
		System.out.print(arr[vidx]+" ");
		disp(arr,vidx+1);
	}
}
