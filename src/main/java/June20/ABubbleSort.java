package June20;

import java.util.Scanner;

public class ABubbleSort {

	public static void main(String[] args) {

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
			for(int i=0;i<n-jrneycntr;i++){
				if(arr[i]>arr[i+1]){
					int temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
}