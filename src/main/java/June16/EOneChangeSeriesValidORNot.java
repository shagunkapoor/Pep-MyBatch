package June16;

import java.io.*;
import java.util.*;

public class EOneChangeSeriesValidORNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no. of elements to be entered");
		int n = scn.nextInt();
		int first = scn.nextInt();
		int sec = scn.nextInt();

		boolean res = true;
		int cntr = 1;
		for (int i = 3; i <= n; i++) {
			boolean GngUp = sec > first;
			if (GngUp == false) {
				if (sec > first) {
					 GngUp=true;
					 res=true;
					 cntr++;
					// break;
				}
			}else if (GngUp == true) {
				if (sec < first) {
					 GngUp=false;
					 res=true;
					cntr++;
					// break;
				}
			} else {
				res = false;
				return;
			}
			if (cntr == 2) {
				res = true;
			}
			if (cntr >= 3) {
				res = false;
				break;
			}
			
			first = sec;
			sec = scn.nextInt();
		}
		System.out.println(res);
	}

}
