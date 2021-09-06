package AlgorithmsImp;

import java.util.Scanner;

public class ArraySubset {

    public static void main(String[] args) {
        // int[] arr = ArrayUtils.takeInput();
        // int loop = nthroot(2, arr.length);
        // int n = 0, i;
        // for (i = 0; i < loop; i++) {
        // n = i;
        // int k = 0;
        // System.out.print("[");
        // while (k <= arr.length - 1) {
        // int mask = 1 << k;
        // int x = n & mask;
        // if (x == mask) {
        // System.out.print(arr[k] + " ");
        // }
        // k++;
        // }
        // System.out.print("]");
        // System.out.println();
        // }
        // }
        //
        // private static int nthroot(int x, int n) {
        // if (n == 0) {
        // return 1;
        // } else {
        // int x2 = x;
        // while (n - 1 != 0) {
        // x2 = x2 * x;
        // n--;
        // }
        // return x2;
        // }
        // }

        // OR using bit manipulation

        Scanner scn = new Scanner(System.in);
        char[] arr = new char[3];
        System.out.println("Enter array elements");
        for (int i = 0; i < 3; i++) {
            arr[i] = scn.nextLine().charAt(0);
        }
        subset(arr);
    }

    public static void subset(char[] arr) {
        for (int i = 0; i < (int) Math.pow(2, arr.length); i++) {
            // (1 << arr.length); i++) {
            for (int j = arr.length - 1; j >= 0; j--) {

                int mask = (1 << j) & i;
                if (mask != 0) {
                    System.out.print(arr[arr.length - 1 - j]);
                } else if (mask == 0) {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}