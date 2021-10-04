package DSA_Udemy.Arrays;

import java.util.Arrays;
import java.util.HashMap;

//Min no. of swaps needed to make the array sorted
public class GMinSwaps {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 1, 3};

        //O(n logn)
        System.out.println(getMinSwaps(arr));
    }

    private static int getMinSwaps(int[] arr) {
        int minSwaps = 0;
        //Store the original positions
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hmap.put(arr[i], i);
        }

        //Sort the array
        Arrays.sort(arr);

        //Find count of swaps, for unsorted array
        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);
        for (int i = 0; i < arr.length; i++) {
            //if value is already visited (a part of cycle formed)
            //if value is at same position=>already sorted (old position == current position)
            if (visited[i] == true || hmap.get(arr[i]) == i) {
                continue;
            }

            int nextPosition = i;
            int cycleCount = 0;
            while (!visited[nextPosition]) {
                visited[i] = true;
                //arr[nextPosition]=> cycle node
                //hmap.get(arr[nextPosition])=> next node's position
                nextPosition = hmap.get(arr[nextPosition]);
                cycleCount++;
            }

            minSwaps += (cycleCount - 1);
        }
        return minSwaps;
    }
}
