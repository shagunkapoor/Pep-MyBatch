import java.util.Scanner;

public class BReverseDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {1,2,3,4,5,6};
		revDisplay(arr,0);

	}
	public static void revDisplay(int[] arr, int vidx){
		if(vidx==arr.length)
			return;
	
	revDisplay(arr, vidx+1);
	System.out.print(arr[vidx]+" ");
	}
}



























