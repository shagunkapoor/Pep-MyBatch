package DSA_Udemy;

//Given n non-negative integers that form an elevation map, with width of each bar as 1
//How much water can it trap after raining
public class Rains {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int count = getRainCount(arr);
        System.out.println(count);
    }

    private static int getRainCount(int[] arr) {
        //Max elt on left so far
        int[] leftHeight = new int[arr.length];

        leftHeight[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1], arr[i]);
            //rightHeight[n-i-1] = Math.max(rightHeight[n-i], arr[n-i-1]);
        }

        //Max elt on right so far
        int[] rightHeight = new int[arr.length];
        rightHeight[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(rightHeight[i + 1], arr[i]);
        }

        //Calculate  water collected at each step
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += Math.min(leftHeight[i], rightHeight[i]) - arr[i];
        }

        return count;
    }
}
