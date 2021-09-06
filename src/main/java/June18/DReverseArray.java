package June18;

public class DReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= ArrayUtils.takeInput();
		ArrayUtils.display(arr);
		int n=arr.length;
//		for(int i=0,j=n-1;i<(arr.length)/2;i++,j--){
//
//			int temp=arr[i];
//			arr[i]=arr[j];
//			arr[j]=temp;
//			
//		}
//		ArrayUtils.display(arr);
//		}
	
//OR
		int left=0;
		int right=n-1;
		while(left<right){
			ArrayUtils.swap(arr, left, right);
			left++;
			right--;
		}
	
	ArrayUtils.display(arr);
	}
}
