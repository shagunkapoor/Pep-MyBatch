package DSA_Udemy;

import java.util.ArrayList;
import java.util.Arrays;

//Find the triplets that sums up to the target
public class Triplets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        int target = 18;

        //O(n^2)
        ArrayList<String> triplets = getTriplets(arr, target);
        System.out.println(triplets);
    }

    private static ArrayList<String> getTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        ArrayList<String> triplets = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    triplets.add(arr[i] + "," + arr[left] + "," + arr[right]);
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }
}
