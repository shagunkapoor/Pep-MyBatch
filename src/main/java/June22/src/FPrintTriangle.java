import java.util.Scanner;

//*
//**
//***
//****
//*****
public class FPrintTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n=scn.nextInt();
		triangle(n,1,1);
		System.out.println();
		inverted(n,1,n);

	}
	public static void triangle(int n,int i, int j){
		if(i>n){
			return;
		}
		if(j<=i){
			System.out.print("*");
			triangle(n,i,j+1);
		}else{
			System.out.println();
			triangle(n,i+1,1);
	
		}
			}
	public static void inverted(int n, int i, int j){
		if(i>n){
			return;
		}
		if(j>=i){
			System.out.print("*");
			inverted(n,i,j-1);
		}else{
			System.out.println();
			inverted(n,i+1,n);
		}
	}

}
