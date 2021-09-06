package June16;

import java.util.Scanner;
// \				/       \    /
//  \			   /         \  /               //VALID SEQ
//   \			  /           \/
//  
//   /\         \    /\    /					//INVALID SEQ
//  /  \         \  /  \  /
// /    \         \/    \/
//  
public class BSeqValidOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of inputs");
		int n = scn.nextInt();
		
		System.out.println("Enter the first no.");
		int first = scn.nextInt();
		System.out.println("Enter the second no.");
		int second = scn.nextInt();
		
		boolean GoingUpwards = second > first;

		for (int i = 3; i <= n; i++) {
			if (GoingUpwards == false) { // downwards
				if (second > first) {
					GoingUpwards = true;
				}
			} else { // upwards
				if (second < first) {
					System.out.println("Invalid");
					return;
				}
			}
			first = second;
			System.out.println("Enter the " + i + "th number");
			second = scn.nextInt();
		}
		System.out.println("Valid");
	}

}
