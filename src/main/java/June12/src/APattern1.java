import java.util.Scanner;


//*
//**
//***
//****
//*****

public class APattern1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int n = scn.nextInt();
//		int i = 1;
//		while (i <= n) {
//			int a=i;
//			while(a>0){
//				System.out.print("*");											//CORRECT	
//				a--;	
//			}
//			System.out.println();
//			i++;
//		}
//	}
//
//}




int r=1;
while(r<=n){
	int c=1;
	while(c<=r){
		System.out.print("* ");														//CORRECT
		c++;
	}
	System.out.print("\n");
	r++;
}
}
}


////*****
////****
////***
////**
////*
//		int r=1;
//		while(r<=n){
//			int c=n;
//			while(c>=r){
//				System.out.print("* ");
//				c--;
//			}
//			System.out.println();
//			r++;
//		}
//		
//	}
//
//}

////
////*****
//// ****
////  ***
////   **
////    *
//
//int r=1;
//int sp=0;
//int st=n;
//while(r<=n){
//	int csp=1;
//	
//	while(csp<=sp){
//		System.out.print(" ");
//		csp++;
//	}
//	int cst=1;
//	while(cst<=st){
//		System.out.print("* ");
//		cst++;
//	}
//	if(r<=n){
//		sp+=2;
//		st-=1;
//	}
//	System.out.println();
//	r++;
//}}}

//
////
////        *
////      * *
////    * * *
////  * * * *
////* * * * *
//int r=1;
//int sp=n-1;
//int st=1;
//while(r<=n){
//	int csp=1;
//	while(csp<=sp){
//		System.out.print(" ");
//		csp++;
//	}
//	
//	int cst=1;
//	while(cst<=st){
//		System.out.print("*");
//		cst++;
//	}
//	if(r<=n){
//		sp-=1;
//		st+=1;
//	}
//	System.out.println();
//	r++;
//}}}





////* * * * * 
//// * * * * 
////  * * * 
////   * * 
////    * 
//
//int r=1;
//int sp=0;
//int st=n;
//while(r<=n){
//	int c=1;
//	int csp=1;
//	
//	while(csp<=sp){
//		System.out.print(" ");
//		csp++;
//	}
//	int cst=1;
//	while(cst<=st){
//		System.out.print("* ");
//		cst++;
//	}
//	if(c<=n){
//		sp+=1;
//		st-=1;
//		c++;
//	}
//	System.out.println();
//	r++;
//}}}


