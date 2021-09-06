package June14;
//Take as input
//1. first number: a
//2. common difference for the AP: d
//3. common ratio for the GP: r
//4. number of elements: n
//
//Let us assume fap is the nth number of AP
//Let us assume fgp is the nth number of GP
//Let us assume fagp is the nth number of AGP
//Let us assume sap is the sum of first n number of AP
//Let us assume sgp is the sum of first n number of GP
//Let us assume sagp is the sum of first n number of AGP
//Print fap, fgp, fagp, sap, sgp, sagp separated by a space on the same line


import java.io.*;
import java.util.*;

public class H {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn=new Scanner(System.in);
        int a=scn.nextInt();
        int d=scn.nextInt();
        int r=scn.nextInt();
        int n=scn.nextInt();
        int fap= a+(n-1)*d;
        int sap=n*(a+fap)/2;
        
        int pow=1;
        int cnt=1;
        while(cnt<=n){
        int fgp=a*r^pow;
            pow*=(n-1);
        }
        int sgp=a*(1-r^n)/(1-r);
    }
}
