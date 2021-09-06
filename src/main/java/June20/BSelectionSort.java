package June20;

import java.util.Scanner;

public class BSelectionSort {

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
		int jrneycntr;
		for(jrneycntr=1;jrneycntr<n;jrneycntr++){
			for(int i=jrneycntr;i<n;i++){
				if(arr[jrneycntr-1]>arr[i]){
					int temp=arr[i];
					arr[i]=arr[jrneycntr-1];
					arr[jrneycntr-1]=temp;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
