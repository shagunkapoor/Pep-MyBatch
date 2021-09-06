package June18;//import java.util.Scanner;
//
//public class GMirrorInverse {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Scanner scn=new Scanner(System.in);
//		int[] arr=ArrayUtils.takeInput();
//		int n=arr.length-1;
//		boolean res=true;
//for(int i=0;i<arr.length;i++){					//checking if val on arr's index=
//	int x=arr[i];								//val on val's index
//	if(arr[x]!=i)								//inverse concept with 1 array
//		res=false;
//}
//System.out.println(res);
//}
//}
//
////for(int i=0,j=n;i<arr.length/2;i++,j--){
////if(arr[i]==arr[j])
////	res=true;										//checking if no.=its inverse
////else
////	res=false;
////}
////System.out.println(res);
////}
////
////}


import java.io.*;
import java.util.*;

public class GMirrorInverse {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn=new Scanner(System.in);
        System.out.println("n");
        int n=scn.nextInt();
        //array1;
        long[] arr1=new long[n];
        long[] arr2=new long[n];
        
        for(int i=0;i<n;i++){
            arr1[i]=scn.nextLong();
        }
        for(int i=0;i<n;i++){
            arr2[i]=scn.nextLong();
        }
        checkrev(arr1,arr2);
    }
    public static void checkrev(long[] one, long[] two){
        boolean res=false;
        for(int i=0;i<one.length;i++){
            long x=one[i];
            if(two[(int) x]==i)
                res=true;
            else
            	res=false;
        }
        System.out.println(res);
    }
}
