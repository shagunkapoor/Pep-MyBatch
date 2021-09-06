package June22;

import java.util.Scanner;

public class DPower {

    public static void main(String[] args) { //O(log n)
        // TODO Auto-generated method stub

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n & x");
        int n = scn.nextInt();
        int x = scn.nextInt();
        int val = power(n, x);
        System.out.println(val);

    }

    public static int power(int n, int x) {

        if (x == 0)
            return 1;
        // int res=power(n,x-1);
        // return n*res;
        // }
        //
        // }
        // OR
        int val;
        if (x % 2 == 0) {
            val = power(n, x / 2) * power(n, x / 2);
        } else {
            val = power(n, x / 2) * power(n, x / 2) * n;
        }
        return val;
    }
}