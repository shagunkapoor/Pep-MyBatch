import java.util.Scanner;

//You are given an array A with size N (indexed from 0) and an integer K. Let's
//define another array B with size N · K as the array that's formed by
//concatenating K copies of array A.
//
//For example, if A = {1, 2} and K = 3, then B = {1, 2, 1, 2, 1, 2}.
//
//You have to find the maximum subarray sum of the array B. Formally, you should
//compute the maximum value of Bi + Bi+1 + Bi+2 + ... + Bj,
//where 0 ≤ i ≤ j < N · K.
//
//
//Example
//Input:
//2
//N K
//2 3
//1 2
//N K
//3 2
//1 -2 1
//
//Output:
//9
//2
//
//Explanation
//
//Example case 1: B = {1, 2, 1, 2, 1, 2} and the subarray with maximum sum is the
//whole {1, 2, 1, 2, 1, 2}. Hence, the answer is 9.
public class HKConcatnations {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the test cases");
        int t = scn.nextInt();
        while (t-- > 0) {
            System.out.println("Enter N & K");
            int N = scn.nextInt();
            int K = scn.nextInt();
            System.out.println("Enter the array elements");
            int[] arr = new int[N * K];
            for (int j = 0; j < N; j++) {
                arr[j] = scn.nextInt();
            }

            int indx = 0;
            for (int i = N; i < N * K; i++) {
                arr[i] = arr[indx % N];
                indx++;
            }

            int sum = getMaxSubArraySum(arr, N * K);
            System.out.println(sum);
        }

    }

    private static int getMaxSubArraySum(int[] arr, int n) {
        int csp = 0, cep = 0, osp = 0, oep = 0;
        int csum = arr[0], osum = arr[0];

        for (int i = 1; i < n; i++) {
            if (csum < 0) {
                csum = arr[i];
                csp = cep = i;
            } else {
                csum += arr[i];
                cep++;
            }

            if (osum < csum) {
                osum = csum;
                osp = csp;
                oep = cep;
            }
        }

        return osum;
    }

}

