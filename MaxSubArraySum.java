package DSA_Udemy.Arrays;

//If all elts are -ve, return 0
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, 4, -2, 6, -8, 3};

        int maxSubArraySum = getMaxSubArraySum(arr);
        System.out.println(maxSubArraySum);
    }

    private static int getMaxSubArraySum(int[] arr) {
        int osum = 0;
        int csum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (csum < 0) {
                csum = arr[i];
            } else {
                csum += arr[i];
            }

            if (csum > osum) {
                osum = csum;
            }
        }

        return osum;
    }
}
