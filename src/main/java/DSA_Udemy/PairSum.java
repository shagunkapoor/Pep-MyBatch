package DSA_Udemy;

import java.util.Arrays;

//Find a pair that sums up to the target
public class PairSum {
    public static void main(String[] args) {
        int[] arr = {10, -2, -6, 4, 17, 13};
        int target = 15;

        //O(nLogn)
        int[] pairs = getPairSum(arr, target);

        for (int pair : pairs) {
            System.out.print(pair + ", ");
        }

    }

    private static int[] getPairSum(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

}


