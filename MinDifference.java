package DSA_Udemy.Arrays;

import java.util.Arrays;

//Find a pair of numbers (one from each array),
// whose absolute difference is closest to 0
public class MinDifference {
    public static void main(String[] args) {
        int[] arr1 = {23, 5, 10, 17, 30};
        int[] arr2 = {26, 134, 135, 14, 19};

        int[] pair = getMinDiffPair(arr1, arr2);
        System.out.println(pair[0] + "-" + pair[1]);
    }

    private static int[] getMinDiffPair(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int minDiff = Integer.MAX_VALUE;
        int arr1Idx = 0, arr2Idx = 0;
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            int diff = Math.abs(arr1[i] - arr2[j]);
            if (diff < minDiff) {
                minDiff = diff;
                arr1Idx = i;
                arr2Idx = j;
            }
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return new int[]{arr1[arr1Idx], arr2[arr2Idx]};
    }
}
