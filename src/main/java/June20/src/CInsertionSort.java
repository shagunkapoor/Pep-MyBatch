import java.util.Scanner;

public class CInsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the array size");
		int n=scn.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter the array elements");
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		for(int jrneycntr=1;jrneycntr<n;jrneycntr++){
			for(int i=jrneycntr;i>0;i--){
				if(arr[i]<arr[i-1]){
					int temp=arr[i];
					arr[i]=arr[i-1];
					arr[i-1]=temp;
				}else{
					break;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
