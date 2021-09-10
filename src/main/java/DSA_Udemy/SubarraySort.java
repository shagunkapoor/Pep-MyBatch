package DSA_Udemy;

//Find the smallest sub-array that needs to be sorted in place, so that
//the entire input array becomes sorted
//If i/p is already sorted, then return [-1,-1]
public class SubarraySort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11};

        int[] subarrayIndexes = subarraySort(arr);
        System.out.println(subarrayIndexes[0] + ", " + subarrayIndexes[1]);
    }

    private static int[] subarraySort(int[] arr) {

        return new int[]{-1, -1};
    }
}
