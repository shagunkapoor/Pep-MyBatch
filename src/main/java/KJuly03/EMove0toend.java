package KJuly03;

public class EMove0toend {

    //O(n)
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {5, 4, 0, 9, 0, 0, 8, 0, 1, 0};
        moveZeroesToEnd(arr, arr.length);
        for (int x = 0; x < arr.length; x++) {
            System.out.print(arr[x] + " ");
        }
    }

    private static void moveZeroesToEnd(int[] arr, int n) {
        int itr = 0;
        int nonZero = 0;
        while (itr < n) {
            if (arr[itr] != 0) {//Bring non zero to beginning
                swap(arr, itr, nonZero);
                itr++;
                nonZero++;
            } else {//Non Zero
                itr++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
