package project.practice;

import java.util.Arrays;
import java.util.HashMap;

public class GoogleQues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={8,6,10,1,4,20,3,-5,5};
		subarrayWithSum(arr, 33);
		
		System.out.println("\n************");
		//Min Insertions to make a string palindrome
		String s="aabcaad";
		int count=minInPal(s);
		System.out.println(count);
	}
	
	public static void subarrayWithSum(int[] arr, int sum){
		int n=arr.length;
		findsiei(arr,n,sum, new HashMap<>());
	}
	private static void findsiei(int[] arr, int n, int sum, HashMap<Integer, Integer> hmap ){
		int curr_sum=0, start=-1, end=-1;
		
		for(int i=0;i<n;i++){
			curr_sum+=arr[i];
			
			if(curr_sum - sum==0){
				start=0;
				end=i;
				break;
			}
			
			if(hmap.containsKey(curr_sum-sum)){
				start=hmap.get(curr_sum-sum)+1;
				end=i;
				break;
			}
			
			hmap.put(curr_sum, i);
		}
		
		if(start!=-1 && end!=-1){
			System.out.println("SUBARRAY : start="+start+" end="+end);
			while(start<=end){
				System.out.print(arr[start]+" ");
				start++;
			}
		}else{
			System.out.println("No Subarray");
		}	
		
	}
	
	public static int minInPal(String str){
		int[][] arr=new int[str.length()][str.length()];
		int n=str.length();
		
//		Arrays.fill(arr, 0);
		
		for(int gap=1;gap<n;gap++){
			for(int sp=0, ep=gap;ep<n;sp++,ep++){
					
					System.out.println((str.charAt(sp)==str.charAt(ep))?arr[sp+1][ep-1]: Integer.min(arr[sp][ep-1], arr[sp+1][ep])+1);

					arr[sp][sp]=(str.charAt(sp)==str.charAt(ep))?arr[sp+1][ep-1]: (Integer.min(arr[sp][ep-1], arr[sp+1][ep])+1);
			
			}
		}
		return arr[0][n-1];
	}

}
