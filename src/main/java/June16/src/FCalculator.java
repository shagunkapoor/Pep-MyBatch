
import java.io.*;
import java.util.*;		

public class FCalculator {

	public static void main(String[] args) {
		        Scanner scn=new Scanner(System.in);
		        char ch=scn.nextLine().charAt(0);
		        while(ch!='x' && ch!='X'){
		        
		            if(ch=='+'){
		                int n1=Integer.parseInt(scn.nextLine());
		                int n2=Integer.parseInt(scn.nextLine());
		                System.out.println(n1+n2);
		            }else if(ch=='-'){
		                int n1=Integer.parseInt(scn.nextLine());
		                int n2=Integer.parseInt(scn.nextLine());
		                System.out.println(n1-n2);
		            }else if(ch=='*'){
		                int n1=Integer.parseInt(scn.nextLine());
		                int n2=Integer.parseInt(scn.nextLine());
		                System.out.println(n1*n2);
		            }else if(ch=='/'){
		                int n1=Integer.parseInt(scn.nextLine());
		                int n2=Integer.parseInt(scn.nextLine());
		                System.out.println(n1/n2);
		            }else 
		                System.out.println("Invalid Operation.");
		        	ch=scn.nextLine().charAt(0);    
		            
		        }
		        if(ch=='x'||ch=='X')
	            	return;
		    }
		}