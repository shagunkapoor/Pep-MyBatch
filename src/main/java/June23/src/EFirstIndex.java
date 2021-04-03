import java.util.Scanner;

public class EFirstIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 6, 1, 94, 5, 6 };
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the number whose index is to be printed");
		int n=scn.nextInt();
		int res = firstIndex(arr, 0,n);
		System.out.println(res);
	}
	public static int firstIndex(int[] arr, int vidx, int data){
		if(vidx==arr.length)
			return -1;
		
		if(data==arr[vidx])
			return vidx;
		int val=firstIndex(arr,vidx+1,data);
		
		
		return val;
	}

}


