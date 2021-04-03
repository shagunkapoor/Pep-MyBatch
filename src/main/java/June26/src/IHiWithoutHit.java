import java.util.ArrayList;
import java.util.Scanner;
//a. Write a recursive function which counts the number of times ‘hi’ appears in
//the string – but skip all such ‘hi’ which are followed by ‘t’ to form ‘hit’.
//Print the value returned.
//b. Write a recursive function which removes all ‘hi’ in the string – but skip
//all such ‘hi’ which are followed by ‘t’ to form ‘hit’. Print the i'th index
//character from the returned value.
//c. Write a recursive function which removes all ‘hi’ in the string – but skip
//all such ‘hi’ which are followed by ‘t’ to form ‘hit’. Print the
//output (return type void).
//
//
//Example(To be used only for expected output):
//
//Input:
//hihihithi 2
//
//output
//3
//t
//hit

public class IHiWithoutHit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string :");
		String s = scn.nextLine();
		int index = scn.nextInt();
		int res1 = counthi(s, 0);
		System.out.println(res1);
		StringBuilder sb=new StringBuilder();
		String res2=removeallhi(s,0,sb);
		//System.out.println(res2.charAt(index));
		printhiwithouthit(s,0);
	}

	static int cnt = 0;

	public static int counthi(String str, int vidx) {
		if (vidx == str.length()-2) {
			if (str.charAt(vidx) == 'h' && str.charAt(str.length()-1) == 'i'){
				cnt++;
			}
			return cnt;
		}
		if (str.charAt(vidx) == 'h' && str.charAt(vidx + 1) == 'i' && str.charAt(vidx + 2) == 't') {
			counthi(str, vidx + 1);
		} else if (str.charAt(vidx) == 'h' && str.charAt(vidx + 1) == 'i') {
			cnt++;
			counthi(str, vidx + 1);
		} else {
			counthi(str, vidx + 1);
		}

		return cnt;
	}
	public static String removeallhi(String str, int vidx, StringBuilder sb){
		if (vidx == str.length()-2) {
			if (str.charAt(vidx) == 'h' && str.charAt(str.length()-1)=='i'){
	
			}else{
				sb.append(str.charAt(vidx));
				sb.append(str.length()-1);
			}
			return "";
		}
		if(str.charAt(vidx) == 'h' && str.charAt(vidx + 1) == 'i' && str.charAt(vidx + 2) == 't'){
			sb.append(str.charAt(vidx));
			removeallhi(str,vidx+1,sb);
		}else if(str.charAt(vidx)=='h' && str.charAt(vidx+1)=='i'){
			removeallhi(str,vidx+2,sb);
		}else{
			sb.append(str.charAt(vidx));
			removeallhi(str,vidx+1,sb);
		}
		
		return sb.toString();
	}
	
	public static void printhiwithouthit(String str, int vidx){
		if (vidx == str.length()-2) {
			if (str.charAt(vidx) == 'h' && str.charAt(str.length()-1)=='i'){
	
			}else{
				System.out.print(str.charAt(vidx));
				System.out.print(str.length()-1);
			}
			return;
		}
		if(str.charAt(vidx) == 'h' && str.charAt(vidx + 1) == 'i' && str.charAt(vidx + 2) == 't'){
			System.out.print("hit");
			printhiwithouthit(str,vidx+3);
		}else if(str.charAt(vidx)=='h' && str.charAt(vidx+1)=='i'){
			printhiwithouthit(str,vidx+2);
		}else{
			System.out.print(str.charAt(vidx));
			printhiwithouthit(str,vidx+1);
		}
	}

}
