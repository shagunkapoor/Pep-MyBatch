package Oct1_Subseq;

import java.util.ArrayList;

public class BRecursion {

	public static void main(String[] args) {
//		System.out.println("Inverse");
//		int[] arr = { 3, 4, 2, 1, 0 };
//		inverse(arr, 0, 0);
//		for (int i : arr)
//			System.out.println(i);
//
//		System.out.println("First Index");
//		int[] arrfi = { 3, 9, 2, 7, 9, 9, 4, 9, 3, 6 };
//		int fi = firstIndex(arrfi, 0, 9);
//		System.out.println(fi);
//
//		System.out.println("Last Index");
//		int li = lastIndex(arrfi, 0, 9);
//		System.out.println(li);
//
//		System.out.println("All Indices");
//		int[] allind = allIndices(arrfi, 0, 9, 0);
//		for (int i : allind) {
//			System.out.println(i);
//		}
//
//		System.out.println("Get Subseq with ASCII");
//		ArrayList<String> res = getSubseq("abc");
//		System.out.println(res);
//
//		System.out.println("Get Key Pad Code");
//		ArrayList<String> reskpc = getKPC("367");
//		System.out.println(reskpc);
//
//		System.out.println("Get Board Paths");
//		ArrayList<String> resbp = getBoardPaths(0, 10);
//		System.out.println(resbp);
//		
		System.out.println("Subsequence");
		subSequence("abc");
		
		System.out.println("String Permutations");
		ArrayList<StringBuilder> result=stringPermutations("abc");
		for(StringBuilder r:result){
			System.out.println(r);
		}
		
	}

	public static void inverse(int[] arr, int vidx, int val) {
		if (vidx == arr.length) {
			return;
		}

		val = arr[vidx];
		inverse(arr, vidx + 1, val);
		arr[val] = vidx;
	}

	public static int firstIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == data) {
			return vidx;
		}
		int indx = firstIndex(arr, vidx + 1, data);

		return indx;
	}

	public static int lastIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		int indx = lastIndex(arr, vidx + 1, data);
		if (indx == -1) {
			if (arr[vidx] == data) {
				return vidx;
			} else {
				return indx;
			}
		} else {
			return indx;
		}
	}

	public static int[] allIndices(int[] arr, int vidx, int data, int csf) {
		if (vidx == arr.length) {
			return new int[csf];
		}

		if (arr[vidx] == data) {
			int res[] = allIndices(arr, vidx + 1, data, csf + 1);
			res[csf] = vidx;
			return res;
		} else {
			int res[] = allIndices(arr, vidx + 1, data, csf);
			return res;
		}
	}

	public static ArrayList<String> getSubseq(String str) {
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rossubseq = getSubseq(ros);
		ArrayList<String> res = new ArrayList<>();

		for (String s : rossubseq) {
			res.add("-" + s);
			res.add(ch + s);
			res.add((int) ch + s);
		}

		return res;
	}

	static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static ArrayList<String> getKPC(String keys) {

		if (keys.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		char ch = keys.charAt(0);
		String remkeys = keys.substring(1);

		String chcode = codes[ch - '0'];

		ArrayList<String> remkeysres = getKPC(remkeys);
		ArrayList<String> res = new ArrayList<>();

		for (String s : remkeysres) {
			for (int i = 0; i < chcode.length(); i++) {
				res.add(chcode.charAt(i) + s);
			}
		}

		return res;
	}

	public static ArrayList<String> getBoardPaths(int src, int dest) {
		if (src == dest) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> srctodest = new ArrayList<>();

		for (int dice = 1; dice <= 6 & (src+dice)<=dest; dice++) {
			int inter = src + dice;

			ArrayList<String> intertodest = getBoardPaths(inter, dest);

				for (String i : intertodest) {
					String srcpath = dice + i;
					srctodest.add(srcpath);
				}
		}

		return srctodest;
	}
	
	public static void subSequence(String str){
		
		for(int i=0;i<(1<<str.length());i++){
			for(int j=str.length()-1;j>=0;j--){
				int mask=1<<j;
				if((mask&i)==0){
					System.out.print("_ ");
				}else{
					System.out.print(str.charAt(str.length()-j-1)+" ");
				}
			}
			System.out.println();
		}
	}
	
	public static ArrayList<StringBuilder> stringPermutations(String str){
		
		if(str.length()==1){
			ArrayList<StringBuilder> base=new ArrayList<>();
			base.add(new StringBuilder(str));
			return base;
		}
		
		char ch=str.charAt(0);
		String ros=str.substring(1);
		
		ArrayList<StringBuilder> restAL=stringPermutations(ros);
		ArrayList<StringBuilder> res=new ArrayList<>();
		
		for(StringBuilder r:restAL){
			StringBuilder temp=r;
			for(int i=0;i<r.length();i++){
				r.insert(i, ch);
				res.add(r);
				r=temp;
			}
		}
		return res;
	}
	
	public static void printAllPossibleCode(String str){
		
	}

}
