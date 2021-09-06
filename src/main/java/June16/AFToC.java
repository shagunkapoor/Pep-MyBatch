package June16;

import java.util.Scanner;

public class AFToC {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);

		System.out.println("Enter the min Farenheight");
		double min=scn.nextInt();
		System.out.println("Enter the max Farenheight");
		double max=scn.nextInt();
		System.out.println("Enter the step size");
		int s=scn.nextInt();
		double Far=min;
		int Cel=0;
		while(Far<=max){
			int val=5/9;
			System.out.println(val);
			//if it would have been 5/9, then the ans=0 as integer accepts only 0 for this case
			// but if we use 5.0, then the output would come out to be 0.55555555566
			Cel=(int)((5.0/9)*(Far-32));  
			System.out.print(Far+" "+Cel);
			System.out.println();
			Far+=s;
		}
	}
}