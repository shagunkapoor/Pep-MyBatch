
//Take as input
//1. a source number: sn
//2. base of source number system: sb
//3. base of destination number system: db
//q	q                                           .
//Print the equivalent of sn in destination number system.
import java.io.*;
import java.util.*;
public class G {



	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner scn=new Scanner(System.in);
	        int sn=scn.nextInt();
	        int sb=scn.nextInt();
	        int db=scn.nextInt();
	        
	        if(sb==8){
	            int n=0;
	            int dec=0;
	            int pow=1;
	            while(sn!=0){
	                n=sn%10;
	                sn=sn/10;
	                dec=dec+n*pow;
	                pow*=8;
	            }
	            int rem=0;
	            pow=1;
	            int bin=0;
	            while(dec!=0){
	                rem=dec%2;
	                dec/=2;
	                bin+=rem*pow;
	                pow*=10;
	            }
	            System.out.println(bin);
	        }else if(sb==2){
	            int n=0;
	            int dec=0;
	            int power=1;
	            while(sn!=0){
	                n=sn%10;
	                sn/=10;
	                dec+=n*power;
	                power*=2;
	            }
	            int rem=0;
	            int oct=0;
	            power=1;
	            while(dec!=0){
	                rem=dec%8;
	                dec/=8;
	                oct+=rem*power;
	                power*=10;
	            }
	            System.out.println(oct);
	        
	    }else{
	            return;
	        }
	            
	}
	}