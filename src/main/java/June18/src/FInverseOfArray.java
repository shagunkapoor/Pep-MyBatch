import java.util.Scanner;

public class FInverseOfArray {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the no. of elements");
		int n=scn.nextInt();
		int[] arr1=new int[n];
		int[] arr2=new int[n];
		System.out.println("Enter the elements");
		for(int i=0;i<arr1.length;i++){
			 arr1[i]=scn.nextInt();
			 if(arr1[i]>arr1.length-1){
				 System.out.println("Wrong elements");
				 return;
			 }
		}
		for(int i=0;i<arr1.length;i++){
			int x=arr1[i];
			arr2[x]=i;
		}
		ArrayUtils.display(arr2);
	}

}
