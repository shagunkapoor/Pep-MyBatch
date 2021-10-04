package DSA_Interview;

import java.util.Arrays;

public class TripletsSumEqualToZero {
    public static void main(String[] args) {
        int[] arr = {1, 5, -2, 7, 12, -4, 9, 6};

        int[] res = triplets(arr);
        if (res.length > 0)
            System.out.println(res[0] + ", " + res[1] + ", " + res[2]);
    }

    private static int[] triplets(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    return new int[]{arr[i], arr[left], arr[right]};
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return null;
    }
}