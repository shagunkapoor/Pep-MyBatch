package June12;

import java.util.Scanner;

//  1
// 232
//34543
// 232
//  1

public class HPattern8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int n = scn.nextInt();
		pat(n);
	}
	/*
		int r = 1;
		int sp = n / 2;
		int st = 1;
		int val = 1;
		while (r <= n) {
			int csp = 1;
			while (csp <= sp) {
				System.out.print(" ");
				csp++;
			}

			int cst = 1;
			int cval = 1;
			//change no 2
			if (r <= n / 2) {
				val=r;
			} else {
				val=(n+1)-r;
			}
			while (cst <= st) {

				System.out.print(val);
				cst++;

				if (cst <= (st / 2)+1) //change no 1
					val++;
				else
					val--;
				
			}
			
			if (r <= n / 2) {
				sp -= 1;
				st += 2;
			} else {
				sp += 1;
				st -= 2;
			}

			System.out.println();
			r++;
		}

	}
	*/
	
	public static void pat(int n){
		
		int sp=n/2;
		int st=1;
		int val=1;
		
		for(int i=1;i<=n;i++){
			
			int csp=1;
			while(csp<=sp){
				System.out.print(" ");
				csp++;
				}
			
			int cst=1;
			while(cst<=st){
				System.out.print(val);
				
				if(cst<=st/2){
					val++;
				}else{
					val--;
				}
				cst++;
			}
			
			if(i<=n/2){
				sp--;
				st+=2;
				val=i+1;
			}else{
				sp++;
				st-=2;
				val=n-i;
			}
			System.out.println();
		}
	}

}

