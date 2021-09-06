package June18;

import java.io.*;
import java.util.*;

public class IIndexOnWhichElementFound {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the element:");
		int n = scn.nextInt();
		int[] arr = new int[n];
		boolean invalid = false;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			if (arr[i] < 0)
				invalid = true;
		}
		int x = scn.nextInt();
		int flag = 0;
		if (invalid == false) {
			for (int i = 0; i < n; i++) {
				if (x == arr[i]) {
					flag = 1;
					System.out.println(i);
				}
			}
			if (flag == 0)
				System.out.println(-1);
		} else
			System.out.println("Invalid Input");
	}
}