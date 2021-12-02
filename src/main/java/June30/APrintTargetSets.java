package June30;

import java.util.ArrayList;
import java.util.Scanner;

public class APrintTargetSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Scanner scn=new Scanner(System.in);
		// System.out.println("Enter the size of array");
		// int n=scn.nextInt();
		// int[] arr=new int[n];
		// System.out.println("Enter the array");
		// for(int i=0;i<n;i++){
		// arr[i]=scn.nextInt();
		// }
		// System.out.println("Enter the target");
		// int target=scn.nextInt();

		int[] arr = { 10, 20, 30, 40, 50 };
		printsubset(arr, 0, 100, "", 0);
		System.out.println("--------------------------");
		ArrayList<Integer> list=new ArrayList<>();
		printsubsetusingArrayList(arr,0,100,list,0);
	}

	//Time -> O(2^n)
	//Space-> O(n)

	//All subsets with sum < target
	public static void printsubset(int[] arr, int vidx, int target, String ssf,int sumsf){

		if(vidx==arr.length){
			if(sumsf<target){
				System.out.println(ssf);
			}
			return;
		}

		printsubset(arr, vidx+1, target, ssf, sumsf);
		printsubset(arr, vidx+1, target, ssf+" "+arr[vidx], sumsf+arr[vidx]);
	}
	public static void printsubsetusingArrayList(int[] arr, int vidx, int target, ArrayList<Integer> ssf,int sumsf){

		if(vidx==arr.length){
			if(sumsf<target){
				System.out.println(ssf);
			}
			return;
		}
			printsubsetusingArrayList(arr,vidx+1,target,ssf,sumsf);
			ssf.add(arr[vidx]);
			printsubsetusingArrayList(arr,vidx+1,target,ssf,sumsf+arr[vidx]);
			ssf.remove(ssf.size()-1);
		}

}
