package June21;

import java.awt.font.NumericShaper;
import java.util.HashSet;

//import java.util.HashSet;

public class CIsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 String s="eclipilce";
		boolean res;
		String str="Madam --12I'21m Adam";
//		String str="e1ating 0gnita1e";
		str=str.toLowerCase();
		
		res=check(str);
		
		System.out.println(res);
		
		
	}
	
	public static boolean check(String sentence) {
		
		int left=0;
		int right=sentence.length()-1;
	
		while(left<right){
			
			if(!Character.isLetterOrDigit(sentence.charAt(left))){
				left++;
			}else if(!Character.isLetterOrDigit(sentence.charAt(right))){
				right--;
			}else{
				if(sentence.charAt(left)!=sentence.charAt(right))
					return false;
				left++;
				right--;
			}
		
		}
        return true;
    }
}
/*
 * int n = s.length(); boolean res = true; // for(int i=0,j=n-1;i<n/2 &&
 * j>=n/2;i++,j--){ // if(s.charAt(i)!=s.charAt(j)){ // CORRECT // res=false; //
 * } // } // int left = 0; int right = s.length() - 1; while (left < right) { if
 * (s.charAt(left) != s.charAt(right)) { res = false; } left++; right--; }
 * 
 * if (res == true) { System.out.println("String is Palindrome"); } else
 * System.out.println("String is not Palindrome"); }
 * 
 * }
 */
