package AugNewBatch.Oct1_Subseq;

import java.util.ArrayList;

public class D {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		int tar = 140;

		 System.out.println("Target Subsets");
		 printTargetSubset(arr, tar, 0, 0, "");
		
		 System.out.println("Target Subset with ArrayList");
		 printTargetSubset2(arr, tar, 0, 0, new ArrayList<>());
		
		 System.out.println("Target Subset with Static");
		 printTargetSetswithStatic(arr, tar, 0, new ArrayList<>());

		System.out.println("Print Equisets");
		printEquiSets(arr, 0, new ArrayList<>(), 0, new ArrayList<>(), 0);

		//stringPerm("abc", "");
		//stringPermSB(new StringBuilder("abc"), new StringBuilder());
		
		stringPermutations("abc", "");
		stringPermutationsSB(new StringBuilder("abc"), new StringBuilder());
	}

	public static void printTargetSubset(int[] arr, int tar, int vidx, int ssf, String strsf) {

		if (vidx == arr.length) {
			if (ssf == tar) {
				System.out.println(strsf);
			}
			return;
		}

		printTargetSubset(arr, tar, vidx + 1, ssf, strsf);
		printTargetSubset(arr, tar, vidx + 1, ssf + arr[vidx], strsf + arr[vidx] + "-");
	}

	public static void printTargetSubset2(int[] arr, int tar, int vidx, int ssf, ArrayList<Integer> strsf) {
		if (vidx == arr.length) {
			if (ssf == tar) {
				System.out.println(strsf);
			}
			return;
		}

		printTargetSubset2(arr, tar, vidx + 1, ssf, strsf);
		strsf.add(arr[vidx]);
		printTargetSubset2(arr, tar, vidx + 1, ssf + arr[vidx], strsf);
		strsf.remove(strsf.size() - 1);

	}

	static int sumsf = 0;

	public static void printTargetSetswithStatic(int[] arr, int tar, int vidx, ArrayList<Integer> strsf) {
		if (vidx == arr.length) {
			if (sumsf == tar) {
				System.out.println(strsf);
			}
			return;
		}

		printTargetSetswithStatic(arr, tar, vidx + 1, strsf);
		strsf.add(arr[vidx]);
		sumsf += arr[vidx];
		printTargetSetswithStatic(arr, tar, vidx + 1, strsf);
		sumsf -= arr[vidx];
		strsf.remove(strsf.size() - 1);
	}

	public static void printEquiSets(int[] arr, int vidx, ArrayList<Integer> set1, int sos1, ArrayList<Integer> set2,
			int sos2) {
		if (vidx == arr.length) {
			if (sos1 == sos2) {
				System.out.println(set1 + "=" + set2);
			}
			return;
		}
		set1.add(arr[vidx]);
		printEquiSets(arr, vidx + 1, set1, sos1 + arr[vidx], set2, sos2);
		set1.remove(set1.size() - 1);
		set2.add(arr[vidx]);
		printEquiSets(arr, vidx + 1, set1, sos1, set2, sos2 + arr[vidx]);
		set2.remove(set2.size() - 1);
	}

	public static void stringPerm(String ques, String ans){//choices of answer
		if(ques.length()==0){
			System.out.println(ans);
			return;
		}
		
		char ch=ques.charAt(0);
		String ros=ques.substring(1);
		
		for(int i=0;i<=ans.length();i++){
			String left=ans.substring(0,i);
			String right=ans.substring(i);
			stringPerm(ros, left+ch+right);
		}
	}
	
	public static void stringPermSB(StringBuilder ques, StringBuilder ans){
		if(ques.length()==0){
			System.out.println(ans);
			return;
		}
		
		char ch=ques.charAt(0);
		ques.deleteCharAt(0);
		
		for(int i=0;i<=ans.length();i++){
			ans.insert(i, ch);
			stringPermSB(ques,ans);
			ans.deleteCharAt(i);
		}
		ques.insert(0, ch);
	}
		
	public static void stringPermutations(String ques, String ans) { //choices of question
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String left = ques.substring(0, i);
			String right = ques.substring(i + 1);
			String ros = left + right;
			stringPermutations(ros, ans + ch);
		}
	}
	
	public static void stringPermutationsSB(StringBuilder ques, StringBuilder ans){ //choices of question
		if(ques.length()==0){
			System.out.println(ans);
			return;
		}
		
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			ques.deleteCharAt(i);
			ans.append(ch);
			stringPermutationsSB(ques,ans);
			ans.deleteCharAt(ans.length()-1);
			ques.insert(i, ch);
			
		}
	}

}
