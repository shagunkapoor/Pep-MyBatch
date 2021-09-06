package June18;

import java.util.Scanner;

//Search the position of a particular element
public class BLinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the element to be searched");
		int num=scn.nextInt();
		int[] arr= ArrayUtils.takeInput();
		int pos=0;
		for(int i=0;i<arr.length;i++){
			if(num==arr[i]){
				pos=i+1;
				
			}
		}
		if(pos!=0)
			System.out.println("Element is present at position: "+pos);
		else
			System.out.println("Element not present");
	}

}
