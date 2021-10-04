package DSA_Udemy.Arrays;

//Find the smallest sub-array that needs to be sorted in place, so that
//the entire input array becomes sorted
//If i/p is already sorted, then return [-1,-1]
public class FSubarraySort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11};

        //O(n)
        int[] subarrayIndexes = subarraySort(arr);
        System.out.println(subarrayIndexes[0] + ", " + subarrayIndexes[1]);
    }

    private static int[] subarraySort(int[] arr) {
        int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1] || arr[i] < arr[i - 1]) {
                smallest = Math.min(smallest, arr[i]);
                largest = Math.max(largest, arr[i]);
            }
        }
        //Look for the right index to place the smallest unsorted elt
        int sp = 0;
        for (int i = 0; i < arr.length && arr[i] < smallest; i++, sp++) ;

        //Look for the right index to place the largest unsorted elt
        int ep = arr.length - 1;
        for (int i = arr.length - 1; i >= 0 && arr[i] > largest; i--, ep--) ;

        if (smallest == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return new int[]{sp, ep};
    }
}
