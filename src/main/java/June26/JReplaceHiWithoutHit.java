package June26;

import java.util.Scanner;
//a. Write a recursive function which replaces all �hi� in the string with �pep� �
//but skip all such �hi� which are followed by �t� to form �hit�. Print the
//i'th index character from the returned value.
//b. Write a recursive function which replace all �hi� in the string � but skip
//all such �hi� which are followed by �t� to form �hit�.
//Print the output(Return type void).
//
//
//Example(To be used only for expected output):
//
//Input:
//hihihithi 2
//
//output
//p
//peppephitpep

public class JReplaceHiWithoutHit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = scn.nextLine();
		int index = scn.nextInt();
		StringBuilder sb=new StringBuilder();
		String res=replacehiwithpep(s,0,sb);
		System.out.println(res);
		System.out.println(res.charAt(index));
		printreplacedhi(s, 0);
	}
	public static String replacehiwithpep(String str, int vidx,StringBuilder sb){
		if(vidx==str.length()-2){
			if(str.charAt(vidx)=='h' && str.charAt(str.length()-1)=='i'){
				sb.append("pep");
			}else{
				sb.append(str.charAt(vidx));
				sb.append(str.charAt(str.length()-1));
			}
			return sb.toString();
		}
		if(str.charAt(vidx) == 'h' && str.charAt(vidx + 1) == 'i' && str.charAt(vidx + 2) == 't'){
			sb.append(str.charAt(vidx));
			replacehiwithpep(str,vidx+1,sb);
		}else if(str.charAt(vidx) == 'h' && str.charAt(vidx + 1) == 'i'){
			sb.append("pep");
			replacehiwithpep(str,vidx+2,sb);
		}else{
			sb.append(str.charAt(vidx));
			replacehiwithpep(str, vidx+1, sb);
		}
		
		return sb.toString();
	}
	
	public static void printreplacedhi(String str, int vidx) {
		if (vidx >= str.length()-2) {
				if (str.charAt(vidx) == 'h' && str.charAt(str.length()-1)=='i'){
					System.out.println("pep");
				}else{
					System.out.print(str.charAt(vidx));
					System.out.print(str.length()-1);
				}
				return;
			}	
		
		if (str.charAt(vidx) == 'h' && str.charAt(vidx + 1) == 'i' && str.charAt(vidx + 2) == 't') {
			System.out.print(str.charAt(vidx));
			printreplacedhi(str, vidx + 1);
		} else if (str.charAt(vidx) == 'h' && str.charAt(vidx + 1) == 'i') {
			System.out.print("pep");
			printreplacedhi(str, vidx + 2);
		} else {
			System.out.print(str.charAt(vidx));
			printreplacedhi(str, vidx + 1);
		}
	}

}
